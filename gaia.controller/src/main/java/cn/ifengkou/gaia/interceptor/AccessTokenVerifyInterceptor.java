package cn.ifengkou.gaia.interceptor;

import cn.ifengkou.commons.StringUtils;
import cn.ifengkou.gaia.common._Sys;
import cn.ifengkou.gaia.service.CustomerService;
import cn.ifengkou.gaia.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;

/**
 * 验证token有效性
 * Created by Sloong on 2015/12/2.
 */
@Component
public class AccessTokenVerifyInterceptor extends HandlerInterceptorAdapter {
    @Resource
    UserService userService;

    @Resource
    CustomerService customerService;

    private final static Logger LOG = LoggerFactory.getLogger(AccessTokenVerifyInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        LOG.info("AccessTokenVerifyInterceptor executing.......");
        boolean flag = false;
        String accessToken = request.getParameter("accesstoken");
        if(StringUtils.notEmpty(accessToken)) {
            //验证accessToken
            //verifyAccessToken 已做缓存处理
            HashMap<String,Object> customer = customerService.verifyAccessToken(accessToken);
            if(customer!=null){
                flag = true;
                request.setAttribute(_Sys.USER_KEY,customer);
            }else{
                HashMap<String,Object> user = userService.verifyAccessToken(accessToken);
                if(user!=null){
                    flag = true;
                    request.setAttribute(_Sys.ADMIN_KEY,user);
                }
            }
        }

        if(!flag){
            response.setStatus(HttpStatus.FORBIDDEN.value());
            response.getWriter().print("wrong access token");
        }
        return flag;
    }
}
