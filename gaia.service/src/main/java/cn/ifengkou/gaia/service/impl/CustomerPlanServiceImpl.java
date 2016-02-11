package cn.ifengkou.gaia.service.impl;

import cn.ifengkou.gaia.dao.CustomerPlanDao;
import cn.ifengkou.gaia.model.CustomerPlan;
import cn.ifengkou.gaia.service.CustomerPlanService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.TimeZone;

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

    @Override
    public HashMap<String, Double> getTodayPlansGroupInfo() {
        long current=System.currentTimeMillis();//当前时间毫秒数
        long zero=current/(1000*3600*24)*(1000*3600*24)- TimeZone.getDefault().getRawOffset();//今天零点零分零秒的毫秒数
        return customerPlanDao.getPlansGroupInfo(new Date(zero));
    }

    @Override
    public List<CustomerPlan> getTodayAllAuditedPlans() {
        long current=System.currentTimeMillis();//当前时间毫秒数
        long zero=current/(1000*3600*24)*(1000*3600*24)- TimeZone.getDefault().getRawOffset();//今天零点零分零秒的毫秒数
        return customerPlanDao.getAllAuditedPlans(new Date(zero));
    }
}
