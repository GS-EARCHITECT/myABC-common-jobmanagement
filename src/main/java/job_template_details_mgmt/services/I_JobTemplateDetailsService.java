package job_template_details_mgmt.services;

import java.util.ArrayList;
import job_template_details_mgmt.model.dto.JobTemplateDetailsDTO;

public interface I_JobTemplateDetailsService 
{
	abstract public JobTemplateDetailsDTO newJobTemplateDetail(JobTemplateDetailsDTO jobTemplateDetailsDTO);
	abstract void updJobTemplateDetail(JobTemplateDetailsDTO jobTemplateDetailsDTO);
	abstract public ArrayList<JobTemplateDetailsDTO> getAllJobTemplateDetails();
	abstract ArrayList<JobTemplateDetailsDTO> getSelectJobTemplateDetails(ArrayList<Long> jobTemplateDetailsNos);
	abstract void delSelectJobTemplateDetails(ArrayList<Long> jobTemplateDetailsSeqNos);
	abstract public void delAllJobTemplateDetails();
}