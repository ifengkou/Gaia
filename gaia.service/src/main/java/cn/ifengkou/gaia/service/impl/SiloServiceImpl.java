package cn.ifengkou.gaia.service.impl;

import cn.ifengkou.gaia.dao.SiloDao;
import cn.ifengkou.gaia.service.SiloService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Sloong on 2016/2/12.
 */
@Service("siloService")
public class SiloServiceImpl implements SiloService {

    @Resource
    SiloDao siloDao;

    @Override
    public List<HashMap<String, Object>> querySilo() {
        return siloDao.querySilo();
    }
}
