package cn.ifengkou.gaia.test;

import cn.ifengkou.commons.DecriptTools;
import cn.ifengkou.commons.StringUtils;
import cn.ifengkou.commons.UUIDTools;
import cn.ifengkou.gaia.service.UserService;
import junit.framework.Assert;
import org.junit.Test;

import javax.annotation.Resource;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;

/**
 * Create by Sloong 2015/12/15
 */
public class UserTest extends SpringTest {
    @Resource
    UserService userService;

    @Test
    public void test_getUser() throws NoSuchAlgorithmException {
        //long id = 15099503247360L;
        String id ="admin";
        HashMap<String,Object> user = userService.get(id);

        Assert.assertEquals(id,user.get("UserID"));
    }

    @Test
    public void test_userLogin(){
        String name = "admin";
        String pass = "admin1";

        HashMap<String,Object> user = userService.getUserByName(name);
        if(user!=null){
            String password = (String)user.get("Password");
            //TODO pass后台加密 方便测试
            pass = DecriptTools.SHA1(pass).toUpperCase();

            if(StringUtils.notEmpty(password)&&password.equals(pass)){
                user.remove("Password");

                //如果用户token为空
                String token = (String)user.get("Token");
                if(StringUtils.isEmpty(token)){
                    token = UUIDTools.uuid();

                    userService.genUserToken(name,token);

                    user.put("Token",token);
                }

                System.out.println(user.get("UserID")+","+user.get("Token"));
            }
            Assert.assertEquals(name,user.get("UserID"));
        }
    }

    /*@Test
    public void test_addUser(){

        LoginData user = userService.getUserByLoginName(TestData.loginName);
        if(user == null){
            user = new LoginData();

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
        LoginData user = userService.getUserByLoginName(loginName);
        if(user!=null) {
            long userId = user.getId();
            List<TopicCollect> collects = userService.getCollectTopicByUserId(userId);
            System.out.print(collects.get(0).getTopic().getAuthor().getName());
            Assert.assertEquals(2, collects.size());
        }
    }*/
}
