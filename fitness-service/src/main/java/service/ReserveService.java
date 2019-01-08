package service;

import java.util.List;
import java.util.Map;

import model.Reserve;
import pojo.RequestResultVO;

public interface ReserveService {

	public RequestResultVO insert(Reserve reserve);

	public RequestResultVO update(Reserve reserve);

	public RequestResultVO delete(List<Integer> reserveIds);

    public Map<String,Object> getByPage(String keys, Integer pageSize, Integer pageNow);

    }


