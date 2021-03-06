package model;

import java.io.Serializable;
import java.util.Date;

public class Course implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column course.course_id
     *
     * @mbg.generated Mon Dec 31 09:59:50 CST 2018
     */
    private Integer courseId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column course.name
     *
     * @mbg.generated Mon Dec 31 09:59:50 CST 2018
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column course.class_num
     *
     * @mbg.generated Mon Dec 31 09:59:50 CST 2018
     */
    private Integer classNum;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column course.class_per_price
     *
     * @mbg.generated Mon Dec 31 09:59:50 CST 2018
     */
    private Long classPerPrice;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column course.description
     *
     * @mbg.generated Mon Dec 31 09:59:50 CST 2018
     */
    private String description;

    private String picture;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column course.creator
     *
     * @mbg.generated Mon Dec 31 09:59:50 CST 2018
     */
    private Integer creator;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column course.create_time
     *
     * @mbg.generated Mon Dec 31 09:59:50 CST 2018
     */
    private Date createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column course.amender
     *
     * @mbg.generated Mon Dec 31 09:59:50 CST 2018
     */
    private Integer amender;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column course.amend_time
     *
     * @mbg.generated Mon Dec 31 09:59:50 CST 2018
     */
    private Date amendTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table course
     *
     * @mbg.generated Mon Dec 31 09:59:50 CST 2018
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column course.course_id
     *
     * @return the value of course.course_id
     *
     * @mbg.generated Mon Dec 31 09:59:50 CST 2018
     */
    public Integer getCourseId() {
        return courseId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column course.course_id
     *
     * @param courseId the value for course.course_id
     *
     * @mbg.generated Mon Dec 31 09:59:50 CST 2018
     */
    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column course.name
     *
     * @return the value of course.name
     *
     * @mbg.generated Mon Dec 31 09:59:50 CST 2018
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column course.name
     *
     * @param name the value for course.name
     *
     * @mbg.generated Mon Dec 31 09:59:50 CST 2018
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column course.class_num
     *
     * @return the value of course.class_num
     *
     * @mbg.generated Mon Dec 31 09:59:50 CST 2018
     */
    public Integer getClassNum() {
        return classNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column course.class_num
     *
     * @param classNum the value for course.class_num
     *
     * @mbg.generated Mon Dec 31 09:59:50 CST 2018
     */
    public void setClassNum(Integer classNum) {
        this.classNum = classNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column course.class_per_price
     *
     * @return the value of course.class_per_price
     *
     * @mbg.generated Mon Dec 31 09:59:50 CST 2018
     */
    public Long getClassPerPrice() {
        return classPerPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column course.class_per_price
     *
     * @param classPerPrice the value for course.class_per_price
     *
     * @mbg.generated Mon Dec 31 09:59:50 CST 2018
     */
    public void setClassPerPrice(Long classPerPrice) {
        this.classPerPrice = classPerPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column course.description
     *
     * @return the value of course.description
     *
     * @mbg.generated Mon Dec 31 09:59:50 CST 2018
     */
    public String getDescription() {
        return description;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column course.description
     *
     * @param description the value for course.description
     *
     * @mbg.generated Mon Dec 31 09:59:50 CST 2018
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getPicture() {
        return picture;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column course.creator
     *
     * @return the value of course.creator
     *
     * @mbg.generated Mon Dec 31 09:59:50 CST 2018
     */
    public Integer getCreator() {
        return creator;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column course.creator
     *
     * @param creator the value for course.creator
     *
     * @mbg.generated Mon Dec 31 09:59:50 CST 2018
     */
    public void setCreator(Integer creator) {
        this.creator = creator;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column course.create_time
     *
     * @return the value of course.create_time
     *
     * @mbg.generated Mon Dec 31 09:59:50 CST 2018
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column course.create_time
     *
     * @param createTime the value for course.create_time
     *
     * @mbg.generated Mon Dec 31 09:59:50 CST 2018
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column course.amender
     *
     * @return the value of course.amender
     *
     * @mbg.generated Mon Dec 31 09:59:50 CST 2018
     */
    public Integer getAmender() {
        return amender;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column course.amender
     *
     * @param amender the value for course.amender
     *
     * @mbg.generated Mon Dec 31 09:59:50 CST 2018
     */
    public void setAmender(Integer amender) {
        this.amender = amender;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column course.amend_time
     *
     * @return the value of course.amend_time
     *
     * @mbg.generated Mon Dec 31 09:59:50 CST 2018
     */
    public Date getAmendTime() {
        return amendTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column course.amend_time
     *
     * @param amendTime the value for course.amend_time
     *
     * @mbg.generated Mon Dec 31 09:59:50 CST 2018
     */
    public void setAmendTime(Date amendTime) {
        this.amendTime = amendTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table course
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
        Course other = (Course) that;
        return (this.getCourseId() == null ? other.getCourseId() == null : this.getCourseId().equals(other.getCourseId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getClassNum() == null ? other.getClassNum() == null : this.getClassNum().equals(other.getClassNum()))
            && (this.getClassPerPrice() == null ? other.getClassPerPrice() == null : this.getClassPerPrice().equals(other.getClassPerPrice()))
            && (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(other.getDescription()))
            && (this.getCreator() == null ? other.getCreator() == null : this.getCreator().equals(other.getCreator()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getAmender() == null ? other.getAmender() == null : this.getAmender().equals(other.getAmender()))
            && (this.getAmendTime() == null ? other.getAmendTime() == null : this.getAmendTime().equals(other.getAmendTime()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table course
     *
     * @mbg.generated Mon Dec 31 09:59:50 CST 2018
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCourseId() == null) ? 0 : getCourseId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getClassNum() == null) ? 0 : getClassNum().hashCode());
        result = prime * result + ((getClassPerPrice() == null) ? 0 : getClassPerPrice().hashCode());
        result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
        result = prime * result + ((getCreator() == null) ? 0 : getCreator().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getAmender() == null) ? 0 : getAmender().hashCode());
        result = prime * result + ((getAmendTime() == null) ? 0 : getAmendTime().hashCode());
        return result;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table course
     *
     * @mbg.generated Mon Dec 31 09:59:50 CST 2018
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", courseId=").append(courseId);
        sb.append(", name=").append(name);
        sb.append(", classNum=").append(classNum);
        sb.append(", classPerPrice=").append(classPerPrice);
        sb.append(", description=").append(description);
        sb.append(", creator=").append(creator);
        sb.append(", createTime=").append(createTime);
        sb.append(", amender=").append(amender);
        sb.append(", amendTime=").append(amendTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}