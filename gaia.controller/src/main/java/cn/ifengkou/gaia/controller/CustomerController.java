package cn.ifengkou.gaia.controller;

import cn.ifengkou.commons.DecriptTools;
import cn.ifengkou.commons.StringUtils;
import cn.ifengkou.commons.UUIDTools;
import cn.ifengkou.gaia.common.JsonDto;
import cn.ifengkou.gaia.exception.IllegalException;
import cn.ifengkou.gaia.service.CustomerService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;

/**
 * Created by Sloong on 2015/12/15.
 */
@RestController
@RequestMapping("api/customer")
public class CustomerController {

    @Resource
    CustomerService customerService;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public JsonDto userLogin(String name,String pass){
        HashMap<String,Object> user = customerService.getByName(name);
        if(user!=null){
            String password = (String)user.get("Password");
            //TODO pass后台加密 方便测试
            pass = DecriptTools.SHA1(pass).toUpperCase();

            if(StringUtils.notEmpty(password)&&password.equals(pass)){
                user.remove("Password");

                //如果用户token为空
                String token = (String)user.get("Token");
                if(StringUtils.isEmpty(token)){
                    token = UUIDTools.uuid();

                    customerService.genToken(name, token);

                    user.put("Token",token);
                }

                return new JsonDto(true,user);
            }
            return new JsonDto(false,"用户名或密码错误");
        }
        return new JsonDto(false,"用户不存在");
    }

    @RequestMapping(method= RequestMethod.GET,value = "/accesstoken")
    @ResponseBody
    public String verifyAccessToken(String accessToken) throws IllegalException{
        HashMap<String,Object> user = customerService.verifyAccessToken(accessToken);
        if(user==null) throw new IllegalException("validation fails");
        return (String)user.get("id");
    }



}
