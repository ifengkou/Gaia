package cn.ifengkou.gaia.service;

import cn.ifengkou.gaia.model.Shipping;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Sloong on 2015/12/15.
 */
public interface ShippingDocService {
    List<HashMap<String,Object>> getCustomerShippingDoc(String userName);

    Shipping get(String shippingId,String userName);

    int sign(Shipping bean);
}
