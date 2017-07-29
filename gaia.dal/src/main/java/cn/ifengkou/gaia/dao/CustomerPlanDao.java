package cn.ifengkou.gaia.dao;

import cn.ifengkou.gaia.model.CustomerPlan;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Sloong on 2015/12/17.
 */
@Repository
public interface CustomerPlanDao {
    List<CustomerPlan> getAuditedPlansByCustomerID(String customerID);
    List<CustomerPlan> getAuditingPlansByCustomerID(String customerID);

    List<CustomerPlan> getPlansByContractId(String contractId);

    int add(CustomerPlan bean);
    int update(CustomerPlan bean);
    int delete(String id);

    CustomerPlan get(String id);

    //以下为站内功能

    HashMap<String,Double> getPlansGroupInfo(Map map);

    List<CustomerPlan> getAllAuditedPlans(Map map);
}
