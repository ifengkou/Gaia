package cn.ifengkou.gaia.test;

import cn.ifengkou.commons.IdGen;
import cn.ifengkou.gaia.common.MyBeanUtils;
import cn.ifengkou.gaia.model.CustomerPlan;
import cn.ifengkou.gaia.service.CustomerPlanService;
import cn.ifengkou.gaia.service.DicService;
import com.github.pagehelper.PageHelper;
import junit.framework.Assert;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Sloong on 2015/12/30.
 */
public class PlanTest extends SpringTest {
    @Resource
    CustomerPlanService customerPlanService;

    @Resource
    DicService dicService;

    @Test
    public void test_getList() {
        //long id = 15099503247360L;
        String id = "1";
        PageHelper.startPage(1, 1);
        List<CustomerPlan> beans = customerPlanService.getAuditedPlansByCustomerID(id);


        Assert.assertEquals(1, beans.size());
    }

    @Test
    public void test_add() {
        List<HashMap<String, Object>> dics = dicService.getDics();
        List<HashMap<String, Object>> casModes = new ArrayList<>();
        List<HashMap<String, Object>> slumps = new ArrayList<>();
        List<HashMap<String, Object>> consPos = new ArrayList<>();
        for (HashMap<String, Object> map : dics) {
            if (map.get("parentId").equals("CastMode")) {
                casModes.add(map);
            } else if (map.get("parentId").equals("Slump")) {
                slumps.add(map);
            } else if (map.get("parentId").equals("ConsPos")) {
                consPos.add(map);
            }
        }
        List<HashMap<String, Object>> conStrengths = dicService.getConStrengths();

        CustomerPlan plan = new CustomerPlan();

        plan.setCustomerPlanID(IdGen.genId());

        plan.setContractID("369296085262336");
        plan.setProjectName("哭录取推荐");
        plan.setProjectAddr("金龙鱼");
        plan.setConsPos((String) consPos.get(0).get("dicName"));
        plan.setSlump((String) slumps.get(0).get("dicName"));
        plan.setCastMode((String) casModes.get(0).get("dicName"));

        plan.setPlanDate(new Date());

        plan.setNeedDate("12:00");
        plan.setPlanCube(2000);

        plan.setLinkMan("123xu");

        plan.setConStrength((String) conStrengths.get(0).get("dicName"));

        customerPlanService.add(plan);

        CustomerPlan bean = new CustomerPlan();

        bean.setPlanCube(3000);

        MyBeanUtils.copyProperties(bean, plan);

        customerPlanService.update(plan);

        CustomerPlan bean2 = customerPlanService.get(plan.getCustomerPlanID());

        Assert.assertEquals(3000.00, bean2.getPlanCube());
    }


    @Test
    public void test_update() {
        CustomerPlan bean2 = customerPlanService.get("15099519893504");

        CustomerPlan bean = new CustomerPlan();

        bean.setPlanCube(4000);

        bean.setPlanDate(new Date());

        MyBeanUtils.copyProperties(bean, bean2);

        customerPlanService.update(bean2);

        CustomerPlan bean3 = customerPlanService.get("15099519893504");

        Assert.assertEquals(4000.00, bean3.getPlanCube());
    }

    @Test
    public void test_today(){
        List<CustomerPlan> todayList = customerPlanService.getTodayAllAuditedPlans();

        Assert.assertEquals(3,todayList);
    }
}
