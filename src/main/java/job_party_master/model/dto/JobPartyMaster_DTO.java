package job_party_master.model.dto;

import java.io.Serializable;

public class JobPartyMaster_DTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1430754654232647250L;
	private Long jobSeqNo;
	private String description;
	private Float discPer;
	private Long discSeqNo;
	private Float discVal;
	private Float duration;
	private Long durationCodeSeqNo;
	private String job;
	private String jobId;
	private Long masterJobSeqNo;
	private Long partySeqNo;
	private Long specificationSeqNo;
	private Character status;
	private Float taxPer;
	private Long taxSeqNo;
	private Float taxVal;
	private Float unitRate;
	private Long unitRateSeqNo;

	public Long getJobSeqNo() {
		return jobSeqNo;
	}

	public void setJobSeqNo(Long jobSeqNo) {
		this.jobSeqNo = jobSeqNo;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Float getDiscPer() {
		return discPer;
	}

	public void setDiscPer(Float discPer) {
		this.discPer = discPer;
	}

	public Long getDiscSeqNo() {
		return discSeqNo;
	}

	public void setDiscSeqNo(Long discSeqNo) {
		this.discSeqNo = discSeqNo;
	}

	public Float getDiscVal() {
		return discVal;
	}

	public void setDiscVal(Float discVal) {
		this.discVal = discVal;
	}

	public Float getDuration() {
		return duration;
	}

	public void setDuration(Float duration) {
		this.duration = duration;
	}

	public Long getDurationCodeSeqNo() {
		return durationCodeSeqNo;
	}

	public void setDurationCodeSeqNo(Long durationCodeSeqNo) {
		this.durationCodeSeqNo = durationCodeSeqNo;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getJobId() {
		return jobId;
	}

	public void setJobId(String jobId) {
		this.jobId = jobId;
	}

	public Long getMasterJobSeqNo() {
		return masterJobSeqNo;
	}

	public void setMasterJobSeqNo(Long masterJobSeqNo) {
		this.masterJobSeqNo = masterJobSeqNo;
	}

	public Long getPartySeqNo() {
		return partySeqNo;
	}

	public void setPartySeqNo(Long partySeqNo) {
		this.partySeqNo = partySeqNo;
	}

	public Long getSpecificationSeqNo() {
		return specificationSeqNo;
	}

	public void setSpecificationSeqNo(Long specificationSeqNo) {
		this.specificationSeqNo = specificationSeqNo;
	}

	public Character getStatus() {
		return status;
	}

	public void setStatus(Character status) {
		this.status = status;
	}

	public Float getTaxPer() {
		return taxPer;
	}

	public void setTaxPer(Float taxPer) {
		this.taxPer = taxPer;
	}

	public Long getTaxSeqNo() {
		return taxSeqNo;
	}

	public void setTaxSeqNo(Long taxSeqNo) {
		this.taxSeqNo = taxSeqNo;
	}

	public Float getTaxVal() {
		return taxVal;
	}

	public void setTaxVal(Float taxVal) {
		this.taxVal = taxVal;
	}

	public Float getUnitRate() {
		return unitRate;
	}

	public void setUnitRate(Float unitRate) {
		this.unitRate = unitRate;
	}

	public Long getUnitRateSeqNo() {
		return unitRateSeqNo;
	}

	public void setUnitRateSeqNo(Long unitRateSeqNo) {
		this.unitRateSeqNo = unitRateSeqNo;
	}

	public JobPartyMaster_DTO(Long jobSeqNo, String description, Float discPer, Long discSeqNo, Float discVal,
			Float duration, Long durationCodeSeqNo, String job, String jobId, Long masterJobSeqNo, Long partySeqNo,
			Long specificationSeqNo, Character status, Float taxPer, Long taxSeqNo, Float taxVal, Float unitRate,
			Long unitRateSeqNo) {
		super();
		this.jobSeqNo = jobSeqNo;
		this.description = description;
		this.discPer = discPer;
		this.discSeqNo = discSeqNo;
		this.discVal = discVal;
		this.duration = duration;
		this.durationCodeSeqNo = durationCodeSeqNo;
		this.job = job;
		this.jobId = jobId;
		this.masterJobSeqNo = masterJobSeqNo;
		this.partySeqNo = partySeqNo;
		this.specificationSeqNo = specificationSeqNo;
		this.status = status;
		this.taxPer = taxPer;
		this.taxSeqNo = taxSeqNo;
		this.taxVal = taxVal;
		this.unitRate = unitRate;
		this.unitRateSeqNo = unitRateSeqNo;
	}

	public JobPartyMaster_DTO() {
		super();
	}

}