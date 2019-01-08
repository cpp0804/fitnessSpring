package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import model.UserRole;
import service.UserRoleService;
import common.exceptions.BizException;
import common.util.CommonUtils;
import common.util.JsonFastUtil;
import pojo.RequestResultVO;
import common.util.HttpResponseConstants.Public;

@Controller
@RequestMapping(value="/userRole")
public class UserRoleController {

	@Autowired
	private UserRoleService userRoleService;
	/**
	 * 新增
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/insert.do")
	public @ResponseBody RequestResultVO insert(HttpServletRequest request){
		String userRoleString = request.getParameter("userRole");
UserRole userRole = null;
		try{
userRole = JsonFastUtil.parseObject(userRoleString, UserRole.class);
		}catch(Exception e){
			throw new BizException(Public.ERROR_700);
		}
		return userRoleService.insert(userRole);
	}
	/**
	 * 修改
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/update.do")
	public @ResponseBody RequestResultVO update(HttpServletRequest request){
		String userRoleString = request.getParameter("userRole");
UserRole userRole = null;
		try{
userRole = JsonFastUtil.parseObject(userRoleString, UserRole.class);
		}catch(Exception e){
			throw new BizException(Public.ERROR_700);
		}
		return userRoleService.update(userRole);
	}
	/**
	 * 删除
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/delete.do")
	public @ResponseBody RequestResultVO delete(HttpServletRequest request){
		String userRoleIdsString = request.getParameter("userRoleIds");
		List<Integer> userRoleIds;
    try{
userRoleIds = CommonUtils.idsArrayToList(userRoleIdsString);
    }catch(Exception e){
    throw new BizException(Public.ERROR_700);
    }
    return userRoleService.delete(userRoleIds);
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
    return userRoleService.getByPage(keys, length, start);
    }
    }
