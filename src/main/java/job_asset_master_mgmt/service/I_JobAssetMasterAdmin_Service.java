package job_asset_master_mgmt.service;

import java.util.ArrayList;
import job_asset_master_mgmt.model.dto.JobAssetMaster_DTO;
import job_asset_master_mgmt.model.master.JobAssetMasterPK;

public interface I_JobAssetMasterAdmin_Service 
{
	public JobAssetMaster_DTO newJobAsset(JobAssetMaster_DTO jobAssetMaster_DTO);
	public void updJobAsset(JobAssetMaster_DTO jobAssetMaster_DTO);
	public ArrayList<JobAssetMaster_DTO> getAllJobAssets();
	public ArrayList<JobAssetMaster_DTO> getSelectJobAssets(ArrayList<JobAssetMasterPK> jobAssetMasterPKs);	
	public ArrayList<JobAssetMaster_DTO> getSelectJobAssetsByJobs( ArrayList<Long> jobSeqNos);
	public ArrayList<JobAssetMaster_DTO> getSelectJobAssetsByTargets( ArrayList<Long> trgSeqNos);
	public ArrayList<JobAssetMaster_DTO> getSelectJobAssetsByAssets( ArrayList<Long> assetSeqNos);		
	public void delAllJobAssets();
	public void delSelectJobAssets(ArrayList<JobAssetMasterPK> ids);
	public void delSelectJobAssetsByJobs(ArrayList<Long> jobSeqNos);	
	public void delSelectJobAssetsByAssets( ArrayList<Long> assetSeqNos);
	public void delSelectJobAssetsByTargets( ArrayList<Long> trgSeqNos);

}