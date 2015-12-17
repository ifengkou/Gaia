package cn.ifengkou.gaia.service.impl;

import cn.ifengkou.gaia.dao.ContractDao;
import cn.ifengkou.gaia.model.Contract;
import cn.ifengkou.gaia.service.ContractService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Sloong on 2015/12/17.
 */
@Service("contractService")
public class ContractServiceImpl implements ContractService {

    @Resource
    ContractDao contractDao;

    @Override
    public int add(Contract bean) {
        return contractDao.add(bean);
    }

    @Override
    public int update(Contract bean) {
        return contractDao.update(bean);
    }

    @Override
    public int delete(String id) {
        return contractDao.delete(id);
    }
}
