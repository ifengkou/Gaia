package cn.ifengkou.gaia.dao;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Sloong on 2015/12/15.
 */
@Repository
public interface UserDao {
    HashMap<String,Object> get(String id);

    HashMap<String,Object> getByName(String name);

    List<HashMap<String,Object>> getUserByAccessToken(String accessToken);

    int genUserToken(HashMap<String, String> map);
}
