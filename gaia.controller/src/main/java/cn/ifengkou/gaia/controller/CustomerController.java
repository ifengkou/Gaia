package cn.ifengkou.gaia.controller;

import cn.ifengkou.commons.StringUtils;
import cn.ifengkou.commons.UUIDTools;
import cn.ifengkou.gaia.common.JsonDto;
import cn.ifengkou.gaia.common._Sys;
import cn.ifengkou.gaia.model.ChangePwdModel;
import cn.ifengkou.gaia.model.LoginData;
import cn.ifengkou.gaia.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

/**
 * Created by Sloong on 2015/12/15.
 */
@RestController
@RequestMapping("api/customer")
public class CustomerController {

    @Resource
    CustomerService customerService;

    @RequestMapping(value = "/login", method = RequestMethod.POST, consumes = "application/json")
    @ResponseBody
    public JsonDto userLogin(@RequestBody LoginData data) {
        String name = data.getName();
        String pass = data.getPass();
        HashMap<String, Object> user = customerService.getByName(name);
        if (user != null) {
            String password = (String) user.get("password");
            //pass = DecriptTools.SHA1(pass).toUpperCase();

            if (StringUtils.notEmpty(password) && password.equals(pass)) {
                user.remove("password");

                //如果没有token，那么这时候生成
                String token = (String) user.get("token");
                if (StringUtils.isEmpty(token)) {
                    token = UUIDTools.uuid();
                    String customerId = (String) user.get("id");
                    customerService.genToken(customerId, token);

                    user.put("token", token);
                }

                return new JsonDto(true, user);
            }
            return new JsonDto(false, "用户名或密码错误");
        }
        return new JsonDto(false, "用户不存在，请重试或联系管理员");
    }

    @RequestMapping(method = RequestMethod.GET, value = "/accesstoken")
    @ResponseBody
    public JsonDto verifyAccessToken(String token) {
        HashMap<String, Object> user = customerService.verifyAccessToken(token);
        if (user == null) {
            return new JsonDto(false, "验证失败");
        }
        return new JsonDto(true, "验证成功", user.get("id"));
    }

    @RequestMapping(method = RequestMethod.POST, value = "/password")
    @ResponseBody
    public JsonDto changePassword(@RequestBody ChangePwdModel model,HttpServletRequest request) {
        HashMap<String, Object> user = (HashMap<String, Object>) request.getAttribute(_Sys.USER_KEY);
        String customerId = (String) user.get("id");
        HashMap<String,Object> map = customerService.get(customerId);
        //比较密码
        String password = (String) map.get("Password");
        int x;
        if (StringUtils.notEmpty(password) && password.equals(model.getOldPasswordCiphertext())) {
            x = customerService.changePwd(customerId,model.getNewPasswordCiphertext());
        }else{
            return new JsonDto(false,"原密码错误，修改失败");
        }
        if(x>0){
            return new JsonDto(true, "密码修改成功", customerId);
        }
        return new JsonDto(false,"密码修改失败");
    }


}
