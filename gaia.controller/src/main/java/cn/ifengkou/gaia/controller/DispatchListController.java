package cn.ifengkou.gaia.controller;

import cn.ifengkou.commons.DateTools;
import cn.ifengkou.gaia.common.JsonDto;
import cn.ifengkou.gaia.common._Sys;
import cn.ifengkou.gaia.service.DispatchListService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

/**
 * Created by Sloong on 2016/2/17.
 */
@RestController
@RequestMapping("api/dispatch")
public class DispatchListController {

    @Resource
    DispatchListService dispatchListService;

    /**
     * 今日生产情况
     * @return
     */
    @RequestMapping(method = RequestMethod.GET,value = "/list")
    @ResponseBody
    public JsonDto getTodayDispatchList(HttpServletRequest request){
        HashMap<String,Object> user = (HashMap<String,Object>)request.getAttribute(_Sys.ADMIN_KEY);
        if(user == null){
            return new JsonDto(false,"无权限");
        }
        //Date date = new Date(115,11,8);
        //return new JsonDto(true,dispatchListService.getDispatchList(date));
        return new JsonDto(true,dispatchListService.getDispatchList(DateTools.getBeginOfCurrentDay()));
    }

    @RequestMapping(method = RequestMethod.GET,value = "/stat")
    @ResponseBody
    public JsonDto statDispatchList(HttpServletRequest request){
        HashMap<String,Object> user = (HashMap<String,Object>)request.getAttribute(_Sys.ADMIN_KEY);
        if(user == null){
            return new JsonDto(false,"无权限");
        }
        HashMap<String,Object> returnMap = new HashMap<>();
        returnMap.put("today",dispatchListService.statDispatchList(DateTools.getBeginOfCurrentDay()));
        returnMap.put("month",dispatchListService.statDispatchList(DateTools.getFirstDayCurrentMonth()));
        returnMap.put("year",dispatchListService.statDispatchList(DateTools.getFirstDayOfCurrentYear()));
        return new JsonDto(true,returnMap);
    }

}
