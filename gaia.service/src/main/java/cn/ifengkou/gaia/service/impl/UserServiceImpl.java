package cn.ifengkou.gaia.service.impl;

import cn.ifengkou.gaia.dao.UserDao;
import cn.ifengkou.gaia.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;

/**
 * Created by Sloong on 2015/12/15.
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource
    UserDao userDao;


    @Override
    public HashMap<String, Object> get(long id) {
        return userDao.get(id);
    }
}
