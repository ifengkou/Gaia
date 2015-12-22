package cn.ifengkou.gaia.dao;

import cn.ifengkou.gaia.model.CustomerPlan;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Sloong on 2015/12/17.
 */
@Repository
public interface CustomerPlanDao {
    List<CustomerPlan> getAuditedPlansByCustomerID(String customerID);
    List<CustomerPlan> getAuditingPlansByCustomerID(String customerID);

    List<CustomerPlan> getPlansByContractId(HashMap<String,String> map);

    int add(CustomerPlan bean);
    int update(CustomerPlan bean);
    int delete(String id);
}
