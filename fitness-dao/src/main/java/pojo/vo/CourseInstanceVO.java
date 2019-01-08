package pojo.vo;

import model.CourseInstance;
import pojo.BaseModelVO;

public class CourseInstanceVO extends CourseInstance {

	private BaseModelVO baseModel;

	private String courseName;

	private String coachName;

	public void setCoachName(String coachName) {
		this.coachName = coachName;
	}

	public String getCoachName() {
		return coachName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCourseName() {
		return courseName;
	}

	public BaseModelVO getBaseModel() {
		return baseModel;
	}
	public void setBaseModel(BaseModelVO baseModel) {
		this.baseModel = baseModel;
	}
}