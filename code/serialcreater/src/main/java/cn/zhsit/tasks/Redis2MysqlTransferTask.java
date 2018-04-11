package cn.zhsit.tasks;

import cn.zhsit.services.OrgProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import java.text.SimpleDateFormat;
import java.util.Date;

//http://mp.weixin.qq.com/s?__biz=MzA4ODIyMzEwMg==&mid=2447532919&idx=1&sn=da5ce7c03ee8151eae92d57d488b6e21&chksm=843bbf66b34c36700fef380ddb93c4340b461dcb9e7de61adbcd3f59dc714e0b155cbd65699b&scene=0#rd
@Component
@EnableScheduling
public class Redis2MysqlTransferTask {
    private final Logger log = LoggerFactory.getLogger(getClass());
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
    @Autowired
    private OrgProductService orgProductService;

    //设置最后资源号
    @Scheduled(fixedDelay = 1000 * 10)
    public void transSourceId() {
        try {
            int num=orgProductService.transOrgProduct2RDB();
            System.out.println("transSourceId 数据量:" +num+"  "+ dateFormat.format(new Date()));
        } catch (Exception e) {
            log.error("定时任务器Redis2MysqlTransfer.....", e);
        }
    }

}
