package job_party_master.services;

import java.util.ArrayList;
import job_party_master.model.dto.JobPartyMaster_DTO;

public interface I_JobPartyMaster_Service 
{
	public JobPartyMaster_DTO newJobPartyMaster(JobPartyMaster_DTO jcmDTO);
	public void updJobPartyMaster(JobPartyMaster_DTO jcmDTO);
	public ArrayList<JobPartyMaster_DTO> getSelectJobPartyMasters(ArrayList<Long> ids);
	public ArrayList<JobPartyMaster_DTO> getSelectJobPartyMastersByParties(ArrayList<Long> pids);
	public ArrayList<JobPartyMaster_DTO> getSelectJobPartyMastersByMasterJobs(ArrayList<Long> ids);
	public ArrayList<JobPartyMaster_DTO> getAllJobPartyMasters();
	public void delAllJobPartyMasters();	
	public void delSelectJobPartyMasters(ArrayList<Long> ids);
	public void delSelectJobPartyMastersByParties(ArrayList<Long> pids);
	public void delSelectJobPartyMastersByMasterJobs(ArrayList<Long> ids);
}