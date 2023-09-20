package job_asset_master_mgmt.controller;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import job_asset_master_mgmt.model.dto.JobAssetMaster_DTO;
import job_asset_master_mgmt.model.master.JobAssetMasterPK;
import job_asset_master_mgmt.service.I_JobAssetMasterAdmin_Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/jobAssetMasterAdminMgmt")
public class JobAssetMasterAdmin_Controller {

	// private static final Logger logger =
	// LoggerFactory.getLogger(JobAssetMasterAdminMaster_Controller.class);

	@Autowired
	private I_JobAssetMasterAdmin_Service jobAssetMasterAdminServ;

	@PostMapping("/new")
	public ResponseEntity<JobAssetMaster_DTO> newJobAsset(@RequestBody JobAssetMaster_DTO resourceDTO) {
		JobAssetMaster_DTO resourceDTO2 = jobAssetMasterAdminServ.newJobAsset(resourceDTO);
		HttpHeaders httpHeaders = new HttpHeaders();
		return new ResponseEntity<>(resourceDTO2, httpHeaders, HttpStatus.CREATED);
	}

	@PutMapping("/updResJobAsset")
	public void updateJobAssetMasterAdmin(@RequestBody JobAssetMaster_DTO resourceDTO) {
		jobAssetMasterAdminServ.updJobAsset(resourceDTO);
		return;
	}

	@GetMapping(value = "/getAllJobAssets", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<JobAssetMaster_DTO>> getAllJobAssets() {
		ArrayList<JobAssetMaster_DTO> resourceDTOs = jobAssetMasterAdminServ.getAllJobAssets();
		return new ResponseEntity<>(resourceDTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectJobAssets", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<JobAssetMaster_DTO>> getSelectJobAssets(
			@RequestBody ArrayList<JobAssetMasterPK> jobAssetMasterPKs) {
		ArrayList<JobAssetMaster_DTO> resourceDTOs = jobAssetMasterAdminServ.getSelectJobAssets(jobAssetMasterPKs);
		return new ResponseEntity<>(resourceDTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectJobAssetsByJobs", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<JobAssetMaster_DTO>> getSelectJobAssetsByJobs(
			@RequestBody ArrayList<Long> jobSeqNos) {
		ArrayList<JobAssetMaster_DTO> resourceDTOs = jobAssetMasterAdminServ.getSelectJobAssetsByJobs(jobSeqNos);
		return new ResponseEntity<>(resourceDTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectJobAssetsByDirection/{dFlag}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<JobAssetMaster_DTO>> getSelectJobAssetsByDirection(	@PathVariable Character dFlag) {
		ArrayList<JobAssetMaster_DTO> resourceDTOs = jobAssetMasterAdminServ.getSelectAssetsByDirection(dFlag);
		return new ResponseEntity<>(resourceDTOs, HttpStatus.OK);
	}

	
	@GetMapping(value = "/getSelectJobAssetsByTargets", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<JobAssetMaster_DTO>> getSelectJobAssetsByTargets(
			@RequestBody ArrayList<Long> targetSeqNos) {
		ArrayList<JobAssetMaster_DTO> resourceDTOs = jobAssetMasterAdminServ.getSelectJobAssetsByTargets(targetSeqNos);
		return new ResponseEntity<>(resourceDTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectJobAssetsByAssets", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<JobAssetMaster_DTO>> getSelectJobAssetsByAssets(
			@RequestBody ArrayList<Long> rSeqNos) {
		ArrayList<JobAssetMaster_DTO> resourceDTOs = jobAssetMasterAdminServ.getSelectJobAssetsByAssets(rSeqNos);
		return new ResponseEntity<>(resourceDTOs, HttpStatus.OK);
	}

	@DeleteMapping("/delSelectJobAssets(")
	public void deleteSelectresource(@RequestBody ArrayList<JobAssetMasterPK> jobAssetMasterPKs) {
		jobAssetMasterAdminServ.delSelectJobAssets(jobAssetMasterPKs);
		return;
	}

	@DeleteMapping("/delSelectJobAssetsByJobs")
	public void delSelectJobAssetsByJobs(@RequestBody ArrayList<Long> jobSeqNos) {
		jobAssetMasterAdminServ.delSelectJobAssetsByJobs(jobSeqNos);
		return;
	}

	@DeleteMapping("/delSelectJobAssetsByAssets")
	public void delSelectAssetJobTypesByAllocated(@RequestBody ArrayList<Long> resourceSeqNos) {
		jobAssetMasterAdminServ.delSelectJobAssetsByAssets(resourceSeqNos);
		return;
	}

	@DeleteMapping("/delSelectJobAssetsByTargets")
	public void delSelectJobAssetsByTargets(@RequestBody ArrayList<Long> targetSeqNos) {
		jobAssetMasterAdminServ.delSelectJobAssetsByTargets(targetSeqNos);
		return;
	}

	@DeleteMapping("/delAllJobAssets")
	public void deleteAllJobAssets() {
		jobAssetMasterAdminServ.delAllJobAssets();
		return;
	}
}