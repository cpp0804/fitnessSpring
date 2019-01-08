package pojo.vo;

import model.RoleResource;
import pojo.BaseModelVO;

public class RoleResourceVO extends RoleResource {

	private BaseModelVO baseModel;

	public BaseModelVO getBaseModel() {
		return baseModel;
	}
	public void setBaseModel(BaseModelVO baseModel) {
		this.baseModel = baseModel;
	}
}