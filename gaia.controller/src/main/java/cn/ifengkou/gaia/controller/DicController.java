package cn.ifengkou.gaia.controller;

import cn.ifengkou.gaia.service.DicService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Sloong on 2015/12/30.
 */
@RestController
@RequestMapping("api/dics")
public class DicController {

    @Resource
    DicService dicService;

    @RequestMapping(method = RequestMethod.GET)
    public List<HashMap<String,Object>> getDics(){
        return  dicService.getDics();
    }

    @RequestMapping(method = RequestMethod.GET,value ="/constrength")
    public List<HashMap<String,Object>> getConStrengths(){
        return  dicService.getConStrengths();
    }
}
