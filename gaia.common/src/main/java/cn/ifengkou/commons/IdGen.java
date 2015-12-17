package cn.ifengkou.commons;

/**
 * Created by Sloong on 2015/12/10.
 */
public class IdGen {
    static final long idepo = System.currentTimeMillis() - 3600 * 1000L;

    public static String genId(){
        IdWorker idWorker = new IdWorker(idepo);
        return idWorker.getId()+"";
    }
}
