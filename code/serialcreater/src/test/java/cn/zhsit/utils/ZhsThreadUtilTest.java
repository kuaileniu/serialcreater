package cn.zhsit.utils;

import org.databene.contiperf.PerfTest;
import org.databene.contiperf.Required;
import org.databene.contiperf.junit.ContiPerfRule;
import org.junit.AfterClass;
import org.junit.Rule;
import org.junit.Test;

import java.util.*;

public class ZhsThreadUtilTest {
    @Rule
    public ContiPerfRule i = new ContiPerfRule();


    @Test
    @PerfTest(invocations = 10000, threads = 100)
    @Required(max = 1000, average = 250, totalTime = 1000 * 20)
    public void testCurrentThreadId() {
        String id = ZhsThreadUtil.currentThreadId();
        System.out.println("id:"+id);
    }

    @AfterClass
    public static void print() {

    }
}
