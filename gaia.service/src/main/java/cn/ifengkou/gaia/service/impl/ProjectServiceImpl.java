package cn.ifengkou.gaia.service.impl;

import cn.ifengkou.gaia.dao.ContractDao;
import cn.ifengkou.gaia.dao.ProjectDao;
import cn.ifengkou.gaia.model.Project;
import cn.ifengkou.gaia.service.ProjectService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Sloong on 2015/12/17.
 */
@Service("projectService")
public class ProjectServiceImpl implements ProjectService {
    @Resource
    ProjectDao projectDao;

    @Resource
    ContractDao contractDao;

    @Override
    public Project get(String id) {
        return projectDao.get(id);
    }

    @Override
    public Project getByName(String name) {
        return projectDao.getByName(name);
    }

    @Override
    public List<Project> getList(String customerID) {
        return projectDao.getList(customerID);
    }

    @Override
    public int add(Project bean) {


        return projectDao.add(bean);
    }

    @Override
    public int update(Project bean) {
        return projectDao.update(bean);
    }

    @Override
    public int delete(String id) {
        return projectDao.delete(id);
    }
}
