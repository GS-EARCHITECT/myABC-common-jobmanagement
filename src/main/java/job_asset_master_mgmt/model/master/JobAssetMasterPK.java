package job_asset_master_mgmt.model.master;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the JOB_ASSET_MASTER database table.
 * 
 */
@Embeddable
public class JobAssetMasterPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="ASSET_SEQ_NO")
	private long assetSeqNo;

	@Column(name="JOB_SEQ_NO")
	private long jobSeqNo;

	@Column(name="TARGET_SEQ_NO")
	private long targetSeqNo;

	@Column(name="FR_LOC_SEQ_NO")
	private long frLocSeqNo;

	@Column(name="TO_LOC_SEQ_NO")
	private long toLocSeqNo;

	@Column(name="MODE_SEQ_NO")
	private long modeSeqNo;

	public JobAssetMasterPK() {
	}
	public long getAssetSeqNo() {
		return this.assetSeqNo;
	}
	public void setAssetSeqNo(long assetSeqNo) {
		this.assetSeqNo = assetSeqNo;
	}
	public long getJobSeqNo() {
		return this.jobSeqNo;
	}
	public void setJobSeqNo(long jobSeqNo) {
		this.jobSeqNo = jobSeqNo;
	}
	public long getTargetSeqNo() {
		return this.targetSeqNo;
	}
	public void setTargetSeqNo(long targetSeqNo) {
		this.targetSeqNo = targetSeqNo;
	}
	public long getFrLocSeqNo() {
		return this.frLocSeqNo;
	}
	public void setFrLocSeqNo(long frLocSeqNo) {
		this.frLocSeqNo = frLocSeqNo;
	}
	public long getToLocSeqNo() {
		return this.toLocSeqNo;
	}
	public void setToLocSeqNo(long toLocSeqNo) {
		this.toLocSeqNo = toLocSeqNo;
	}
	public long getModeSeqNo() {
		return this.modeSeqNo;
	}
	public void setModeSeqNo(long modeSeqNo) {
		this.modeSeqNo = modeSeqNo;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof JobAssetMasterPK)) {
			return false;
		}
		JobAssetMasterPK castOther = (JobAssetMasterPK)other;
		return 
			(this.assetSeqNo == castOther.assetSeqNo)
			&& (this.jobSeqNo == castOther.jobSeqNo)
			&& (this.targetSeqNo == castOther.targetSeqNo)
			&& (this.frLocSeqNo == castOther.frLocSeqNo)
			&& (this.toLocSeqNo == castOther.toLocSeqNo)
			&& (this.modeSeqNo == castOther.modeSeqNo);
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
}