package job_target_details.model.repo;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import job_target_details.model.master.JobTargetDetail;
import job_target_details.model.master.JobTargetDetailPK;

@Repository("jobTargetDetailsRepo")
public interface JobTargetDetails_Repo extends JpaRepository<JobTargetDetail, JobTargetDetailPK> 
{	
	@Modifying
	@Query(value="delete from JOB_TARGET_DETAILS  where JOB_SEQ_NO in :jobSeqNos", nativeQuery = true)
	void deleteSelectJobTargetDetails(@Param("jobSeqNos") ArrayList<Long> jobSeqNos);
	
	@Query(value = "SELECT * from  JOB_TARGET_DETAILS where JOB_SEQ_NO in :jobTargetDetailsSeqNos ORDER BY JOB_SEQ_NO",nativeQuery = true) 
	ArrayList<JobTargetDetail> getSelectJobTargetDetails(@Param("jobTargetDetailsSeqNos") ArrayList<Long> jobTargetDetailsSeqNos);
	
}