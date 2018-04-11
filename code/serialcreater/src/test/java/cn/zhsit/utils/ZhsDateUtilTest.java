package cn.zhsit.utils;

import org.junit.Test;
import java.util.Date;

public class ZhsDateUtilTest {

    @Test
    public void testAddDays() {
        Date date = ZhsDateUtil.addDays(new Date(), -1);
        System.out.println(ZhsJsonUtil.toJson(date));

    }

}
