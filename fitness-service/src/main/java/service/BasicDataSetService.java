package service;

import java.util.List;
import java.util.Map;

import model.BasicDataSet;
import pojo.RequestResultVO;

public interface BasicDataSetService {

	public RequestResultVO insert(BasicDataSet basicDataSet);

	public RequestResultVO update(BasicDataSet basicDataSet);

	public RequestResultVO delete(List<Integer> basicDataSetIds);

    public Map<String,Object> getByPage(String keys, Integer pageSize, Integer pageNow);

    }


