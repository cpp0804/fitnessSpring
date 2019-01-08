package service.impl;


import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;

import org.apache.commons.lang.StringUtils;
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
import mapper.LoginMapper;
import model.Login;
import model.LoginExample;

import pojo.vo.LoginVO;
import service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginMapper loginMapper;

    @Autowired
    private DataAuthorizeService dataAuthorizeService;

    private CommonService<Login, LoginMapper, LoginExample> commonService;

    //注入commonService
    @Resource(name = "commonService")
    public void setCommonService(CommonService<Login, LoginMapper, LoginExample> commonService) {
        this.commonService = commonService;
    }

    @Override
    public RequestResultVO insert(Login login) {
        if (login == null) {
            throw new BizException(Public.ERROR_700);
        }
        dataAuthorizeService.addDataAuthorizeInfo(login, "insert");
        loginMapper.insert(login);
        return ResultBuilder.buildSuccessResult(Public.SUCCESS_200, "");
    }

    @Override
    public RequestResultVO update(Login login) {
        if (login == null || login.getLoginId() == null) {
            throw new BizException(Public.ERROR_700);
        }
        dataAuthorizeService.addDataAuthorizeInfo(login, "update");
        loginMapper.updateByPrimaryKeySelective(login);
        return ResultBuilder.buildSuccessResult(Public.SUCCESS_300, "");
    }

    @Override
    public RequestResultVO delete(List<Integer> loginIds) {
        if (loginIds == null || loginIds.size() == 0) {
            throw new BizException(Public.ERROR_700);
        }
        LoginExample loginExample = new LoginExample();
        loginExample.createCriteria().andLoginIdIn(loginIds);
        loginMapper.deleteByExample(loginExample);
        return ResultBuilder.buildSuccessResult(Public.SUCCESS_400, "");
    }

    @Override
    public Map<String, Object> getByPage(String keys, Integer pageSize,
                                         Integer pageNow) {
        LoginExample loginExample = new LoginExample();
        this.setCriteria(keys, loginExample);
        int totalrecords = (int) loginMapper.countByExample(loginExample);

        Page page = new Page();
        page.setBegin(pageNow);
        page.setLength(pageSize);
        loginExample.setOrderByClause("loginId desc");
        loginExample.setPage(page);
        List<Login> logins = loginMapper.selectByExample(loginExample);

        Map<String, Object> map = new HashMap<String, Object>();
        JsonConfig config = new JsonConfig();
        config.setIgnoreDefaultExcludes(false);
        config.registerJsonValueProcessor(Date.class, new DateJsonValueProcessor("yyyy-MM-dd"));
        try {
            map.put("aaData", JSONArray.fromObject(this.creatVos(logins), config));
        } catch (Exception e) {
            LogUtil.error(ErrorLoggers.ERROR_LOGGER, e.getMessage());
            throw new BizException(Public.ERROR_100);
        }
        map.put("recordsTotal", totalrecords);
        map.put("recordsFiltered", totalrecords);

        return map;
    }

    @Override
    public Login getLoginByLoginName(String loginName) {

        if (StringUtils.isEmpty(loginName)) {
            return null;
        }
        LoginExample loginExample = new LoginExample();
        LoginExample.Criteria criteria = loginExample.createCriteria();
        criteria.andLoginNameEqualTo(loginName);
        List<Login> logins = loginMapper.selectByExample(loginExample);

        if (logins.size() > 0) {
            return logins.get(0);
        }
        return null;
    }

    private void setCriteria(String keys, LoginExample loginExample) {
        if (keys == null || "{}".equals(keys))
            return;
        //JSONObject jKeys = JSONObject.fromObject(keys);
        //Criteria criteria = loginExample.createCriteria();

    }

    private List<LoginVO> creatVos(List<Login> logins) throws Exception {
        List<LoginVO> loginVOs = new ArrayList<LoginVO>();
        for (Login login : logins) {
            LoginVO loginVO = new LoginVO();
            BeanUtils.copyProperties(login, loginVO);
            commonService.addBaseModel(login, loginVO);
            loginVOs.add(loginVO);
        }
        return loginVOs;
    }
}




