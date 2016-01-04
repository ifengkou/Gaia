package cn.ifengkou.gaia.service.impl;

import cn.ifengkou.gaia.dao.DicDao;
import cn.ifengkou.gaia.service.DicService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Sloong on 2015/12/15.
 */
@Service("dicService")
public class DicServiceImpl implements DicService {
    @Resource
    DicDao dicDao;


    @Override
    public List<HashMap<String, Object>> getDics() {
        return dicDao.getDics();
    }


    @Override
    public List<HashMap<String, Object>> getConStrengths() {
        return dicDao.getConStrengths();
    }

}
