package cn.zhsit.init;

import cn.zhsit.Application;
import org.databene.contiperf.PerfTest;
import org.databene.contiperf.Required;
import org.databene.contiperf.junit.ContiPerfRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by Administrator on 2017/5/15.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class})
public class InitApplicationListenerTest {
    InitApplicationListener init=null;
    @Rule
    public ContiPerfRule i = new ContiPerfRule();

    @Test
//    @PerfTest(invocations = 100, threads = 10)
//    @Required(max = 1000, average = 250, totalTime = 1000*20 )
    public void testInit(){
        System.out.println("初始化执行完毕-------------------");
    }
}
