package job_target_details.services;

import java.util.ArrayList;

import job_target_details.model.dto.JobTargetDetail_DTO;
import job_target_details.model.master.JobTargetDetailPK;

public interface I_JobTargetDetails_Service 
{
	public JobTargetDetail_DTO newJobTargetDetail(JobTargetDetail_DTO jobTargetDetailDTO);
	public void updJobTargetDetail(JobTargetDetail_DTO jobTargetDetailsDTO);
	public ArrayList<JobTargetDetail_DTO> getAllJobTargetDetails();
	public ArrayList<JobTargetDetail_DTO> getSelectJobTargetDetails(ArrayList<JobTargetDetailPK> jobTargetDetailPKs);
	public void delSelectJobTargetDetails(ArrayList<JobTargetDetailPK> jobTargetDetailPKs);
	public void delAllJobTargetDetails();
}