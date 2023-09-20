package job_asset_master_mgmt.model.dto;

import java.io.Serializable;

public class JobAssetMaster_DTO implements Serializable 
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7904049969234080371L;
	private Long assetSeqNo;
	private Long jobSeqNo;
	private Long targetSeqNo;
	private Long frLocSeqNo;
	private Long toLocSeqNo;
	private Long modeSeqNo;
	private Long rateSeqNo;
	private Character returnflag;
	private Float unitRate;
	private Character directionflag;
	
	public Character getDirectionflag() 
	{
		return directionflag;
	}

	public void setDirectionflag(Character directionflag) {
		this.directionflag = directionflag;
	}

	public Long getAssetSeqNo() {
		return assetSeqNo;
	}

	public void setAssetSeqNo(Long assetSeqNo) {
		this.assetSeqNo = assetSeqNo;
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

	public Long getModeSeqNo() {
		return modeSeqNo;
	}

	public void setModeSeqNo(Long modeSeqNo) {
		this.modeSeqNo = modeSeqNo;
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

	public JobAssetMaster_DTO(Long assetSeqNo, Long jobSeqNo, Long targetSeqNo, Long frLocSeqNo, Long toLocSeqNo,
			Long modeSeqNo, Long rateSeqNo, Character returnflag, Float unitRate, Character directionflag) {
		super();
		this.assetSeqNo = assetSeqNo;
		this.jobSeqNo = jobSeqNo;
		this.targetSeqNo = targetSeqNo;
		this.frLocSeqNo = frLocSeqNo;
		this.toLocSeqNo = toLocSeqNo;
		this.modeSeqNo = modeSeqNo;
		this.rateSeqNo = rateSeqNo;
		this.returnflag = returnflag;
		this.unitRate = unitRate;
		this.directionflag = directionflag;
	}

	public JobAssetMaster_DTO() {
		super();
	}

}