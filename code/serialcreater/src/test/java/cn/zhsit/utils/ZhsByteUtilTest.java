package cn.zhsit.utils;

import org.junit.Assert;
import org.junit.Test;


public class ZhsByteUtilTest {

    @Test
    public void testLong2Byte() {
        long ini=System.currentTimeMillis();
        System.out.println("init:\n"+ini);
        byte[] bb = ZhsByteUtil.long2Byte(ini);
        System.out.println(bb);
        long l = ZhsByteUtil.byte2Long(bb);
        System.out.println(l);
        Assert.assertEquals(ini,l);

    }
}
