package job_structure_target_details_mgmt.model.dto;

import java.io.Serializable;

public class JobStructureTargetDetail_DTO implements Serializable 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1364667199762823836L;
	private Long jobSeqNo;
	private Long parJobSeqNo;
	private Long jobClassSeqNo;
	private Long targetSeqNo;
	private Long parJobClassSeqNo;
	private Long parTargetSeqNo;
	private String remark;
	private Long seqNo;
	private String status;

	public Long getJobSeqNo() {
		return jobSeqNo;
	}

	public void setJobSeqNo(Long jobSeqNo) {
		this.jobSeqNo = jobSeqNo;
	}

	public Long getParJobSeqNo() {
		return parJobSeqNo;
	}

	public void setParJobSeqNo(Long parJobSeqNo) {
		this.parJobSeqNo = parJobSeqNo;
	}

	public Long getJobClassSeqNo() {
		return jobClassSeqNo;
	}

	public void setJobClassSeqNo(Long jobClassSeqNo) {
		this.jobClassSeqNo = jobClassSeqNo;
	}

	public Long getTargetSeqNo() {
		return targetSeqNo;
	}

	public void setTargetSeqNo(Long targetSeqNo) {
		this.targetSeqNo = targetSeqNo;
	}

	public Long getParJobClassSeqNo() {
		return parJobClassSeqNo;
	}

	public void setParJobClassSeqNo(Long parJobClassSeqNo) {
		this.parJobClassSeqNo = parJobClassSeqNo;
	}

	public Long getParTargetSeqNo() {
		return parTargetSeqNo;
	}

	public void setParTargetSeqNo(Long parTargetSeqNo) {
		this.parTargetSeqNo = parTargetSeqNo;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Long getSeqNo() {
		return seqNo;
	}

	public void setSeqNo(Long seqNo) {
		this.seqNo = seqNo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public JobStructureTargetDetail_DTO(Long jobSeqNo, Long parJobSeqNo, Long jobClassSeqNo, Long targetSeqNo,
			Long parJobClassSeqNo, Long parTargetSeqNo, String remark, Long seqNo, String status) {
		super();
		this.jobSeqNo = jobSeqNo;
		this.parJobSeqNo = parJobSeqNo;
		this.jobClassSeqNo = jobClassSeqNo;
		this.targetSeqNo = targetSeqNo;
		this.parJobClassSeqNo = parJobClassSeqNo;
		this.parTargetSeqNo = parTargetSeqNo;
		this.remark = remark;
		this.seqNo = seqNo;
		this.status = status;
	}

	public JobStructureTargetDetail_DTO() {
		super();
	}

}