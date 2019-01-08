package pojo.vo;

import model.UserRole;
import pojo.BaseModelVO;

public class UserRoleVO extends UserRole {

	private BaseModelVO baseModel;

	public BaseModelVO getBaseModel() {
		return baseModel;
	}
	public void setBaseModel(BaseModelVO baseModel) {
		this.baseModel = baseModel;
	}
}