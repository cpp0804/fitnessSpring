package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import model.UserCourse;
import service.UserCourseService;
import common.exceptions.BizException;
import common.util.CommonUtils;
import common.util.JsonFastUtil;
import pojo.RequestResultVO;
import common.util.HttpResponseConstants.Public;

@Controller
@RequestMapping(value="/userCourse")
public class UserCourseController {

	@Autowired
	private UserCourseService userCourseService;
	/**
	 * 新增
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/insert.do")
	public @ResponseBody RequestResultVO insert(HttpServletRequest request){
		String userCourseString = request.getParameter("userCourse");
UserCourse userCourse = null;
		try{
userCourse = JsonFastUtil.parseObject(userCourseString, UserCourse.class);
		}catch(Exception e){
			throw new BizException(Public.ERROR_700);
		}
		return userCourseService.insert(userCourse);
	}
	/**
	 * 修改
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/update.do")
	public @ResponseBody RequestResultVO update(HttpServletRequest request){
		String userCourseString = request.getParameter("userCourse");
UserCourse userCourse = null;
		try{
userCourse = JsonFastUtil.parseObject(userCourseString, UserCourse.class);
		}catch(Exception e){
			throw new BizException(Public.ERROR_700);
		}
		return userCourseService.update(userCourse);
	}
	/**
	 * 删除
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/delete.do")
	public @ResponseBody RequestResultVO delete(HttpServletRequest request){
		String userCourseIdsString = request.getParameter("userCourseIds");
		List<Integer> userCourseIds;
    try{
userCourseIds = CommonUtils.idsArrayToList(userCourseIdsString);
    }catch(Exception e){
    throw new BizException(Public.ERROR_700);
    }
    return userCourseService.delete(userCourseIds);
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
    return userCourseService.getByPage(keys, length, start);
    }
    }
