package cn.ifengkou.gaia.controller;

import cn.ifengkou.commons.DecriptTools;
import cn.ifengkou.commons.StringUtils;
import cn.ifengkou.commons.UUIDTools;
import cn.ifengkou.gaia.common.JsonDto;
import cn.ifengkou.gaia.model.LoginData;
import cn.ifengkou.gaia.service.CustomerService;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "/login",method = RequestMethod.POST,consumes = "application/json")
    @ResponseBody
    public JsonDto userLogin(@RequestBody LoginData data){
        String name = data.getName();
        String pass = data.getPass();
        HashMap<String,Object> user = customerService.getByName(name);
        if(user!=null){
            String password = (String)user.get("password");
            //TODO pass 前端处理加密
            pass = DecriptTools.SHA1(pass).toUpperCase();

            if(StringUtils.notEmpty(password)&&password.equals(pass)){
                user.remove("password");

                //如果没有token，那么这时候生成
                String token = (String)user.get("token");
                if(StringUtils.isEmpty(token)){
                    token = UUIDTools.uuid();

                    customerService.genToken(name, token);

                    user.put("token",token);
                }

                return new JsonDto(true,user);
            }
            return new JsonDto(false,"用户名或密码错误");
        }
        return new JsonDto(false,"用户不存在，请重试或联系管理员");
    }

    @RequestMapping(method= RequestMethod.GET,value = "/accesstoken")
    @ResponseBody
    public JsonDto verifyAccessToken(String token){
        HashMap<String,Object> user = customerService.verifyAccessToken(token);
        if(user==null) {
            return new JsonDto(false,"验证失败");
        }
        return new JsonDto(true,"验证成功",user.get("id"));
    }



}
