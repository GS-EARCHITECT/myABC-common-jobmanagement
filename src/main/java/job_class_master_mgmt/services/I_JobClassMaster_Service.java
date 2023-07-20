package job_class_master_mgmt.services;

import java.util.ArrayList;
import job_class_master_mgmt.model.dto.JobClassMaster_DTO;

public interface I_JobClassMaster_Service 
{
	public JobClassMaster_DTO newJobClass(JobClassMaster_DTO jcmDTO);
	public void updJobClass(JobClassMaster_DTO jcmDTO);
	public ArrayList<JobClassMaster_DTO> getSelectJobClasses(ArrayList<Long> ids);
	public ArrayList<JobClassMaster_DTO> getAllJobClasses();
	public void delAllJobClasses();	
	public void delSelectJobClasses(ArrayList<Long> ids);
}