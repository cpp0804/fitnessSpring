package pojo.vo;

import model.Reserve;
import pojo.BaseModelVO;

public class ReserveVO extends Reserve {

	private BaseModelVO baseModel;

	private String coachName;
	private String courseName;
	private String courseTime;

	public void setCourseTime(String courseTime) {
		this.courseTime = courseTime;
	}

	public String getCourseTime() {
		return courseTime;
	}

	public void setCoachName(String coachName) {
		this.coachName = coachName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCourseName() {
		return courseName;
	}

	public String getCoachName() {
		return coachName;
	}

	public BaseModelVO getBaseModel() {
		return baseModel;
	}
	public void setBaseModel(BaseModelVO baseModel) {
		this.baseModel = baseModel;
	}
}