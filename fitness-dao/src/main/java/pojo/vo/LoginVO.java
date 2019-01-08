package pojo.vo;

import model.Login;
import pojo.BaseModelVO;

public class LoginVO extends Login {

	private BaseModelVO baseModel;

	public BaseModelVO getBaseModel() {
		return baseModel;
	}
	public void setBaseModel(BaseModelVO baseModel) {
		this.baseModel = baseModel;
	}
}