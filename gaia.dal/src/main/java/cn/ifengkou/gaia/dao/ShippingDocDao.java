package cn.ifengkou.gaia.dao;

import cn.ifengkou.gaia.model.Shipping;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Sloong on 2015/12/30.
 */
@Repository
public interface ShippingDocDao {
    List<HashMap<String,Object>> getCustomerShippingDoc(String userName);

    Shipping get(HashMap<String, String> map);
    int sign(Shipping bean);

    //站内功能

    /**
     * 出票方量、调度方量统计
     * @param map
     * @return
     */
    HashMap<String,Object> statShippingCubes(HashMap<String, Date> map);

    /**
     * 生产方量统计，按工地和砼强度分组
     * @param map
     * @return
     */
    List<HashMap<String,Object>> getShippingDocByTime(HashMap<String, Date> map);
}
