package cn.ifengkou.gaia.service;

import cn.ifengkou.gaia.model.Project;

import java.util.List;

/**
 * Created by Sloong on 2015/12/17.
 */
public interface ProjectService {
    Project get(String id);
    Project getByName(String name);
    List<Project> getList(String customerID);

    int add(Project bean);
    int update(Project bean);
    int delete(String id);
}
