package cn.ifengkou.gaia.test;

import cn.ifengkou.gaia.service.DicService;
import junit.framework.Assert;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Sloong on 2015/12/30.
 */
public class DicTest extends SpringTest {

    @Resource
    DicService dicService;

    @Test
    public void test_getList() {
        List<HashMap<String,Object>> dics = dicService.getDics();

        Assert.assertEquals(1, dics.size());
    }

}
