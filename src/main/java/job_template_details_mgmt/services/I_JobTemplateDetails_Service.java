package job_template_details_mgmt.services;

import java.util.ArrayList;
import job_template_details_mgmt.model.dto.JobTemplateDetail_DTO;

public interface I_JobTemplateDetails_Service 
{
	abstract public JobTemplateDetail_DTO newJobTemplateDetail(JobTemplateDetail_DTO jobTemplateDetailsDTO);
	abstract void updJobTemplateDetail(JobTemplateDetail_DTO jobTemplateDetailsDTO);
	abstract public ArrayList<JobTemplateDetail_DTO> getAllJobTemplateDetails();
	abstract ArrayList<JobTemplateDetail_DTO> getSelectJobTemplateDetails(ArrayList<Long> jobTemplateDetailsNos);
	abstract void delSelectJobTemplateDetails(ArrayList<Long> jobTemplateDetailsSeqNos);
	abstract public void delAllJobTemplateDetails();
}