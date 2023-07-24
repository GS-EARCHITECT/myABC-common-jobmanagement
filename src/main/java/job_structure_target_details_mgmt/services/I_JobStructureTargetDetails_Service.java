package job_structure_target_details_mgmt.services;

import java.util.ArrayList;

import job_structure_target_details_mgmt.model.details.JobStructureTargetDetailPK;
import job_structure_target_details_mgmt.model.dto.JobStructureTargetDetail_DTO;

public interface I_JobStructureTargetDetails_Service 
{
	public JobStructureTargetDetail_DTO newJobStructureTargetDetail(JobStructureTargetDetail_DTO jobStructureTargetDetailsDTO);
	public void updJobStructureTargetDetail(JobStructureTargetDetail_DTO jobStructureTargetDetailsDTO);
	public ArrayList<JobStructureTargetDetail_DTO> getAllJobStructureTargetDetails();
	public ArrayList<JobStructureTargetDetail_DTO> getSelectJobStructureTargetDetails(ArrayList<JobStructureTargetDetailPK> jobStructureTargetDetailPKs);
	public ArrayList<JobStructureTargetDetail_DTO> getSelectJobStructureTargetDetailsForJobs(ArrayList<Long> jobSeqNos);
	public ArrayList<JobStructureTargetDetail_DTO> getSelectJobStructureTargetDetailsForParents(ArrayList<Long> jobSeqNos, ArrayList<Long> parTargetSeqNo);
	public void deleteSelectJobStructureTargetDetailForJobs(ArrayList<Long> jobSeqNos);
	public void delSelectJobStructureTargetDetails(ArrayList<JobStructureTargetDetailPK> jobStructureTargetDetailPKs);
	public void delSelectJobStructureTargetDetailForParents(ArrayList<Long> jobSeqNos, ArrayList<Long> parTargetSeqNo);
	public void delAllJobStructureTargetDetails();	
}