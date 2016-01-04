package cn.ifengkou.gaia.controller;

import cn.ifengkou.commons.IdGen;
import cn.ifengkou.commons.StringUtils;
import cn.ifengkou.gaia.common.JsonDto;
import cn.ifengkou.gaia.common.MyBeanUtils;
import cn.ifengkou.gaia.common._Sys;
import cn.ifengkou.gaia.controller.exception.ResourceIsNotExistException;
import cn.ifengkou.gaia.model.CustomerPlan;
import cn.ifengkou.gaia.service.ContractService;
import cn.ifengkou.gaia.service.CustomerPlanService;
import cn.ifengkou.gaia.service.ProjectService;
import com.github.pagehelper.PageHelper;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Sloong on 2015/12/30.
 */
@RestController
@RequestMapping("api/plans")
public class CustomerPlanController {
    @Resource
    ProjectService projectService;

    @Resource
    ContractService contractService;

    @Resource
    CustomerPlanService customerPlanService;

    @RequestMapping(method= RequestMethod.GET,value = "/audited")
    @ResponseBody
    public JsonDto getAuditedList(@RequestParam(value = "page",defaultValue = "1")int page,HttpServletRequest request) {
        //id,username,usertype
        HashMap<String,Object> user = (HashMap<String,Object>)request.getAttribute(_Sys.USER_KEY);
        String customerId = (String) user.get("id");
        PageHelper.startPage(page, _Sys.PAGE_SIZE);
        List<CustomerPlan> auditedList = customerPlanService.getAuditedPlansByCustomerID(customerId);
        return new JsonDto(true,auditedList);
    }

    @RequestMapping(method= RequestMethod.GET,value = "/auditing")
    @ResponseBody
    public JsonDto getAuditingList(@RequestParam(value = "page",defaultValue = "1")int page,HttpServletRequest request) {
        HashMap<String,Object> user = (HashMap<String,Object>)request.getAttribute(_Sys.USER_KEY);
        String customerId = (String) user.get("id");
        PageHelper.startPage(page, _Sys.PAGE_SIZE);
        List<CustomerPlan> auditingList = customerPlanService.getAuditingPlansByCustomerID(customerId);
        return new JsonDto(true,auditingList);
    }

    @RequestMapping(method= RequestMethod.POST,consumes = "application/json")
    @ResponseBody
    public JsonDto add(@RequestBody CustomerPlan plan,HttpServletRequest request){

        HashMap<String,Object> user = (HashMap<String,Object>)request.getAttribute(_Sys.USER_KEY);
        String userId = (String)user.get("id");
        String id = IdGen.genId();
        plan.setCustomerPlanID(id);
        plan.setBuilder(userId);
        plan.setBuildTime(new Date());

        int x1=customerPlanService.add(plan);

        if(x1 != 1) {
            return new JsonDto(false,"新增工地计划异常");
        }else{
            HashMap<String,String> map = new HashMap<>();
            map.put("customerPlanID",id);
            return new JsonDto(true,map);
        }

    }

    @RequestMapping(method= RequestMethod.PUT,value = "/{id}",consumes = "application/json")
    @ResponseBody
    public JsonDto update(@PathVariable("id")String id,@RequestBody CustomerPlan plan,HttpServletRequest request) throws ResourceIsNotExistException {
        CustomerPlan bean = customerPlanService.get(id);
        if(bean == null){
            throw new ResourceIsNotExistException();
        }
        if(bean.isAuditStatus()){
            return new JsonDto(false,"该计划已审核，无法修改，请联系站内人员");
        }
        if(StringUtils.notEmpty(plan.getContractID())) {
            bean.setContractID(plan.getContractID());
        }
        HashMap<String,Object> user = (HashMap<String,Object>)request.getAttribute(_Sys.USER_KEY);
        String userId = (String)user.get("id");
        bean.setModifier(userId);

        MyBeanUtils.copyProperties(plan, bean);

        /*if(StringUtils.notEmpty(plan.getProjectName())) {
            bean.setProjectName(plan.getProjectName());
        }
        if(StringUtils.notEmpty(plan.getProjectAddr())) {
            bean.setProjectAddr(plan.getProjectAddr());
        }
        if(StringUtils.notEmpty(plan.getProjectAddr())) {
            bean.setProjectAddr(plan.getProjectAddr());
        }
        if(StringUtils.notEmpty(plan.getTel())) {
            bean.setTel(plan.getTel());
        }
        if(StringUtils.notEmpty(plan.getConsPos())) {
            bean.setConsPos(plan.getConsPos());
        }
        if(plan.getPlanCube()>0) {
            bean.setPlanCube(plan.getPlanCube());
        }
        if(StringUtils.notEmpty(plan.getConStrength())) {
            bean.setConStrength(plan.getConStrength());
        }*/

        customerPlanService.update(bean);
        return new JsonDto(true,"修改成功",bean.getCustomerPlanID());
    }

    @RequestMapping(method= RequestMethod.DELETE,value = "/{id}")
    @ResponseBody
    public JsonDto delete(@PathVariable("id")String id,HttpServletRequest request) throws ResourceIsNotExistException {
        CustomerPlan bean = customerPlanService.get(id);
        if(bean == null){
            throw new ResourceIsNotExistException();
        }
        if(bean.isAuditStatus()){
            return new JsonDto(false,"该计划已审核，无法删除，请联系站内人员");
        }
        customerPlanService.delete(id);
        return new JsonDto(true,"删除成功",bean.getCustomerPlanID());
    }
}
