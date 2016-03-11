package cn.ifengkou.gaia.controller;

import cn.ifengkou.commons.DateTools;
import cn.ifengkou.gaia.common.JsonDto;
import cn.ifengkou.gaia.common._Sys;
import cn.ifengkou.gaia.model.DispatchGroup;
import cn.ifengkou.gaia.model.DispatchList;
import cn.ifengkou.gaia.service.DispatchListService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
        List<DispatchList> list = dispatchListService.getDispatchList(DateTools.getBeginOfCurrentDay());
        List<DispatchGroup> returnList = new ArrayList<>();

        HashMap<String,List<DispatchList>> map = new HashMap<>();
        for(DispatchList d : list){
            String key = d.getProductLineName();
            if(map.containsKey(key)){
                map.get(d.getProductLineName()).add(d);
            }else{
                List<DispatchList> newList = new ArrayList<>();
                newList.add(d);
                map.put(key,newList);
            }
        }

        for (String k : map.keySet()){
            DispatchGroup group = new DispatchGroup();
            group.setKey(k);
            group.setList(map.get(k));
            returnList.add(group);
        }
        return new JsonDto(true,returnList);
    }

    @RequestMapping(method = RequestMethod.GET,value = "/stat")
    @ResponseBody
    public JsonDto statDispatchList(HttpServletRequest request){
        HashMap<String,Object> user = (HashMap<String,Object>)request.getAttribute(_Sys.ADMIN_KEY);
        if(user == null){
            return new JsonDto(false,"无权限");
        }
        HashMap<String,Object> returnMap = new HashMap<>();
        returnMap.put("today",dispatchListService.statDispatchList("d"));
        returnMap.put("month",dispatchListService.statDispatchList("m"));
        returnMap.put("year",dispatchListService.statDispatchList("y"));
        return new JsonDto(true,returnMap);
    }

}
