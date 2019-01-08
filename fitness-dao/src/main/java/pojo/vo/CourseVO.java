package pojo.vo;

import model.Course;
import pojo.BaseModelVO;

public class CourseVO extends Course {

	private BaseModelVO baseModel;

	public BaseModelVO getBaseModel() {
		return baseModel;
	}
	public void setBaseModel(BaseModelVO baseModel) {
		this.baseModel = baseModel;
	}
}