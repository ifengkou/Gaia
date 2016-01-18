package cn.ifengkou.gaia.controller;

import cn.ifengkou.gaia.common.JsonDto;
import cn.ifengkou.gaia.service.DicService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by Sloong on 2015/12/30.
 */
@RestController
@RequestMapping("api/dics")
public class DicController {

    @Resource
    DicService dicService;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public JsonDto getDics(){
        return new JsonDto(true,dicService.getDics());
    }

    @RequestMapping(method = RequestMethod.GET,value ="/constrength")
    @ResponseBody
    public JsonDto getConStrengths(){
        return new JsonDto(true,dicService.getConStrengths());
    }
}
