package cn.ifengkou.gaia.service;

import cn.ifengkou.gaia.model.CustomerPlan;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Sloong on 2015/12/17.
 */
public interface CustomerPlanService {

    List<CustomerPlan> getAuditedPlansByCustomerID(String customerID);
    List<CustomerPlan> getAuditingPlansByCustomerID(String customerID);

    List<CustomerPlan> getPlansByContractId(String contractID);

    int add(CustomerPlan bean);
    int update(CustomerPlan bean);
    int delete(String id);

    CustomerPlan get(String id);

    /**
     * 查询 今日 计划总数，计划总方量
     * @return
     */
    HashMap<String,Double> getTodayPlansGroupInfo();

    /**
     * 查询 今日 已审核计划信息列表
     * @return
     */
    List<CustomerPlan> getTodayAllAuditedPlans();
}
