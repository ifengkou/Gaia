package cn.ifengkou.gaia.service.impl;

import cn.ifengkou.commons.DateTools;
import cn.ifengkou.gaia.dao.CustomerPlanDao;
import cn.ifengkou.gaia.model.CustomerPlan;
import cn.ifengkou.gaia.service.CustomerPlanService;
import org.apache.commons.lang.time.DateUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
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

    @Override
    public HashMap<String, Double> getTodayPlansGroupInfo() {
        Date date = DateTools.getBeginOfCurrentDay();

        HashMap<String,Object> map = new HashMap<>();
        map.put("beginTime",date);
        map.put("endTime", DateUtils.addDays(date, 1));
        return customerPlanDao.getPlansGroupInfo(map);
    }

    @Override
    public List<CustomerPlan> getTodayAllAuditedPlans() {
        Date date = DateTools.getBeginOfCurrentDay();

        HashMap<String,Object> map = new HashMap<>();
        map.put("beginTime",date);
        map.put("endTime", DateUtils.addDays(date, 1));
        return customerPlanDao.getAllAuditedPlans(map);
    }

    @Override
    public HashMap<String, Double> getTomorrowPlansGroupInfo() {
        Date date = DateTools.getBeginOfCurrentDay();

        HashMap<String,Object> map = new HashMap<>();
        map.put("beginTime",DateUtils.addDays(date, 1));
        map.put("endTime", DateUtils.addDays(date, 2));
        return customerPlanDao.getPlansGroupInfo(map);
    }

    @Override
    public List<CustomerPlan> getTomorrowAllAuditedPlans() {
        Date date = DateTools.getBeginOfCurrentDay();

        HashMap<String,Object> map = new HashMap<>();
        map.put("beginTime",DateUtils.addDays(date, 1));
        map.put("endTime", DateUtils.addDays(date, 2));
        return customerPlanDao.getAllAuditedPlans(map);
    }

    @Override
    public HashMap<String, Double> getPlansGroupInfo(String beginTime, String endTime) {
        HashMap<String,Object> map = new HashMap<>();
        map.put("beginTime",beginTime);
        map.put("endTime", endTime);
        return customerPlanDao.getPlansGroupInfo(map);
    }

    @Override
    public List<CustomerPlan> getAllAuditedPlans(String beginTime, String endTime) {
        HashMap<String,Object> map = new HashMap<>();
        map.put("beginTime",beginTime);
        map.put("endTime", endTime);
        return customerPlanDao.getAllAuditedPlans(map);
    }
}
