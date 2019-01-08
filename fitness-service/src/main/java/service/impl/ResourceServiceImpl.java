package service.impl;


import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import service.commonService.util.SysConst;
import service.commonService.util.SysResourceTree;
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
import mapper.ResourceMapper;
import model.ResourceExample;

import pojo.vo.ResourceVO;
import service.ResourceService;

@Service
public class ResourceServiceImpl implements ResourceService {

    @Autowired
    private ResourceMapper resourceMapper;

    @Autowired
    private DataAuthorizeService dataAuthorizeService;

    private CommonService<model.Resource, ResourceMapper, ResourceExample> commonService;

    //注入commonService
    @Resource(name = "commonService")
    public void setCommonService(CommonService<model.Resource, ResourceMapper, ResourceExample> commonService) {
        this.commonService = commonService;
    }

    @Override
    public RequestResultVO insert(model.Resource resource) {
        if (resource == null) {
            throw new BizException(Public.ERROR_700);
        }
        dataAuthorizeService.addDataAuthorizeInfo(resource, "insert");
        resourceMapper.insert(resource);
        return ResultBuilder.buildSuccessResult(Public.SUCCESS_200, "");
    }

    @Override
    public RequestResultVO update(model.Resource resource) {
        if (resource == null || resource.getResourceId() == null) {
            throw new BizException(Public.ERROR_700);
        }
        dataAuthorizeService.addDataAuthorizeInfo(resource, "update");
        resourceMapper.updateByPrimaryKeySelective(resource);
        return ResultBuilder.buildSuccessResult(Public.SUCCESS_300, "");
    }

    @Override
    public RequestResultVO delete(List<Integer> resourceIds) {
        if (resourceIds == null || resourceIds.size() == 0) {
            throw new BizException(Public.ERROR_700);
        }
        ResourceExample resourceExample = new ResourceExample();
        resourceExample.createCriteria().andResourceIdIn(resourceIds);
        resourceMapper.deleteByExample(resourceExample);
        return ResultBuilder.buildSuccessResult(Public.SUCCESS_400, "");
    }

    @Override
    public Map<String, Object> getByPage(String keys, Integer pageSize,
                                         Integer pageNow) {
        ResourceExample resourceExample = new ResourceExample();
        this.setCriteria(keys, resourceExample);
        int totalrecords = (int) resourceMapper.countByExample(resourceExample);

        Page page = new Page();
        page.setBegin(pageNow);
        page.setLength(pageSize);
        resourceExample.setOrderByClause("resourceId desc");
        resourceExample.setPage(page);
        List<model.Resource> resources = resourceMapper.selectByExample(resourceExample);

        Map<String, Object> map = new HashMap<String, Object>();
        JsonConfig config = new JsonConfig();
        config.setIgnoreDefaultExcludes(false);
        config.registerJsonValueProcessor(Date.class, new DateJsonValueProcessor("yyyy-MM-dd"));
        try {
            map.put("aaData", JSONArray.fromObject(this.creatVos(resources), config));
        } catch (Exception e) {
            LogUtil.error(ErrorLoggers.ERROR_LOGGER, e.getMessage());
            throw new BizException(Public.ERROR_100);
        }
        map.put("recordsTotal", totalrecords);
        map.put("recordsFiltered", totalrecords);

        return map;
    }

    @Override
    public void init_RESOURCESTREE() {
        ResourceExample resourceExample=new ResourceExample();
        resourceExample.setOrderByClause("resource_id asc");
        List<model.Resource>resources=resourceMapper.selectByExample(resourceExample);
        SysConst.RESOURCESTREE=new SysResourceTree(resources);

    }


    private void setCriteria(String keys, ResourceExample resourceExample) {
        if (keys == null || "{}".equals(keys))
            return;
        //JSONObject jKeys = JSONObject.fromObject(keys);
        //Criteria criteria = resourceExample.createCriteria();

    }

    private List<ResourceVO> creatVos(List<model.Resource> resources) throws Exception {
        List<ResourceVO> resourceVOs = new ArrayList<ResourceVO>();
        for (model.Resource resource : resources) {
            ResourceVO resourceVO = new ResourceVO();
            BeanUtils.copyProperties(resource, resourceVO);
            commonService.addBaseModel(resource, resourceVO);
            resourceVOs.add(resourceVO);
        }
        return resourceVOs;
    }
}




