package service;

import java.util.List;
import java.util.Map;

import model.Resource;
import pojo.RequestResultVO;

public interface ResourceService {

	public RequestResultVO insert(Resource resource);

	public RequestResultVO update(Resource resource);

	public RequestResultVO delete(List<Integer> resourceIds);

    public Map<String,Object> getByPage(String keys, Integer pageSize, Integer pageNow);

	public void init_RESOURCESTREE();

    }


