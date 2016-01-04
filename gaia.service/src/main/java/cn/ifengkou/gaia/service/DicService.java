package cn.ifengkou.gaia.service;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Sloong on 2015/12/15.
 */
public interface DicService {
    List<HashMap<String,Object>> getDics();
    List<HashMap<String,Object>> getConStrengths();
}
