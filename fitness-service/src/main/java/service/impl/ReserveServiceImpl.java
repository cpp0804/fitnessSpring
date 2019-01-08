package service.impl;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import mapper.CourseInstanceMapper;
import mapper.CourseMapper;
import mapper.UserMapper;
import model.CourseInstance;
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
import mapper.ReserveMapper;
import model.Reserve;
import model.ReserveExample;

import pojo.vo.ReserveVO;
import service.ReserveService;

@Service
public class ReserveServiceImpl implements ReserveService {

    @Autowired
    private ReserveMapper reserveMapper;

    @Autowired
    private DataAuthorizeService dataAuthorizeService;

    @Autowired
    private UserService userService;

    @Autowired
    private CourseInstanceMapper courseInstanceMapper;

    @Autowired
    private UserCourseService userCourseService;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private CourseMapper courseMapper;

    private CommonService<Reserve, ReserveMapper, ReserveExample> commonService;

    //注入commonService
    @Resource(name = "commonService")
    public void setCommonService(CommonService<Reserve, ReserveMapper, ReserveExample> commonService) {
        this.commonService = commonService;
    }

    @Override
    public RequestResultVO insert(Reserve reserve) {
        if (reserve == null) {
            throw new BizException(Public.ERROR_700);
        }
        dataAuthorizeService.addDataAuthorizeInfo(reserve, "insert");
        reserveMapper.insert(reserve);
        return ResultBuilder.buildSuccessResult(Public.SUCCESS_200, "");
    }

    @Override
    public RequestResultVO update(Reserve reserve) {
        if (reserve == null || reserve.getReserveId() == null) {
            throw new BizException(Public.ERROR_700);
        }
        dataAuthorizeService.addDataAuthorizeInfo(reserve, "update");
        reserveMapper.updateByPrimaryKeySelective(reserve);
        return ResultBuilder.buildSuccessResult(Public.SUCCESS_300, "");
    }

    @Override
    public RequestResultVO delete(List<Integer> reserveIds) {
        if (reserveIds == null || reserveIds.size() == 0) {
            throw new BizException(Public.ERROR_700);
        }
        ReserveExample reserveExample = new ReserveExample();
        reserveExample.createCriteria().andReserveIdIn(reserveIds);
        reserveMapper.deleteByExample(reserveExample);
        return ResultBuilder.buildSuccessResult(Public.SUCCESS_400, "");
    }

    @Override
    public Map<String, Object> getByPage(String keys, Integer pageSize,
                                         Integer pageNow) {
        ReserveExample reserveExample = new ReserveExample();
        this.setCriteria(keys, reserveExample);
        int totalrecords = (int) reserveMapper.countByExample(reserveExample);

        Page page = new Page();
        page.setBegin(pageNow);
        page.setLength(pageSize);
        reserveExample.setOrderByClause("reserve_id desc");
        reserveExample.setPage(page);
        List<Reserve> reserves = reserveMapper.selectByExample(reserveExample);

        Map<String, Object> map = new HashMap<String, Object>();
        JsonConfig config = new JsonConfig();
        config.setIgnoreDefaultExcludes(false);
        config.registerJsonValueProcessor(Date.class, new DateJsonValueProcessor("yyyy-MM-dd"));
        try {
            map.put("aaData", JSONArray.fromObject(this.creatVos(reserves), config));
        } catch (Exception e) {
            LogUtil.error(ErrorLoggers.ERROR_LOGGER, e.getMessage());
            throw new BizException(Public.ERROR_100);
        }
        map.put("recordsTotal", totalrecords);
        map.put("recordsFiltered", totalrecords);

        return map;
    }

    @Override
    public RequestResultVO reserve(Integer courseInstanceId) {
        if (courseInstanceId == null) {
            throw new BizException(Public.ERROR_700);
        }
        Reserve reserve = new Reserve();
        reserve.setCourseInstanceId(courseInstanceId);
        reserve.setUserId(userService.getSessionUser().getUserId());
        reserve.setStatus("待开始");
        dataAuthorizeService.addDataAuthorizeInfo(reserve, "insert");
        reserveMapper.insert(reserve);
        CourseInstance courseInstance = courseInstanceMapper.selectByPrimaryKey(courseInstanceId);
        courseInstance.setRemainingReserve(courseInstance.getRemainingReserve() - 1);
        courseInstanceMapper.updateByPrimaryKey(courseInstance);
        UserCourse userCourse = userCourseService.findByCourseAndUserNotFinished(courseInstance.getCourseId(), userService.getSessionUser().getUserId());
        userCourse.setRemainingNum(userCourse.getRemainingNum() - 1);
        userCourseService.update(userCourse);
        return ResultBuilder.buildSuccessResult(Public.RESERVE_COURSE_SUCCESS, "");
    }

    @Override
    public Map<String, Object> getReserveNotStarted() {
        ReserveExample reserveExample = new ReserveExample();
        ReserveExample.Criteria criteria = reserveExample.createCriteria();
        criteria.andStatusEqualTo("待开始");
        criteria.andUserIdEqualTo(userService.getSessionUser().getUserId());
        reserveExample.setOrderByClause("reserve_id desc");
        List<Reserve> reserves = reserveMapper.selectByExample(reserveExample);

        Map<String, Object> map = new HashMap<String, Object>();
        JsonConfig config = new JsonConfig();
        config.setIgnoreDefaultExcludes(false);
        config.registerJsonValueProcessor(Date.class, new DateJsonValueProcessor("yyyy-MM-dd"));
        try {
            map.put("aaData", JSONArray.fromObject(this.creatVos(reserves), config));
        } catch (Exception e) {
            LogUtil.error(ErrorLoggers.ERROR_LOGGER, e.getMessage());
            throw new BizException(Public.ERROR_100);
        }
        return map;
    }

    private void setCriteria(String keys, ReserveExample reserveExample) {
        if (keys == null || "{}".equals(keys))
            return;
        //JSONObject jKeys = JSONObject.fromObject(keys);
        //Criteria criteria = reserveExample.createCriteria();

    }

    private List<ReserveVO> creatVos(List<Reserve> reserves) throws Exception {
        List<ReserveVO> reserveVOs = new ArrayList<ReserveVO>();
        for (Reserve reserve : reserves) {
            ReserveVO reserveVO = new ReserveVO();
            BeanUtils.copyProperties(reserve, reserveVO);
            reserveVO.setCoachName(userMapper.selectByPrimaryKey(reserve.getUserId()).getName());
            CourseInstance courseInstance = courseInstanceMapper.selectByPrimaryKey(reserve.getCourseInstanceId());
            reserveVO.setCourseName(courseMapper.selectByPrimaryKey(courseInstance.getCourseId()).getName());
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");

            reserveVO.setCourseTime(simpleDateFormat.format(courseInstance.getCourseTime()));
            commonService.addBaseModel(reserve, reserveVO);
            reserveVOs.add(reserveVO);
        }
        return reserveVOs;
    }
}




