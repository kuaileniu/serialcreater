package cn.zhsit.services.impl;

import cn.zhsit.enums.OrgEnum;
import cn.zhsit.models.vo.SerialReq;
import cn.zhsit.services.ZuZhiService;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;


@Service("serviceCollection")
public class ServiceCollection implements ApplicationContextAware {
    private ApplicationContext context;
    private volatile boolean inCollection = false;

    private Map<OrgEnum, ZuZhiService> zuZhiCollection = new HashMap();

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }

    private void initCollection() {
        if (!inCollection) {
            addService();
            inCollection = true;
        }
    }

    public ZuZhiService getZuZhiService(SerialReq serial) {
        initCollection();
        ZuZhiService zuZhiService = zuZhiCollection.get(OrgEnum.of(serial.getOrgCode()));
        if (zuZhiService == null) {
//            zuZhiService = zuZhiCollection.get(OrgEnum.Undefine);
        }
        return zuZhiService;
    }

    private void addService() {
//        zuZhiCollection.put(OrgEnum.Undefine, (ZuZhiService) context.getBean("undefineZuZhiService"));
        zuZhiCollection.put(OrgEnum.CaiTuan, (ZuZhiService) context.getBean("caiTuanZuZhiService"));
    }
}
