package job_resource_master_mgmt.model.repo;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import job_resource_master_mgmt.model.master.JobResourceMaster;
import job_resource_master_mgmt.model.master.JobResourceMasterPK;

@Repository("jobResourceMasterAdminRepo")
public interface JobResourceMasterAdmin_Repo extends JpaRepository<JobResourceMaster, JobResourceMasterPK> 
{
	@Query(value = "SELECT * FROM JOB_RESOURCE_MASTER a WHERE a.job_seq_no in :jobSeqNos order by resource_seq_no", nativeQuery = true)
	ArrayList<JobResourceMaster> getSelectResourcesByJobs(@Param("jobSeqNos") ArrayList<Long> jobSeqNos);
	
	@Query(value = "SELECT * FROM JOB_RESOURCE_MASTER a WHERE a.target_seq_no in :trgSeqNos order by resource_seq_no", nativeQuery = true)
	ArrayList<JobResourceMaster> getSelectResourcesByTargets(@Param("trgSeqNos") ArrayList<Long> trgSeqNos);
	
	@Query(value = "SELECT * FROM JOB_RESOURCE_MASTER a WHERE a.resource_seq_no in :resourceSeqNos order by resource_seq_no", nativeQuery = true)
	ArrayList<JobResourceMaster> getSelectResourcesByResources(@Param("resourceSeqNos") ArrayList<Long> resourceSeqNos);
	
	@Query(value = "DELETE FROM JOB_RESOURCE_MASTER WHERE a.job_seq_no in :jobSeqNos", nativeQuery = true)
	void delSelectResourcesByJobs(@Param("jobSeqNos") ArrayList<Long> jobSeqNos);

	@Query(value = "DELETE FROM JOB_RESOURCE_MASTER WHERE a.resource_seq_no in :resourceSeqNos", nativeQuery = true)
	void delSelectResourcesByResources(@Param("resourceSeqNos") ArrayList<Long> resourceSeqNos);
	
	@Query(value = "DELETE FROM JOB_RESOURCE_MASTER a WHERE a.target_seq_no in :trgSeqNos order by resource_seq_no", nativeQuery = true)
	void delSelectResourcesByTargets(@Param("trgSeqNos") ArrayList<Long> trgSeqNos);
	
}
