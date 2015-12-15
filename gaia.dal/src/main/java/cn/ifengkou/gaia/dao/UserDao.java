package cn.ifengkou.gaia.dao;

import org.springframework.stereotype.Repository;

import java.util.HashMap;

/**
 * Created by Sloong on 2015/12/15.
 */
@Repository
public interface UserDao {
    HashMap<String,Object> get(long id);
}
