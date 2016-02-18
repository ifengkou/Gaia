package cn.ifengkou.gaia.model;

import java.util.List;

/**
 * Created by Sloong on 2016/2/18.
 */
public class DispatchGroup {
    private String key;
    private List<DispatchList> list;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public List<DispatchList> getList() {
        return list;
    }

    public void setList(List<DispatchList> list) {
        this.list = list;
    }
}
