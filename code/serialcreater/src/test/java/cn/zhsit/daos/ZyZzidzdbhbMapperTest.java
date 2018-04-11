package cn.zhsit.daos;

import cn.zhsit.Application;
import cn.zhsit.enums.OrgEnum;
import cn.zhsit.models.po.ZyZzidzdbhb;
import cn.zhsit.utils.ZhsNumberUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 组织ID最大编号表
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@Component
public class ZyZzidzdbhbMapperTest extends BaseDao {
    @Autowired
    public ZyZzidzdbhbMapper zzidzdbhbMapper;

    @Test
    public void add() {
        OrgEnum zz[] = OrgEnum.values();
        for (OrgEnum z : zz) {
            ZyZzidzdbhb po = new ZyZzidzdbhb();
            po.setvZzlb(z.getZzlb());
            po.setvQsh(ZhsNumberUtil.getBitNum(OrgEnum.Length, z.getQsh()));
            po.setvJzh(ZhsNumberUtil.getBitNum(OrgEnum.Length, z.getJzh()));
            po.setvBz(z.getBz());
//          System.out.println(po.toString());
            zzidzdbhbMapper.insert(po);
        }

    }


    @Override
    @Test
    public void addAll() {
        add();
    }
}
