package cn.ifengkou.commons.test;

import cn.ifengkou.commons.DecriptTools;
import org.junit.Assert;
import org.junit.Test;

import java.security.NoSuchAlgorithmException;

/**
 * Created by Sloong on 2015/12/16.
 */
public class Sha1Test {

    @Test
    public void test() throws NoSuchAlgorithmException {
        String password = "admin1";

        String sha1 = DecriptTools.SHA1(password);

        System.out.println(sha1);
        Assert.assertEquals("6C7CA345F63F835CB353FF15BD6C5E052EC08E7A",sha1.toUpperCase());
    }
}
