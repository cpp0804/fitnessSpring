package pojo.vo;

import model.BasicDataSet;
import pojo.BaseModelVO;

public class BasicDataSetVO extends BasicDataSet {

	private BaseModelVO baseModel;

	public BaseModelVO getBaseModel() {
		return baseModel;
	}
	public void setBaseModel(BaseModelVO baseModel) {
		this.baseModel = baseModel;
	}
}