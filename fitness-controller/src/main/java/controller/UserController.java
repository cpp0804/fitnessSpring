package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import model.User;
import service.UserService;
import common.exceptions.BizException;
import common.util.CommonUtils;
import common.util.JsonFastUtil;
import pojo.RequestResultVO;
import common.util.HttpResponseConstants.Public;

@Controller
@RequestMapping(value="/user")
public class UserController {

	@Autowired
	private UserService userService;
	/**
	 * 新增
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/insert.do")
	public @ResponseBody RequestResultVO insert(HttpServletRequest request){
		String userString = request.getParameter("user");
User user = null;
		try{
user = JsonFastUtil.parseObject(userString, User.class);
		}catch(Exception e){
			throw new BizException(Public.ERROR_700);
		}
		return userService.insert(user);
	}
	/**
	 * 修改
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/update.do")
	public @ResponseBody RequestResultVO update(HttpServletRequest request){
		String userString = request.getParameter("user");
User user = null;
		try{
user = JsonFastUtil.parseObject(userString, User.class);
		}catch(Exception e){
			throw new BizException(Public.ERROR_700);
		}
		return userService.update(user);
	}
	/**
	 * 删除
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/delete.do")
	public @ResponseBody RequestResultVO delete(HttpServletRequest request){
		String userIdsString = request.getParameter("userIds");
		List<Integer> userIds;
    try{
userIds = CommonUtils.idsArrayToList(userIdsString);
    }catch(Exception e){
    throw new BizException(Public.ERROR_700);
    }
    return userService.delete(userIds);
    }
    /**
    * 分页查询
    * @param request
    * @return
    */
    @RequestMapping(value="/getByPage.do")
    public @ResponseBody Object getByPage(HttpServletRequest request){
    String keys = request.getParameter("keys");
    Integer length = Integer.parseInt(request.getParameter("length"));
    Integer start = Integer.parseInt(request.getParameter("start"));
    return userService.getByPage(keys, length, start);
    }
    }
