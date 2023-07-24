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

import job_template_details_mgmt.model.dto.JobTemplateDetailsDTO;
import job_template_details_mgmt.services.I_JobTemplateDetailsService;

@RestController
@RequestMapping("/jobTemplateDetailsMgmt")
public class JobTemplateDetailsController {

	// private static final Logger logger =
	// LoggerFactory.getLogger(JobTemplateDetails_Controller.class);

	@Autowired
	private I_JobTemplateDetailsService jobTemplateDetailsService;

	@PostMapping("/new")
	public ResponseEntity<JobTemplateDetailsDTO> newJobTemplateDetail(@RequestBody JobTemplateDetailsDTO jobDTO) {
		JobTemplateDetailsDTO JobTemplateDetailsDTO2 = jobTemplateDetailsService.newJobTemplateDetail(jobDTO);
		HttpHeaders httpHeaders = new HttpHeaders();
		return new ResponseEntity<>(JobTemplateDetailsDTO2, httpHeaders, HttpStatus.CREATED);
	}

	@GetMapping(value = "/getSelectJobTemplateDetails", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<JobTemplateDetailsDTO>> getSelectJobTemplateDetails(
			@RequestBody ArrayList<Long> jobTemplateDetailsSeqNos) {
		ArrayList<JobTemplateDetailsDTO> JobTemplateDetailsDTOs = jobTemplateDetailsService
				.getSelectJobTemplateDetails(jobTemplateDetailsSeqNos);
		return new ResponseEntity<>(JobTemplateDetailsDTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getAllJobTemplateDetails", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<JobTemplateDetailsDTO>> getAllJobTemplateDetails() {
		ArrayList<JobTemplateDetailsDTO> JobTemplateDetailsDTOs = jobTemplateDetailsService.getAllJobTemplateDetails();
		return new ResponseEntity<>(JobTemplateDetailsDTOs, HttpStatus.OK);
	}

	@PutMapping("/jobType")
	public void updateJobTemplateDetail(@RequestBody JobTemplateDetailsDTO jobDTO) {
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