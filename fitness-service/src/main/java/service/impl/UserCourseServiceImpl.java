package service.impl;


import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

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
import service.commonService.DataAuthorizeService;
import service.commonService.util.ResultBuilder;
import service.commonService.CommonService;
import mapper.UserCourseMapper;
import model.UserCourse;
import model.UserCourseExample;

import pojo.vo.UserCourseVO;
import service.UserCourseService;

@Service
public class UserCourseServiceImpl implements UserCourseService {

    @Autowired
    private UserCourseMapper userCourseMapper;

    @Autowired
    private DataAuthorizeService dataAuthorizeService;

    private CommonService<UserCourse, UserCourseMapper, UserCourseExample> commonService;

    //注入commonService
    @Resource(name = "commonService")
    public void setCommonService(CommonService<UserCourse, UserCourseMapper, UserCourseExample> commonService) {
        this.commonService = commonService;
    }

    @Override
    public RequestResultVO insert(UserCourse userCourse) {
        if (userCourse == null) {
            throw new BizException(Public.ERROR_700);
        }
        dataAuthorizeService.addDataAuthorizeInfo(userCourse, "insert");
        userCourseMapper.insert(userCourse);
        return ResultBuilder.buildSuccessResult(Public.SUCCESS_200, "");
    }

    @Override
    public RequestResultVO update(UserCourse userCourse) {
        if (userCourse == null || userCourse.getUserCourseId() == null) {
            throw new BizException(Public.ERROR_700);
        }
        dataAuthorizeService.addDataAuthorizeInfo(userCourse, "update");
        userCourseMapper.updateByPrimaryKeySelective(userCourse);
        return ResultBuilder.buildSuccessResult(Public.SUCCESS_300, "");
    }

    @Override
    public RequestResultVO delete(List<Integer> userCourseIds) {
        if (userCourseIds == null || userCourseIds.size() == 0) {
            throw new BizException(Public.ERROR_700);
        }
        UserCourseExample userCourseExample = new UserCourseExample();
        userCourseExample.createCriteria().andUserCourseIdIn(userCourseIds);
        userCourseMapper.deleteByExample(userCourseExample);
        return ResultBuilder.buildSuccessResult(Public.SUCCESS_400, "");
    }

    @Override
    public Map<String, Object> getByPage(String keys, Integer pageSize,
                                         Integer pageNow) {
        UserCourseExample userCourseExample = new UserCourseExample();
        this.setCriteria(keys, userCourseExample);
        int totalrecords = (int) userCourseMapper.countByExample(userCourseExample);

        Page page = new Page();
        page.setBegin(pageNow);
        page.setLength(pageSize);
        userCourseExample.setOrderByClause("userCourseId desc");
        userCourseExample.setPage(page);
        List<UserCourse> userCourses = userCourseMapper.selectByExample(userCourseExample);

        Map<String, Object> map = new HashMap<String, Object>();
        JsonConfig config = new JsonConfig();
        config.setIgnoreDefaultExcludes(false);
        config.registerJsonValueProcessor(Date.class, new DateJsonValueProcessor("yyyy-MM-dd"));
        try {
            map.put("aaData", JSONArray.fromObject(this.creatVos(userCourses), config));
        } catch (Exception e) {
            LogUtil.error(ErrorLoggers.ERROR_LOGGER, e.getMessage());
            throw new BizException(Public.ERROR_100);
        }
        map.put("recordsTotal", totalrecords);
        map.put("recordsFiltered", totalrecords);

        return map;
    }

    private void setCriteria(String keys, UserCourseExample userCourseExample) {
        if (keys == null || "{}".equals(keys))
            return;
        //JSONObject jKeys = JSONObject.fromObject(keys);
        //Criteria criteria = userCourseExample.createCriteria();

    }

    private List<UserCourseVO> creatVos(List<UserCourse> userCourses) throws Exception {
        List<UserCourseVO> userCourseVOs = new ArrayList<UserCourseVO>();
        for (UserCourse userCourse : userCourses) {
            UserCourseVO userCourseVO = new UserCourseVO();
            BeanUtils.copyProperties(userCourse, userCourseVO);
            commonService.addBaseModel(userCourse, userCourseVO);
            userCourseVOs.add(userCourseVO);
        }
        return userCourseVOs;
    }
}



