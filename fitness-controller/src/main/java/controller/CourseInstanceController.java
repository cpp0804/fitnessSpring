package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import model.CourseInstance;
import service.CourseInstanceService;
import common.exceptions.BizException;
import common.util.CommonUtils;
import common.util.JsonFastUtil;
import pojo.RequestResultVO;
import common.util.HttpResponseConstants.Public;

@Controller
@RequestMapping(value = "/courseInstance")
public class CourseInstanceController {

    @Autowired
    private CourseInstanceService courseInstanceService;

    /**
     * 新增
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/insert.do")
    public @ResponseBody
    RequestResultVO insert(HttpServletRequest request) {
        String courseInstanceString = request.getParameter("courseInstance");
        CourseInstance courseInstance = null;
        try {
            courseInstance = JsonFastUtil.parseObject(courseInstanceString, CourseInstance.class);
        } catch (Exception e) {
            throw new BizException(Public.ERROR_700);
        }
        return courseInstanceService.insert(courseInstance);
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
        String courseInstanceString = request.getParameter("courseInstance");
        CourseInstance courseInstance = null;
        try {
            courseInstance = JsonFastUtil.parseObject(courseInstanceString, CourseInstance.class);
        } catch (Exception e) {
            throw new BizException(Public.ERROR_700);
        }
        return courseInstanceService.update(courseInstance);
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
        String courseInstanceIdsString = request.getParameter("courseInstanceIds");
        List<Integer> courseInstanceIds;
        try {
            courseInstanceIds = CommonUtils.idsArrayToList(courseInstanceIdsString);
        } catch (Exception e) {
            throw new BizException(Public.ERROR_700);
        }
        return courseInstanceService.delete(courseInstanceIds);
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
//        String keys = request.getParameter("keys");
//        Integer length = Integer.parseInt(request.getParameter("length"));
//        Integer start = Integer.parseInt(request.getParameter("start"));
        return courseInstanceService.getByPage();
    }
}
