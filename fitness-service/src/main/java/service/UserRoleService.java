package service;

import java.util.List;
import java.util.Map;

import model.Role;
import model.UserRole;
import pojo.RequestResultVO;

public interface UserRoleService {

	public RequestResultVO insert(UserRole userRole);

	public RequestResultVO update(UserRole userRole);

	public RequestResultVO delete(List<Integer> userRoleIds);

    public Map<String,Object> getByPage(String keys, Integer pageSize, Integer pageNow);

	public List<UserRole>getUserRoleListByUser(Integer userId);
    }


