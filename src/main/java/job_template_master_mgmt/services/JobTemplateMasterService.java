package job_template_master_mgmt.services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import job_template_master_mgmt.model.dto.JobTemplateMasterDTO;
import job_template_master_mgmt.model.master.JobTemplateMaster;
import job_template_master_mgmt.model.master.JobTemplateMasterPK;
import job_template_master_mgmt.model.repo.JobTemplateMasterRepo;

@Service("jobTemplateMasterServ")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class JobTemplateMasterService implements I_JobTemplateMasterService 
{
	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(JobTemplateMasterService.class);

	@Autowired
	private JobTemplateMasterRepo jobTemplateMasterRepo;

	@Override
	public JobTemplateMasterDTO newJobTemplateMaster(JobTemplateMasterDTO jobStructureDetailsDTO) 
	{
		JobTemplateMasterPK jobTemplateMasterPK = new JobTemplateMasterPK();
		jobTemplateMasterPK.setJobTemplateSeqNo(jobStructureDetailsDTO.getJobTemplateSeqNo());		
		jobTemplateMasterPK.setServiceSeqNo(jobStructureDetailsDTO.getServiceSeqNo());
		JobTemplateMaster jobTemplateMaster2 = null;
		JobTemplateMasterDTO jobTemplateMasterDTO = null;

		if (!jobTemplateMasterRepo.existsById(jobTemplateMasterPK)) {
			jobTemplateMaster2 = this.setJobTemplateMaster(jobStructureDetailsDTO);
			jobTemplateMaster2.setId(jobTemplateMasterPK);
			jobTemplateMasterDTO = this.getJobTemplateMasterDTO(jobTemplateMaster2);
		}
		return jobTemplateMasterDTO;
	}

	@Override
	public ArrayList<JobTemplateMasterDTO> getAllJobTemplateMasters() {
		ArrayList<JobTemplateMaster> jobList = (ArrayList<JobTemplateMaster>) jobTemplateMasterRepo
				.findAll();
		ArrayList<JobTemplateMasterDTO> jobStructureDetailsDTOs = new ArrayList<JobTemplateMasterDTO>();
		jobStructureDetailsDTOs = jobList != null ? this.getJobTemplateMasterDTOs(jobList) : null;
		return jobStructureDetailsDTOs;
	}

	@Override
	public ArrayList<JobTemplateMasterDTO> getSelectJobTemplateMasters(
			ArrayList<Long> jobTemplateMasterSeqNos) {
		ArrayList<JobTemplateMaster> jobTemplateMasters = null;
		ArrayList<JobTemplateMasterDTO> jobTemplateMasterDTOs = null;

		if (jobTemplateMasterSeqNos != null) {
			jobTemplateMasters = jobTemplateMasterRepo
					.getSelectJobTemplateMasters(jobTemplateMasterSeqNos);
			if (jobTemplateMasters != null) {
				jobTemplateMasterDTOs = this.getJobTemplateMasterDTOs(jobTemplateMasters);
			}
		}
		return jobTemplateMasterDTOs;
	}

	@Override
	public JobTemplateMasterDTO getJobTemplateMasterById(Long jobTemplateMasterSeqNo,Long serviceSeqNo, BigDecimal serviceCategorySeqNo) 
	{
		JobTemplateMasterPK jobTemplateMasterPK = new JobTemplateMasterPK();		
		jobTemplateMasterPK.setJobTemplateSeqNo(jobTemplateMasterSeqNo);
		jobTemplateMasterPK.setServiceSeqNo(serviceSeqNo);		
		Optional<JobTemplateMaster> jobTemplateMaster = jobTemplateMasterRepo.findById(jobTemplateMasterPK);
		JobTemplateMasterDTO jobTemplateMasterDTO = null;

		if (jobTemplateMaster.isPresent()) {
			jobTemplateMasterDTO = getJobTemplateMasterDTO(jobTemplateMaster.get());
		}
		return jobTemplateMasterDTO;
	}

	@Override
	public void updJobTemplateMaster(JobTemplateMasterDTO jobTemplateMasterDTO)
	{
		JobTemplateMasterPK jobTemplateMasterPK = new JobTemplateMasterPK();
		jobTemplateMasterPK.setJobTemplateSeqNo(jobTemplateMasterDTO.getJobTemplateSeqNo());
		jobTemplateMasterPK.setServiceSeqNo(jobTemplateMasterDTO.getServiceSeqNo());
		JobTemplateMaster jobTemplateMaster2 = null;
		Optional<JobTemplateMaster> jobTemplateMaster = jobTemplateMasterRepo.findById(jobTemplateMasterPK);

		if (jobTemplateMaster.isPresent()) {
			jobTemplateMaster2 = this.setJobTemplateMaster(jobTemplateMasterDTO);
			jobTemplateMaster2.setId(jobTemplateMasterPK);
			;
			jobTemplateMasterRepo.save(jobTemplateMaster2);
		}
	}

	@Override
	public void delJobTemplateMaster(Long jobTemplateMasterSeqNo,Long serviceSeqNo, BigDecimal serviceCategorySeqNo) 
	{
		JobTemplateMasterPK jobTemplateMasterPK = new JobTemplateMasterPK();		
		jobTemplateMasterPK.setJobTemplateSeqNo(jobTemplateMasterSeqNo);
		jobTemplateMasterPK.setServiceSeqNo(serviceSeqNo);
		
		if (jobTemplateMasterRepo.existsById(jobTemplateMasterPK)) 
		{
			jobTemplateMasterRepo.deleteById(jobTemplateMasterPK);
		}
	}

	@Override
	public void delAllJobTemplateMasters() {
		jobTemplateMasterRepo.deleteAll();
	}

	@Override
	public void delSelectJobTemplateMasters(ArrayList<Long> jobTemplateMasterSeqNos) 
	{
		jobTemplateMasterRepo.deleteSelectJobTemplateMasters(jobTemplateMasterSeqNos);
	}

	private ArrayList<JobTemplateMasterDTO> getJobTemplateMasterDTOs(
			ArrayList<JobTemplateMaster> jobStructureDetailss) {
		JobTemplateMasterDTO jobStructureDetailsDTO = null;
		ArrayList<JobTemplateMasterDTO> jobStructureDetailsDTOs = new ArrayList<JobTemplateMasterDTO>();

		for (int i = 0; i < jobStructureDetailss.size(); i++) {
			jobStructureDetailsDTO = getJobTemplateMasterDTO(jobStructureDetailss.get(i));
			jobStructureDetailsDTOs.add(jobStructureDetailsDTO);
		}
		return jobStructureDetailsDTOs;
	}

	private JobTemplateMasterDTO getJobTemplateMasterDTO(JobTemplateMaster jobTemplateMaster) 
	{
		JobTemplateMasterDTO jobTemplateMasterDTO = new JobTemplateMasterDTO();
		jobTemplateMasterDTO.setJobTemplateSeqNo(jobTemplateMaster.getId().getJobTemplateSeqNo());
		jobTemplateMasterDTO.setServiceSeqNo(jobTemplateMaster.getId().getServiceSeqNo());
		jobTemplateMasterDTO.setRemarks(jobTemplateMaster.getRemarks());
		jobTemplateMasterDTO.setStatus(jobTemplateMaster.getStatus());
		return jobTemplateMasterDTO;
	}

	private JobTemplateMaster setJobTemplateMaster(JobTemplateMasterDTO cDTO) 
	{
		JobTemplateMaster jobTemplateMaster = new JobTemplateMaster();	
		jobTemplateMaster.setRemarks(cDTO.getRemarks());
		jobTemplateMaster.setStatus(cDTO.getStatus());
		return jobTemplateMaster;
	}
}