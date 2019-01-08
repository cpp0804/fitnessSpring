package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import model.Resource;
import service.ResourceService;
import common.exceptions.BizException;
import common.util.CommonUtils;
import common.util.JsonFastUtil;
import pojo.RequestResultVO;
import common.util.HttpResponseConstants.Public;

@Controller
@RequestMapping(value="/resource")
public class ResourceController {

	@Autowired
	private ResourceService resourceService;
	/**
	 * 新增
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/insert.do")
	public @ResponseBody RequestResultVO insert(HttpServletRequest request){
		String resourceString = request.getParameter("resource");
Resource resource = null;
		try{
resource = JsonFastUtil.parseObject(resourceString, Resource.class);
		}catch(Exception e){
			throw new BizException(Public.ERROR_700);
		}
		return resourceService.insert(resource);
	}
	/**
	 * 修改
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/update.do")
	public @ResponseBody RequestResultVO update(HttpServletRequest request){
		String resourceString = request.getParameter("resource");
Resource resource = null;
		try{
resource = JsonFastUtil.parseObject(resourceString, Resource.class);
		}catch(Exception e){
			throw new BizException(Public.ERROR_700);
		}
		return resourceService.update(resource);
	}
	/**
	 * 删除
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/delete.do")
	public @ResponseBody RequestResultVO delete(HttpServletRequest request){
		String resourceIdsString = request.getParameter("resourceIds");
		List<Integer> resourceIds;
    try{
resourceIds = CommonUtils.idsArrayToList(resourceIdsString);
    }catch(Exception e){
    throw new BizException(Public.ERROR_700);
    }
    return resourceService.delete(resourceIds);
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
    return resourceService.getByPage(keys, length, start);
    }
    }
