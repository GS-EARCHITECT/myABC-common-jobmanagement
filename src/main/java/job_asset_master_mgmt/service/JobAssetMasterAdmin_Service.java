package job_asset_master_mgmt.service;

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
import job_asset_master_mgmt.model.dto.JobAssetMaster_DTO;
import job_asset_master_mgmt.model.master.JobAssetMaster;
import job_asset_master_mgmt.model.master.JobAssetMasterPK;
import job_asset_master_mgmt.model.repo.JobAssetMasterAdmin_Repo;

@Service("jobAssetMasterAdminServ")
@Scope(value = "prototype", proxyMode = ScopedProxyMode.TARGET_CLASS)
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class JobAssetMasterAdmin_Service implements I_JobAssetMasterAdmin_Service 
{

	@Autowired
	private JobAssetMasterAdmin_Repo jobAssetMasterAdminRepo;

	public JobAssetMaster_DTO newJobAsset(JobAssetMaster_DTO lMasters) 
	{
		JobAssetMasterPK assetJobAssetMasterPK= new JobAssetMasterPK();
		assetJobAssetMasterPK.setAssetSeqNo(lMasters.getAssetSeqNo());
		assetJobAssetMasterPK.setFrLocSeqNo(lMasters.getFrLocSeqNo());
		assetJobAssetMasterPK.setToLocSeqNo(lMasters.getToLocSeqNo());
		assetJobAssetMasterPK.setJobSeqNo(lMasters.getJobSeqNo());
		assetJobAssetMasterPK.setModeSeqNo(lMasters.getModeSeqNo());
		assetJobAssetMasterPK.setTargetSeqNo(lMasters.getTargetSeqNo());
		Optional<JobAssetMaster> resOptional = jobAssetMasterAdminRepo.findById(assetJobAssetMasterPK);
		JobAssetMaster assetJobAssetMaster = null;
		JobAssetMaster_DTO assetJobAssetMasterDTO = null;
		
		if(!resOptional.isPresent())
		{
		assetJobAssetMaster = this.setJobAssetMaster(lMasters);
		assetJobAssetMaster.setId(assetJobAssetMasterPK);
		assetJobAssetMasterDTO=getJobAssetMaster_DTO(jobAssetMasterAdminRepo.save(assetJobAssetMaster));
		}	
		return assetJobAssetMasterDTO;
	}

	public void updJobAsset(JobAssetMaster_DTO lMaster) 
	{
		JobAssetMasterPK assetJobAssetMasterPK= new JobAssetMasterPK();
		assetJobAssetMasterPK.setAssetSeqNo(lMaster.getAssetSeqNo());
		assetJobAssetMasterPK.setFrLocSeqNo(lMaster.getFrLocSeqNo());
		assetJobAssetMasterPK.setToLocSeqNo(lMaster.getToLocSeqNo());
		assetJobAssetMasterPK.setJobSeqNo(lMaster.getJobSeqNo());
		assetJobAssetMasterPK.setModeSeqNo(lMaster.getModeSeqNo());
		assetJobAssetMasterPK.setTargetSeqNo(lMaster.getTargetSeqNo());
		JobAssetMaster assetJobAssetMaster = this.setJobAssetMaster(lMaster);
		
		if (jobAssetMasterAdminRepo.existsById(assetJobAssetMasterPK)) 
		{		
		assetJobAssetMaster.setId(assetJobAssetMasterPK);			
		jobAssetMasterAdminRepo.save(assetJobAssetMaster);			
		}
		return;
	}

	
	public ArrayList<JobAssetMaster_DTO> getAllJobAssets() 
	{
		ArrayList<JobAssetMaster> assetList = (ArrayList<JobAssetMaster>) jobAssetMasterAdminRepo.findAll();
		ArrayList<JobAssetMaster_DTO> lMasterss = new ArrayList<JobAssetMaster_DTO>();
		lMasterss = assetList != null ? this.getJobAssetMaster_DTOs(assetList) : null;
		return lMasterss;
	}

	public ArrayList<JobAssetMaster_DTO> getSelectJobAssets(ArrayList<JobAssetMasterPK> jobAssetMasterPKs)
	{
		ArrayList<JobAssetMaster> lMasters = (ArrayList<JobAssetMaster>) jobAssetMasterAdminRepo.findAllById(jobAssetMasterPKs);
		ArrayList<JobAssetMaster_DTO> jobAssetMaster_DTOs = new ArrayList<JobAssetMaster_DTO>();
		jobAssetMaster_DTOs = lMasters != null ? this.getJobAssetMaster_DTOs(lMasters) : null;
		return jobAssetMaster_DTOs;		
	}
   
	public ArrayList<JobAssetMaster_DTO> getSelectAssetsByDirection(Character dFlag)
	{
		ArrayList<JobAssetMaster> lMasters = (ArrayList<JobAssetMaster>) jobAssetMasterAdminRepo.getSelectAssetsByDirection(dFlag);
		ArrayList<JobAssetMaster_DTO> jobAssetMaster_DTOs = new ArrayList<JobAssetMaster_DTO>();
		jobAssetMaster_DTOs = lMasters != null ? this.getJobAssetMaster_DTOs(lMasters) : null;
		return jobAssetMaster_DTOs;		
	}
	
	public ArrayList<JobAssetMaster_DTO> getSelectJobAssetsByJobs( ArrayList<Long> jobSeqNos)
	{
		ArrayList<JobAssetMaster> jobAssetMasters = jobAssetMasterAdminRepo.getSelectAssetsByJobs(jobSeqNos);
		ArrayList<JobAssetMaster_DTO> jobAssetMaster_DTOs = new ArrayList<JobAssetMaster_DTO>();
		jobAssetMaster_DTOs = jobAssetMasters != null ? this.getJobAssetMaster_DTOs(jobAssetMasters) : null;
		return jobAssetMaster_DTOs;
	}

	public ArrayList<JobAssetMaster_DTO> getSelectJobAssetsByTargets( ArrayList<Long> trgSeqNos)	
	{
		ArrayList<JobAssetMaster> lMasters = jobAssetMasterAdminRepo.getSelectAssetsByTargets(trgSeqNos);
		ArrayList<JobAssetMaster_DTO> jobAssetMaster_DTOs = new ArrayList<JobAssetMaster_DTO>();
		jobAssetMaster_DTOs = lMasters != null ? this.getJobAssetMaster_DTOs(lMasters) : null;
		return jobAssetMaster_DTOs;
	}

	public ArrayList<JobAssetMaster_DTO> getSelectJobAssetsByAssets( ArrayList<Long> assetSeqNos)	
	{
		ArrayList<JobAssetMaster> lMasters = jobAssetMasterAdminRepo.getSelectAssetsByAssets(assetSeqNos);
		ArrayList<JobAssetMaster_DTO> jobAssetMaster_DTOs = new ArrayList<JobAssetMaster_DTO>();
		jobAssetMaster_DTOs = lMasters != null ? this.getJobAssetMaster_DTOs(lMasters) : null;
		return jobAssetMaster_DTOs;
	}


	public void delAllJobAssets() 
	{
		jobAssetMasterAdminRepo.deleteAll();;
		return;
	}
	
	public void delSelectJobAssets(ArrayList<JobAssetMasterPK> ids) 
	{
		jobAssetMasterAdminRepo.deleteAllById(ids);
		
		return;
	}

	public void delSelectAssetsByDirection(Character dFlag) 
	{
		jobAssetMasterAdminRepo.delSelectAssetsByDirection(dFlag);		
		return;
	}
	
	public void delSelectJobAssetsByAssets( ArrayList<Long> assetSeqNos) 
	{
		jobAssetMasterAdminRepo.delSelectAssetsByAssets( assetSeqNos);
		
		return;
	}
	

	public void delSelectJobAssetsByJobs( ArrayList<Long> jobSeqNos) 
	{
		jobAssetMasterAdminRepo.delSelectAssetsByJobs(jobSeqNos);
		
		return;
	}

	public void delSelectJobAssetsByTargets( ArrayList<Long> trgSeqNos) 
	{
		jobAssetMasterAdminRepo.delSelectAssetsByTargets(trgSeqNos);;
		
		return;
	}
	

	private ArrayList<JobAssetMaster_DTO> getJobAssetMaster_DTOs(ArrayList<JobAssetMaster> lMasters) {
		JobAssetMaster_DTO lDTO = null;
		ArrayList<JobAssetMaster_DTO> lMasterDTOs = new ArrayList<JobAssetMaster_DTO>();		
		for (int i = 0; i < lMasters.size(); i++) {
			lDTO = getJobAssetMaster_DTO(lMasters.get(i));			
			lMasterDTOs.add(lDTO);
		}
		return lMasterDTOs;
	}

	private JobAssetMaster_DTO getJobAssetMaster_DTO(JobAssetMaster lMaster) 
	{		
		JobAssetMaster_DTO lDTO = new JobAssetMaster_DTO();
		lDTO.setAssetSeqNo(lMaster.getId().getAssetSeqNo());
		lDTO.setFrLocSeqNo(lMaster.getId().getFrLocSeqNo());
		lDTO.setToLocSeqNo(lMaster.getId().getToLocSeqNo());
		lDTO.setJobSeqNo(lMaster.getId().getJobSeqNo());
		lDTO.setTargetSeqNo(lMaster.getId().getTargetSeqNo());
		lDTO.setUnitRate(lMaster.getUnitRate());
		lDTO.setModeSeqNo(lMaster.getId().getModeSeqNo());
		lDTO.setRateSeqNo(lMaster.getRateSeqNo());
		lDTO.setReturnflag(lMaster.getReturnflag());
		lDTO.setDirectionflag(lMaster.getDirectionflag());
		return lDTO;
	}

	private JobAssetMaster setJobAssetMaster(JobAssetMaster_DTO lDTO) 
	{
		JobAssetMaster lMaster = new JobAssetMaster();
		JobAssetMasterPK assetJobAssetMasterPK= new JobAssetMasterPK();
		assetJobAssetMasterPK.setAssetSeqNo(lDTO.getAssetSeqNo());
		assetJobAssetMasterPK.setFrLocSeqNo(lDTO.getFrLocSeqNo());
		assetJobAssetMasterPK.setToLocSeqNo(lDTO.getToLocSeqNo());
		assetJobAssetMasterPK.setJobSeqNo(lDTO.getJobSeqNo());
		assetJobAssetMasterPK.setModeSeqNo(lDTO.getModeSeqNo());		
		assetJobAssetMasterPK.setTargetSeqNo(lDTO.getTargetSeqNo());		
		lMaster.setId(assetJobAssetMasterPK);
		lMaster.setReturnflag(lMaster.getReturnflag());
		lMaster.setUnitRate(lMaster.getUnitRate());				
		lMaster.setRateSeqNo(lDTO.getRateSeqNo());	
		lMaster.setDirectionflag(lDTO.getDirectionflag());
		return lMaster;
	}
}