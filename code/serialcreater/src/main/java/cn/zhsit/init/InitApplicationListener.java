package cn.zhsit.init;

import cn.zhsit.helpers.KeyHelper;
import cn.zhsit.services.OrgProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class InitApplicationListener implements ApplicationListener<ContextRefreshedEvent> {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private OrgProductService orgProductService;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if (event.getApplicationContext().getParent() == null) {
            //TODO业务逻辑

//            initTableOrgProduct();
        }
    }



    //检测最小的org和product，保持同一org  product 的记录不少于5个可用
    private void initTableOrgProduct() {
        try {
//            orgProductService.addOrgProductRDBIfLess5();
        } catch (Exception e) {
            logger.error("", e);
        }
    }

}
