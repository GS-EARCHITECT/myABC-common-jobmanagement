package job_resource_master_mgmt.model.dto;

import java.io.Serializable;

public class JobResourceMaster_DTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1243666536812827894L;
	private Long jobSeqNo;
	private Long targetSeqNo;
	private Long frLocSeqNo;
	private Long toLocSeqNo;
	private Long resourceSeqNo;
	private Long modeSeqNo;
	private Float qty;
	private Long qtySeqNo;
	private Long rateSeqNo;
	private Character returnflag;
	private Float unitRate;
	private Character directionflag;

	public Character getDirectionflag() {
		return directionflag;
	}

	public void setDirectionflag(Character directionflag) {
		this.directionflag = directionflag;
	}

	public Long getJobSeqNo() {
		return jobSeqNo;
	}

	public void setJobSeqNo(Long jobSeqNo) {
		this.jobSeqNo = jobSeqNo;
	}

	public Long getTargetSeqNo() {
		return targetSeqNo;
	}

	public void setTargetSeqNo(Long targetSeqNo) {
		this.targetSeqNo = targetSeqNo;
	}

	public Long getFrLocSeqNo() {
		return frLocSeqNo;
	}

	public void setFrLocSeqNo(Long frLocSeqNo) {
		this.frLocSeqNo = frLocSeqNo;
	}

	public Long getToLocSeqNo() {
		return toLocSeqNo;
	}

	public void setToLocSeqNo(Long toLocSeqNo) {
		this.toLocSeqNo = toLocSeqNo;
	}

	public Long getResourceSeqNo() {
		return resourceSeqNo;
	}

	public void setResourceSeqNo(Long resourceSeqNo) {
		this.resourceSeqNo = resourceSeqNo;
	}

	public Long getModeSeqNo() {
		return modeSeqNo;
	}

	public void setModeSeqNo(Long modeSeqNo) {
		this.modeSeqNo = modeSeqNo;
	}

	public Float getQty() {
		return qty;
	}

	public void setQty(Float qty) {
		this.qty = qty;
	}

	public Long getQtySeqNo() {
		return qtySeqNo;
	}

	public void setQtySeqNo(Long qtySeqNo) {
		this.qtySeqNo = qtySeqNo;
	}

	public Long getRateSeqNo() {
		return rateSeqNo;
	}

	public void setRateSeqNo(Long rateSeqNo) {
		this.rateSeqNo = rateSeqNo;
	}

	public Character getReturnflag() {
		return returnflag;
	}

	public void setReturnflag(Character returnflag) {
		this.returnflag = returnflag;
	}

	public Float getUnitRate() {
		return unitRate;
	}

	public void setUnitRate(Float unitRate) {
		this.unitRate = unitRate;
	}

	public JobResourceMaster_DTO(Long jobSeqNo, Long targetSeqNo, Long frLocSeqNo, Long toLocSeqNo, Long resourceSeqNo,
			Long modeSeqNo, Float qty, Long qtySeqNo, Long rateSeqNo, Character returnflag, Float unitRate,
			Character directionflag) {
		super();
		this.jobSeqNo = jobSeqNo;
		this.targetSeqNo = targetSeqNo;
		this.frLocSeqNo = frLocSeqNo;
		this.toLocSeqNo = toLocSeqNo;
		this.resourceSeqNo = resourceSeqNo;
		this.modeSeqNo = modeSeqNo;
		this.qty = qty;
		this.qtySeqNo = qtySeqNo;
		this.rateSeqNo = rateSeqNo;
		this.returnflag = returnflag;
		this.unitRate = unitRate;
		this.directionflag = directionflag;
	}

	public JobResourceMaster_DTO() {
		super();
	}

}