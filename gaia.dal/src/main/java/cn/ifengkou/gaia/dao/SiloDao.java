package cn.ifengkou.gaia.dao;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

/**
 * 今日生产情况 查询
 * Created by Sloong on 2016/2/12.
 */
@Repository
public interface SiloDao {

    List<HashMap<String,Object>> querySilo();

}
