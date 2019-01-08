package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import model.RoleResource;
import service.RoleResourceService;
import common.exceptions.BizException;
import common.util.CommonUtils;
import common.util.JsonFastUtil;
import pojo.RequestResultVO;
import common.util.HttpResponseConstants.Public;

@Controller
@RequestMapping(value="/roleResource")
public class RoleResourceController {

	@Autowired
	private RoleResourceService roleResourceService;
	/**
	 * 新增
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/insert.do")
	public @ResponseBody RequestResultVO insert(HttpServletRequest request){
		String roleResourceString = request.getParameter("roleResource");
RoleResource roleResource = null;
		try{
roleResource = JsonFastUtil.parseObject(roleResourceString, RoleResource.class);
		}catch(Exception e){
			throw new BizException(Public.ERROR_700);
		}
		return roleResourceService.insert(roleResource);
	}
	/**
	 * 修改
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/update.do")
	public @ResponseBody RequestResultVO update(HttpServletRequest request){
		String roleResourceString = request.getParameter("roleResource");
RoleResource roleResource = null;
		try{
roleResource = JsonFastUtil.parseObject(roleResourceString, RoleResource.class);
		}catch(Exception e){
			throw new BizException(Public.ERROR_700);
		}
		return roleResourceService.update(roleResource);
	}
	/**
	 * 删除
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/delete.do")
	public @ResponseBody RequestResultVO delete(HttpServletRequest request){
		String roleResourcedsString = request.getParameter("roleResourceds");
		List<Integer> roleResourceds;
    try{
roleResourceds = CommonUtils.idsArrayToList(roleResourcedsString);
    }catch(Exception e){
    throw new BizException(Public.ERROR_700);
    }
    return roleResourceService.delete(roleResourceds);
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
    return roleResourceService.getByPage(keys, length, start);
    }
    }
