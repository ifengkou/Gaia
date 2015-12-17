package cn.ifengkou.gaia.service.impl;

import cn.ifengkou.gaia.dao.UserDao;
import cn.ifengkou.gaia.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Sloong on 2015/12/15.
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    private final static Logger LOG = LoggerFactory.getLogger(UserServiceImpl.class);
    @Resource
    UserDao userDao;


    @Override
    public HashMap<String, Object> get(String id) {
        return userDao.get(id);
    }

    @Override
    public HashMap<String, Object> getUserByName(String name) {
        return userDao.getByName(name);
    }

    @Cacheable(value = "accessTokenUser",key = "#accessToken")
    @Override
    public HashMap<String,Object> verifyAccessToken(String accessToken) {
        LOG.info("user token check:{}",accessToken);
        List<HashMap<String,Object>> users = userDao.getByAccessToken(accessToken);
        if(users.size()!=1){
            if(users.size()>1){
                LOG.error("accessToken 出现了重复，bug！请检查！");
            }
            return null;
        }
        return users.get(0);
    }

    @Override
    public int genUserToken(String name, String token) {
        HashMap<String,String> map = new HashMap<>();
        map.put("name",name);
        map.put("token",token);
        return userDao.genToken(map);
    }
}
