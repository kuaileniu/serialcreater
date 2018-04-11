package cn.zhsit.daos;

import cn.zhsit.Application;
import cn.zhsit.enums.ZhsLockEnum;
import cn.zhsit.models.po.ZhsLock;
import cn.zhsit.models.po.ZhsLockExample;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@Component
public class ZhsLockMapperTest extends BaseDao {

    @Autowired
    private ZhsLockMapper zhsLockMapper;

    @Test
    public void addZhsLocks() {

        ZhsLockExample sql=new ZhsLockExample();
        zhsLockMapper.deleteByExample(sql);

        ZhsLockEnum[] locks=ZhsLockEnum.values();
        for (ZhsLockEnum lock : locks) {
            ZhsLock zhsLock=new ZhsLock();
            zhsLock.setId(lock.tableId());
            zhsLock.setServiceId(lock.serviceId());
            zhsLock.setCreateTime(current);
            zhsLockMapper.insert(zhsLock);
        }
    }



    @Override
    public void addAll() throws Exception {
        addZhsLocks();
    }
}
