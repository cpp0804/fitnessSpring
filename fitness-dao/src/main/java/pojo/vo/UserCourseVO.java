package pojo.vo;

import model.UserCourse;
import pojo.BaseModelVO;

public class UserCourseVO extends UserCourse {

	private BaseModelVO baseModel;

	public BaseModelVO getBaseModel() {
		return baseModel;
	}
	public void setBaseModel(BaseModelVO baseModel) {
		this.baseModel = baseModel;
	}
}