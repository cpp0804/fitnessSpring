package service.impl;


import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import common.log.ErrorLoggers;
import common.log.LogUtil;
import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import common.exceptions.BizException;;
import page.Page;
import common.util.DateJsonValueProcessor;
import common.util.HttpResponseConstants.Public;
import pojo.RequestResultVO;

import service.commonService.DataAuthorizeService;
import service.commonService.util.ResultBuilder;
import service.commonService.CommonService;
import mapper.BasicDataSetMapper;
import model.BasicDataSet;
import model.BasicDataSetExample;

import pojo.vo.BasicDataSetVO;
import service.BasicDataSetService;

@Service
public class BasicDataSetServiceImpl implements BasicDataSetService {

    @Autowired
    private BasicDataSetMapper basicDataSetMapper;

    @Autowired
    private DataAuthorizeService dataAuthorizeService;

    private CommonService<BasicDataSet, BasicDataSetMapper, BasicDataSetExample> commonService;

    //注入commonService
    @Resource(name = "commonService")
    public void setCommonService(CommonService<BasicDataSet, BasicDataSetMapper, BasicDataSetExample> commonService) {
        this.commonService = commonService;
    }

    @Override
    public RequestResultVO insert(BasicDataSet basicDataSet) {
        if (basicDataSet == null) {
            throw new BizException(Public.ERROR_700);
        }
        dataAuthorizeService.addDataAuthorizeInfo(basicDataSet, "insert");
        basicDataSetMapper.insert(basicDataSet);
        return ResultBuilder.buildSuccessResult(Public.SUCCESS_200, "");
    }

    @Override
    public RequestResultVO update(BasicDataSet basicDataSet) {
        if (basicDataSet == null || basicDataSet.getBasicDataSetId() == null) {
            throw new BizException(Public.ERROR_700);
        }
        dataAuthorizeService.addDataAuthorizeInfo(basicDataSet, "update");
        basicDataSetMapper.updateByPrimaryKeySelective(basicDataSet);
        return ResultBuilder.buildSuccessResult(Public.SUCCESS_300, "");
    }

    @Override
    public RequestResultVO delete(List<Integer> basicDataSetIds) {
        if (basicDataSetIds == null || basicDataSetIds.size() == 0) {
            throw new BizException(Public.ERROR_700);
        }
        BasicDataSetExample basicDataSetExample = new BasicDataSetExample();
        basicDataSetExample.createCriteria().andBasicDataSetIdIn(basicDataSetIds);
        basicDataSetMapper.deleteByExample(basicDataSetExample);
        return ResultBuilder.buildSuccessResult(Public.SUCCESS_400, "");
    }

    @Override
    public Map<String, Object> getByPage(String keys, Integer pageSize,
                                         Integer pageNow) {
        BasicDataSetExample basicDataSetExample = new BasicDataSetExample();
        this.setCriteria(keys, basicDataSetExample);
        int totalrecords = (int) basicDataSetMapper.countByExample(basicDataSetExample);

        Page page = new Page();
        page.setBegin(pageNow);
        page.setLength(pageSize);
        basicDataSetExample.setOrderByClause("basicDataSetId desc");
        basicDataSetExample.setPage(page);
        List<BasicDataSet> basicDataSets = basicDataSetMapper.selectByExample(basicDataSetExample);

        Map<String, Object> map = new HashMap<String, Object>();
        JsonConfig config = new JsonConfig();
        config.setIgnoreDefaultExcludes(false);
        config.registerJsonValueProcessor(Date.class, new DateJsonValueProcessor("yyyy-MM-dd"));
        try {
            map.put("aaData", JSONArray.fromObject(this.creatVos(basicDataSets), config));
        } catch (Exception e) {
            LogUtil.error(ErrorLoggers.ERROR_LOGGER, e.getMessage());
            throw new BizException(Public.ERROR_100);
        }
        map.put("recordsTotal", totalrecords);
        map.put("recordsFiltered", totalrecords);

        return map;
    }

    private void setCriteria(String keys, BasicDataSetExample basicDataSetExample) {
        if (keys == null || "{}".equals(keys))
            return;
        //JSONObject jKeys = JSONObject.fromObject(keys);
        //Criteria criteria = basicDataSetExample.createCriteria();

    }

    private List<BasicDataSetVO> creatVos(List<BasicDataSet> basicDataSets) throws Exception {
        List<BasicDataSetVO> basicDataSetVOs = new ArrayList<BasicDataSetVO>();
        for (BasicDataSet basicDataSet : basicDataSets) {
            BasicDataSetVO basicDataSetVO = new BasicDataSetVO();
            BeanUtils.copyProperties(basicDataSet, basicDataSetVO);
            commonService.addBaseModel(basicDataSet, basicDataSetVO);
            basicDataSetVOs.add(basicDataSetVO);
        }
        return basicDataSetVOs;
    }
}




