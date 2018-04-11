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


@Component
@EnableScheduling
public class RDBDataTask {
    private final Logger log = LoggerFactory.getLogger(getClass());
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
    @Autowired
    private OrgProductService orgProductService;



    //检测最小的org和product，保持同一org  product 的记录不少于n个可用
    @Scheduled(cron = "*/20 * * * * ?")//每20秒
//    @Scheduled(fixedDelay = 1000*60*60)
    public void checkAddOrgProductTable() {
        try {
            int num=orgProductService.addOrgProductRDBIfLessN(3);
            System.out.println("checkAddOrgProductTable 添加记录数:"+num+"   "+ dateFormat.format(new Date()));
        } catch (Exception e) {
            log.error("定时任务器checkAddOrgProductTable", e);
        }
    }



    //检测最小的org和product，保持同一org  product 的记录不少于n个可用
    @Scheduled(cron = "*/20 * * * * ?")//每20秒
//    @Scheduled(fixedDelay = 1000*60*60)
    public void moveOrgProductTableToHistory() {
        try {
            int num=orgProductService.moveOrgProduct2His();
            System.out.println("checkAddOrgProductTable 添加记录数:"+num+"   "+ dateFormat.format(new Date()));
        } catch (Exception e) {
            log.error("定时任务器checkAddOrgProductTable", e);
        }
    }



}
