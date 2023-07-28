package job_target_details.controller;

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
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

import job_target_details.model.dto.JobTargetDetail_DTO;
import job_target_details.model.master.JobTargetDetailPK;
import job_target_details.services.I_JobTargetDetails_Service;

@RestController
@RequestMapping("/jobTargetDetailsMgmt")
public class JobTargetDetails_Controller 
{

	// private static final Logger logger =
	// LoggerFactory.getLogger(JobTargetDetails_Controller.class);

	@Autowired
	private I_JobTargetDetails_Service jobTypeTargetDetailsService;

	@PostMapping("/new")
	public ResponseEntity<JobTargetDetail_DTO> newJobTargetDetail(@RequestBody JobTargetDetail_DTO jobTypeTargetDetails) {
		JobTargetDetail_DTO JobTargetDetail_DTO2 = jobTypeTargetDetailsService.newJobTargetDetail(jobTypeTargetDetails);
		HttpHeaders httpHeaders = new HttpHeaders();
		return new ResponseEntity<>(JobTargetDetail_DTO2, httpHeaders, HttpStatus.CREATED);
	}

	@GetMapping(value = "/getSelectJobTargetDetails", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<JobTargetDetail_DTO>> getSelectJobTargetDetails(
			@RequestBody ArrayList<JobTargetDetailPK> jobTargetDetailPKs) 
	{
		ArrayList<JobTargetDetail_DTO> JobTargetDetail_DTOs = jobTypeTargetDetailsService
				.getSelectJobTargetDetails(jobTargetDetailPKs);
		return new ResponseEntity<>(JobTargetDetail_DTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getAllJobTargetDetails", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<JobTargetDetail_DTO>> getAllJobTargetDetails() {
		ArrayList<JobTargetDetail_DTO> JobTargetDetail_DTOs = jobTypeTargetDetailsService.getAllJobTargetDetails();
		return new ResponseEntity<>(JobTargetDetail_DTOs, HttpStatus.OK);
	}

	@PutMapping("/jobTargetDetail")
	public void updateJobTargetDetail(@RequestBody JobTargetDetail_DTO jobTypeTargetDetail)
	{
		jobTypeTargetDetailsService.updJobTargetDetail(jobTypeTargetDetail);
	}

	@DeleteMapping("/delAllJobTargetDetails")
	public void deleteAllJobTargetDetails() {
		jobTypeTargetDetailsService.delAllJobTargetDetails();
	}

	@DeleteMapping("/delSelectJobTargetDetails")
	public void deleteSelectJobTargetDetails(@RequestBody ArrayList<JobTargetDetailPK> jobTargetDetailPKs) 
	{
		jobTypeTargetDetailsService.delSelectJobTargetDetails(jobTargetDetailPKs);
	}
}