package service;

import java.util.List;
import java.util.Map;

import model.Course;
import pojo.RequestResultVO;

public interface CourseService {

    public RequestResultVO insert(Course course);

    public RequestResultVO update(Course course);

    public RequestResultVO delete(List<Integer> courseIds);

    public Map<String, Object> getByPage(String keys, Integer pageSize, Integer pageNow);

}


