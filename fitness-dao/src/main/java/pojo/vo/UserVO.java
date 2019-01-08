package pojo.vo;

import model.User;
import pojo.BaseModelVO;

public class UserVO extends User {

	private BaseModelVO baseModel;

	public BaseModelVO getBaseModel() {
		return baseModel;
	}
	public void setBaseModel(BaseModelVO baseModel) {
		this.baseModel = baseModel;
	}
}