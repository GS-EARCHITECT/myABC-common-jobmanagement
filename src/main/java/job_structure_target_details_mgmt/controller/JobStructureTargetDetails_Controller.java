package job_structure_target_details_mgmt.controller;

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

import job_structure_target_details_mgmt.model.details.JobStructureTargetDetailPK;
import job_structure_target_details_mgmt.model.dto.JobStructureTargetDetail_DTO;
import job_structure_target_details_mgmt.services.I_JobStructureTargetDetails_Service;

@RestController
@RequestMapping("/jobStructureTargetDetailsMgmt")
public class JobStructureTargetDetails_Controller 
{

	// private static final Logger logger =
	// LoggerFactory.getLogger(JobStructureTargetDetails_Controller.class);

	@Autowired
	private I_JobStructureTargetDetails_Service jobStructureTargetDetailsService;

	@PostMapping("/new")
	public ResponseEntity<JobStructureTargetDetail_DTO> newJobStructureTargetDetail(@RequestBody JobStructureTargetDetail_DTO jstDTO) {
		JobStructureTargetDetail_DTO JobStructureTargetDetail_DTO2 = jobStructureTargetDetailsService.newJobStructureTargetDetail(jstDTO);
		HttpHeaders httpHeaders = new HttpHeaders();
		return new ResponseEntity<>(JobStructureTargetDetail_DTO2, httpHeaders, HttpStatus.CREATED);
	}

	@PutMapping("/jobType")
	public void updateJobStructureTargetDetails(@RequestBody JobStructureTargetDetail_DTO jstDTO) {
		jobStructureTargetDetailsService.updJobStructureTargetDetail(jstDTO);
	}

	@GetMapping(value = "/getAllJobStructureTargetDetailss", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<JobStructureTargetDetail_DTO>> getAllJobStructureTargetDetailss() {
		ArrayList<JobStructureTargetDetail_DTO> JobStructureTargetDetail_DTOs = jobStructureTargetDetailsService.getAllJobStructureTargetDetails();
		return new ResponseEntity<>(JobStructureTargetDetail_DTOs, HttpStatus.OK);
	}
	
	@GetMapping(value = "/getSelectJobStructureTargetDetails", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<JobStructureTargetDetail_DTO>> getSelectJobStructureTargetDetails(
			@RequestBody ArrayList<JobStructureTargetDetailPK> jobStructureTargetDetailsPKs) 
	{
		ArrayList<JobStructureTargetDetail_DTO> JobStructureTargetDetail_DTOs = jobStructureTargetDetailsService.getSelectJobStructureTargetDetails(jobStructureTargetDetailsPKs);
		return new ResponseEntity<>(JobStructureTargetDetail_DTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectJobStructureTargetDetailsForJobs", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<JobStructureTargetDetail_DTO>> getSelectJobStructureTargetDetailsForJobs(@RequestBody ArrayList<Long> ids) 
	{
		ArrayList<JobStructureTargetDetail_DTO> JobStructureTargetDetail_DTOs = jobStructureTargetDetailsService.getSelectJobStructureTargetDetailsForJobs(ids);
		return new ResponseEntity<>(JobStructureTargetDetail_DTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectJobStructureTargetDetailsForParents", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<JobStructureTargetDetail_DTO>> getSelectJobStructureTargetDetailsForParents(@RequestBody ArrayList<Long> ids, @RequestBody ArrayList<Long> tids) 
	{
		ArrayList<JobStructureTargetDetail_DTO> JobStructureTargetDetail_DTOs = jobStructureTargetDetailsService.getSelectJobStructureTargetDetailsForParents(ids, tids);
		return new ResponseEntity<>(JobStructureTargetDetail_DTOs, HttpStatus.OK);
	}
	
	@DeleteMapping("/delAllJobStructureTargetDetails")
	public void deleteAllJobStructureTargetDetails() {
		jobStructureTargetDetailsService.delAllJobStructureTargetDetails();
	}
	
	@DeleteMapping("/delSelectJobStructureTargetDetails")
	public void deleteSelectJobStructureTargetDetails(@RequestBody ArrayList<JobStructureTargetDetailPK> jobStructureTargetDetailsPKs) 
	{
		jobStructureTargetDetailsService.delSelectJobStructureTargetDetails(jobStructureTargetDetailsPKs);
	}

	@DeleteMapping("/delSelectJobStructureTargetDetailForJobs")
	public void delSelectJobStructureTargetDetailForJobs(@RequestBody ArrayList<Long> jList) 
	{
		jobStructureTargetDetailsService.deleteSelectJobStructureTargetDetailForJobs(jList);
	}

	
	@DeleteMapping("/delSelectJobStructureTargetDetailForParents")
	public void delSelectJobStructureTargetDetailForParents(@RequestBody ArrayList<Long> jList, @RequestBody ArrayList<Long> tList) 
	{
		jobStructureTargetDetailsService.delSelectJobStructureTargetDetailForParents(jList, tList);
	}
}