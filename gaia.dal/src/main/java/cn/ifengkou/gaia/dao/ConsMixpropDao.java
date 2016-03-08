package cn.ifengkou.gaia.dao;

import cn.ifengkou.gaia.model.ConsMixprop;
import cn.ifengkou.gaia.model.ConsMixpropItem;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Sloong on 2016/2/9.
 */
@Repository
public interface ConsMixpropDao {

    /**
     * 根据生产线id获取未被审核的施工配比单
     * @param map
     * @return
     */
    List<ConsMixprop> getConsMixprops(HashMap<String,String> map);

    /**
     * 根据施工配比ID，获得配比详细材料用量
     * @param consMixpropId
     * @return
     */
    List<ConsMixpropItem> getConsMixpropItems(String consMixpropId);

    int audit(HashMap<String,String> map);
}
