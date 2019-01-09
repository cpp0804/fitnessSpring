package service;

import java.util.List;
import java.util.Map;

import model.User;
import pojo.RequestResultVO;

public interface UserService {

    public RequestResultVO insert(User user);

    public RequestResultVO update(User user);

    public RequestResultVO delete(List<Integer> userIds);

    public Map<String, Object> getByPage(String keys, Integer pageSize, Integer pageNow);

    public User getUserById(Integer userId);

    public User getSessionUser();

    public void init_USERMAP();

    public Map<String,Object> getStudentList(Integer reserveId);
}


