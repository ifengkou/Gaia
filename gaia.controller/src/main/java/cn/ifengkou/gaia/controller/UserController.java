package cn.ifengkou.gaia.controller;

import cn.ifengkou.commons.StringUtils;
import cn.ifengkou.commons.UUIDTools;
import cn.ifengkou.gaia.common.JsonDto;
import cn.ifengkou.gaia.common._Sys;
import cn.ifengkou.gaia.model.ChangePwdModel;
import cn.ifengkou.gaia.model.LoginData;
import cn.ifengkou.gaia.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

/**
 * Created by Sloong on 2015/12/15.
 */
@RestController
@RequestMapping("api/user")
public class UserController {

    @Resource
    UserService userService;

    private final static Logger LOG = LoggerFactory.getLogger(UserController.class);

    @RequestMapping(value = "/login", method = RequestMethod.POST, consumes = "application/json")
    @ResponseBody
    public JsonDto userLogin(@RequestBody LoginData data) {
        String name = data.getName();
        String pass = data.getPass();

        LOG.info("用户登录,{},{}", name, pass);
        HashMap<String, Object> user = userService.getUserByName(name);
        if (user != null) {
            String password = (String) user.get("password");
            //pass = DecriptTools.SHA1(pass).toUpperCase();

            if (StringUtils.notEmpty(password) && password.equals(pass)) {
                user.remove("password");

                //如果没有token，那么这时候生成
                String token = (String) user.get("token");
                if (StringUtils.isEmpty(token)) {
                    token = UUIDTools.uuid();

                    userService.genUserToken(name, token);

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
        HashMap<String, Object> user = userService.verifyAccessToken(token);
        if (user == null) {
            return new JsonDto(false, "验证失败");
        }
        return new JsonDto(true, "验证成功", user.get("id"));
    }

    @RequestMapping(method = RequestMethod.POST, value = "/password")
    @ResponseBody
    public JsonDto changePassword(@RequestBody ChangePwdModel model, HttpServletRequest request) {

        HashMap<String, Object> user = (HashMap<String, Object>) request.getAttribute(_Sys.ADMIN_KEY);
        String userId = (String) user.get("id");
        LOG.info("修改密码，userID {}", userId);
        HashMap<String, Object> map = userService.get(userId);
        //比较密码
        String password = (String) map.get("password");
        int x;
        if (StringUtils.notEmpty(password) && password.equals(model.getOldPasswordCiphertext())) {
            x = userService.changePwd(userId, model.getNewPasswordCiphertext());
        } else {
            return new JsonDto(false, "原密码错误，修改失败");
        }
        if (x > 0) {
            return new JsonDto(true, "密码修改成功", userId);
        }
        return new JsonDto(false, "密码修改失败");
    }

}
