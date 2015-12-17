package cn.ifengkou.gaia.controller;

import cn.ifengkou.commons.IdGen;
import cn.ifengkou.commons.StringUtils;
import cn.ifengkou.gaia.common.JsonDto;
import cn.ifengkou.gaia.common._Sys;
import cn.ifengkou.gaia.exception.IllegalException;
import cn.ifengkou.gaia.model.Contract;
import cn.ifengkou.gaia.model.CustomerPlan;
import cn.ifengkou.gaia.model.Project;
import cn.ifengkou.gaia.service.ContractService;
import cn.ifengkou.gaia.service.CustomerPlanService;
import cn.ifengkou.gaia.service.ProjectService;
import com.github.pagehelper.PageHelper;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Sloong on 2015/12/17.
 */
@RestController
@RequestMapping("api/projects")
public class ProjectController {

    @Resource
    ProjectService projectService;

    @Resource
    ContractService contractService;

    @Resource
    CustomerPlanService customerPlanService;

    @RequestMapping(method= RequestMethod.GET)
    @ResponseBody
    public JsonDto getList(@RequestParam(value = "page",defaultValue = "1")int page,HttpServletRequest request) throws IllegalException {
        //id,username,usertype
        HashMap<String,Object> user = (HashMap<String,Object>)request.getAttribute(_Sys.USER_KEY);
        PageHelper.startPage(page, _Sys.PAGE_SIZE);
        List<Project> projects = projectService.getList((String) user.get("id"));
        return new JsonDto(true,projects);
    }

    @RequestMapping(method= RequestMethod.POST)
    @ResponseBody
    public JsonDto add(Project project,HttpServletRequest request){
        if(StringUtils.isEmpty(project.getContractName())||StringUtils.isEmpty(project.getProjectName())){
            return new JsonDto(false,"合同名称和项目名称不能为空");
        }
        Project temp = projectService.getByName(project.getProjectName());
        if(temp !=null){
            return new JsonDto(false,"已存在相同名称的项目，请检查后重试");
        }
        HashMap<String,Object> user = (HashMap<String,Object>)request.getAttribute(_Sys.USER_KEY);
        Contract contract = new Contract();
        String contractId = IdGen.genId();
        contract.setContractID(contractId);
        contract.setContractName(project.getContractName());
        contract.setCustomerID((String) user.get("id"));

        int x1=contractService.add(contract);

        if(x1 != 1) {
            return new JsonDto(false,"增加合同失败");
        }else{
            String projectId = IdGen.genId();
            project.setProjectID(projectId);
            project.setContractID(contractId);
            projectService.add(project);

            HashMap<String,String> map = new HashMap<>();
            map.put("contractID",contractId);
            map.put("projectID",projectId);

            return new JsonDto(true,map);
        }

    }

    @RequestMapping(method= RequestMethod.PUT)
    @ResponseBody
    public JsonDto update(Project project) throws IllegalException {
        Project bean = projectService.get(project.getProjectID());
        if(bean == null){
            throw new IllegalException("工程不存在");
        }
        bean.setProjectName(project.getProjectName());
        bean.setProjectAddr(project.getProjectAddr());
        bean.setLinkMan(project.getLinkMan());
        bean.setTel(project.getTel());
        projectService.update(bean);
        return new JsonDto(true,project.getProjectID());
    }

    @RequestMapping(method= RequestMethod.DELETE,value = "/{id}")
    @ResponseBody
    public JsonDto delete(@PathVariable("id")String id,HttpServletRequest request) throws IllegalException {
        Project bean = projectService.get(id);
        if(bean == null){
            throw new IllegalException("工程不存在");
        }
        HashMap<String,Object> user = (HashMap<String,Object>)request.getAttribute(_Sys.USER_KEY);
        List<CustomerPlan> customerPlans = customerPlanService.getPlansByProjectID((String) user.get("id"),id);
        if(customerPlans !=null && customerPlans.size()>0){
            return new JsonDto(false,"已存在工地计划，不能被删除");
        }
        projectService.delete(id);
        return new JsonDto(true,"删除成功",id);
    }
}
