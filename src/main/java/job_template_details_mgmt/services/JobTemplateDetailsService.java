package job_template_details_mgmt.services;

import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import job_template_details_mgmt.model.details.JobTemplateDetails;
import job_template_details_mgmt.model.details.JobTemplateDetailsPK;
import job_template_details_mgmt.model.dto.JobTemplateDetailsDTO;
import job_template_details_mgmt.model.repo.JobTemplateDetailsRepo;

@Service("jobTemplateDetailsServ")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class JobTemplateDetailsService implements I_JobTemplateDetailsService 
{
	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(JobTemplateDetailsService.class);

	@Autowired
	private JobTemplateDetailsRepo jobTemplateDetailsRepo;

	@Override
	public JobTemplateDetailsDTO newJobTemplateDetail(JobTemplateDetailsDTO jobTemplateDetailsDTO) 
	{
		JobTemplateDetailsPK jobTemplateDetailsPK = new JobTemplateDetailsPK();
		jobTemplateDetailsPK.setJobTemplateSeqNo(jobTemplateDetailsDTO.getJobTemplateSeqNo());
		jobTemplateDetailsPK.setJobLevelNo(jobTemplateDetailsDTO.getJobLevelNo());
		jobTemplateDetailsPK.setJOB_SEQ_NO(jobTemplateDetailsDTO.getJobSeqNo());
		jobTemplateDetailsPK.setSeqNo(jobTemplateDetailsDTO.getSeqNo());
		jobTemplateDetailsPK.setTargetSeqNo(jobTemplateDetailsDTO.getTargetSeqNo());
		jobTemplateDetailsPK.setTargetClassSeqNo(jobTemplateDetailsDTO.getTargetClassSeqNo());
		JobTemplateDetails jobTemplateDetails2 = null;
		JobTemplateDetailsDTO jobTemplateDetailsDTO2 = null;

		if (!jobTemplateDetailsRepo.existsById(jobTemplateDetailsPK)) {
			jobTemplateDetails2 = this.setJobTemplateDetails(jobTemplateDetailsDTO);
			jobTemplateDetails2.setId(jobTemplateDetailsPK);
			jobTemplateDetailsDTO2 = this.getJobTemplateDetailsDTO(jobTemplateDetails2);
		}
		return jobTemplateDetailsDTO2;
	}

	@Override
	public ArrayList<JobTemplateDetailsDTO> getAllJobTemplateDetails() {
		ArrayList<JobTemplateDetails> jobList = (ArrayList<JobTemplateDetails>) jobTemplateDetailsRepo
				.findAll();
		ArrayList<JobTemplateDetailsDTO> jobTemplateDetailsDTOs = new ArrayList<JobTemplateDetailsDTO>();
		jobTemplateDetailsDTOs = jobList != null ? this.getJobTemplateDetailsDTOs(jobList) : null;
		return jobTemplateDetailsDTOs;
	}

	@Override
	public ArrayList<JobTemplateDetailsDTO> getSelectJobTemplateDetails(ArrayList<Long> jobTemplateDetailsSeqNos) {
		ArrayList<JobTemplateDetails> jobTemplateDetails = null;
		ArrayList<JobTemplateDetailsDTO> jobTemplateDetailsDTOs = null;
		if (jobTemplateDetailsSeqNos != null) {
			jobTemplateDetails = jobTemplateDetailsRepo.getSelectJobTemplateDetails(jobTemplateDetailsSeqNos);
			if (jobTemplateDetails != null) 
			{
			jobTemplateDetailsDTOs = this.getJobTemplateDetailsDTOs(jobTemplateDetails);
			}
		}
		return jobTemplateDetailsDTOs;
	}

	@Override
	public void updJobTemplateDetail(JobTemplateDetailsDTO jobTemplateDetailsDTO)
	{
		JobTemplateDetailsPK jobTemplateDetailsPK = new JobTemplateDetailsPK();
		jobTemplateDetailsPK.setJobTemplateSeqNo(jobTemplateDetailsDTO.getJobTemplateSeqNo());
		jobTemplateDetailsPK.setJobLevelNo(jobTemplateDetailsDTO.getJobLevelNo());
		jobTemplateDetailsPK.setJOB_SEQ_NO(jobTemplateDetailsDTO.getJobSeqNo());
		jobTemplateDetailsPK.setSeqNo(jobTemplateDetailsDTO.getSeqNo());
		jobTemplateDetailsPK.setTargetSeqNo(jobTemplateDetailsDTO.getTargetSeqNo());
		jobTemplateDetailsPK.setTargetClassSeqNo(jobTemplateDetailsDTO.getTargetClassSeqNo());		
		JobTemplateDetails jobTemplateDetails2 = null;
		
		if (jobTemplateDetailsRepo.existsById(jobTemplateDetailsPK)) 
		{
			jobTemplateDetails2 = this.setJobTemplateDetails(jobTemplateDetailsDTO);
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
		jobTemplateDetailsRepo.delSelectJobTemplateDetails(jobTemplateDetailsSeqNos);;
	}

	private ArrayList<JobTemplateDetailsDTO> getJobTemplateDetailsDTOs(
			ArrayList<JobTemplateDetails> jobTemplateDetails) {
		JobTemplateDetailsDTO jobTemplateDetailsDTO = null;
		ArrayList<JobTemplateDetailsDTO> jobTemplateDetailsDTOs = new ArrayList<JobTemplateDetailsDTO>();

		for (int i = 0; i < jobTemplateDetails.size(); i++) {
			jobTemplateDetailsDTO = getJobTemplateDetailsDTO(jobTemplateDetails.get(i));
			jobTemplateDetailsDTOs.add(jobTemplateDetailsDTO);
		}
		return jobTemplateDetailsDTOs;
	}

	private JobTemplateDetailsDTO getJobTemplateDetailsDTO(JobTemplateDetails jobTemplateDetails) 
	{
		JobTemplateDetailsDTO jobTemplateDetailsDTO = new JobTemplateDetailsDTO();
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

	private JobTemplateDetails setJobTemplateDetails(JobTemplateDetailsDTO cDTO) 
	{
		JobTemplateDetails jobTemplateDetails = new JobTemplateDetails();
		JobTemplateDetailsPK jobTemplateDetailsPK = new JobTemplateDetailsPK();
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