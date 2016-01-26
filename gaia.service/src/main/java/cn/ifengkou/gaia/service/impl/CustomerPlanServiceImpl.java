package cn.ifengkou.gaia.service.impl;

import cn.ifengkou.gaia.dao.CustomerPlanDao;
import cn.ifengkou.gaia.model.CustomerPlan;
import cn.ifengkou.gaia.service.CustomerPlanService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Sloong on 2015/12/17.
 */
@Service("customerPlanService")
public class CustomerPlanServiceImpl implements CustomerPlanService {
    @Resource
    CustomerPlanDao customerPlanDao;
    @Override
    public List<CustomerPlan> getAuditedPlansByCustomerID(String customerID) {
        return customerPlanDao.getAuditedPlansByCustomerID(customerID);
    }

    @Override
    public List<CustomerPlan> getAuditingPlansByCustomerID(String customerID) {
        return customerPlanDao.getAuditingPlansByCustomerID(customerID);
    }

    @Override
    public List<CustomerPlan> getPlansByContractId(String contractID) {
        return customerPlanDao.getPlansByContractId(contractID);
    }

    @Override
    public int add(CustomerPlan bean) {
        return customerPlanDao.add(bean);
    }

    @Override
    public int update(CustomerPlan bean) {
        return customerPlanDao.update(bean);
    }

    @Override
    public int delete(String id) {
        return customerPlanDao.delete(id);
    }

    @Override
    public CustomerPlan get(String id) {
        return customerPlanDao.get(id);
    }
}