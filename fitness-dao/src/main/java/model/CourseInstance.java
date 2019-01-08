package model;

import java.io.Serializable;
import java.util.Date;

public class CourseInstance implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column course_instance.course_instance_id
     *
     * @mbg.generated Mon Dec 31 09:59:50 CST 2018
     */
    private Integer courseInstanceId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column course_instance.course_time
     *
     * @mbg.generated Mon Dec 31 09:59:50 CST 2018
     */
    private Date courseTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column course_instance.coach
     *
     * @mbg.generated Mon Dec 31 09:59:50 CST 2018
     */
    private Integer coach;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column course_instance.max_reserve
     *
     * @mbg.generated Mon Dec 31 09:59:50 CST 2018
     */
    private Integer maxReserve;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column course_instance.status
     *
     * @mbg.generated Mon Dec 31 09:59:50 CST 2018
     */
    private Integer status;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column course_instance.course_id
     *
     * @mbg.generated Mon Dec 31 09:59:50 CST 2018
     */
    private Integer courseId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column course_instance.creator
     *
     * @mbg.generated Mon Dec 31 09:59:50 CST 2018
     */
    private Integer creator;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column course_instance.create_time
     *
     * @mbg.generated Mon Dec 31 09:59:50 CST 2018
     */
    private Date createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column course_instance.amender
     *
     * @mbg.generated Mon Dec 31 09:59:50 CST 2018
     */
    private Integer amender;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column course_instance.amend_time
     *
     * @mbg.generated Mon Dec 31 09:59:50 CST 2018
     */
    private Date amendTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column course_instance.remaining_reserve
     *
     * @mbg.generated Mon Dec 31 09:59:50 CST 2018
     */
    private Integer remainingReserve;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table course_instance
     *
     * @mbg.generated Mon Dec 31 09:59:50 CST 2018
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column course_instance.course_instance_id
     *
     * @return the value of course_instance.course_instance_id
     *
     * @mbg.generated Mon Dec 31 09:59:50 CST 2018
     */
    public Integer getCourseInstanceId() {
        return courseInstanceId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column course_instance.course_instance_id
     *
     * @param courseInstanceId the value for course_instance.course_instance_id
     *
     * @mbg.generated Mon Dec 31 09:59:50 CST 2018
     */
    public void setCourseInstanceId(Integer courseInstanceId) {
        this.courseInstanceId = courseInstanceId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column course_instance.course_time
     *
     * @return the value of course_instance.course_time
     *
     * @mbg.generated Mon Dec 31 09:59:50 CST 2018
     */
    public Date getCourseTime() {
        return courseTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column course_instance.course_time
     *
     * @param courseTime the value for course_instance.course_time
     *
     * @mbg.generated Mon Dec 31 09:59:50 CST 2018
     */
    public void setCourseTime(Date courseTime) {
        this.courseTime = courseTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column course_instance.coach
     *
     * @return the value of course_instance.coach
     *
     * @mbg.generated Mon Dec 31 09:59:50 CST 2018
     */
    public Integer getCoach() {
        return coach;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column course_instance.coach
     *
     * @param coach the value for course_instance.coach
     *
     * @mbg.generated Mon Dec 31 09:59:50 CST 2018
     */
    public void setCoach(Integer coach) {
        this.coach = coach;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column course_instance.max_reserve
     *
     * @return the value of course_instance.max_reserve
     *
     * @mbg.generated Mon Dec 31 09:59:50 CST 2018
     */
    public Integer getMaxReserve() {
        return maxReserve;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column course_instance.max_reserve
     *
     * @param maxReserve the value for course_instance.max_reserve
     *
     * @mbg.generated Mon Dec 31 09:59:50 CST 2018
     */
    public void setMaxReserve(Integer maxReserve) {
        this.maxReserve = maxReserve;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column course_instance.status
     *
     * @return the value of course_instance.status
     *
     * @mbg.generated Mon Dec 31 09:59:50 CST 2018
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column course_instance.status
     *
     * @param status the value for course_instance.status
     *
     * @mbg.generated Mon Dec 31 09:59:50 CST 2018
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column course_instance.course_id
     *
     * @return the value of course_instance.course_id
     *
     * @mbg.generated Mon Dec 31 09:59:50 CST 2018
     */
    public Integer getCourseId() {
        return courseId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column course_instance.course_id
     *
     * @param courseId the value for course_instance.course_id
     *
     * @mbg.generated Mon Dec 31 09:59:50 CST 2018
     */
    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column course_instance.creator
     *
     * @return the value of course_instance.creator
     *
     * @mbg.generated Mon Dec 31 09:59:50 CST 2018
     */
    public Integer getCreator() {
        return creator;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column course_instance.creator
     *
     * @param creator the value for course_instance.creator
     *
     * @mbg.generated Mon Dec 31 09:59:50 CST 2018
     */
    public void setCreator(Integer creator) {
        this.creator = creator;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column course_instance.create_time
     *
     * @return the value of course_instance.create_time
     *
     * @mbg.generated Mon Dec 31 09:59:50 CST 2018
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column course_instance.create_time
     *
     * @param createTime the value for course_instance.create_time
     *
     * @mbg.generated Mon Dec 31 09:59:50 CST 2018
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column course_instance.amender
     *
     * @return the value of course_instance.amender
     *
     * @mbg.generated Mon Dec 31 09:59:50 CST 2018
     */
    public Integer getAmender() {
        return amender;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column course_instance.amender
     *
     * @param amender the value for course_instance.amender
     *
     * @mbg.generated Mon Dec 31 09:59:50 CST 2018
     */
    public void setAmender(Integer amender) {
        this.amender = amender;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column course_instance.amend_time
     *
     * @return the value of course_instance.amend_time
     *
     * @mbg.generated Mon Dec 31 09:59:50 CST 2018
     */
    public Date getAmendTime() {
        return amendTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column course_instance.amend_time
     *
     * @param amendTime the value for course_instance.amend_time
     *
     * @mbg.generated Mon Dec 31 09:59:50 CST 2018
     */
    public void setAmendTime(Date amendTime) {
        this.amendTime = amendTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column course_instance.remaining_reserve
     *
     * @return the value of course_instance.remaining_reserve
     *
     * @mbg.generated Mon Dec 31 09:59:50 CST 2018
     */
    public Integer getRemainingReserve() {
        return remainingReserve;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column course_instance.remaining_reserve
     *
     * @param remainingReserve the value for course_instance.remaining_reserve
     *
     * @mbg.generated Mon Dec 31 09:59:50 CST 2018
     */
    public void setRemainingReserve(Integer remainingReserve) {
        this.remainingReserve = remainingReserve;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table course_instance
     *
     * @mbg.generated Mon Dec 31 09:59:50 CST 2018
     */
    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        CourseInstance other = (CourseInstance) that;
        return (this.getCourseInstanceId() == null ? other.getCourseInstanceId() == null : this.getCourseInstanceId().equals(other.getCourseInstanceId()))
            && (this.getCourseTime() == null ? other.getCourseTime() == null : this.getCourseTime().equals(other.getCourseTime()))
            && (this.getCoach() == null ? other.getCoach() == null : this.getCoach().equals(other.getCoach()))
            && (this.getMaxReserve() == null ? other.getMaxReserve() == null : this.getMaxReserve().equals(other.getMaxReserve()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getCourseId() == null ? other.getCourseId() == null : this.getCourseId().equals(other.getCourseId()))
            && (this.getCreator() == null ? other.getCreator() == null : this.getCreator().equals(other.getCreator()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getAmender() == null ? other.getAmender() == null : this.getAmender().equals(other.getAmender()))
            && (this.getAmendTime() == null ? other.getAmendTime() == null : this.getAmendTime().equals(other.getAmendTime()))
            && (this.getRemainingReserve() == null ? other.getRemainingReserve() == null : this.getRemainingReserve().equals(other.getRemainingReserve()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table course_instance
     *
     * @mbg.generated Mon Dec 31 09:59:50 CST 2018
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCourseInstanceId() == null) ? 0 : getCourseInstanceId().hashCode());
        result = prime * result + ((getCourseTime() == null) ? 0 : getCourseTime().hashCode());
        result = prime * result + ((getCoach() == null) ? 0 : getCoach().hashCode());
        result = prime * result + ((getMaxReserve() == null) ? 0 : getMaxReserve().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getCourseId() == null) ? 0 : getCourseId().hashCode());
        result = prime * result + ((getCreator() == null) ? 0 : getCreator().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getAmender() == null) ? 0 : getAmender().hashCode());
        result = prime * result + ((getAmendTime() == null) ? 0 : getAmendTime().hashCode());
        result = prime * result + ((getRemainingReserve() == null) ? 0 : getRemainingReserve().hashCode());
        return result;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table course_instance
     *
     * @mbg.generated Mon Dec 31 09:59:50 CST 2018
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", courseInstanceId=").append(courseInstanceId);
        sb.append(", courseTime=").append(courseTime);
        sb.append(", coach=").append(coach);
        sb.append(", maxReserve=").append(maxReserve);
        sb.append(", status=").append(status);
        sb.append(", courseId=").append(courseId);
        sb.append(", creator=").append(creator);
        sb.append(", createTime=").append(createTime);
        sb.append(", amender=").append(amender);
        sb.append(", amendTime=").append(amendTime);
        sb.append(", remainingReserve=").append(remainingReserve);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}