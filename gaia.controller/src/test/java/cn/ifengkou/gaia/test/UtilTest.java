package cn.ifengkou.gaia.test;

import cn.ifengkou.commons.DateTools;
import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.commons.lang.time.DateUtils;
import org.junit.Test;

import java.util.Date;

/**
 * @author shenlongguang<https://github.com/ifengkou>
 * @date 2017/7/29
 */
public class UtilTest {

    @Test
    public void testGetBeginOfCurrentDay(){
        Date date = DateTools.getBeginOfCurrentDay();
        System.out.println(DateFormatUtils.ISO_DATETIME_FORMAT.format(date));
        System.out.println(DateFormatUtils.ISO_DATETIME_FORMAT.format(DateUtils.addDays(date, 1)));
    }
}
