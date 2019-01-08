package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import model.Course;
import service.CourseService;
import common.exceptions.BizException;
import common.util.CommonUtils;
import common.util.JsonFastUtil;
import pojo.RequestResultVO;
import common.util.HttpResponseConstants.Public;

@Controller
@RequestMapping(value = "/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    /**
     * 新增
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/insert.do")
    public @ResponseBody
    RequestResultVO insert(HttpServletRequest request) {
        String courseString = request.getParameter("course");
        Course course = null;
        try {
            course = JsonFastUtil.parseObject(courseString, Course.class);
        } catch (Exception e) {
            throw new BizException(Public.ERROR_700);
        }
        return courseService.insert(course);
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
        String courseString = request.getParameter("course");
        Course course = null;
        try {
            course = JsonFastUtil.parseObject(courseString, Course.class);
        } catch (Exception e) {
            throw new BizException(Public.ERROR_700);
        }
        return courseService.update(course);
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
        String courseIdsString = request.getParameter("courseIds");
        List<Integer> courseIds;
        try {
            courseIds = CommonUtils.idsArrayToList(courseIdsString);
        } catch (Exception e) {
            throw new BizException(Public.ERROR_700);
        }
        return courseService.delete(courseIds);
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
        return courseService.getByPage(keys, length, start);
    }
}
