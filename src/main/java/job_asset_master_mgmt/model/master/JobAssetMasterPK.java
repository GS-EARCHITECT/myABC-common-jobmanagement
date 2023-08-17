package job_asset_master_mgmt.model.master;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the JOB_ASSET_MASTER database table.
 * 
 */
@Embeddable
public class JobAssetMasterPK implements Serializable 
{
	// default serial version id, required for serializable classes.

	/**
	 * 
	 */
	private static final long serialVersionUID = -8257014151788153155L;

	@Column(name = "ASSET_SEQ_NO")
	private Long assetSeqNo;

	@Column(name = "JOB_SEQ_NO")
	private Long jobSeqNo;

	@Column(name = "TARGET_SEQ_NO")
	private Long targetSeqNo;

	@Column(name = "FR_LOC_SEQ_NO")
	private Long frLocSeqNo;

	@Column(name = "TO_LOC_SEQ_NO")
	private Long toLocSeqNo;

	@Column(name = "MODE_SEQ_NO")
	private Long modeSeqNo;

	public JobAssetMasterPK() {
	}

	public Long getAssetSeqNo() {
		return this.assetSeqNo;
	}

	public void setAssetSeqNo(Long assetSeqNo) {
		this.assetSeqNo = assetSeqNo;
	}

	public Long getJobSeqNo() {
		return this.jobSeqNo;
	}

	public void setJobSeqNo(Long jobSeqNo) {
		this.jobSeqNo = jobSeqNo;
	}

	public Long getTargetSeqNo() {
		return this.targetSeqNo;
	}

	public void setTargetSeqNo(Long targetSeqNo) {
		this.targetSeqNo = targetSeqNo;
	}

	public Long getFrLocSeqNo() {
		return this.frLocSeqNo;
	}

	public void setFrLocSeqNo(Long frLocSeqNo) {
		this.frLocSeqNo = frLocSeqNo;
	}

	public Long getToLocSeqNo() {
		return this.toLocSeqNo;
	}

	public void setToLocSeqNo(Long toLocSeqNo) {
		this.toLocSeqNo = toLocSeqNo;
	}

	public Long getModeSeqNo() {
		return this.modeSeqNo;
	}

	public void setModeSeqNo(Long modeSeqNo) {
		this.modeSeqNo = modeSeqNo;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof JobAssetMasterPK)) {
			return false;
		}
		JobAssetMasterPK castOther = (JobAssetMasterPK) other;
		return (this.assetSeqNo == castOther.assetSeqNo) && (this.jobSeqNo == castOther.jobSeqNo)
				&& (this.targetSeqNo == castOther.targetSeqNo) && (this.frLocSeqNo == castOther.frLocSeqNo)
				&& (this.toLocSeqNo == castOther.toLocSeqNo) && (this.modeSeqNo == castOther.modeSeqNo);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.assetSeqNo ^ (this.assetSeqNo >>> 32)));
		hash = hash * prime + ((int) (this.jobSeqNo ^ (this.jobSeqNo >>> 32)));
		hash = hash * prime + ((int) (this.targetSeqNo ^ (this.targetSeqNo >>> 32)));
		hash = hash * prime + ((int) (this.frLocSeqNo ^ (this.frLocSeqNo >>> 32)));
		hash = hash * prime + ((int) (this.toLocSeqNo ^ (this.toLocSeqNo >>> 32)));
		hash = hash * prime + ((int) (this.modeSeqNo ^ (this.modeSeqNo >>> 32)));

		return hash;
	}

	public JobAssetMasterPK(Long assetSeqNo, Long jobSeqNo, Long targetSeqNo, Long frLocSeqNo, Long toLocSeqNo,
			Long modeSeqNo) {
		super();
		this.assetSeqNo = assetSeqNo;
		this.jobSeqNo = jobSeqNo;
		this.targetSeqNo = targetSeqNo;
		this.frLocSeqNo = frLocSeqNo;
		this.toLocSeqNo = toLocSeqNo;
		this.modeSeqNo = modeSeqNo;
	}

}