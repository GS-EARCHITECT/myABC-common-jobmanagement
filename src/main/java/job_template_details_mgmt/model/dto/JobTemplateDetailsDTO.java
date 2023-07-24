package job_template_details_mgmt.model.dto;

import java.io.Serializable;

public class JobTemplateDetailsDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3932040714110276999L;
	private long jobTemplateSeqNo;
	private long jobLevelNo;
	private Long seqNo;
	private Long jobSeqNo;
	private long targetSeqNo;
	private Long targetClassSeqNo;
	private Integer weeksPlus;
	private Integer monthsPlus;
	private Integer daysPlus;
	private Integer durDays;
	private Integer durHours;
	private Integer durMinutes;
	private Integer durMonths;
	private Integer durSeconds;
	private Integer durWeeks;
	private Integer hoursPlus;
	private Integer minutesPlus;
	private Integer predecessorSeqNo;
	private Integer secondsPlus;
	private Character durationFlag;

	public Long getJobSeqNo() {
		return jobSeqNo;
	}

	public void setJobSeqNo(Long jobSeqNo) {
		this.jobSeqNo = jobSeqNo;
	}

	public long getJobTemplateSeqNo() {
		return jobTemplateSeqNo;
	}

	public void setJobTemplateSeqNo(long jobTemplateSeqNo) {
		this.jobTemplateSeqNo = jobTemplateSeqNo;
	}

	public long getJobLevelNo() {
		return jobLevelNo;
	}

	public void setJobLevelNo(long jobLevelNo) {
		this.jobLevelNo = jobLevelNo;
	}

	public Long getSeqNo() {
		return seqNo;
	}

	public void setSeqNo(Long seqNo) {
		this.seqNo = seqNo;
	}

	public Long getJobClassSeqNo() {
		return jobSeqNo;
	}

	public void setJobClassSeqNo(Long jobSeqNo) {
		this.jobSeqNo = jobSeqNo;
	}

	public long getTargetSeqNo() {
		return targetSeqNo;
	}

	public void setTargetSeqNo(long targetSeqNo) {
		this.targetSeqNo = targetSeqNo;
	}

	public Long getTargetClassSeqNo() {
		return targetClassSeqNo;
	}

	public void setTargetClassSeqNo(Long targetClassSeqNo) {
		this.targetClassSeqNo = targetClassSeqNo;
	}

	public Integer getWeeksPlus() {
		return weeksPlus;
	}

	public void setWeeksPlus(Integer weeksPlus) {
		this.weeksPlus = weeksPlus;
	}

	public Integer getMonthsPlus() {
		return monthsPlus;
	}

	public void setMonthsPlus(Integer monthsPlus) {
		this.monthsPlus = monthsPlus;
	}

	public Integer getDaysPlus() {
		return daysPlus;
	}

	public void setDaysPlus(Integer daysPlus) {
		this.daysPlus = daysPlus;
	}

	public Integer getDurDays() {
		return durDays;
	}

	public void setDurDays(Integer durDays) {
		this.durDays = durDays;
	}

	public Integer getDurHours() {
		return durHours;
	}

	public void setDurHours(Integer durHours) {
		this.durHours = durHours;
	}

	public Integer getDurMinutes() {
		return durMinutes;
	}

	public void setDurMinutes(Integer durMinutes) {
		this.durMinutes = durMinutes;
	}

	public Integer getDurMonths() {
		return durMonths;
	}

	public void setDurMonths(Integer durMonths) {
		this.durMonths = durMonths;
	}

	public Integer getDurSeconds() {
		return durSeconds;
	}

	public void setDurSeconds(Integer durSeconds) {
		this.durSeconds = durSeconds;
	}

	public Integer getDurWeeks() {
		return durWeeks;
	}

	public void setDurWeeks(Integer durWeeks) {
		this.durWeeks = durWeeks;
	}

	public Integer getHoursPlus() {
		return hoursPlus;
	}

	public void setHoursPlus(Integer hoursPlus) {
		this.hoursPlus = hoursPlus;
	}

	public Integer getMinutesPlus() {
		return minutesPlus;
	}

	public void setMinutesPlus(Integer minutesPlus) {
		this.minutesPlus = minutesPlus;
	}

	public Integer getPredecessorSeqNo() {
		return predecessorSeqNo;
	}

	public void setPredecessorSeqNo(Integer predecessorSeqNo) {
		this.predecessorSeqNo = predecessorSeqNo;
	}

	public Integer getSecondsPlus() {
		return secondsPlus;
	}

	public void setSecondsPlus(Integer secondsPlus) {
		this.secondsPlus = secondsPlus;
	}

	public Character getDurationFlag() {
		return durationFlag;
	}

	public void setDurationFlag(Character durationFlag) {
		this.durationFlag = durationFlag;
	}

	public JobTemplateDetailsDTO(long jobTemplateSeqNo, long jobLevelNo, Long seqNo, Long jobSeqNo, long targetSeqNo,
			Long targetClassSeqNo, Integer weeksPlus, Integer monthsPlus, Integer daysPlus, Integer durDays,
			Integer durHours, Integer durMinutes, Integer durMonths, Integer durSeconds, Integer durWeeks,
			Integer hoursPlus, Integer minutesPlus, Integer predecessorSeqNo, Integer secondsPlus,
			Character durationFlag) {
		super();
		this.jobTemplateSeqNo = jobTemplateSeqNo;
		this.jobLevelNo = jobLevelNo;
		this.seqNo = seqNo;
		this.jobSeqNo = jobSeqNo;
		this.targetSeqNo = targetSeqNo;
		this.targetClassSeqNo = targetClassSeqNo;
		this.weeksPlus = weeksPlus;
		this.monthsPlus = monthsPlus;
		this.daysPlus = daysPlus;
		this.durDays = durDays;
		this.durHours = durHours;
		this.durMinutes = durMinutes;
		this.durMonths = durMonths;
		this.durSeconds = durSeconds;
		this.durWeeks = durWeeks;
		this.hoursPlus = hoursPlus;
		this.minutesPlus = minutesPlus;
		this.predecessorSeqNo = predecessorSeqNo;
		this.secondsPlus = secondsPlus;
		this.durationFlag = durationFlag;
	}

	public JobTemplateDetailsDTO() {
		super();
	}

}