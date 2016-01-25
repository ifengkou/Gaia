package cn.ifengkou.gaia.service;

import java.util.HashMap;

/**
 * Created by Sloong on 2015/12/15.
 */
public interface UserService {
    HashMap<String,Object> get(String id);

    HashMap<String,Object> getUserByName(String name);

    HashMap<String,Object> verifyAccessToken(String accessToken);

    int genUserToken(String name, String token);

    int changePwd(String id, String newPasswordCiphertext);
}
