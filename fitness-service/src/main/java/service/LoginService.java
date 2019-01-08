package service;

import java.util.List;
import java.util.Map;

import model.Login;
import pojo.RequestResultVO;

public interface LoginService {

    public RequestResultVO insert(Login login);

    public RequestResultVO update(Login login);

    public RequestResultVO delete(List<Integer> loginIds);

    public Map<String, Object> getByPage(String keys, Integer pageSize, Integer pageNow);

    public Login getLoginByLoginName(String loginName);
}


