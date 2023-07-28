package job_template_details_mgmt.services;

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
import job_template_details_mgmt.model.details.JobTemplateDetail;
import job_template_details_mgmt.model.details.JobTemplateDetailPK;
import job_template_details_mgmt.model.dto.JobTemplateDetail_DTO;
import job_template_details_mgmt.model.repo.JobTemplateDetails_Repo;

@Service("jobTemplateDetailsServ")
@Scope(value = "prototype", proxyMode = ScopedProxyMode.TARGET_CLASS)
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class JobTemplateDetail_Service implements I_JobTemplateDetails_Service 
{
	
//	private static final Logger logger = LoggerFactory.getLogger(JobTemplateDetailService.class);

	@Autowired
	private JobTemplateDetails_Repo jobTemplateDetailsRepo;

	@Override
	public JobTemplateDetail_DTO newJobTemplateDetail(JobTemplateDetail_DTO jobTemplateDetailsDTO) 
	{
		JobTemplateDetailPK jobTemplateDetailsPK = new JobTemplateDetailPK();
		jobTemplateDetailsPK.setJobTemplateSeqNo(jobTemplateDetailsDTO.getJobTemplateSeqNo());
		jobTemplateDetailsPK.setJobLevelNo(jobTemplateDetailsDTO.getJobLevelNo());
		jobTemplateDetailsPK.setJOB_SEQ_NO(jobTemplateDetailsDTO.getJobSeqNo());
		jobTemplateDetailsPK.setSeqNo(jobTemplateDetailsDTO.getSeqNo());
		jobTemplateDetailsPK.setTargetSeqNo(jobTemplateDetailsDTO.getTargetSeqNo());
		jobTemplateDetailsPK.setTargetClassSeqNo(jobTemplateDetailsDTO.getTargetClassSeqNo());
		JobTemplateDetail jobTemplateDetails2 = null;
		JobTemplateDetail_DTO jobTemplateDetailsDTO2 = null;

		if (!jobTemplateDetailsRepo.existsById(jobTemplateDetailsPK)) {
			jobTemplateDetails2 = this.setJobTemplateDetail(jobTemplateDetailsDTO);
			jobTemplateDetails2.setId(jobTemplateDetailsPK);
			jobTemplateDetailsDTO2 = this.getJobTemplateDetail_DTO(jobTemplateDetails2);
		}
		return jobTemplateDetailsDTO2;
	}

	@Override
	public ArrayList<JobTemplateDetail_DTO> getAllJobTemplateDetails() {
		ArrayList<JobTemplateDetail> jobList = (ArrayList<JobTemplateDetail>) jobTemplateDetailsRepo
				.findAll();
		ArrayList<JobTemplateDetail_DTO> jobTemplateDetailsDTOs = new ArrayList<JobTemplateDetail_DTO>();
		jobTemplateDetailsDTOs = jobList != null ? this.getJobTemplateDetail_DTOs(jobList) : null;
		return jobTemplateDetailsDTOs;
	}

	@Override
	public ArrayList<JobTemplateDetail_DTO> getSelectJobTemplateDetails(ArrayList<Long> jobTemplateDetailsSeqNos) {
		ArrayList<JobTemplateDetail> jobTemplateDetails = null;
		ArrayList<JobTemplateDetail_DTO> jobTemplateDetailsDTOs = null;
		if (jobTemplateDetailsSeqNos != null) {
			jobTemplateDetails = jobTemplateDetailsRepo.getSelectJobTemplateDetails(jobTemplateDetailsSeqNos);
			if (jobTemplateDetails != null) 
			{
			jobTemplateDetailsDTOs = this.getJobTemplateDetail_DTOs(jobTemplateDetails);
			}
		}
		return jobTemplateDetailsDTOs;
	}

	@Override
	public void updJobTemplateDetail(JobTemplateDetail_DTO jobTemplateDetailsDTO)
	{
		JobTemplateDetailPK jobTemplateDetailsPK = new JobTemplateDetailPK();
		jobTemplateDetailsPK.setJobTemplateSeqNo(jobTemplateDetailsDTO.getJobTemplateSeqNo());
		jobTemplateDetailsPK.setJobLevelNo(jobTemplateDetailsDTO.getJobLevelNo());
		jobTemplateDetailsPK.setJOB_SEQ_NO(jobTemplateDetailsDTO.getJobSeqNo());
		jobTemplateDetailsPK.setSeqNo(jobTemplateDetailsDTO.getSeqNo());
		jobTemplateDetailsPK.setTargetSeqNo(jobTemplateDetailsDTO.getTargetSeqNo());
		jobTemplateDetailsPK.setTargetClassSeqNo(jobTemplateDetailsDTO.getTargetClassSeqNo());		
		JobTemplateDetail jobTemplateDetails2 = null;
		
		if (jobTemplateDetailsRepo.existsById(jobTemplateDetailsPK)) 
		{
			jobTemplateDetails2 = this.setJobTemplateDetail(jobTemplateDetailsDTO);
			jobTemplateDetails2.setId(jobTemplateDetailsPK);
			;
			jobTemplateDetailsRepo.save(jobTemplateDetails2);
		}
	}

	@Override
	public void delAllJobTemplateDetails() {
		jobTemplateDetailsRepo.deleteAll();
	}

	@Override
	public void delSelectJobTemplateDetails(ArrayList<Long> jobTemplateDetailsSeqNos) 
	{
		jobTemplateDetailsRepo.delSelectJobTemplateDetails(jobTemplateDetailsSeqNos);
	}

	private ArrayList<JobTemplateDetail_DTO> getJobTemplateDetail_DTOs(
			ArrayList<JobTemplateDetail> jobTemplateDetails) {
		JobTemplateDetail_DTO jobTemplateDetailsDTO = null;
		ArrayList<JobTemplateDetail_DTO> jobTemplateDetailsDTOs = new ArrayList<JobTemplateDetail_DTO>();

		for (int i = 0; i < jobTemplateDetails.size(); i++) {
			jobTemplateDetailsDTO = getJobTemplateDetail_DTO(jobTemplateDetails.get(i));
			jobTemplateDetailsDTOs.add(jobTemplateDetailsDTO);
		}
		return jobTemplateDetailsDTOs;
	}

	private JobTemplateDetail_DTO getJobTemplateDetail_DTO(JobTemplateDetail jobTemplateDetails) 
	{
		JobTemplateDetail_DTO jobTemplateDetailsDTO = new JobTemplateDetail_DTO();
		jobTemplateDetailsDTO.setJobTemplateSeqNo(jobTemplateDetails.getId().getJobTemplateSeqNo());		
		jobTemplateDetailsDTO.setJobSeqNo(jobTemplateDetails.getId().getJOB_SEQ_NO());
		jobTemplateDetailsDTO.setSeqNo(jobTemplateDetails.getId().getSeqNo());
		jobTemplateDetailsDTO.setTargetSeqNo(jobTemplateDetails.getId().getTargetSeqNo());
		jobTemplateDetailsDTO.setTargetClassSeqNo(jobTemplateDetails.getId().getTargetClassSeqNo());
		jobTemplateDetailsDTO.setJobLevelNo(jobTemplateDetails.getId().getJobLevelNo());
		jobTemplateDetailsDTO.setDaysPlus(jobTemplateDetailsDTO.getDaysPlus());
		jobTemplateDetailsDTO.setDurDays(jobTemplateDetailsDTO.getDurDays());
		jobTemplateDetailsDTO.setDurHours(jobTemplateDetailsDTO.getDurHours());
		jobTemplateDetailsDTO.setDurMinutes(jobTemplateDetailsDTO.getDurMinutes());
		jobTemplateDetailsDTO.setDurMonths(jobTemplateDetailsDTO.getDurMonths());
		jobTemplateDetailsDTO.setDurSeconds(jobTemplateDetailsDTO.getDurSeconds());
		jobTemplateDetailsDTO.setHoursPlus(jobTemplateDetailsDTO.getHoursPlus());				
		jobTemplateDetailsDTO.setMinutesPlus(jobTemplateDetailsDTO.getMinutesPlus());
		jobTemplateDetailsDTO.setPredecessorSeqNo(jobTemplateDetailsDTO.getPredecessorSeqNo());
		jobTemplateDetailsDTO.setSecondsPlus(jobTemplateDetailsDTO.getSecondsPlus());				
		return jobTemplateDetailsDTO;
	}

	private JobTemplateDetail setJobTemplateDetail(JobTemplateDetail_DTO cDTO) 
	{
		JobTemplateDetail jobTemplateDetails = new JobTemplateDetail();
		JobTemplateDetailPK jobTemplateDetailsPK = new JobTemplateDetailPK();
		jobTemplateDetailsPK.setJobTemplateSeqNo(cDTO.getJobTemplateSeqNo());
		jobTemplateDetailsPK.setJobLevelNo(cDTO.getJobLevelNo());
		jobTemplateDetailsPK.setJOB_SEQ_NO(cDTO.getJobSeqNo());
		jobTemplateDetailsPK.setSeqNo(cDTO.getSeqNo());
		jobTemplateDetailsPK.setTargetSeqNo(cDTO.getTargetSeqNo());
		jobTemplateDetailsPK.setTargetClassSeqNo(cDTO.getTargetClassSeqNo());
		jobTemplateDetails.setId(jobTemplateDetailsPK);
		jobTemplateDetails.setDaysPlus(cDTO.getDaysPlus());
		jobTemplateDetails.setDurDays(cDTO.getDurDays());
		jobTemplateDetails.setDurHours(cDTO.getDurHours());
		jobTemplateDetails.setDurMinutes(cDTO.getDurMinutes());
		jobTemplateDetails.setDurMonths(cDTO.getDurMonths());
		jobTemplateDetails.setDurSeconds(cDTO.getDurSeconds());
		jobTemplateDetails.setHoursPlus(cDTO.getHoursPlus());				
		jobTemplateDetails.setMinutesPlus(cDTO.getMinutesPlus());
		jobTemplateDetails.setPredecessorSeqNo(cDTO.getPredecessorSeqNo());
		jobTemplateDetails.setSecondsPlus(cDTO.getSecondsPlus());				
		return jobTemplateDetails;
	}
}