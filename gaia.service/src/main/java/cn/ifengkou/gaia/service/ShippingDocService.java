package cn.ifengkou.gaia.service;

import cn.ifengkou.gaia.model.Shipping;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Sloong on 2015/12/15.
 */
public interface ShippingDocService {
    List<HashMap<String,Object>> getCustomerShippingDoc(String userName);

    Shipping get(String shippingId,String userName);

    int sign(Shipping bean);

    //站内功能

    /**
     * 出票方量、调度方量统计
     * @param beginTime
     * @param endTime
     * @return
     */
    HashMap<String,Object> statShippingCubes(Date beginTime,Date endTime);

    /**
     * 生产方量统计，按工地和砼强度分组
     * @param beginTime
     * @param endTime
     * @return
     */
    List<HashMap<String,Object>> getShippingDocByTime(Date beginTime,Date endTime);
}
