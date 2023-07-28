package job_target_details.services;

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

import job_target_details.model.dto.JobTargetDetail_DTO;
import job_target_details.model.master.JobTargetDetail;
import job_target_details.model.master.JobTargetDetailPK;
import job_target_details.model.repo.JobTargetDetails_Repo;

@Service("jobTargetDetailsServ")
@Scope(value = "prototype", proxyMode = ScopedProxyMode.TARGET_CLASS)
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class JobTargetDetails_Service implements I_JobTargetDetails_Service 
{

//	private static final Logger logger = LoggerFactory.getLogger(JobTargetDetailService.class);

	@Autowired
	private JobTargetDetails_Repo jobTargetDetailsRepo;

	@Override
	public JobTargetDetail_DTO newJobTargetDetail(JobTargetDetail_DTO jobTargetDetailsDTO) 
	{
	
		JobTargetDetailPK jobTargetDetailsPK = new JobTargetDetailPK();
		jobTargetDetailsPK.setJobSeqNo(jobTargetDetailsDTO.getJobSeqNo());
		jobTargetDetailsPK.setTargetSeqNo(jobTargetDetailsDTO.getTargetSeqNo());
		JobTargetDetail jobTargetDetails = null;
			
		if(!jobTargetDetailsRepo.existsById(jobTargetDetailsPK))
		{		
		jobTargetDetailsDTO = getJobTargetDetail_DTO(jobTargetDetailsRepo.save(this.setJobTargetDetail(jobTargetDetailsDTO)));
		}
		return jobTargetDetailsDTO;
	}

	@Override
	public ArrayList<JobTargetDetail_DTO> getAllJobTargetDetails() 
	{
		ArrayList<JobTargetDetail> jobList = (ArrayList<JobTargetDetail>) jobTargetDetailsRepo.findAll();
		ArrayList<JobTargetDetail_DTO> jobTargetDetailsDTOs = new ArrayList<JobTargetDetail_DTO>();
		jobTargetDetailsDTOs = jobList != null ? this.getJobTargetDetail_DTOs(jobList) : null;
		return jobTargetDetailsDTOs;
	}

	@Override
	public ArrayList<JobTargetDetail_DTO> getSelectJobTargetDetails(ArrayList<JobTargetDetailPK> jobTargetDetailPKs) 
	{
		ArrayList<JobTargetDetail> jobList = (ArrayList<JobTargetDetail>) jobTargetDetailsRepo.findAllById(jobTargetDetailPKs);
		ArrayList<JobTargetDetail_DTO> jobTargetDetailsDTOs = new ArrayList<JobTargetDetail_DTO>();
		jobTargetDetailsDTOs = jobList != null ? this.getJobTargetDetail_DTOs(jobList) : null;
		return jobTargetDetailsDTOs;
	}

	@Override
	public void updJobTargetDetail(JobTargetDetail_DTO jobTargetDetailsDTO) 
	{
		JobTargetDetailPK jobTargetDetailsPK = new JobTargetDetailPK();
		jobTargetDetailsPK.setJobSeqNo(jobTargetDetailsDTO.getJobSeqNo());
		jobTargetDetailsPK.setTargetSeqNo(jobTargetDetailsDTO.getTargetSeqNo());
		JobTargetDetail jobTargetDetails = null;
		
		if(jobTargetDetailsRepo.existsById(jobTargetDetailsPK))
		{		
		jobTargetDetails = this.setJobTargetDetail(jobTargetDetailsDTO);
		jobTargetDetailsRepo.save(jobTargetDetails);
		}
	}

	@Override
	public void delAllJobTargetDetails() 
	{
		jobTargetDetailsRepo.deleteAll();
	}

	@Override
	public void delSelectJobTargetDetails(ArrayList<JobTargetDetailPK> jobTargetDetailPKs) 
	{
		jobTargetDetailsRepo.deleteAllById(jobTargetDetailPKs);
		
	}

	private ArrayList<JobTargetDetail_DTO> getJobTargetDetail_DTOs(ArrayList<JobTargetDetail> jobTargetDetails) {
		JobTargetDetail_DTO jobTargetDetailsDTO = null;
		ArrayList<JobTargetDetail_DTO> jobTargetDetailsDTOs = new ArrayList<JobTargetDetail_DTO>();

		for (int i = 0; i < jobTargetDetails.size(); i++) {
			jobTargetDetailsDTO = getJobTargetDetail_DTO(jobTargetDetails.get(i));
			jobTargetDetailsDTOs.add(jobTargetDetailsDTO);
		}
		return jobTargetDetailsDTOs;
	}

	private JobTargetDetail_DTO getJobTargetDetail_DTO(JobTargetDetail jobTargetDetails) 
	{
		JobTargetDetail_DTO jobTargetDetailsDTO = new JobTargetDetail_DTO();
		jobTargetDetailsDTO = new JobTargetDetail_DTO();
		jobTargetDetailsDTO.setJobSeqNo(jobTargetDetails.getId().getJobSeqNo());
		jobTargetDetailsDTO.setTargetSeqNo(jobTargetDetails.getId().getTargetSeqNo());
		jobTargetDetailsDTO.setDuration(jobTargetDetails.getDuration());
		jobTargetDetailsDTO.setDurationSeqNo(jobTargetDetails.getDurationSeqNo());
		jobTargetDetailsDTO.setDurMonths(jobTargetDetails.getDurMonths());
		jobTargetDetailsDTO.setDurWeeks(jobTargetDetails.getDurWeeks());
		jobTargetDetailsDTO.setDurDays(jobTargetDetails.getDurDays());
		jobTargetDetailsDTO.setDurHours(jobTargetDetails.getDurHours());
		jobTargetDetailsDTO.setDurMinutes(jobTargetDetails.getDurMinutes());
		jobTargetDetailsDTO.setDurSeconds(jobTargetDetails.getDurSeconds());
		jobTargetDetailsDTO.setRateSeqNo(jobTargetDetails.getRateSeqNo());
		jobTargetDetailsDTO.setUnitRate(jobTargetDetails.getUnitRate());		
		jobTargetDetailsDTO.setRemark(jobTargetDetails.getRemark());
		jobTargetDetailsDTO.setStatus(jobTargetDetails.getStatus());		
		return jobTargetDetailsDTO;
	}

	private JobTargetDetail setJobTargetDetail(JobTargetDetail_DTO cDTO) 
	{
		JobTargetDetail jobTargetDetails = new JobTargetDetail();
		JobTargetDetailPK jobTargetDetailsPK = new JobTargetDetailPK();
		jobTargetDetailsPK.setJobSeqNo(cDTO.getJobSeqNo());
		jobTargetDetailsPK.setTargetSeqNo(cDTO.getTargetSeqNo());		
		jobTargetDetails.setDuration(cDTO.getDuration());
		jobTargetDetails.setDurationSeqNo(cDTO.getDurationSeqNo());
		jobTargetDetails.setDurMonths(cDTO.getDurMonths());
		jobTargetDetails.setDurWeeks(cDTO.getDurWeeks());
		jobTargetDetails.setDurDays(cDTO.getDurDays());
		jobTargetDetails.setDurHours(cDTO.getDurHours());
		jobTargetDetails.setDurMinutes(cDTO.getDurMinutes());
		jobTargetDetails.setDurSeconds(cDTO.getDurSeconds());
		jobTargetDetails.setRateSeqNo(cDTO.getRateSeqNo());
		jobTargetDetails.setUnitRate(cDTO.getUnitRate());		
		jobTargetDetails.setRemark(cDTO.getRemark());
		jobTargetDetails.setStatus(cDTO.getStatus());
		jobTargetDetails.setId(jobTargetDetailsPK);
		return jobTargetDetails;
	}
}