package cn.ifengkou.gaia.dao;

import cn.ifengkou.gaia.model.DispatchList;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * 今日生产情况 查询
 * Created by Sloong on 2016/2/12.
 */
@Repository
public interface DispatchListDao {

    List<DispatchList> getDispatchList(Date beginTime);

    HashMap<String,Object> statDispatchList(String type);
}
