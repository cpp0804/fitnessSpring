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
import mapper.UserMapper;
import model.User;
import model.UserExample;

import pojo.vo.UserVO;
import service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private DataAuthorizeService dataAuthorizeService;

    private CommonService<User, UserMapper, UserExample> commonService;

    //注入commonService
    @Resource(name = "commonService")
    public void setCommonService(CommonService<User, UserMapper, UserExample> commonService) {
        this.commonService = commonService;
    }

    @Override
    public RequestResultVO insert(User user) {
        if (user == null) {
            throw new BizException(Public.ERROR_700);
        }
        dataAuthorizeService.addDataAuthorizeInfo(user, "insert");
        userMapper.insert(user);
        return ResultBuilder.buildSuccessResult(Public.SUCCESS_200, "");
    }

    @Override
    public RequestResultVO update(User user) {
        if (user == null || user.getUserId() == null) {
            throw new BizException(Public.ERROR_700);
        }
        dataAuthorizeService.addDataAuthorizeInfo(user, "update");
        userMapper.updateByPrimaryKeySelective(user);
        return ResultBuilder.buildSuccessResult(Public.SUCCESS_300, "");
    }

    @Override
    public RequestResultVO delete(List<Integer> userIds) {
        if (userIds == null || userIds.size() == 0) {
            throw new BizException(Public.ERROR_700);
        }
        UserExample userExample = new UserExample();
        userExample.createCriteria().andUserIdIn(userIds);
        userMapper.deleteByExample(userExample);
        return ResultBuilder.buildSuccessResult(Public.SUCCESS_400, "");
    }

    @Override
    public Map<String, Object> getByPage(String keys, Integer pageSize,
                                         Integer pageNow) {
        UserExample userExample = new UserExample();
        this.setCriteria(keys, userExample);
        int totalrecords = (int) userMapper.countByExample(userExample);

        Page page = new Page();
        page.setBegin(pageNow);
        page.setLength(pageSize);
        userExample.setOrderByClause("userId desc");
        userExample.setPage(page);
        List<User> users = userMapper.selectByExample(userExample);

        Map<String, Object> map = new HashMap<String, Object>();
        JsonConfig config = new JsonConfig();
        config.setIgnoreDefaultExcludes(false);
        config.registerJsonValueProcessor(Date.class, new DateJsonValueProcessor("yyyy-MM-dd"));
        try {
            map.put("aaData", JSONArray.fromObject(this.creatVos(users), config));
        } catch (Exception e) {
            LogUtil.error(ErrorLoggers.ERROR_LOGGER, e.getMessage());
            throw new BizException(Public.ERROR_100);
        }
        map.put("recordsTotal", totalrecords);
        map.put("recordsFiltered", totalrecords);

        return map;
    }

    @Override
    public User getUserById(Integer userId) {
        return userMapper.selectByPrimaryKey(userId);
    }

    private void setCriteria(String keys, UserExample userExample) {
        if (keys == null || "{}".equals(keys))
            return;
        //JSONObject jKeys = JSONObject.fromObject(keys);
        //Criteria criteria = userExample.createCriteria();

    }

    private List<UserVO> creatVos(List<User> users) throws Exception {
        List<UserVO> userVOs = new ArrayList<UserVO>();
        for (User user : users) {
            UserVO userVO = new UserVO();
            BeanUtils.copyProperties(user, userVO);
            commonService.addBaseModel(user, userVO);
            userVOs.add(userVO);
        }
        return userVOs;
    }
}




