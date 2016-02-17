package cn.ifengkou.gaia.service.impl;

import cn.ifengkou.gaia.dao.DispatchListDao;
import cn.ifengkou.gaia.model.DispatchList;
import cn.ifengkou.gaia.service.DispatchListService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Sloong on 2016/2/12.
 */
@Service("dispatchListService")
public class DispatchListServiceImpl implements DispatchListService {

    @Resource
    DispatchListDao dispatchListDao;

    @Override
    public List<DispatchList> getDispatchList(Date date) {
        return dispatchListDao.getDispatchList(date);
    }

    @Override
    public HashMap<String, Object> statDispatchList(Date date) {
        return dispatchListDao.statDispatchList(date);
    }
}
