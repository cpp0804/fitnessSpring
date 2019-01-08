package pojo.vo;

import model.Reserve;
import pojo.BaseModelVO;

public class ReserveVO extends Reserve {

	private BaseModelVO baseModel;

	public BaseModelVO getBaseModel() {
		return baseModel;
	}
	public void setBaseModel(BaseModelVO baseModel) {
		this.baseModel = baseModel;
	}
}