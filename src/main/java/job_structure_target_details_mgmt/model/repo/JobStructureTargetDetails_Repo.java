package job_structure_target_details_mgmt.model.repo;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import job_structure_target_details_mgmt.model.details.JobStructureTargetDetail;
import job_structure_target_details_mgmt.model.details.JobStructureTargetDetailPK;

@Repository("jobStructureTargetDetailsRepo")
public interface JobStructureTargetDetails_Repo extends JpaRepository<JobStructureTargetDetail, JobStructureTargetDetailPK> 
{	
	@Query(value = "SELECT * from JOB_STRUCTURE_TARGET_DETAILS where JOB_SEQ_NO in :jobSeqNos ORDER BY JOB_SEQ_NO",nativeQuery = true) 
	ArrayList<JobStructureTargetDetail> getSelectJobStructureTargetDetailsForJobs(@Param(value = "jobSeqNos") ArrayList<Long> jobSeqNos);
	
	@Query(value = "SELECT * from JOB_STRUCTURE_TARGET_DETAILS where (par_JOB_SEQ_NO in :jobSeqNos and par_target_SEQ_NO in :parTargetSeqNos) ORDER BY SEQ_NO",nativeQuery = true) 
	ArrayList<JobStructureTargetDetail> getSelectJobStructureTargetDetailForParents(@Param(value = "jobSeqNos") ArrayList<Long> jobSeqNos, @Param(value = "parTargetSeqNo") ArrayList<Long> parTargetSeqNos);
	
	@Modifying
	@Query(value="delete from JOB_STRUCTURE_TARGET_DETAILS where JOB_SEQ_NO in :jobSeqNos", nativeQuery = true)
	void deleteSelectJobStructureTargetDetailForJobs(@Param(value = "jobSeqNos") ArrayList<Long> jobSeqNos);
	
	@Query(value = "delete from JOB_STRUCTURE_TARGET_DETAILS where (par_JOB_SEQ_NO in :jobSeqNos and par_target_SEQ_NO in :parTargetSeqNos)",nativeQuery = true) 
	void delSelectJobStructureTargetDetailForParents(@Param(value = "jobSeqNos") ArrayList<Long> jobSeqNos, @Param(value = "parTargetSeqNos") ArrayList<Long> parTargetSeqNos);
	
}