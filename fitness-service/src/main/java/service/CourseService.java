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

    public Map<String, Object> getByPageSimple();

    public RequestResultVO buyCourse(Integer courseId, Integer courseNum);

    public String payCourse(Integer courseId, Long price);
}


