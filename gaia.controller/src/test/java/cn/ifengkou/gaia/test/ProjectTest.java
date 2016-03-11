package cn.ifengkou.gaia.test;

import cn.ifengkou.gaia.model.Project;
import cn.ifengkou.gaia.service.DispatchListService;
import cn.ifengkou.gaia.service.ProjectService;
import com.github.pagehelper.PageHelper;
import junit.framework.Assert;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * Create by Sloong 2015/12/15
 */
public class ProjectTest extends SpringTest {
    @Resource
    ProjectService projectService;
    @Resource
    DispatchListService dispatchListService;

    @Test
    public void test_getList(){
        //long id = 15099503247360L;
        String id ="1";
        PageHelper.startPage(1, 1);
        List<Project> projects = projectService.getList(id);


        Assert.assertEquals(1,projects.size());
    }

    @Test
    public void test_stat(){
        HashMap<String,Object> map = dispatchListService.statDispatchList("y");

        Assert.assertEquals(30.0,map.get("produceCubes"));
    }
}
