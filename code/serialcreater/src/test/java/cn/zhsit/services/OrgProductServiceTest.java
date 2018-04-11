package cn.zhsit.services;

import cn.zhsit.Application;
import cn.zhsit.daos.BaseDao;
import cn.zhsit.daos.DaoForTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class})
public class OrgProductServiceTest extends BaseDao {

    @Autowired
    private OrgProductService orgProductService;
    @Autowired
    private DaoForTest daoForTest;
    @Test
    public void testAddOrgProductRDBIfLessN(){
        int num=orgProductService.addOrgProductRDBIfLessN(3);
        System.out.println("addOrgProductRDBIfLessN 数量："+num);
    }

    @Override
    @Test
    public void addAll() throws Exception {
        daoForTest.truncateTableOrgProduct();
        testAddOrgProductRDBIfLessN();
    }
}
