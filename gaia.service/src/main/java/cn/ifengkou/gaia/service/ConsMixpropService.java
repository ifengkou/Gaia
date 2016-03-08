package cn.ifengkou.gaia.service;

import cn.ifengkou.gaia.model.ConsMixprop;
import cn.ifengkou.gaia.model.ConsMixpropItem;

import java.util.List;

/**
 * Created by Sloong on 2016/2/10.
 */
public interface ConsMixpropService {
    /**
     * 根据生产线id获取未被审核的施工配比单
     * @param productLineId
     * @return
     */
    List<ConsMixprop> getConsMixprops(String productLineId);

    /**
     * 根据施工配比ID，获得配比详细材料用量
     * @param custMixpropId
     * @return
     */
    List<ConsMixpropItem> getConsMixpropItems(String custMixpropId);

    /**
     * 审核配比单
     * @param consMixpropId
     * @return
     */
    int audit(String consMixpropId,String userId);
}
