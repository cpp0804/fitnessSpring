package model;

import java.io.Serializable;
import java.util.Date;

public class Login implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column login.login_id
     *
     * @mbg.generated Mon Dec 31 09:59:50 CST 2018
     */
    private Integer loginId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column login.user_id
     *
     * @mbg.generated Mon Dec 31 09:59:50 CST 2018
     */
    private Integer userId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column login.login_name
     *
     * @mbg.generated Mon Dec 31 09:59:50 CST 2018
     */
    private String loginName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column login.password
     *
     * @mbg.generated Mon Dec 31 09:59:50 CST 2018
     */
    private String password;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column login.creator
     *
     * @mbg.generated Mon Dec 31 09:59:50 CST 2018
     */
    private Integer creator;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column login.create_time
     *
     * @mbg.generated Mon Dec 31 09:59:50 CST 2018
     */
    private Date createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column login.amender
     *
     * @mbg.generated Mon Dec 31 09:59:50 CST 2018
     */
    private Integer amender;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column login.amend_time
     *
     * @mbg.generated Mon Dec 31 09:59:50 CST 2018
     */
    private Date amendTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table login
     *
     * @mbg.generated Mon Dec 31 09:59:50 CST 2018
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column login.login_id
     *
     * @return the value of login.login_id
     *
     * @mbg.generated Mon Dec 31 09:59:50 CST 2018
     */
    public Integer getLoginId() {
        return loginId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column login.login_id
     *
     * @param loginId the value for login.login_id
     *
     * @mbg.generated Mon Dec 31 09:59:50 CST 2018
     */
    public void setLoginId(Integer loginId) {
        this.loginId = loginId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column login.user_id
     *
     * @return the value of login.user_id
     *
     * @mbg.generated Mon Dec 31 09:59:50 CST 2018
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column login.user_id
     *
     * @param userId the value for login.user_id
     *
     * @mbg.generated Mon Dec 31 09:59:50 CST 2018
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column login.login_name
     *
     * @return the value of login.login_name
     *
     * @mbg.generated Mon Dec 31 09:59:50 CST 2018
     */
    public String getLoginName() {
        return loginName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column login.login_name
     *
     * @param loginName the value for login.login_name
     *
     * @mbg.generated Mon Dec 31 09:59:50 CST 2018
     */
    public void setLoginName(String loginName) {
        this.loginName = loginName == null ? null : loginName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column login.password
     *
     * @return the value of login.password
     *
     * @mbg.generated Mon Dec 31 09:59:50 CST 2018
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column login.password
     *
     * @param password the value for login.password
     *
     * @mbg.generated Mon Dec 31 09:59:50 CST 2018
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column login.creator
     *
     * @return the value of login.creator
     *
     * @mbg.generated Mon Dec 31 09:59:50 CST 2018
     */
    public Integer getCreator() {
        return creator;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column login.creator
     *
     * @param creator the value for login.creator
     *
     * @mbg.generated Mon Dec 31 09:59:50 CST 2018
     */
    public void setCreator(Integer creator) {
        this.creator = creator;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column login.create_time
     *
     * @return the value of login.create_time
     *
     * @mbg.generated Mon Dec 31 09:59:50 CST 2018
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column login.create_time
     *
     * @param createTime the value for login.create_time
     *
     * @mbg.generated Mon Dec 31 09:59:50 CST 2018
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column login.amender
     *
     * @return the value of login.amender
     *
     * @mbg.generated Mon Dec 31 09:59:50 CST 2018
     */
    public Integer getAmender() {
        return amender;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column login.amender
     *
     * @param amender the value for login.amender
     *
     * @mbg.generated Mon Dec 31 09:59:50 CST 2018
     */
    public void setAmender(Integer amender) {
        this.amender = amender;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column login.amend_time
     *
     * @return the value of login.amend_time
     *
     * @mbg.generated Mon Dec 31 09:59:50 CST 2018
     */
    public Date getAmendTime() {
        return amendTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column login.amend_time
     *
     * @param amendTime the value for login.amend_time
     *
     * @mbg.generated Mon Dec 31 09:59:50 CST 2018
     */
    public void setAmendTime(Date amendTime) {
        this.amendTime = amendTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table login
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
        Login other = (Login) that;
        return (this.getLoginId() == null ? other.getLoginId() == null : this.getLoginId().equals(other.getLoginId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getLoginName() == null ? other.getLoginName() == null : this.getLoginName().equals(other.getLoginName()))
            && (this.getPassword() == null ? other.getPassword() == null : this.getPassword().equals(other.getPassword()))
            && (this.getCreator() == null ? other.getCreator() == null : this.getCreator().equals(other.getCreator()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getAmender() == null ? other.getAmender() == null : this.getAmender().equals(other.getAmender()))
            && (this.getAmendTime() == null ? other.getAmendTime() == null : this.getAmendTime().equals(other.getAmendTime()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table login
     *
     * @mbg.generated Mon Dec 31 09:59:50 CST 2018
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getLoginId() == null) ? 0 : getLoginId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getLoginName() == null) ? 0 : getLoginName().hashCode());
        result = prime * result + ((getPassword() == null) ? 0 : getPassword().hashCode());
        result = prime * result + ((getCreator() == null) ? 0 : getCreator().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getAmender() == null) ? 0 : getAmender().hashCode());
        result = prime * result + ((getAmendTime() == null) ? 0 : getAmendTime().hashCode());
        return result;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table login
     *
     * @mbg.generated Mon Dec 31 09:59:50 CST 2018
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", loginId=").append(loginId);
        sb.append(", userId=").append(userId);
        sb.append(", loginName=").append(loginName);
        sb.append(", password=").append(password);
        sb.append(", creator=").append(creator);
        sb.append(", createTime=").append(createTime);
        sb.append(", amender=").append(amender);
        sb.append(", amendTime=").append(amendTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}