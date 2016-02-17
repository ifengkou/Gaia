package cn.ifengkou.commons.test;

import cn.ifengkou.commons.DateTools;
import junit.framework.Assert;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * Created by Sloong on 2016/2/16.
 */
public class DateToolsTest {
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss E");
    @Test
    public void test() {
        Date firstOfMonth = DateTools.getFirstDayCurrentMonth();
        System.out.println(firstOfMonth.getTime());
        System.out.println(format.format(firstOfMonth));
        System.out.println(firstOfMonth.getTime());

        Date firstOfYear = DateTools.getFirstDayOfCurrentYear();
        System.out.println(firstOfYear.getTime());
        System.out.println(format.format(firstOfYear));

        Date firstOfDay = DateTools.getBeginOfCurrentDay();
        System.out.println(firstOfDay.getTime());
        System.out.println(format.format(firstOfDay));

        Assert.assertEquals(0,0);
    }
}
