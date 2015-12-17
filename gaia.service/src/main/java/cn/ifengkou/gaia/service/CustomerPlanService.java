package cn.ifengkou.gaia.service;

import cn.ifengkou.gaia.model.CustomerPlan;

import java.util.List;

/**
 * Created by Sloong on 2015/12/17.
 */
public interface CustomerPlanService {

    List<CustomerPlan> getAuditedPlansByCustomerID(String customerID);
    List<CustomerPlan> getAuditingPlansByCustomerID(String customerID);

    List<CustomerPlan> getPlansByProjectID(String customerID,String projectID);

    int add(CustomerPlan bean);
    int update(CustomerPlan bean);
    int delete(String id);
}
