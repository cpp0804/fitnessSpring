package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import model.Role;
import service.RoleService;
import common.exceptions.BizException;
import common.util.CommonUtils;
import common.util.JsonFastUtil;
import pojo.RequestResultVO;
import common.util.HttpResponseConstants.Public;

@Controller
@RequestMapping(value="/role")
public class RoleController {

	@Autowired
	private RoleService roleService;
	/**
	 * 新增
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/insert.do")
	public @ResponseBody RequestResultVO insert(HttpServletRequest request){
		String roleString = request.getParameter("role");
Role role = null;
		try{
role = JsonFastUtil.parseObject(roleString, Role.class);
		}catch(Exception e){
			throw new BizException(Public.ERROR_700);
		}
		return roleService.insert(role);
	}
	/**
	 * 修改
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/update.do")
	public @ResponseBody RequestResultVO update(HttpServletRequest request){
		String roleString = request.getParameter("role");
Role role = null;
		try{
role = JsonFastUtil.parseObject(roleString, Role.class);
		}catch(Exception e){
			throw new BizException(Public.ERROR_700);
		}
		return roleService.update(role);
	}
	/**
	 * 删除
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/delete.do")
	public @ResponseBody RequestResultVO delete(HttpServletRequest request){
		String roleIdsString = request.getParameter("roleIds");
		List<Integer> roleIds;
    try{
roleIds = CommonUtils.idsArrayToList(roleIdsString);
    }catch(Exception e){
    throw new BizException(Public.ERROR_700);
    }
    return roleService.delete(roleIds);
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
    return roleService.getByPage(keys, length, start);
    }
    }
