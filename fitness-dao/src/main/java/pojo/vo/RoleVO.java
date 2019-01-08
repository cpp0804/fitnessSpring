package pojo.vo;

import model.Role;
import pojo.BaseModelVO;

public class RoleVO extends Role {

	private BaseModelVO baseModel;

	public BaseModelVO getBaseModel() {
		return baseModel;
	}
	public void setBaseModel(BaseModelVO baseModel) {
		this.baseModel = baseModel;
	}
}