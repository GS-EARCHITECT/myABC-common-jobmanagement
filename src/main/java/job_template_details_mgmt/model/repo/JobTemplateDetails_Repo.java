package job_template_details_mgmt.model.repo;

import java.util.ArrayList;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import job_template_details_mgmt.model.details.JobTemplateDetail;
import job_template_details_mgmt.model.details.JobTemplateDetailPK;

@Repository("jobTemplateDetailsRepo")
public interface JobTemplateDetails_Repo extends CrudRepository<JobTemplateDetail, JobTemplateDetailPK> 
{
	@Modifying
	@Query(value = "delete from JOB_TEMPLATE_DETAILS  where JOB_TEMPLATE_SEQ_NO in :jobTemplateDetailsSeqNos", nativeQuery = true)
	void delSelectJobTemplateDetails(@Param(value = "jobTemplateDetailsSeqNos") ArrayList<Long> jobTemplateDetailsSeqNos);

	@Query(value = "SELECT * JOB_TEMPLATE_DETAILS where JOB_TEMPLATE_SEQ_NO in :jobTemplateDetailsSeqNos ORDER BY JOB_TEMPLATE_SEQ_NO", nativeQuery = true)
	ArrayList<JobTemplateDetail> getSelectJobTemplateDetails(@Param("jobTemplateDetailsSeqNos") ArrayList<Long> jobTemplateDetailsSeqNos);
	
}