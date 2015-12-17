package cn.ifengkou.gaia.service;

import cn.ifengkou.gaia.model.Contract;

/**
 * Created by Sloong on 2015/12/17.
 */
public interface ContractService {
    int add(Contract bean);
    int update(Contract bean);
    int delete(String id);
}
