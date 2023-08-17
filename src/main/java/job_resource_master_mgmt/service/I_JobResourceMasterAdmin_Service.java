package job_resource_master_mgmt.service;

import java.util.ArrayList;
import job_resource_master_mgmt.model.dto.JobResourceMaster_DTO;
import job_resource_master_mgmt.model.master.JobResourceMasterPK;

public interface I_JobResourceMasterAdmin_Service 
{
	public JobResourceMaster_DTO newJobResource(JobResourceMaster_DTO jobResourceMaster_DTO);
	public void updJobResource(JobResourceMaster_DTO jobResourceMaster_DTO);
	public ArrayList<JobResourceMaster_DTO> getAllJobResources();
	public ArrayList<JobResourceMaster_DTO> getSelectJobResources(ArrayList<JobResourceMasterPK> jobResourceMasterPKs);	
	public ArrayList<JobResourceMaster_DTO> getSelectJobResourcesByJobs( ArrayList<Long> jobSeqNos);
	public ArrayList<JobResourceMaster_DTO> getSelectJobResourcesByTargets( ArrayList<Long> trgSeqNos);
	public ArrayList<JobResourceMaster_DTO> getSelectJobResourcesByResources( ArrayList<Long> resourceSeqNos);		
	public void delAllJobResources();
	public void delSelectJobResources(ArrayList<JobResourceMasterPK> ids);
	public void delSelectJobResourcesByJobs(ArrayList<Long> jobSeqNos);	
	public void delSelectJobResourcesByResources( ArrayList<Long> resourceSeqNos);
	public void delSelectJobResourcesByTargets( ArrayList<Long> trgSeqNos);

}