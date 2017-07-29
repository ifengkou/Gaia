package cn.ifengkou.gaia.service;

import java.util.HashMap;

/**
 * Created by Sloong on 2015/12/17.
 */
public interface CustomerService {
    HashMap<String,Object> get(String id);

    HashMap<String,Object> getByName(String name);

    HashMap<String,Object> verifyAccessToken(String accessToken);

    int genToken(String id, String token);

    int changePwd(String id, String newPasswordCiphertext);
}
