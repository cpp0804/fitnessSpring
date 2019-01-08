package service;

import java.util.List;
import java.util.Map;

import model.Role;
import pojo.RequestResultVO;

public interface RoleService {

	public RequestResultVO insert(Role role);

	public RequestResultVO update(Role role);

	public RequestResultVO delete(List<Integer> roleIds);

    public Map<String,Object> getByPage(String keys, Integer pageSize, Integer pageNow);

    }


