package cn.ifengkou.gaia.service.impl;

import cn.ifengkou.gaia.dao.ShippingDocDao;
import cn.ifengkou.gaia.model.Shipping;
import cn.ifengkou.gaia.service.ShippingDocService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Sloong on 2016/1/12.
 */
@Service("shippingDocService")
public class ShippingDocServiceImpl implements ShippingDocService {
    @Resource
    ShippingDocDao shippingDocDao;
    @Override
    public List<HashMap<String, Object>> getCustomerShippingDoc(String userName) {
        return shippingDocDao.getCustomerShippingDoc(userName);
    }

    @Override
    public Shipping get(String shippingId) {
        return shippingDocDao.get(shippingId);
    }

    @Override
    public int sign(Shipping bean) {
        return shippingDocDao.sign(bean);
    }
}
