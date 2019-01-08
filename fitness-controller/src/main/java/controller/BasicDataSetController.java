package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import model.BasicDataSet;
import service.BasicDataSetService;
import common.exceptions.BizException;
import common.util.CommonUtils;
import common.util.JsonFastUtil;
import pojo.RequestResultVO;
import common.util.HttpResponseConstants.Public;

@Controller
@RequestMapping(value = "/basicDataSet")
public class BasicDataSetController {

    @Autowired
    private BasicDataSetService basicDataSetService;

    /**
     * 新增
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/insert.do")
    public @ResponseBody
    RequestResultVO insert(HttpServletRequest request) {
        String basicDataSetString = request.getParameter("basicDataSet");
        BasicDataSet basicDataSet = null;
        try {
            basicDataSet = JsonFastUtil.parseObject(basicDataSetString, BasicDataSet.class);
        } catch (Exception e) {
            throw new BizException(Public.ERROR_700);
        }
        return basicDataSetService.insert(basicDataSet);
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
        String basicDataSetString = request.getParameter("basicDataSet");
        BasicDataSet basicDataSet = null;
        try {
            basicDataSet = JsonFastUtil.parseObject(basicDataSetString, BasicDataSet.class);
        } catch (Exception e) {
            throw new BizException(Public.ERROR_700);
        }
        return basicDataSetService.update(basicDataSet);
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
        String basicDataSetIdsString = request.getParameter("basicDataSetIds");
        List<Integer> basicDataSetIds;
        try {
            basicDataSetIds = CommonUtils.idsArrayToList(basicDataSetIdsString);
        } catch (Exception e) {
            throw new BizException(Public.ERROR_700);
        }
        return basicDataSetService.delete(basicDataSetIds);
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
        return basicDataSetService.getByPage(keys, length, start);
    }

}
