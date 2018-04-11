package cn.zhsit.daos;

import cn.zhsit.Application;
import cn.zhsit.enums.ZhsLockEnum;
import cn.zhsit.models.po.ZhsLockPO;
import cn.zhsit.utils.ZhsThreadUtil;
import org.databene.contiperf.PerfTest;
import org.databene.contiperf.junit.ContiPerfRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class})
public class ZhsLockDaoTest extends BaseDao {
    @Rule
    public ContiPerfRule ie = new ContiPerfRule();
    @Autowired
    private ZhsLockDao zhsLockDao;

    @Test
    @PerfTest(invocations = 20, threads = 20)
    public void testLock() throws Exception {
        ZhsLockPO po = new ZhsLockPO();
        po.setId(ZhsLockEnum.OrgProductInsertLock.tableId());
        po.setRecordOwner(ZhsThreadUtil.currentThreadId());
        po.setSeconds(60);
        int lockNum = zhsLockDao.lock(po);
        System.out.println("lockNum:" + lockNum);
        if (lockNum == 1) {
            Thread.sleep(1000 * 2);
        }
    }

    @Test
    @PerfTest(invocations = 20, threads = 20)
    public void testUnlock() throws Exception {
        ZhsLockPO po = new ZhsLockPO();
        po.setId(ZhsLockEnum.OrgProductInsertLock.tableId());
        po.setRecordOwner(ZhsThreadUtil.currentThreadId());
        po.setSeconds(60);
        int lock = zhsLockDao.lock(po);
        int unLock = zhsLockDao.releaseLock(po);
        int lock2 = zhsLockDao.lock(po);
        System.out.println("lock:" + lock + "   releaseLock:" + unLock + "  第二次lock:" + lock2);
        if (lock2 == 1) {
            Thread.sleep(1000 * 2);
            System.out.println("在规定的时间内最多有一个第二次lock成功");
        }

    }

    @Override
    public void addAll() throws Exception {

    }
}
