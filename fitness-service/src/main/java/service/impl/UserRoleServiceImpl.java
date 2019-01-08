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
import mapper.UserRoleMapper;
import model.UserRole;
import model.UserRoleExample;

import pojo.vo.UserRoleVO;
import service.UserRoleService;

@Service
public class UserRoleServiceImpl implements UserRoleService {

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Autowired
    private DataAuthorizeService dataAuthorizeService;

    private CommonService<UserRole, UserRoleMapper, UserRoleExample> commonService;

    //注入commonService
    @Resource(name = "commonService")
    public void setCommonService(CommonService<UserRole, UserRoleMapper, UserRoleExample> commonService) {
        this.commonService = commonService;
    }

    @Override
    public RequestResultVO insert(UserRole userRole) {
        if (userRole == null) {
            throw new BizException(Public.ERROR_700);
        }
        dataAuthorizeService.addDataAuthorizeInfo(userRole, "insert");
        userRoleMapper.insert(userRole);
        return ResultBuilder.buildSuccessResult(Public.SUCCESS_200, "");
    }

    @Override
    public RequestResultVO update(UserRole userRole) {
        if (userRole == null || userRole.getUserRoleId() == null) {
            throw new BizException(Public.ERROR_700);
        }
        dataAuthorizeService.addDataAuthorizeInfo(userRole, "update");
        userRoleMapper.updateByPrimaryKeySelective(userRole);
        return ResultBuilder.buildSuccessResult(Public.SUCCESS_300, "");
    }

    @Override
    public RequestResultVO delete(List<Integer> userRoleIds) {
        if (userRoleIds == null || userRoleIds.size() == 0) {
            throw new BizException(Public.ERROR_700);
        }
        UserRoleExample userRoleExample = new UserRoleExample();
        userRoleExample.createCriteria().andUserRoleIdIn(userRoleIds);
        userRoleMapper.deleteByExample(userRoleExample);
        return ResultBuilder.buildSuccessResult(Public.SUCCESS_400, "");
    }

    @Override
    public Map<String, Object> getByPage(String keys, Integer pageSize,
                                         Integer pageNow) {
        UserRoleExample userRoleExample = new UserRoleExample();
        this.setCriteria(keys, userRoleExample);
        int totalrecords = (int) userRoleMapper.countByExample(userRoleExample);

        Page page = new Page();
        page.setBegin(pageNow);
        page.setLength(pageSize);
        userRoleExample.setOrderByClause("userRoleId desc");
        userRoleExample.setPage(page);
        List<UserRole> userRoles = userRoleMapper.selectByExample(userRoleExample);

        Map<String, Object> map = new HashMap<String, Object>();
        JsonConfig config = new JsonConfig();
        config.setIgnoreDefaultExcludes(false);
        config.registerJsonValueProcessor(Date.class, new DateJsonValueProcessor("yyyy-MM-dd"));
        try {
            map.put("aaData", JSONArray.fromObject(this.creatVos(userRoles), config));
        } catch (Exception e) {
            LogUtil.error(ErrorLoggers.ERROR_LOGGER, e.getMessage());
            throw new BizException(Public.ERROR_100);
        }
        map.put("recordsTotal", totalrecords);
        map.put("recordsFiltered", totalrecords);

        return map;
    }

    private void setCriteria(String keys, UserRoleExample userRoleExample) {
        if (keys == null || "{}".equals(keys))
            return;
        //JSONObject jKeys = JSONObject.fromObject(keys);
        //Criteria criteria = userRoleExample.createCriteria();

    }


    @Override
    public List<UserRole> getUserRoleListByUser(Integer userId) {
        UserRoleExample userRoleExample = new UserRoleExample();
        userRoleExample.or().andUserIdEqualTo(userId);
        return userRoleMapper.selectByExample(userRoleExample);
    }

    private List<UserRoleVO> creatVos(List<UserRole> userRoles) throws Exception {
        List<UserRoleVO> userRoleVOs = new ArrayList<UserRoleVO>();
        for (UserRole userRole : userRoles) {
            UserRoleVO userRoleVO = new UserRoleVO();
            BeanUtils.copyProperties(userRole, userRoleVO);
            commonService.addBaseModel(userRole, userRoleVO);
            userRoleVOs.add(userRoleVO);
        }
        return userRoleVOs;
    }
}




