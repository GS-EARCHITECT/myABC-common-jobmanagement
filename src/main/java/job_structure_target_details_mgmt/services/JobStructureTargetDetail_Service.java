package job_structure_target_details_mgmt.services;

import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import job_structure_target_details_mgmt.model.details.JobStructureTargetDetail;
import job_structure_target_details_mgmt.model.details.JobStructureTargetDetailPK;
import job_structure_target_details_mgmt.model.dto.JobStructureTargetDetail_DTO;
import job_structure_target_details_mgmt.model.repo.JobStructureTargetDetails_Repo;

@Service("jobStructureTargetDetailsServ")
@Scope(value = "prototype", proxyMode = ScopedProxyMode.TARGET_CLASS)
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class JobStructureTargetDetail_Service implements I_JobStructureTargetDetails_Service {
	
	//private static final Logger logger = LoggerFactory.getLogger(JobStructureTargetDetailService.class);

	@Autowired
	private JobStructureTargetDetails_Repo jobStructureTargetDetailsRepo;

	@Override
	public JobStructureTargetDetail_DTO newJobStructureTargetDetail(JobStructureTargetDetail_DTO jobStructureDetailsDTO) 
	{
		JobStructureTargetDetailPK jobStructureTargetDetailsPK = new JobStructureTargetDetailPK();
		jobStructureTargetDetailsPK.setJobClassSeqNo(jobStructureDetailsDTO.getJobClassSeqNo());
		jobStructureTargetDetailsPK.setJobSeqNo(jobStructureDetailsDTO.getJobSeqNo());
		jobStructureTargetDetailsPK.setParJobSeqNo(jobStructureDetailsDTO.getParJobSeqNo());
		jobStructureTargetDetailsPK.setParJobClassSeqNo(jobStructureDetailsDTO.getParJobClassSeqNo());
		jobStructureTargetDetailsPK.setTargetSeqNo(jobStructureTargetDetailsPK.getTargetSeqNo());
		jobStructureTargetDetailsPK.setParTargetSeqNo(jobStructureTargetDetailsPK.getParTargetSeqNo());
		JobStructureTargetDetail jobStructureTargetDetails2 = null;
		JobStructureTargetDetail_DTO jobStructureTargetDetailsDTO = null;

		if (!jobStructureTargetDetailsRepo.existsById(jobStructureTargetDetailsPK)) 
		{
			jobStructureTargetDetails2 = this.setJobStructureTargetDetail(jobStructureDetailsDTO);
			jobStructureTargetDetails2.setId(jobStructureTargetDetailsPK);
			jobStructureTargetDetailsDTO = this.getJobStructureTargetDetail_DTO(jobStructureTargetDetails2);
		}
		return jobStructureTargetDetailsDTO;
	}

	@Override
	public ArrayList<JobStructureTargetDetail_DTO> getAllJobStructureTargetDetails() 
	{
		ArrayList<JobStructureTargetDetail> jobList = (ArrayList<JobStructureTargetDetail>) jobStructureTargetDetailsRepo.findAll();
		ArrayList<JobStructureTargetDetail_DTO> jobStructureDetailsDTOs = new ArrayList<JobStructureTargetDetail_DTO>();
		jobStructureDetailsDTOs = jobList != null ? this.getJobStructureTargetDetail_DTOs(jobList) : null;
		return jobStructureDetailsDTOs;
	}

	@Override
	public ArrayList<JobStructureTargetDetail_DTO> getSelectJobStructureTargetDetailsForJobs(ArrayList<Long> jobSeqNos) 
	{
		
		ArrayList<JobStructureTargetDetail> jobStructureTargetDetails = (ArrayList<JobStructureTargetDetail>) jobStructureTargetDetailsRepo.getSelectJobStructureTargetDetailsForJobs(jobSeqNos);
		ArrayList<JobStructureTargetDetail_DTO> jobStructureTargetDetailsDTOs = jobStructureTargetDetails != null ? this.getJobStructureTargetDetail_DTOs(jobStructureTargetDetails) : null;
		return jobStructureTargetDetailsDTOs;
	}

	@Override
	public ArrayList<JobStructureTargetDetail_DTO> getSelectJobStructureTargetDetails(ArrayList<JobStructureTargetDetailPK> jobStructureTargetDetailPKs) 
	{
		ArrayList<JobStructureTargetDetail> jobStructureTargetDetails = (ArrayList<JobStructureTargetDetail>) jobStructureTargetDetailsRepo.findAllById(jobStructureTargetDetailPKs);
		ArrayList<JobStructureTargetDetail_DTO> jobStructureTargetDetailsDTOs = jobStructureTargetDetails != null ? this.getJobStructureTargetDetail_DTOs(jobStructureTargetDetails) : null;
		return jobStructureTargetDetailsDTOs;		
	}
	
	
	@Override
	public ArrayList<JobStructureTargetDetail_DTO> getSelectJobStructureTargetDetailsForParents(ArrayList<Long> jobSeqNos, ArrayList<Long> parTargetSeqNos) 
	{
		ArrayList<JobStructureTargetDetail> jobStructureTargetDetails = (ArrayList<JobStructureTargetDetail>) jobStructureTargetDetailsRepo.getSelectJobStructureTargetDetailForParents(jobSeqNos, parTargetSeqNos);
		ArrayList<JobStructureTargetDetail_DTO> jobStructureTargetDetailsDTOs = jobStructureTargetDetails != null ? this.getJobStructureTargetDetail_DTOs(jobStructureTargetDetails) : null;
		return jobStructureTargetDetailsDTOs;		
	}

	@Override
	public void updJobStructureTargetDetail(JobStructureTargetDetail_DTO jobStructureTargetDetailsDTO) 
	{
		JobStructureTargetDetailPK jobStructureTargetDetailsPK = new JobStructureTargetDetailPK();
		jobStructureTargetDetailsPK.setJobClassSeqNo( jobStructureTargetDetailsDTO.getJobClassSeqNo());
		jobStructureTargetDetailsPK.setJobSeqNo( jobStructureTargetDetailsDTO.getJobSeqNo());
		jobStructureTargetDetailsPK.setParJobSeqNo( jobStructureTargetDetailsDTO.getParJobSeqNo());
		jobStructureTargetDetailsPK.setParJobClassSeqNo( jobStructureTargetDetailsDTO.getParJobClassSeqNo());
		jobStructureTargetDetailsPK.setTargetSeqNo(jobStructureTargetDetailsPK.getTargetSeqNo());
		jobStructureTargetDetailsPK.setParTargetSeqNo(jobStructureTargetDetailsPK.getParTargetSeqNo());
		JobStructureTargetDetail jobStructureTargetDetails2 = null;
		
		if (jobStructureTargetDetailsRepo.existsById(jobStructureTargetDetailsPK))
		{
			jobStructureTargetDetails2 = this.setJobStructureTargetDetail(jobStructureTargetDetailsDTO);
			jobStructureTargetDetails2.setId(jobStructureTargetDetailsPK);			
			jobStructureTargetDetailsRepo.save(jobStructureTargetDetails2);
		}
	}

	@Override
	public void delAllJobStructureTargetDetails() 
	{
		jobStructureTargetDetailsRepo.deleteAll();
	}

	@Override
	public void delSelectJobStructureTargetDetails(ArrayList<JobStructureTargetDetailPK> jobStructureTargetDetailPKs)
	{
	jobStructureTargetDetailsRepo.deleteAllById(jobStructureTargetDetailPKs);
	}

	@Override
	public void deleteSelectJobStructureTargetDetailForJobs(ArrayList<Long> jobSeqNos)
	{
	jobStructureTargetDetailsRepo.deleteSelectJobStructureTargetDetailForJobs(jobSeqNos);
	}
	
	@Override
	public void delSelectJobStructureTargetDetailForParents(ArrayList<Long> jobSeqNos, ArrayList<Long> parTargetSeqNos)
	{
	jobStructureTargetDetailsRepo.delSelectJobStructureTargetDetailForParents(jobSeqNos, parTargetSeqNos);
	}
	
	private ArrayList<JobStructureTargetDetail_DTO> getJobStructureTargetDetail_DTOs(
			ArrayList<JobStructureTargetDetail> jobStructureDetailss) {
		JobStructureTargetDetail_DTO jobStructureDetailsDTO = null;
		ArrayList<JobStructureTargetDetail_DTO> jobStructureDetailsDTOs = new ArrayList<JobStructureTargetDetail_DTO>();

		for (int i = 0; i < jobStructureDetailss.size(); i++) {
			jobStructureDetailsDTO = getJobStructureTargetDetail_DTO(jobStructureDetailss.get(i));
			jobStructureDetailsDTOs.add(jobStructureDetailsDTO);
		}
		return jobStructureDetailsDTOs;
	}

	private JobStructureTargetDetail_DTO getJobStructureTargetDetail_DTO(JobStructureTargetDetail jobStructureTargetDetails) {
		JobStructureTargetDetail_DTO jobStructureTargetDetailsDTO = new JobStructureTargetDetail_DTO();
		jobStructureTargetDetailsDTO.setJobClassSeqNo(jobStructureTargetDetails.getId().getJobClassSeqNo());
		jobStructureTargetDetailsDTO.setJobSeqNo(jobStructureTargetDetailsDTO.getJobSeqNo());
		jobStructureTargetDetailsDTO.setTargetSeqNo(jobStructureTargetDetailsDTO.getTargetSeqNo());
		jobStructureTargetDetailsDTO.setParJobClassSeqNo(jobStructureTargetDetails.getId().getParJobClassSeqNo());
		jobStructureTargetDetailsDTO.setParJobSeqNo(jobStructureTargetDetails.getId().getParJobSeqNo());
		jobStructureTargetDetailsDTO.setParTargetSeqNo(jobStructureTargetDetailsDTO.getParTargetSeqNo());
		jobStructureTargetDetailsDTO.setStatus(jobStructureTargetDetails.getStatus());
		jobStructureTargetDetailsDTO.setRemark(jobStructureTargetDetails.getRemark());
		jobStructureTargetDetailsDTO.setSeqNo(jobStructureTargetDetails.getSeqNo());
		return jobStructureTargetDetailsDTO;
	}

	private JobStructureTargetDetail setJobStructureTargetDetail(JobStructureTargetDetail_DTO cDTO) {
		JobStructureTargetDetail jobStructureTargetDetails = new JobStructureTargetDetail();
		JobStructureTargetDetailPK jobStructureTargetDetailsPK = new JobStructureTargetDetailPK();
		jobStructureTargetDetailsPK.setJobSeqNo(cDTO.getJobSeqNo());
		jobStructureTargetDetailsPK.setJobClassSeqNo(cDTO.getJobClassSeqNo());
		jobStructureTargetDetailsPK.setTargetSeqNo(cDTO.getTargetSeqNo());
		jobStructureTargetDetailsPK.setParJobSeqNo(cDTO.getParJobSeqNo());
		jobStructureTargetDetailsPK.setParJobClassSeqNo(cDTO.getParJobClassSeqNo());
		jobStructureTargetDetailsPK.setParTargetSeqNo(cDTO.getParTargetSeqNo());
		jobStructureTargetDetails.setId(jobStructureTargetDetailsPK);
		jobStructureTargetDetails.setRemark(cDTO.getRemark());
		jobStructureTargetDetails.setStatus(cDTO.getStatus());
		jobStructureTargetDetails.setSeqNo(cDTO.getSeqNo());		
		return jobStructureTargetDetails;
	}
}