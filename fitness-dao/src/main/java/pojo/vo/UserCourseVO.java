package pojo.vo;

import model.UserCourse;
import pojo.BaseModelVO;

public class UserCourseVO extends UserCourse {

	private BaseModelVO baseModel;
	private String courseName;

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