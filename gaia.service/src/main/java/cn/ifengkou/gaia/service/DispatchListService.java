package cn.ifengkou.gaia.service;

import cn.ifengkou.gaia.model.DispatchList;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * 生产情况 查询
 * Created by Sloong on 2016/2/12.
 */
public interface DispatchListService {

    /**
     * 查询本年度/本月/本日 生产情况列表
     * @param date
     * @return
     */
    List<DispatchList> getDispatchList(Date date);

    /**
     * 统计本年度/本月/本日 生产情况
     * @param type
     * @return
     */
    HashMap<String,Object> statDispatchList(String type);
}
