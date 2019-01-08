package pojo.vo;

import model.CourseInstance;
import pojo.BaseModelVO;

public class CourseInstanceVO extends CourseInstance {

	private BaseModelVO baseModel;

	public BaseModelVO getBaseModel() {
		return baseModel;
	}
	public void setBaseModel(BaseModelVO baseModel) {
		this.baseModel = baseModel;
	}
}