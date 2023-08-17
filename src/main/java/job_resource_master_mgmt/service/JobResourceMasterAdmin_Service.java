package job_resource_master_mgmt.service;

import java.util.ArrayList;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import job_resource_master_mgmt.model.dto.JobResourceMaster_DTO;
import job_resource_master_mgmt.model.master.JobResourceMaster;
import job_resource_master_mgmt.model.master.JobResourceMasterPK;
import job_resource_master_mgmt.model.repo.JobResourceMasterAdmin_Repo;

@Service("jobResourceMasterAdminServ")
@Scope(value = "prototype", proxyMode = ScopedProxyMode.TARGET_CLASS)
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class JobResourceMasterAdmin_Service implements I_JobResourceMasterAdmin_Service 
{

	@Autowired
	private JobResourceMasterAdmin_Repo jobResourceMasterAdminRepo;

	public JobResourceMaster_DTO newJobResource(JobResourceMaster_DTO lMasters) 
	{
		JobResourceMasterPK resourceJobResourceMasterPK= new JobResourceMasterPK();
		resourceJobResourceMasterPK.setResourceSeqNo(lMasters.getResourceSeqNo());
		resourceJobResourceMasterPK.setFrLocSeqNo(lMasters.getFrLocSeqNo());
		resourceJobResourceMasterPK.setToLocSeqNo(lMasters.getToLocSeqNo());
		resourceJobResourceMasterPK.setJobSeqNo(lMasters.getJobSeqNo());
		resourceJobResourceMasterPK.setModeSeqNo(lMasters.getModeSeqNo());
		resourceJobResourceMasterPK.setTargetSeqNo(lMasters.getTargetSeqNo());
		Optional<JobResourceMaster> resOptional = jobResourceMasterAdminRepo.findById(resourceJobResourceMasterPK);
		JobResourceMaster resourceJobResourceMaster = null;
		JobResourceMaster_DTO resourceJobResourceMasterDTO = null;
		
		if(!resOptional.isPresent())
		{
		resourceJobResourceMaster = this.setJobResourceMaster(lMasters);
		resourceJobResourceMaster.setId(resourceJobResourceMasterPK);
		resourceJobResourceMasterDTO=getJobResourceMaster_DTO(jobResourceMasterAdminRepo.save(resourceJobResourceMaster));
		}	
		return resourceJobResourceMasterDTO;
	}

	public void updJobResource(JobResourceMaster_DTO lMaster) 
	{
		JobResourceMasterPK resourceJobResourceMasterPK= new JobResourceMasterPK();
		resourceJobResourceMasterPK.setResourceSeqNo(lMaster.getResourceSeqNo());
		resourceJobResourceMasterPK.setFrLocSeqNo(lMaster.getFrLocSeqNo());
		resourceJobResourceMasterPK.setToLocSeqNo(lMaster.getToLocSeqNo());
		resourceJobResourceMasterPK.setJobSeqNo(lMaster.getJobSeqNo());
		resourceJobResourceMasterPK.setModeSeqNo(lMaster.getModeSeqNo());
		resourceJobResourceMasterPK.setTargetSeqNo(lMaster.getTargetSeqNo());
		JobResourceMaster resourceJobResourceMaster = this.setJobResourceMaster(lMaster);
		
		if (jobResourceMasterAdminRepo.existsById(resourceJobResourceMasterPK)) 
		{		
		resourceJobResourceMaster.setId(resourceJobResourceMasterPK);			
		jobResourceMasterAdminRepo.save(resourceJobResourceMaster);			
		}
		return;
	}

	
	public ArrayList<JobResourceMaster_DTO> getAllJobResources() 
	{
		ArrayList<JobResourceMaster> resourceList = (ArrayList<JobResourceMaster>) jobResourceMasterAdminRepo.findAll();
		ArrayList<JobResourceMaster_DTO> lMasterss = new ArrayList<JobResourceMaster_DTO>();
		lMasterss = resourceList != null ? this.getJobResourceMaster_DTOs(resourceList) : null;
		return lMasterss;
	}

	public ArrayList<JobResourceMaster_DTO> getSelectJobResources(ArrayList<JobResourceMasterPK> jobResourceMasterPKs)
	{
		ArrayList<JobResourceMaster> lMasters = (ArrayList<JobResourceMaster>) jobResourceMasterAdminRepo.findAllById(jobResourceMasterPKs);
		ArrayList<JobResourceMaster_DTO> jobResourceMaster_DTOs = new ArrayList<JobResourceMaster_DTO>();
		jobResourceMaster_DTOs = lMasters != null ? this.getJobResourceMaster_DTOs(lMasters) : null;
		return jobResourceMaster_DTOs;		
	}
   
	public ArrayList<JobResourceMaster_DTO> getSelectJobResourcesByJobs( ArrayList<Long> jobSeqNos)
	{
		ArrayList<JobResourceMaster> jobResourceMasters = jobResourceMasterAdminRepo.getSelectResourcesByJobs(jobSeqNos);
		ArrayList<JobResourceMaster_DTO> jobResourceMaster_DTOs = new ArrayList<JobResourceMaster_DTO>();
		jobResourceMaster_DTOs = jobResourceMasters != null ? this.getJobResourceMaster_DTOs(jobResourceMasters) : null;
		return jobResourceMaster_DTOs;
	}

	public ArrayList<JobResourceMaster_DTO> getSelectJobResourcesByTargets( ArrayList<Long> trgSeqNos)	
	{
		ArrayList<JobResourceMaster> lMasters = jobResourceMasterAdminRepo.getSelectResourcesByTargets(trgSeqNos);
		ArrayList<JobResourceMaster_DTO> jobResourceMaster_DTOs = new ArrayList<JobResourceMaster_DTO>();
		jobResourceMaster_DTOs = lMasters != null ? this.getJobResourceMaster_DTOs(lMasters) : null;
		return jobResourceMaster_DTOs;
	}

	public ArrayList<JobResourceMaster_DTO> getSelectJobResourcesByResources( ArrayList<Long> resourceSeqNos)	
	{
		ArrayList<JobResourceMaster> lMasters = jobResourceMasterAdminRepo.getSelectResourcesByResources(resourceSeqNos);
		ArrayList<JobResourceMaster_DTO> jobResourceMaster_DTOs = new ArrayList<JobResourceMaster_DTO>();
		jobResourceMaster_DTOs = lMasters != null ? this.getJobResourceMaster_DTOs(lMasters) : null;
		return jobResourceMaster_DTOs;
	}


	public void delAllJobResources() 
	{
		jobResourceMasterAdminRepo.deleteAll();;
		return;
	}
	
	public void delSelectJobResources(ArrayList<JobResourceMasterPK> ids) 
	{
		jobResourceMasterAdminRepo.deleteAllById(ids);
		
		return;
	}

	public void delSelectJobResourcesByResources( ArrayList<Long> resourceSeqNos) 
	{
		jobResourceMasterAdminRepo.delSelectResourcesByResources( resourceSeqNos);
		
		return;
	}
	

	public void delSelectJobResourcesByJobs( ArrayList<Long> jobSeqNos) 
	{
		jobResourceMasterAdminRepo.delSelectResourcesByJobs(jobSeqNos);
		
		return;
	}

	public void delSelectJobResourcesByTargets( ArrayList<Long> trgSeqNos) 
	{
		jobResourceMasterAdminRepo.delSelectResourcesByTargets(trgSeqNos);;
		
		return;
	}
	

	private ArrayList<JobResourceMaster_DTO> getJobResourceMaster_DTOs(ArrayList<JobResourceMaster> lMasters) {
		JobResourceMaster_DTO lDTO = null;
		ArrayList<JobResourceMaster_DTO> lMasterDTOs = new ArrayList<JobResourceMaster_DTO>();		
		for (int i = 0; i < lMasters.size(); i++) {
			lDTO = getJobResourceMaster_DTO(lMasters.get(i));			
			lMasterDTOs.add(lDTO);
		}
		return lMasterDTOs;
	}

	private JobResourceMaster_DTO getJobResourceMaster_DTO(JobResourceMaster lMaster) 
	{		
		JobResourceMaster_DTO lDTO = new JobResourceMaster_DTO();
		lDTO.setQtySeqNo(lMaster.getQtySeqNo());
		lDTO.setQty(lMaster.getQty());		
		lDTO.setResourceSeqNo(lMaster.getId().getResourceSeqNo());
		lDTO.setFrLocSeqNo(lMaster.getId().getFrLocSeqNo());
		lDTO.setToLocSeqNo(lMaster.getId().getToLocSeqNo());
		lDTO.setJobSeqNo(lMaster.getId().getJobSeqNo());
		lDTO.setTargetSeqNo(lMaster.getId().getTargetSeqNo());
		lDTO.setUnitRate(lMaster.getUnitRate());
		lDTO.setModeSeqNo(lMaster.getId().getModeSeqNo());
		lDTO.setRateSeqNo(lMaster.getRateSeqNo());
		lDTO.setReturnflag(lMaster.getReturnflag());
		return lDTO;
	}

	private JobResourceMaster setJobResourceMaster(JobResourceMaster_DTO lDTO) 
	{
		JobResourceMaster lMaster = new JobResourceMaster();
		JobResourceMasterPK resourceJobResourceMasterPK= new JobResourceMasterPK();
		resourceJobResourceMasterPK.setResourceSeqNo(lDTO.getResourceSeqNo());
		resourceJobResourceMasterPK.setFrLocSeqNo(lDTO.getFrLocSeqNo());
		resourceJobResourceMasterPK.setToLocSeqNo(lDTO.getToLocSeqNo());
		resourceJobResourceMasterPK.setJobSeqNo(lDTO.getJobSeqNo());
		resourceJobResourceMasterPK.setModeSeqNo(lDTO.getModeSeqNo());		
		resourceJobResourceMasterPK.setTargetSeqNo(lDTO.getTargetSeqNo());		
		lMaster.setId(resourceJobResourceMasterPK);
		lMaster.setReturnflag(lMaster.getReturnflag());
		lMaster.setQtySeqNo(lDTO.getQtySeqNo());
		lMaster.setQty(lDTO.getQty());
		lMaster.setUnitRate(lMaster.getUnitRate());				
		lMaster.setRateSeqNo(lDTO.getRateSeqNo());		
		return lMaster;
	}
}