package cn.ifengkou.gaia.dao;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Sloong on 2015/12/30.
 */
@Repository
public interface DicDao {
    List<HashMap<String,Object>> getDics();

    List<HashMap<String,Object>> getConStrengths();

}
