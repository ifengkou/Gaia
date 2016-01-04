package cn.ifengkou.gaia.controller;

import cn.ifengkou.gaia.common.JsonDto;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Sloong on 2015/12/15.
 */
@RestController
@RequestMapping("api")
public class TestApiController {
    @RequestMapping(method= RequestMethod.GET,value = "/test")
    @ResponseBody
    public JsonDto testServer(){
        return new JsonDto(true);
    }
}
