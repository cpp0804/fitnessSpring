package service.impl;


import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import common.log.ErrorLoggers;
import common.log.LogUtil;
import mapper.CourseMapper;
import mapper.UserMapper;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import common.exceptions.BizException;
import page.Page;
import common.util.DateJsonValueProcessor;
import common.util.HttpResponseConstants.Public;
import pojo.RequestResultVO;
import service.commonService.DataAuthorizeService;
import service.commonService.util.ResultBuilder;
import service.commonService.CommonService;
import mapper.CourseInstanceMapper;
import model.CourseInstance;
import model.CourseInstanceExample;

import pojo.vo.CourseInstanceVO;
import service.CourseInstanceService;

@Service
public class CourseInstanceServiceImpl implements CourseInstanceService {

    @Autowired
    private CourseInstanceMapper courseInstanceMapper;

    @Autowired
    private DataAuthorizeService dataAuthorizeService;

    @Autowired
    private CourseMapper courseMapper;

    @Autowired
    private UserMapper userMapper;

    private CommonService<CourseInstance, CourseInstanceMapper, CourseInstanceExample> commonService;

    //注入commonService
    @Resource(name = "commonService")
    public void setCommonService(CommonService<CourseInstance, CourseInstanceMapper, CourseInstanceExample> commonService) {
        this.commonService = commonService;
    }

    @Override
    public RequestResultVO insert(CourseInstance courseInstance) {
        if (courseInstance == null) {
            throw new BizException(Public.ERROR_700);
        }
        dataAuthorizeService.addDataAuthorizeInfo(courseInstance, "insert");
        courseInstanceMapper.insert(courseInstance);
        return ResultBuilder.buildSuccessResult(Public.SUCCESS_200, "");
    }

    @Override
    public RequestResultVO update(CourseInstance courseInstance) {
        if (courseInstance == null || courseInstance.getCourseInstanceId() == null) {
            throw new BizException(Public.ERROR_700);
        }
        dataAuthorizeService.addDataAuthorizeInfo(courseInstance, "update");
        courseInstanceMapper.updateByPrimaryKeySelective(courseInstance);
        return ResultBuilder.buildSuccessResult(Public.SUCCESS_300, "");
    }

    @Override
    public RequestResultVO delete(List<Integer> courseInstanceIds) {
        if (courseInstanceIds == null || courseInstanceIds.size() == 0) {
            throw new BizException(Public.ERROR_700);
        }
        CourseInstanceExample courseInstanceExample = new CourseInstanceExample();
        courseInstanceExample.createCriteria().andCourseInstanceIdIn(courseInstanceIds);
        courseInstanceMapper.deleteByExample(courseInstanceExample);
        return ResultBuilder.buildSuccessResult(Public.SUCCESS_400, "");
    }

    @Override
    public Map<String, Object> getByPage(String keys) {
        CourseInstanceExample courseInstanceExample = new CourseInstanceExample();
        this.setCriteria(keys, courseInstanceExample);
        int totalrecords = (int) courseInstanceMapper.countByExample(courseInstanceExample);
//
//        Page page = new Page();
//        page.setBegin(pageNow);
//        page.setLength(pageSize);
        courseInstanceExample.setOrderByClause("course_instance_id desc");
//        courseInstanceExample.setPage(page);
        List<CourseInstance> courseInstances = courseInstanceMapper.selectByExample(courseInstanceExample);

        Map<String, Object> map = new HashMap<String, Object>();
        JsonConfig config = new JsonConfig();
        config.setIgnoreDefaultExcludes(false);
        config.registerJsonValueProcessor(Date.class, new DateJsonValueProcessor("yyyy-MM-dd"));
        try {
            map.put("aaData", JSONArray.fromObject(this.creatVos(courseInstances), config));
        } catch (Exception e) {
            LogUtil.error(ErrorLoggers.ERROR_LOGGER, e.getMessage());
            throw new BizException(Public.ERROR_100);
        }
        map.put("recordsTotal", totalrecords);
        map.put("recordsFiltered", totalrecords);

        return map;
    }

    private void setCriteria(String keys, CourseInstanceExample courseInstanceExample) {
        if (keys == null || "{}".equals(keys))
            return;
        JSONObject jKeys = JSONObject.fromObject(keys);
        CourseInstanceExample.Criteria criteria = courseInstanceExample.createCriteria();
        criteria.andRemainingReserveGreaterThan(0);

    }

    private List<CourseInstanceVO> creatVos(List<CourseInstance> courseInstances) throws Exception {
        List<CourseInstanceVO> courseInstanceVOs = new ArrayList<CourseInstanceVO>();
        for (CourseInstance courseInstance : courseInstances) {
            CourseInstanceVO courseInstanceVO = new CourseInstanceVO();
            BeanUtils.copyProperties(courseInstance, courseInstanceVO);
            courseInstanceVO.setCourseName(courseMapper.selectByPrimaryKey(courseInstance.getCourseId()).getName());
            courseInstanceVO.setCoachName(userMapper.selectByPrimaryKey(courseInstance.getCoach()).getName());
            commonService.addBaseModel(courseInstance, courseInstanceVO);
            courseInstanceVOs.add(courseInstanceVO);
        }
        return courseInstanceVOs;
    }
}




