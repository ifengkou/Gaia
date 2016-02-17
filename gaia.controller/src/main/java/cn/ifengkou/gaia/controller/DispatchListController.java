package cn.ifengkou.gaia.controller;

import cn.ifengkou.commons.DateTools;
import cn.ifengkou.gaia.common.JsonDto;
import cn.ifengkou.gaia.service.DispatchListService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
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
    public JsonDto getTodayDispatchList(){
        //Date date = new Date(115,11,8);
        //return new JsonDto(true,dispatchListService.getDispatchList(date));
        return new JsonDto(true,dispatchListService.getDispatchList(DateTools.getBeginOfCurrentDay()));
    }

    @RequestMapping(method = RequestMethod.GET,value = "/stat")
    @ResponseBody
    public JsonDto statDispatchList(){
        HashMap<String,Object> returnMap = new HashMap<>();
        returnMap.put("today",dispatchListService.statDispatchList(DateTools.getBeginOfCurrentDay()));
        returnMap.put("month",dispatchListService.statDispatchList(DateTools.getFirstDayCurrentMonth()));
        returnMap.put("year",dispatchListService.statDispatchList(DateTools.getFirstDayOfCurrentYear()));
        return new JsonDto(true,returnMap);
    }

}
