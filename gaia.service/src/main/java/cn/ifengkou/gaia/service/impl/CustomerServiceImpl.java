package cn.ifengkou.gaia.service.impl;

import cn.ifengkou.gaia.dao.CustomerDao;
import cn.ifengkou.gaia.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Sloong on 2015/12/17.
 */
@Service("customerService")
public class CustomerServiceImpl implements CustomerService {
    @Resource
    CustomerDao customerDao;

    private final static Logger LOG = LoggerFactory.getLogger(CustomerServiceImpl.class);


    @Override
    public HashMap<String, Object> get(String id) {
        return customerDao.get(id);
    }

    @Override
    public HashMap<String, Object> getByName(String name) {
        return customerDao.getByName(name);
    }

    @Cacheable(value = "accessTokenUser",key = "#accessToken")
    @Override
    public HashMap<String,Object> verifyAccessToken(String accessToken) {
        LOG.info("customer token check:{}",accessToken);
        List<HashMap<String,Object>> customer = customerDao.getByAccessToken(accessToken);
        if(customer== null || customer.size()!=1){
            if(customer.size()>1){
                LOG.error("accessToken 出现了重复，bug，请检查");
            }
            return null;
        }
        return customer.get(0);
    }

    @Override
    public int genToken(String id, String token) {
        HashMap<String,String> map = new HashMap<>();
        map.put("id",id);
        map.put("token",token);
        return customerDao.genToken(map);
    }

    @Override
    public int changePwd(String id, String newPassword) {
        HashMap<String,String> map = new HashMap<>();
        map.put("id",id);
        map.put("password",newPassword);
        return customerDao.changePwd(map);
    }
}
