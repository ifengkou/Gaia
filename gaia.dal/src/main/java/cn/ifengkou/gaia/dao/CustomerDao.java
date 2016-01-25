package cn.ifengkou.gaia.dao;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Sloong on 2015/12/17.
 */
@Repository
public interface CustomerDao {
    HashMap<String,Object> get(String id);
    HashMap<String,Object> getByName(String name);

    List<HashMap<String,Object>> getByAccessToken(String accessToken);

    int genToken(HashMap<String, String> map);

    int changePwd(HashMap<String, String> map);
}
