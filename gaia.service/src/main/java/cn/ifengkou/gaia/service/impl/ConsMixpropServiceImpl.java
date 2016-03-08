package cn.ifengkou.gaia.service.impl;

import cn.ifengkou.gaia.dao.ConsMixpropDao;
import cn.ifengkou.gaia.model.ConsMixprop;
import cn.ifengkou.gaia.model.ConsMixpropItem;
import cn.ifengkou.gaia.service.ConsMixpropService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Sloong on 2016/2/10.
 */
@Service("consMixpropService")
public class ConsMixpropServiceImpl implements ConsMixpropService{

    @Resource
    ConsMixpropDao consMixpropDao;
    @Override
    public List<ConsMixprop> getConsMixprops(String productLineId) {
        HashMap<String,String> map = new HashMap<>();
        map.put("productLineId",productLineId);
        return consMixpropDao.getConsMixprops(map);
    }

    @Override
    public List<ConsMixpropItem> getConsMixpropItems(String consMixpropId) {
        return consMixpropDao.getConsMixpropItems(consMixpropId);
    }

    @Override
    public int audit(String consMixpropId,String userId){
        HashMap<String,String> map = new HashMap<>();
        map.put("userId",userId);
        map.put("consMixpropId",consMixpropId);
        return consMixpropDao.audit(map);
    }
}
