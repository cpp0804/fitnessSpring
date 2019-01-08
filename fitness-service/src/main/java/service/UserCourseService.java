package service;

import java.util.List;
import java.util.Map;

import model.UserCourse;
import pojo.RequestResultVO;

public interface UserCourseService {

	public RequestResultVO insert(UserCourse userCourse);

	public RequestResultVO update(UserCourse userCourse);

	public RequestResultVO delete(List<Integer> userCourseIds);

    public Map<String,Object> getByPage(String keys, Integer pageSize, Integer pageNow);

    }


