package cn.ifengkou.gaia.controller;

import cn.ifengkou.gaia.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by Sloong on 2015/12/15.
 */
@Controller
@RequestMapping("api")
public class UserController {

    @Resource
    UserService userService;

    @RequestMapping(value = "/index",method = RequestMethod.GET)
    @ResponseBody
    public String index(){
        return "hello world!";
    }

}
