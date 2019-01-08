package service;

import java.util.List;
import java.util.Map;

import model.Course;
import model.CourseInstance;
import pojo.RequestResultVO;

public interface CourseInstanceService {

	public RequestResultVO insert(CourseInstance courseInstance);

	public RequestResultVO update(CourseInstance courseInstance);

	public RequestResultVO delete(List<Integer> courseInstanceIds);

    public Map<String,Object> getByPage(String keys, Integer pageSize, Integer pageNow);

    }


