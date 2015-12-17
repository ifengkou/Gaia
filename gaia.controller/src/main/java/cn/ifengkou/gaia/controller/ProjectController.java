package cn.ifengkou.gaia.controller;

import cn.ifengkou.gaia.common.JsonDto;
import cn.ifengkou.gaia.common._Sys;
import cn.ifengkou.gaia.exception.IllegalException;
import cn.ifengkou.gaia.model.Project;
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
@RequestMapping("api")
public class ProjectController {

    @Resource
    ProjectService projectService;

    @RequestMapping(method= RequestMethod.GET,value = "/projects")
    @ResponseBody
    public JsonDto getList(@RequestParam(value = "page",defaultValue = "1")int page,HttpServletRequest request) throws IllegalException {
        //id,username,usertype
        HashMap<String,Object> user = (HashMap<String,Object>)request.getAttribute(_Sys.USER_KEY);
        PageHelper.startPage(page, _Sys.PAGE_SIZE);
        List<Project> projects = projectService.getList((String) user.get("id"));
        return new JsonDto(true,projects);
    }
}
