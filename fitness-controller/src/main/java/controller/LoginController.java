package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import model.Login;
import service.LoginService;
import common.exceptions.BizException;
import common.util.CommonUtils;
import common.util.JsonFastUtil;
import pojo.RequestResultVO;
import common.util.HttpResponseConstants.Public;

@Controller
@RequestMapping(value = "/login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    /**
     * 新增
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/insert.do")
    public @ResponseBody
    RequestResultVO insert(HttpServletRequest request) {
        String loginString = request.getParameter("login");
        Login login = null;
        try {
            login = JsonFastUtil.parseObject(loginString, Login.class);
        } catch (Exception e) {
            throw new BizException(Public.ERROR_700);
        }
        return loginService.insert(login);
    }

    /**
     * 修改
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/update.do")
    public @ResponseBody
    RequestResultVO update(HttpServletRequest request) {
        String loginString = request.getParameter("login");
        Login login = null;
        try {
            login = JsonFastUtil.parseObject(loginString, Login.class);
        } catch (Exception e) {
            throw new BizException(Public.ERROR_700);
        }
        return loginService.update(login);
    }

    /**
     * 删除
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/delete.do")
    public @ResponseBody
    RequestResultVO delete(HttpServletRequest request) {
        String loginIdsString = request.getParameter("loginIds");
        List<Integer> loginIds;
        try {
            loginIds = CommonUtils.idsArrayToList(loginIdsString);
        } catch (Exception e) {
            throw new BizException(Public.ERROR_700);
        }
        return loginService.delete(loginIds);
    }

    /**
     * 分页查询
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/getByPage.do")
    public @ResponseBody
    Object getByPage(HttpServletRequest request) {
        String keys = request.getParameter("keys");
        Integer length = Integer.parseInt(request.getParameter("length"));
        Integer start = Integer.parseInt(request.getParameter("start"));
        return loginService.getByPage(keys, length, start);
    }

    @RequestMapping(value="/login.do")
    public String login(HttpServletRequest request){
        String url=request.getHeader("Referer");
        return url;
    }
}
