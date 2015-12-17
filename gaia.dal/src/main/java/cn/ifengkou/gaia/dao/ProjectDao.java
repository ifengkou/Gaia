package cn.ifengkou.gaia.dao;

import cn.ifengkou.gaia.model.Project;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Sloong on 2015/12/17.
 */
@Repository
public interface ProjectDao {

    Project get(String id);
    List<Project> getList(String customerID);

    int add(Project bean);
    int update(Project bean);
    int delete(String id);

    Project getByName(String name);
}
