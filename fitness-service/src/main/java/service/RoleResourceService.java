package service;

import java.util.List;
import java.util.Map;

import model.RoleResource;
import pojo.RequestResultVO;

public interface RoleResourceService {

	public RequestResultVO insert(RoleResource roleResource);

	public RequestResultVO update(RoleResource roleResource);

	public RequestResultVO delete(List<Integer> roleResourceds);

    public Map<String,Object> getByPage(String keys, Integer pageSize, Integer pageNow);

	public List<Integer>getResourceIdList(List<Integer>roleIds);
    }


