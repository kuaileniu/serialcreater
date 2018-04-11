package cn.zhsit.helpers;

import cn.zhsit.Application;
import cn.zhsit.enums.OrgEnum;
import cn.zhsit.enums.ProductEnum;
import cn.zhsit.enums.TableId;
import org.databene.contiperf.PerfTest;
import org.databene.contiperf.Required;
import org.databene.contiperf.junit.ContiPerfRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/5/15.
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class})
public class KeyHelperTest {
    @Rule
    public ContiPerfRule i = new ContiPerfRule();

    @Resource
    private KeyHelper keyHelper;

    @Test
    public void createKey() {
        int max = 0;
        int count = 0;
        OrgEnum[] zzs = OrgEnum.values();
        for (OrgEnum zz : zzs) {
            ProductEnum[] canPins = ProductEnum.values();
            for (ProductEnum canPin : canPins) {
                String key = keyHelper.getSourceKey(zz, canPin);
                System.out.println(key + (++count));
                max = max > key.length() ? max : key.length();
            }
        }

        System.out.println("max:" + max);
    }


    @Test
    @PerfTest(invocations = 1000, threads = 10)
    @Required(max = 1000, average = 250, totalTime = 1000*20 )
    public void testTableIdCreate() {
        Long id = keyHelper.tableIdCreate(TableId.TableHistory);
        System.out.println("TableId.TableHistory:" + id);
    }
}
