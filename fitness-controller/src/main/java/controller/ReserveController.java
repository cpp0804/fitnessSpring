package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import model.Reserve;
import service.ReserveService;
import common.exceptions.BizException;
import common.util.CommonUtils;
import common.util.JsonFastUtil;
import pojo.RequestResultVO;
import common.util.HttpResponseConstants.Public;

@Controller
@RequestMapping(value = "/reserve")
public class ReserveController {

    @Autowired
    private ReserveService reserveService;

    /**
     * 新增
     *
     * @param request
     * @param request
     * @return
     * @RequestMapping(value="/insert.do") public @ResponseBody RequestResultVO insert(HttpServletRequest request){
     * String reserveString = request.getParameter("reserve");
     * Reserve reserve = null;
     * try{
     * reserve = JsonFastUtil.parseObject(reserveString, Reserve.class);
     * }catch(Exception e){
     * throw new BizException(Public.ERROR_700);
     * }
     * return reserveService.insert(reserve);
     * }
     * /**
     * 修改
     */
    @RequestMapping(value = "/update.do")
    public @ResponseBody
    RequestResultVO update(HttpServletRequest request) {
        String reserveString = request.getParameter("reserve");
        Reserve reserve = null;
        try {
            reserve = JsonFastUtil.parseObject(reserveString, Reserve.class);
        } catch (Exception e) {
            throw new BizException(Public.ERROR_700);
        }
        return reserveService.update(reserve);
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
        String reserveIdsString = request.getParameter("reserveIds");
        List<Integer> reserveIds;
        try {
            reserveIds = CommonUtils.idsArrayToList(reserveIdsString);
        } catch (Exception e) {
            throw new BizException(Public.ERROR_700);
        }
        return reserveService.delete(reserveIds);
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
        return reserveService.getByPage(keys, length, start);
    }

    @RequestMapping(value = "/reserve.do")
    public @ResponseBody
    RequestResultVO reserve(HttpServletRequest request) {
        Integer courseInstanceId = Integer.valueOf(request.getParameter("courseInstanceId"));
        return reserveService.reserve(courseInstanceId);
    }

    @RequestMapping(value = "/getReserveNotStarted.do")
    public @ResponseBody
    Object getReserveNotStarted(HttpServletRequest request) {
        return reserveService.getReserveNotStarted();
    }
}
