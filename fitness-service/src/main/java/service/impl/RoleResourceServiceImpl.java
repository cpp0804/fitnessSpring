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
import mapper.RoleResourceMapper;
import model.RoleResource;
import model.RoleResourceExample;

import pojo.vo.RoleResourceVO;
import service.RoleResourceService;

@Service
public class RoleResourceServiceImpl implements RoleResourceService {

    @Autowired
    private RoleResourceMapper roleResourceMapper;

    @Autowired
    private DataAuthorizeService dataAuthorizeService;

    private CommonService<RoleResource, RoleResourceMapper, RoleResourceExample> commonService;

    //注入commonService
    @Resource(name = "commonService")
    public void setCommonService(CommonService<RoleResource, RoleResourceMapper, RoleResourceExample> commonService) {
        this.commonService = commonService;
    }

    @Override
    public RequestResultVO insert(RoleResource roleResource) {
        if (roleResource == null) {
            throw new BizException(Public.ERROR_700);
        }
        dataAuthorizeService.addDataAuthorizeInfo(roleResource, "insert");
        roleResourceMapper.insert(roleResource);
        return ResultBuilder.buildSuccessResult(Public.SUCCESS_200, "");
    }

    @Override
    public RequestResultVO update(RoleResource roleResource) {
        if (roleResource == null || roleResource.getRoleResourceId() == null) {
            throw new BizException(Public.ERROR_700);
        }
        dataAuthorizeService.addDataAuthorizeInfo(roleResource, "update");
        roleResourceMapper.updateByPrimaryKeySelective(roleResource);
        return ResultBuilder.buildSuccessResult(Public.SUCCESS_300, "");
    }

    @Override
    public RequestResultVO delete(List<Integer> roleResourceds) {
        if (roleResourceds == null || roleResourceds.size() == 0) {
            throw new BizException(Public.ERROR_700);
        }
        RoleResourceExample roleResourceExample = new RoleResourceExample();
        roleResourceExample.createCriteria().andRoleResourceIdIn(roleResourceds);
        roleResourceMapper.deleteByExample(roleResourceExample);
        return ResultBuilder.buildSuccessResult(Public.SUCCESS_400, "");
    }

    @Override
    public Map<String, Object> getByPage(String keys, Integer pageSize,
                                         Integer pageNow) {
        RoleResourceExample roleResourceExample = new RoleResourceExample();
        this.setCriteria(keys, roleResourceExample);
        int totalrecords = (int) roleResourceMapper.countByExample(roleResourceExample);

        Page page = new Page();
        page.setBegin(pageNow);
        page.setLength(pageSize);
        roleResourceExample.setOrderByClause("roleResourced desc");
        roleResourceExample.setPage(page);
        List<RoleResource> roleResources = roleResourceMapper.selectByExample(roleResourceExample);

        Map<String, Object> map = new HashMap<String, Object>();
        JsonConfig config = new JsonConfig();
        config.setIgnoreDefaultExcludes(false);
        config.registerJsonValueProcessor(Date.class, new DateJsonValueProcessor("yyyy-MM-dd"));
        try {
            map.put("aaData", JSONArray.fromObject(this.creatVos(roleResources), config));
        } catch (Exception e) {
            LogUtil.error(ErrorLoggers.ERROR_LOGGER, e.getMessage());
            throw new BizException(Public.ERROR_100);
        }
        map.put("recordsTotal", totalrecords);
        map.put("recordsFiltered", totalrecords);

        return map;
    }

    private void setCriteria(String keys, RoleResourceExample roleResourceExample) {
        if (keys == null || "{}".equals(keys))
            return;
        //JSONObject jKeys = JSONObject.fromObject(keys);
        //Criteria criteria = roleResourceExample.createCriteria();

    }

    @Override
    public List<Integer> getResourceIdList(List<Integer> roleIds) {
        RoleResourceExample roleResourceExample = new RoleResourceExample();
        roleResourceExample.setDistinct(true);
        roleResourceExample.or().andRoleIdIn(roleIds);
        List<RoleResource> roleResources = roleResourceMapper.selectByExample(roleResourceExample);

        List<Integer> resourceIds = new ArrayList<>();
        for (RoleResource roleResource : roleResources) {
            if (!resourceIds.contains(roleResource.getResourceId())) {
                resourceIds.add(roleResource.getRoleResourceId());
            }
        }
        return resourceIds;

    }

    private List<RoleResourceVO> creatVos(List<RoleResource> roleResources) throws Exception {
        List<RoleResourceVO> roleResourceVOs = new ArrayList<RoleResourceVO>();
        for (RoleResource roleResource : roleResources) {
            RoleResourceVO roleResourceVO = new RoleResourceVO();
            BeanUtils.copyProperties(roleResource, roleResourceVO);
            commonService.addBaseModel(roleResource, roleResourceVO);
            roleResourceVOs.add(roleResourceVO);
        }
        return roleResourceVOs;
    }
}




