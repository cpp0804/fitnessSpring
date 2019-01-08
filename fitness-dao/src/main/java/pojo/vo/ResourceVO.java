package pojo.vo;

import model.Resource;
import pojo.BaseModelVO;

public class ResourceVO extends Resource {

	private BaseModelVO baseModel;

	public BaseModelVO getBaseModel() {
		return baseModel;
	}
	public void setBaseModel(BaseModelVO baseModel) {
		this.baseModel = baseModel;
	}
}