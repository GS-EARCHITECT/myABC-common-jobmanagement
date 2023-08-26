package job_party_master.controller;

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
import job_party_master.model.dto.JobPartyMaster_DTO;
import job_party_master.services.I_JobPartyMaster_Service;

@RestController
@RequestMapping("/jobPartyMasterMgmt")
public class JobPartyMaster_Controller 
{
	@Autowired
	private I_JobPartyMaster_Service jobPartyMasterService;

	@PostMapping("/new")
	public ResponseEntity<JobPartyMaster_DTO> newJob(@RequestBody JobPartyMaster_DTO jcmDTO) {
		JobPartyMaster_DTO JobPartyMaster_DTO2 = jobPartyMasterService.newJobPartyMaster(jcmDTO);
		HttpHeaders httpHeaders = new HttpHeaders();
		return new ResponseEntity<>(JobPartyMaster_DTO2, httpHeaders, HttpStatus.CREATED);
	}

	@GetMapping(value = "/getSelectJobPartyMasters", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<JobPartyMaster_DTO>> getSelectJobPartyMasters(
			@RequestBody ArrayList<Long> jobPartyMasterSeqNos) {
		ArrayList<JobPartyMaster_DTO> JobPartyMaster_DTOs = jobPartyMasterService
				.getSelectJobPartyMasters(jobPartyMasterSeqNos);
		return new ResponseEntity<>(JobPartyMaster_DTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectJobPartyMastersByParties", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<JobPartyMaster_DTO>> getSelectJobPartyMastersByParties(
			@RequestBody ArrayList<Long> jobPartyMasterSeqNos) {
		ArrayList<JobPartyMaster_DTO> JobPartyMaster_DTOs = jobPartyMasterService
				.getSelectJobPartyMastersByParties(jobPartyMasterSeqNos);
		return new ResponseEntity<>(JobPartyMaster_DTOs, HttpStatus.OK);
	}
	
	@GetMapping(value = "/getSelectJobPartyMastersByMasterJobs", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<JobPartyMaster_DTO>> getSelectJobPartyMastersByMasterJobs(
			@RequestBody ArrayList<Long> jobPartyMasterSeqNos) 
	{
		ArrayList<JobPartyMaster_DTO> JobPartyMaster_DTOs = jobPartyMasterService
				.getSelectJobPartyMastersByMasterJobs(jobPartyMasterSeqNos);
		return new ResponseEntity<>(JobPartyMaster_DTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getAllJobPartyMasters", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<JobPartyMaster_DTO>> getAllJobPartyMasters() 
	{
		ArrayList<JobPartyMaster_DTO> JobPartyMaster_DTOs = jobPartyMasterService.getAllJobPartyMasters();
		return new ResponseEntity<>(JobPartyMaster_DTOs, HttpStatus.OK);
	}

	@PutMapping("/jobPartyMaster")
	public void updateJobPartyMaster(@RequestBody JobPartyMaster_DTO jcmDTO) {
		jobPartyMasterService.updJobPartyMaster(jcmDTO);
	}

	@DeleteMapping("/delAllJobPartyMasters")
	public void deleteAllJobPartyMasters() {
		jobPartyMasterService.delAllJobPartyMasters();
	}

	@DeleteMapping("/delSelectJobPartyMastersByParties")
	public void deleteSelectJobPartyMastersByParties(@RequestBody ArrayList<Long> JobPartyMasterSeqNoList) 
	{
		jobPartyMasterService.delSelectJobPartyMastersByParties(JobPartyMasterSeqNoList);
	}
	
	@DeleteMapping("/delSelectJobPartyMastersByMasterJobs")
	public void delSelectJobPartyMastersByMasterJobs(@RequestBody ArrayList<Long> JobPartyMasterSeqNoList) 
	{
		jobPartyMasterService.delSelectJobPartyMastersByMasterJobs(JobPartyMasterSeqNoList);
	}
}