package job_asset_master_mgmt.model.repo;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import job_asset_master_mgmt.model.master.JobAssetMaster;
import job_asset_master_mgmt.model.master.JobAssetMasterPK;

@Repository("jobAssetMasterAdminRepo")
public interface JobAssetMasterAdmin_Repo extends JpaRepository<JobAssetMaster, JobAssetMasterPK> 
{
	@Query(value = "SELECT * FROM JOB_ASSET_MASTER a WHERE a.job_seq_no in :jobSeqNos order by resource_seq_no", nativeQuery = true)
	ArrayList<JobAssetMaster> getSelectAssetsByJobs(@Param("jobSeqNos") ArrayList<Long> jobSeqNos);
	
	@Query(value = "SELECT * FROM JOB_ASSET_MASTER a WHERE a.target_seq_no in :trgSeqNos order by resource_seq_no", nativeQuery = true)
	ArrayList<JobAssetMaster> getSelectAssetsByTargets(@Param("trgSeqNos") ArrayList<Long> trgSeqNos);
	
	@Query(value = "SELECT * FROM JOB_ASSET_MASTER a WHERE a.resource_seq_no in :resourceSeqNos order by resource_seq_no", nativeQuery = true)
	ArrayList<JobAssetMaster> getSelectAssetsByAssets(@Param("resourceSeqNos") ArrayList<Long> resourceSeqNos);
	
	@Query(value = "DELETE FROM JOB_ASSET_MASTER WHERE a.job_seq_no in :jobSeqNos", nativeQuery = true)
	void delSelectAssetsByJobs(@Param("jobSeqNos") ArrayList<Long> jobSeqNos);

	@Query(value = "DELETE FROM JOB_ASSET_MASTER WHERE a.resource_seq_no in :resourceSeqNos", nativeQuery = true)
	void delSelectAssetsByAssets(@Param("resourceSeqNos") ArrayList<Long> resourceSeqNos);
	
	@Query(value = "DELETE FROM JOB_ASSET_MASTER a WHERE a.target_seq_no in :trgSeqNos order by resource_seq_no", nativeQuery = true)
	void delSelectAssetsByTargets(@Param("trgSeqNos") ArrayList<Long> trgSeqNos);
	
}
