package service.impl;


import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import model.User;
import model.UserCourse;
import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import common.exceptions.BizException;
import common.log.ErrorLoggers;
import common.log.LogUtil;
import page.Page;
import common.util.DateJsonValueProcessor;
import common.util.HttpResponseConstants.Public;
import pojo.RequestResultVO;
import service.UserCourseService;
import service.UserService;
import service.commonService.DataAuthorizeService;
import service.commonService.util.ResultBuilder;
import service.commonService.CommonService;
import mapper.CourseMapper;
import model.Course;
import model.CourseExample;
import service.commonService.util.alipay.AlipayConfig;

import pojo.vo.CourseVO;
import service.CourseService;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseMapper courseMapper;

    @Autowired
    private UserService userService;

    @Autowired
    private DataAuthorizeService dataAuthorizeService;

    private CommonService<Course, CourseMapper, CourseExample> commonService;

    @Autowired
    private UserCourseService userCourseService;

    //注入commonService
    @Resource(name = "commonService")
    public void setCommonService(CommonService<Course, CourseMapper, CourseExample> commonService) {
        this.commonService = commonService;
    }

    @Override
    public RequestResultVO insert(Course course) {
        if (course == null) {
            throw new BizException(Public.ERROR_700);
        }
        dataAuthorizeService.addDataAuthorizeInfo(course, "insert");
        courseMapper.insert(course);
        return ResultBuilder.buildSuccessResult(Public.SUCCESS_200, "");
    }

    @Override
    public RequestResultVO update(Course course) {
        if (course == null || course.getCourseId() == null) {
            throw new BizException(Public.ERROR_700);
        }
        dataAuthorizeService.addDataAuthorizeInfo(course, "update");
        courseMapper.updateByPrimaryKeySelective(course);
        return ResultBuilder.buildSuccessResult(Public.SUCCESS_300, "");
    }

    @Override
    public RequestResultVO delete(List<Integer> courseIds) {
        if (courseIds == null || courseIds.size() == 0) {
            throw new BizException(Public.ERROR_700);
        }
        CourseExample courseExample = new CourseExample();
        courseExample.createCriteria().andCourseIdIn(courseIds);
        courseMapper.deleteByExample(courseExample);
        return ResultBuilder.buildSuccessResult(Public.SUCCESS_400, "");
    }

    @Override
    public Map<String, Object> getByPage(String keys, Integer pageSize,
                                         Integer pageNow) {
        CourseExample courseExample = new CourseExample();
        this.setCriteria(keys, courseExample);
        int totalrecords = (int) courseMapper.countByExample(courseExample);

        Page page = new Page();
        page.setBegin(pageNow);
        page.setLength(pageSize);
        courseExample.setOrderByClause("course_id desc");
        courseExample.setPage(page);
        List<Course> courses = courseMapper.selectByExample(courseExample);

        Map<String, Object> map = new HashMap<String, Object>();
        JsonConfig config = new JsonConfig();
        config.setIgnoreDefaultExcludes(false);
        config.registerJsonValueProcessor(Date.class, new DateJsonValueProcessor("yyyy-MM-dd"));
        try {
            map.put("aaData", JSONArray.fromObject(this.creatVos(courses), config));
        } catch (Exception e) {
            LogUtil.error(ErrorLoggers.ERROR_LOGGER, e.getMessage());
            throw new BizException(Public.ERROR_100);
        }
        map.put("recordsTotal", totalrecords);
        map.put("recordsFiltered", totalrecords);

        return map;
    }

    @Override
    public Map<String, Object> getByPageSimple() {
        CourseExample courseExample = new CourseExample();
        courseExample.setOrderByClause("course_id desc");
        List<Course> courses = courseMapper.selectByExample(courseExample);

        Map<String, Object> map = new HashMap<String, Object>();
        JsonConfig config = new JsonConfig();
        config.setIgnoreDefaultExcludes(false);
        config.registerJsonValueProcessor(Date.class, new DateJsonValueProcessor("yyyy-MM-dd"));
        try {
            map.put("aaData", JSONArray.fromObject(this.creatVos(courses), config));
        } catch (Exception e) {
            LogUtil.error(ErrorLoggers.ERROR_LOGGER, e.getMessage());
            throw new BizException(Public.ERROR_100);
        }

        return map;
    }

    @Override
    public RequestResultVO buyCourse(Integer courseId, Integer courseNum) {
        User user = userService.getSessionUser();
        UserCourse userCourseNotFinished = userCourseService.findByCourseAndUserNotFinished(courseId, user.getUserId());
        if (userCourseNotFinished != null) {
            return ResultBuilder.buildSuccessResult(Public.BUY_COURSE_EXISTING, "0");
        }
        Course course = courseMapper.selectByPrimaryKey(courseId);
        payCourse(courseId, course.getClassPerPrice() * courseNum);

        UserCourse userCourse = new UserCourse();
        userCourse.setUserId(user.getUserId());
        userCourse.setCourseId(courseId);
        userCourse.setCourseNum(courseNum);
        userCourse.setRemainingNum(courseNum);
        return userCourseService.insert(userCourse);
    }

    @Override
    public String payCourse(Integer courseId, Long price) {
        AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id, AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);

        //设置请求参数
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
        alipayRequest.setReturnUrl(AlipayConfig.return_url);
        alipayRequest.setNotifyUrl(AlipayConfig.notify_url);

        String out_trade_no = "" + courseId + System.currentTimeMillis() + (long) (Math.random() * 10000000L);
        String total_amount = String.valueOf(price);
        String subject = courseMapper.selectByPrimaryKey(courseId).getName() + total_amount + System.currentTimeMillis();
        alipayRequest.setBizContent("{\"out_trade_no\":\"" + out_trade_no + "\","
                + "\"total_amount\":\"" + total_amount + "\","
                + "\"subject\":\"" + subject + "\"");
        String result = null;
        try {
            result = alipayClient.pageExecute(alipayRequest).getBody();
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        return result;
    }


    private void setCriteria(String keys, CourseExample courseExample) {
        if (keys == null || "{}".equals(keys))
            return;
        //JSONObject jKeys = JSONObject.fromObject(keys);
        //Criteria criteria = courseExample.createCriteria();

    }

    private List<CourseVO> creatVos(List<Course> courses) throws Exception {
        List<CourseVO> courseVOs = new ArrayList<CourseVO>();
        for (Course course : courses) {
            CourseVO courseVO = new CourseVO();
            BeanUtils.copyProperties(course, courseVO);
            commonService.addBaseModel(course, courseVO);
            courseVOs.add(courseVO);
        }
        return courseVOs;
    }
}




