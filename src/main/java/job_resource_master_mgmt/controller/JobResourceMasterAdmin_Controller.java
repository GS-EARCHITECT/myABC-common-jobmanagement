package job_resource_master_mgmt.controller;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import job_resource_master_mgmt.model.dto.JobResourceMaster_DTO;
import job_resource_master_mgmt.model.master.JobResourceMasterPK;
import job_resource_master_mgmt.service.I_JobResourceMasterAdmin_Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/jobResourceMasterAdminMgmt")
public class JobResourceMasterAdmin_Controller {

	// private static final Logger logger =
	// LoggerFactory.getLogger(JobResourceMasterAdminMaster_Controller.class);

	@Autowired
	private I_JobResourceMasterAdmin_Service jobResourceMasterAdminServ;

	@PostMapping("/new")
	public ResponseEntity<JobResourceMaster_DTO> newJobResource(@RequestBody JobResourceMaster_DTO resourceDTO) {
		JobResourceMaster_DTO resourceDTO2 = jobResourceMasterAdminServ.newJobResource(resourceDTO);
		HttpHeaders httpHeaders = new HttpHeaders();
		return new ResponseEntity<>(resourceDTO2, httpHeaders, HttpStatus.CREATED);
	}

	@PutMapping("/updResJobTypeCates")
	public void updateJobResourceMasterAdmin(@RequestBody JobResourceMaster_DTO resourceDTO) {
		jobResourceMasterAdminServ.updJobResource(resourceDTO);
		return;
	}

	@GetMapping(value = "/getAllJobResources", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<JobResourceMaster_DTO>> getAllJobResources() {
		ArrayList<JobResourceMaster_DTO> resourceDTOs = jobResourceMasterAdminServ.getAllJobResources();
		return new ResponseEntity<>(resourceDTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectJobResources", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<JobResourceMaster_DTO>> getSelectJobResources(
			@RequestBody ArrayList<JobResourceMasterPK> jobResourceMasterPKs) {
		ArrayList<JobResourceMaster_DTO> resourceDTOs = jobResourceMasterAdminServ
				.getSelectJobResources(jobResourceMasterPKs);
		return new ResponseEntity<>(resourceDTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectJobResourcesByJobs", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<JobResourceMaster_DTO>> getSelectJobResourcesByJobs(
			@RequestBody ArrayList<Long> jobSeqNos) {
		ArrayList<JobResourceMaster_DTO> resourceDTOs = jobResourceMasterAdminServ
				.getSelectJobResourcesByJobs(jobSeqNos);
		return new ResponseEntity<>(resourceDTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectJobResourcesByTargets", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<JobResourceMaster_DTO>> getSelectJobResourcesByTargets(
			@RequestBody ArrayList<Long> targetSeqNos) {
		ArrayList<JobResourceMaster_DTO> resourceDTOs = jobResourceMasterAdminServ
				.getSelectJobResourcesByTargets(targetSeqNos);
		return new ResponseEntity<>(resourceDTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectJobResourcesByResources", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<JobResourceMaster_DTO>> getSelectJobResourcesByResources(
			@RequestBody ArrayList<Long> rSeqNos) {
		ArrayList<JobResourceMaster_DTO> resourceDTOs = jobResourceMasterAdminServ
				.getSelectJobResourcesByResources(rSeqNos);
		return new ResponseEntity<>(resourceDTOs, HttpStatus.OK);
	}

	@DeleteMapping("/delSelectJobResources(")
	public void deleteSelectresource(@RequestBody ArrayList<JobResourceMasterPK> jobResourceMasterPKs) {
		jobResourceMasterAdminServ.delSelectJobResources(jobResourceMasterPKs);
		return;
	}

	@DeleteMapping("/delSelectJobResourcesByJobs")
	public void delSelectJobResourcesByJobs(@RequestBody ArrayList<Long> jobSeqNos) {
		jobResourceMasterAdminServ.delSelectJobResourcesByJobs(jobSeqNos);
		return;
	}

	@DeleteMapping("/delSelectJobResourcesByResources")
	public void delSelectResourceJobTypesByAllocated(@RequestBody ArrayList<Long> resourceSeqNos) {
		jobResourceMasterAdminServ.delSelectJobResourcesByResources(resourceSeqNos);
		return;
	}

	@DeleteMapping("/delSelectJobResourcesByTargets")
	public void delSelectJobResourcesByTargets(@RequestBody ArrayList<Long> targetSeqNos) {
		jobResourceMasterAdminServ.delSelectJobResourcesByTargets(targetSeqNos);
		return;
	}

	@DeleteMapping("/delAllJobResources")
	public void deleteAllJobResources() {
		jobResourceMasterAdminServ.delAllJobResources();
		return;
	}
}