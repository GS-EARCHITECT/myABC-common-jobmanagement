package job_template_details_mgmt.controller;

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

import job_template_details_mgmt.model.dto.JobTemplateDetail_DTO;
import job_template_details_mgmt.services.I_JobTemplateDetails_Service;

@RestController
@RequestMapping("/jobTemplateDetailsMgmt")
public class JobTemplateDetailsController {

	// private static final Logger logger =
	// LoggerFactory.getLogger(JobTemplateDetails_Controller.class);

	@Autowired
	private I_JobTemplateDetails_Service jobTemplateDetailsService;

	@PostMapping("/new")
	public ResponseEntity<JobTemplateDetail_DTO> newJobTemplateDetail(@RequestBody JobTemplateDetail_DTO jobDTO) {
		JobTemplateDetail_DTO JobTemplateDetail_DTO2 = jobTemplateDetailsService.newJobTemplateDetail(jobDTO);
		HttpHeaders httpHeaders = new HttpHeaders();
		return new ResponseEntity<>(JobTemplateDetail_DTO2, httpHeaders, HttpStatus.CREATED);
	}

	@GetMapping(value = "/getSelectJobTemplateDetails", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<JobTemplateDetail_DTO>> getSelectJobTemplateDetails(
			@RequestBody ArrayList<Long> jobTemplateDetailsSeqNos) {
		ArrayList<JobTemplateDetail_DTO> JobTemplateDetail_DTOs = jobTemplateDetailsService
				.getSelectJobTemplateDetails(jobTemplateDetailsSeqNos);
		return new ResponseEntity<>(JobTemplateDetail_DTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getAllJobTemplateDetails", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<JobTemplateDetail_DTO>> getAllJobTemplateDetails() {
		ArrayList<JobTemplateDetail_DTO> JobTemplateDetail_DTOs = jobTemplateDetailsService.getAllJobTemplateDetails();
		return new ResponseEntity<>(JobTemplateDetail_DTOs, HttpStatus.OK);
	}

	@PutMapping("/jobType")
	public void updateJobTemplateDetail(@RequestBody JobTemplateDetail_DTO jobDTO) {
		jobTemplateDetailsService.updJobTemplateDetail(jobDTO);
	}

	@DeleteMapping("/delAllJobTemplateDetails")
	public void deleteAllJobTemplateDetails() {
		jobTemplateDetailsService.delAllJobTemplateDetails();
	}

	@DeleteMapping("/delSelectJobTemplateDetails")
	public void deleteSelectJobTemplateDetails(@RequestBody ArrayList<Long> JobTemplateDetailsSeqNoList) {
		jobTemplateDetailsService.delSelectJobTemplateDetails(JobTemplateDetailsSeqNoList);
	}
}