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

	public Map<String,Object> getByPageUser();

	public UserCourse findByCourseAndUserNotFinished(Integer courseId,Integer userId);//0表示已完成，1表示正在上课中
    }


