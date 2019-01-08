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
import mapper.RoleMapper;
import model.Role;
import model.RoleExample;

import pojo.vo.RoleVO;
import service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private DataAuthorizeService dataAuthorizeService;

    private CommonService<Role, RoleMapper, RoleExample> commonService;

    //注入commonService
    @Resource(name = "commonService")
    public void setCommonService(CommonService<Role, RoleMapper, RoleExample> commonService) {
        this.commonService = commonService;
    }

    @Override
    public RequestResultVO insert(Role role) {
        if (role == null) {
            throw new BizException(Public.ERROR_700);
        }
        dataAuthorizeService.addDataAuthorizeInfo(role, "insert");
        roleMapper.insert(role);
        return ResultBuilder.buildSuccessResult(Public.SUCCESS_200, "");
    }

    @Override
    public RequestResultVO update(Role role) {
        if (role == null || role.getRoleId() == null) {
            throw new BizException(Public.ERROR_700);
        }
        dataAuthorizeService.addDataAuthorizeInfo(role, "update");
        roleMapper.updateByPrimaryKeySelective(role);
        return ResultBuilder.buildSuccessResult(Public.SUCCESS_300, "");
    }

    @Override
    public RequestResultVO delete(List<Integer> roleIds) {
        if (roleIds == null || roleIds.size() == 0) {
            throw new BizException(Public.ERROR_700);
        }
        RoleExample roleExample = new RoleExample();
        roleExample.createCriteria().andRoleIdIn(roleIds);
        roleMapper.deleteByExample(roleExample);
        return ResultBuilder.buildSuccessResult(Public.SUCCESS_400, "");
    }

    @Override
    public Map<String, Object> getByPage(String keys, Integer pageSize,
                                         Integer pageNow) {
        RoleExample roleExample = new RoleExample();
        this.setCriteria(keys, roleExample);
        int totalrecords = (int) roleMapper.countByExample(roleExample);

        Page page = new Page();
        page.setBegin(pageNow);
        page.setLength(pageSize);
        roleExample.setOrderByClause("roleId desc");
        roleExample.setPage(page);
        List<Role> roles = roleMapper.selectByExample(roleExample);

        Map<String, Object> map = new HashMap<String, Object>();
        JsonConfig config = new JsonConfig();
        config.setIgnoreDefaultExcludes(false);
        config.registerJsonValueProcessor(Date.class, new DateJsonValueProcessor("yyyy-MM-dd"));
        try {
            map.put("aaData", JSONArray.fromObject(this.creatVos(roles), config));
        } catch (Exception e) {
            LogUtil.error(ErrorLoggers.ERROR_LOGGER, e.getMessage());
            throw new BizException(Public.ERROR_100);
        }
        map.put("recordsTotal", totalrecords);
        map.put("recordsFiltered", totalrecords);

        return map;
    }

    private void setCriteria(String keys, RoleExample roleExample) {
        if (keys == null || "{}".equals(keys))
            return;
        //JSONObject jKeys = JSONObject.fromObject(keys);
        //Criteria criteria = roleExample.createCriteria();

    }

    private List<RoleVO> creatVos(List<Role> roles) throws Exception {
        List<RoleVO> roleVOs = new ArrayList<RoleVO>();
        for (Role role : roles) {
            RoleVO roleVO = new RoleVO();
            BeanUtils.copyProperties(role, roleVO);
            commonService.addBaseModel(role, roleVO);
            roleVOs.add(roleVO);
        }
        return roleVOs;
    }
}




