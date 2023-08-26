package job_party_master.model.repo;

import java.util.ArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import job_party_master.model.master.JobPartyMaster;

@Repository("jobPartyMasterRepo")
public interface JobPartyMaster_Repo extends JpaRepository<JobPartyMaster, Long> 
{

	@Query(value = "SELECT * from  JOB_PARTY_MASTER where party_SEQ_NO in :ids ORDER BY JOB_SEQ_NO", nativeQuery = true)
	ArrayList<JobPartyMaster> getSelectJobPartyMastersByParties(@Param("pids") ArrayList<Long> pids);

	@Query(value = "SELECT * from  JOB_PARTY_MASTER where master_job_SEQ_NO in :ids ORDER BY JOB_SEQ_NO", nativeQuery = true)
	ArrayList<JobPartyMaster> getSelectJobPartyMastersByMasterJobs(@Param("ids") ArrayList<Long> ids);
	
	@Query(value = "delete from  JOB_PARTY_MASTER where party_SEQ_NO in :ids", nativeQuery = true)
	void delSelectJobPartyMastersByParties(@Param("pids") ArrayList<Long> pids);
	
	@Query(value = "SELECT * from  JOB_PARTY_MASTER where master_job_SEQ_NO in :ids", nativeQuery = true)
	void delSelectJobPartyMastersByMasterJobs(@Param("ids") ArrayList<Long> ids);

}