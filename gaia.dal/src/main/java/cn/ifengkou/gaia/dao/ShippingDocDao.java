package cn.ifengkou.gaia.dao;

import cn.ifengkou.gaia.model.Shipping;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Sloong on 2015/12/30.
 */
@Repository
public interface ShippingDocDao {
    List<HashMap<String,Object>> getCustomerShippingDoc(String userName);

    Shipping get(String id);
    int sign(Shipping bean);
}
