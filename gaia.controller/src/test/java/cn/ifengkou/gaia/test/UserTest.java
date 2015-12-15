package cn.ifengkou.gaia.test;

import cn.ifengkou.gaia.service.UserService;
import junit.framework.Assert;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.HashMap;

/**
 * Create by Sloong 2015/12/15
 */
public class UserTest extends SpringTest {
    @Resource
    UserService userService;

    @Test
    public void test_getUser(){
        long id = 15099503247360L;
        HashMap<String,Object> user = userService.get(id);

        Assert.assertEquals(id,user.get("id"));
    }

    /*@Test
    public void test_addUser(){

        User user = userService.getUserByLoginName(TestData.loginName);
        if(user == null){
            user = new User();

            user.setId(IdGen.genId());
            user.setLoginName(TestData.loginName);
            user.setName(TestData.loginName);
            String pass = "123456";
            user.setPass(MD5Utils.md5Encode(pass));
            user.setAccessToken(UUIDTools.uuid());
            userService.add(user);
        }

    }

    *//**
     * 测试用户收藏的topic集合
     *//*
    @Test
    public void getCollectionByUserId(){
        String loginName = "admin";
        User user = userService.getUserByLoginName(loginName);
        if(user!=null) {
            long userId = user.getId();
            List<TopicCollect> collects = userService.getCollectTopicByUserId(userId);
            System.out.print(collects.get(0).getTopic().getAuthor().getName());
            Assert.assertEquals(2, collects.size());
        }
    }*/
}
