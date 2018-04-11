package cn.zhsit.helpers;

import cn.zhsit.Application;
import org.databene.contiperf.PerfTest;
import org.databene.contiperf.Required;
import org.databene.contiperf.junit.ContiPerfRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class})
public class ListOpsHelperTest {
    @Rule
    public ContiPerfRule i = new ContiPerfRule();
    @Autowired
    private ListOpsHelper listOpsHelper;

    static Map map = new HashMap<>(1000);


    @PerfTest(invocations = 10000, threads = 20)
    @Required(max = 1000, average = 250, totalTime = 1000*20 )
    @Test
    public void testLeftPush() {
        String key = "iven";
        String value = "darren"+new Random().nextLong();
        listOpsHelper.leftPush(key, value);
    }

}
