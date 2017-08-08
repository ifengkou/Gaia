package cn.ifengkou.gaia.controller;

import cn.ifengkou.commons.IdGen;
import cn.ifengkou.commons.StringUtils;
import cn.ifengkou.gaia.common.JsonDto;
import cn.ifengkou.gaia.common._Sys;
import cn.ifengkou.gaia.controller.exception.ResourceIsNotExistException;
import cn.ifengkou.gaia.model.Contract;
import cn.ifengkou.gaia.model.CustomerPlan;
import cn.ifengkou.gaia.model.Project;
import cn.ifengkou.gaia.service.ContractService;
import cn.ifengkou.gaia.service.CustomerPlanService;
import cn.ifengkou.gaia.service.ProjectService;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private final static Logger LOG = LoggerFactory.getLogger(ProjectController.class);


    @RequestMapping(method= RequestMethod.GET)
    @ResponseBody
    public JsonDto getList(@RequestParam(value = "page",defaultValue = "1")int page,HttpServletRequest request) {
        LOG.info("获取工地计划");
        //id,username,usertype
        HashMap<String,Object> user = (HashMap<String,Object>)request.getAttribute(_Sys.USER_KEY);
        PageHelper.startPage(page, _Sys.PAGE_SIZE);
        List<Project> projects = projectService.getList((String) user.get("id"));
        return new JsonDto(true,projects);
    }

    @RequestMapping(method= RequestMethod.POST,consumes = "application/json")
    @ResponseBody
    public JsonDto add(@RequestBody Project project,HttpServletRequest request){
        LOG.info("增加工程");
        if(StringUtils.isEmpty(project.getContractName())||StringUtils.isEmpty(project.getProjectName())){
            return new JsonDto(false,"合同名称和工程名称不可为空");
        }
        Project temp = projectService.getByName(project.getProjectName());
        if(temp !=null){
            return new JsonDto(false,"已存在相同名称的工程，请检查重试！");
        }
        HashMap<String,Object> user = (HashMap<String,Object>)request.getAttribute(_Sys.USER_KEY);
        String userId = (String)user.get("id");
        Contract contract = new Contract();
        String contractId = IdGen.genId();
        contract.setContractID(contractId);
        contract.setBuilder(userId);
        contract.setContractName(project.getContractName());
        contract.setCustomerID(userId);

        int x1=contractService.add(contract);

        if(x1 != 1) {
            return new JsonDto(false,"新增合同异常");
        }else{
            String projectId = IdGen.genId();
            project.setProjectID(projectId);
            project.setBuilder(userId);
            project.setContractID(contractId);
            projectService.add(project);

            HashMap<String,String> map = new HashMap<>();
            map.put("contractID",contractId);
            map.put("projectID",projectId);

            return new JsonDto(true,map);
        }

    }

    @RequestMapping(method= RequestMethod.PUT,value = "/{id}",consumes = "application/json")
    @ResponseBody
    public JsonDto update(@PathVariable("id")String id,@RequestBody Project project,HttpServletRequest request) throws ResourceIsNotExistException {
        LOG.info("更新工程");
        Project bean = projectService.get(id);
        if(bean == null){
            throw new ResourceIsNotExistException();
        }
        if(StringUtils.notEmpty(project.getProjectName())) {
            bean.setProjectName(project.getProjectName());
        }
        HashMap<String,Object> user = (HashMap<String,Object>)request.getAttribute(_Sys.USER_KEY);
        String userId = (String)user.get("id");
        bean.setProjectAddr(project.getProjectAddr());
        bean.setLinkMan(project.getLinkMan());
        bean.setModifier(userId);
        bean.setTel(project.getTel());
        projectService.update(bean);
        return new JsonDto(true,"修改成功",bean.getProjectID());
    }

    @RequestMapping(method= RequestMethod.DELETE,value = "/{id}")
    @ResponseBody
    public JsonDto delete(@PathVariable("id")String id,HttpServletRequest request) throws ResourceIsNotExistException {
        LOG.info("删除工程");
        Project bean = projectService.get(id);
        if(bean == null){
            throw new ResourceIsNotExistException();
        }
        String contractId = bean.getContractID();
        List<CustomerPlan> customerPlans = customerPlanService.getPlansByContractId(contractId);
        if(customerPlans !=null && customerPlans.size()>0){
            return new JsonDto(false,"该合同工程已存在工程计划");
        }
        projectService.deleteContractAndProject(contractId,id);
        HashMap<String,String> map = new HashMap<>();
        map.put("contractID", contractId);
        map.put("projectID", id);
        return new JsonDto(true,"删除成功",id);
    }
}
