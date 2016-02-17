package cn.ifengkou.commons;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by Sloong on 2016/2/16.
 */
public class DateTools {
    public static Date getFirstDayCurrentMonth(){
        Calendar c = Calendar.getInstance();
        //c.add(Calendar.MONTH, 0);
        c.set(Calendar.DAY_OF_MONTH,1);//设置为1号,当前日期既为本月第一天
        c.set(Calendar.HOUR_OF_DAY,0);
        c.set(Calendar.MINUTE,0);
        c.set(Calendar.SECOND,0);
        c.set(Calendar.MILLISECOND,0);

        return c.getTime();
    }

    public static Date getFirstDayOfCurrentYear(){
        Calendar c = Calendar.getInstance();
        //c.add(Calendar.MONTH, 0);
        c.set(Calendar.MONTH,Calendar.JANUARY);
        c.set(Calendar.DAY_OF_MONTH, 1);//设置为1号,当前日期既为本月第一天
        c.set(Calendar.HOUR_OF_DAY,0);
        c.set(Calendar.MINUTE,0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND,0);

        return c.getTime();
    }

    public static Date getBeginOfCurrentDay(){
        long current=System.currentTimeMillis();//当前时间毫秒数
        long zero=current/(1000*3600*24)*(1000*3600*24)- TimeZone.getDefault().getRawOffset();//今天零点零分零秒的毫秒数
        return new Date(zero);
    }
}
