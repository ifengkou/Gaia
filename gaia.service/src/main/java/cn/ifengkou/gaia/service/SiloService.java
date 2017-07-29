package cn.ifengkou.gaia.service;

import java.util.HashMap;
import java.util.List;

/**
 * 原材料当前库存 查询
 * Created by Sloong on 2016/2/12.
 */
public interface SiloService {

    /**
     * 查询筒仓内原材料库存
     * @return
     */
    List<HashMap<String,Object>> querySilo();
}
