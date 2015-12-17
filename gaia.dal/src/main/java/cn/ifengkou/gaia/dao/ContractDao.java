package cn.ifengkou.gaia.dao;

import cn.ifengkou.gaia.model.Contract;
import org.springframework.stereotype.Repository;

/**
 * Created by Sloong on 2015/12/17.
 */
@Repository
public interface ContractDao {
    Contract get(String id);
    int add(Contract bean);
    int update(Contract bean);
    int delete(String id);
}
