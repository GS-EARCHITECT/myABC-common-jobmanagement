package job_party_master.services;

import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import job_party_master.model.dto.JobPartyMaster_DTO;
import job_party_master.model.master.JobPartyMaster;
import job_party_master.model.repo.JobPartyMaster_Repo;

@Service("jobPartyMasterServ")
@Scope(value = "prototype", proxyMode = ScopedProxyMode.TARGET_CLASS)
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class JobPartyMaster_Service implements I_JobPartyMaster_Service 
{

//	private static final Logger logger = LoggerFactory.getLogger(JobPartyMasterService.class);

	@Autowired
	private JobPartyMaster_Repo jobPartyMasterRepo;

	@Override
	public JobPartyMaster_DTO newJobPartyMaster(JobPartyMaster_DTO jcmDTO) 
	{
		if(!jobPartyMasterRepo.existsById(jcmDTO.getJobSeqNo()))
		{
		jcmDTO = this.getJobPartyMaster_DTO(jobPartyMasterRepo.save(this.setJobPartyMaster(jcmDTO)));
		}
		return jcmDTO;
	}

	@Override
	public void updJobPartyMaster(JobPartyMaster_DTO jcmDTO) 
	{
		JobPartyMaster jobMaster2 = null;

		if (jobPartyMasterRepo.existsById(jcmDTO.getJobSeqNo())) 
		{
			jobMaster2 = this.setJobPartyMaster(jcmDTO);
			jobMaster2.setJobSeqNo(jcmDTO.getJobSeqNo());
			jobPartyMasterRepo.save(jobMaster2);
		}
	}

	@Override
	public ArrayList<JobPartyMaster_DTO> getSelectJobPartyMasters(ArrayList<Long> jcmSeqNos) 
{
		ArrayList<JobPartyMaster> jobList = (ArrayList<JobPartyMaster>) jobPartyMasterRepo.findAllById(jcmSeqNos);
		ArrayList<JobPartyMaster_DTO> jcmDTOs = new ArrayList<JobPartyMaster_DTO>();
		jcmDTOs = jobList != null ? this.getJobPartyMaster_DTOs(jobList) : null;
		return jcmDTOs;
	}

	@Override
	public ArrayList<JobPartyMaster_DTO> getSelectJobPartyMastersByParties(ArrayList<Long> pids) 
	{
		ArrayList<JobPartyMaster> jobList = jobPartyMasterRepo.getSelectJobPartyMastersByParties(pids);
		ArrayList<JobPartyMaster_DTO> jcmDTOs = new ArrayList<JobPartyMaster_DTO>();
		jcmDTOs = jobList != null ? this.getJobPartyMaster_DTOs(jobList) : null;
		return jcmDTOs;
	}

	@Override
	public ArrayList<JobPartyMaster_DTO> getSelectJobPartyMastersByMasterJobs(ArrayList<Long> ids) 
	{
		ArrayList<JobPartyMaster> jobList = jobPartyMasterRepo.getSelectJobPartyMastersByMasterJobs(ids);
		ArrayList<JobPartyMaster_DTO> jcmDTOs = new ArrayList<JobPartyMaster_DTO>();
		jcmDTOs = jobList != null ? this.getJobPartyMaster_DTOs(jobList) : null;
		return jcmDTOs;
	}
	
	@Override
	public ArrayList<JobPartyMaster_DTO> getAllJobPartyMasters() 
	{
		ArrayList<JobPartyMaster> jobList = (ArrayList<JobPartyMaster>) jobPartyMasterRepo.findAll();
		ArrayList<JobPartyMaster_DTO> jobDTOs = new ArrayList<JobPartyMaster_DTO>();
		jobDTOs = jobList != null ? this.getJobPartyMaster_DTOs(jobList) : null;
		return jobDTOs;
	}

	@Override
	public void delAllJobPartyMasters() 
	{
		jobPartyMasterRepo.deleteAll();
	}

	@Override
	public void delSelectJobPartyMasters(ArrayList<Long> jcmSeqNos) 
	{
		jobPartyMasterRepo.deleteAllById(jcmSeqNos); 
	}

	@Override
	public void delSelectJobPartyMastersByParties(ArrayList<Long> jcmSeqNos) 
	{
		jobPartyMasterRepo.delSelectJobPartyMastersByParties(jcmSeqNos); 
	}

	@Override
	public void delSelectJobPartyMastersByMasterJobs(ArrayList<Long> ids) 
	{
		jobPartyMasterRepo.delSelectJobPartyMastersByMasterJobs(ids); 
	}
	
	private ArrayList<JobPartyMaster_DTO> getJobPartyMaster_DTOs(ArrayList<JobPartyMaster> jobMasters) {
		JobPartyMaster_DTO jobDTO = null;
		ArrayList<JobPartyMaster_DTO> jobDTOs = new ArrayList<JobPartyMaster_DTO>();

		for (int i = 0; i < jobMasters.size(); i++) {
			jobDTO = getJobPartyMaster_DTO(jobMasters.get(i));
			jobDTOs.add(jobDTO);
		}
		return jobDTOs;
	}

	private JobPartyMaster_DTO getJobPartyMaster_DTO(JobPartyMaster jobMaster2) 
	{
		JobPartyMaster_DTO jobMasterDTO = new JobPartyMaster_DTO();
		jobMasterDTO.setJobSeqNo(jobMaster2.getJobSeqNo());
		jobMasterDTO.setMasterJobSeqNo(jobMaster2.getMasterJobSeqNo());
		jobMasterDTO.setPartySeqNo(jobMaster2.getPartySeqNo());
		jobMasterDTO.setDescription(jobMaster2.getDescription());
		jobMasterDTO.setDiscPer(jobMaster2.getDiscPer());
		jobMasterDTO.setDiscSeqNo(jobMaster2.getDiscSeqNo());
		jobMasterDTO.setDiscVal(jobMaster2.getDiscVal());
		jobMasterDTO.setDuration(jobMaster2.getDuration());
		jobMasterDTO.setJob(jobMaster2.getJob());
		jobMasterDTO.setJobId(jobMaster2.getJobId());
		jobMasterDTO.setSpecificationSeqNo(jobMaster2.getSpecificationSeqNo());
		jobMasterDTO.setStatus(jobMaster2.getStatus());
		jobMasterDTO.setTaxPer(jobMaster2.getTaxPer());
		jobMasterDTO.setTaxSeqNo(jobMaster2.getTaxSeqNo());
		jobMasterDTO.setTaxVal(jobMaster2.getTaxVal());
		jobMasterDTO.setUnitRate(jobMaster2.getUnitRate());
		jobMasterDTO.setUnitRateSeqNo(jobMaster2.getUnitRateSeqNo());
		jobMasterDTO.setDurationCodeSeqNo(jobMaster2.getDurationCodeSeqNo());		
		return jobMasterDTO;
	}

	private JobPartyMaster setJobPartyMaster(JobPartyMaster_DTO cDTO) 
	{
		JobPartyMaster jobMaster2 = new JobPartyMaster();		
		jobMaster2.setMasterJobSeqNo(cDTO.getMasterJobSeqNo());
		jobMaster2.setPartySeqNo(cDTO.getPartySeqNo());
		jobMaster2.setDescription(cDTO.getDescription());
		jobMaster2.setDiscPer(cDTO.getDiscPer());
		jobMaster2.setDiscSeqNo(cDTO.getDiscSeqNo());
		jobMaster2.setDiscVal(cDTO.getDiscVal());
		jobMaster2.setDuration(cDTO.getDuration());
		jobMaster2.setJob(cDTO.getJob());
		jobMaster2.setJobId(cDTO.getJobId());
		jobMaster2.setSpecificationSeqNo(cDTO.getSpecificationSeqNo());
		jobMaster2.setStatus(cDTO.getStatus());
		jobMaster2.setTaxPer(jobMaster2.getTaxPer());
		jobMaster2.setTaxSeqNo(jobMaster2.getTaxSeqNo());
		jobMaster2.setTaxVal(jobMaster2.getTaxVal());
		jobMaster2.setUnitRate(jobMaster2.getUnitRate());
		jobMaster2.setUnitRateSeqNo(jobMaster2.getUnitRateSeqNo());
		jobMaster2.setDurationCodeSeqNo(jobMaster2.getDurationCodeSeqNo());
		return jobMaster2;
	}
}