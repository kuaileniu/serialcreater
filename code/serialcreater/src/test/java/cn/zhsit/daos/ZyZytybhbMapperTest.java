package cn.zhsit.daos;

import cn.zhsit.Application;
import cn.zhsit.enums.OrgEnum;
import cn.zhsit.models.po.ZyZytybhb;
import cn.zhsit.utils.ZhsNumberUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 资源统一编号表
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@Component
public class ZyZytybhbMapperTest extends BaseDao {
    @Autowired
    public ZyZytybhbMapper zyZytybhbMapper;
//    （1）单位代码统一分配
//        00,000,000富得益总部；
//        00,000,001-09,999,996保留；      ---------------------保留
//        09,999,997系统管理员(super);
//        09,999,998系统安全员(secsuper);
//        09,999,999系统审计员(auditsuper),
//        10，000，000-19，999，999物流中心、直销店、销售企业
//        20，000,000-29，999,999生产企业；
//        30,000,000-79,999,999用户；
//        80,000,000-99,999,999菜团


    /**
     * （2）产品规格分类
     “0000-0009”人员；
     “0010-0029”订单；
     “0030-0039”运单；
     “0040-0049”出入库单；
     “0050-0069”预留；
     “0070”管理批次
     “0071”视频头
     “0072”库房
     “0073”库位
     “0074”车辆；
     “0075”软硬件模块；
     “0076”结算单；
     “0077”支付单；
     “0078”论坛编号；
     “0079”帖子编号；
     “0080”相册编号
     “0081-0099”保留；
     “1000-1999”消息编号；
      “2000-2999”照片编号；
     “3000-3999”评论编号。
     “4000-4999”微博编号
     其它按单位类型不同，产品规格编号分类不同。
     生产企业： “5000-5999”零售规格包装号；“6000-6999”批发规格包装号；“7000-7999”生产批次号；“8000-8999”生产记录号；“9000-9999”其它记录。
     物流公司：“9000-9999”其它记录。
     直销店：“5000-5999”批发零售交易单；“6000-6999”退货交易单；“7000-7999”送货单；“9000-9999”其它记录。
     菜团：“5000-5999”活动；“9000-9999”其它记录。
     富德益： 专有业务 “5000-5999”
      */

    //00,000,000富得益总部；
    @Test
    public void testInsertFuDeYiZongBu() {
        ZyZytybhb po = new ZyZytybhb();
//        po.setvId("00000000");
        po.setvId(ZhsNumberUtil.getBitNum(OrgEnum.Length,OrgEnum.FuDeYiZongBu.getQsh()));
//        po.setvCplb();

        {  //产品分类
            //产品分类起号
            po.setvCpflqh("00000000");
            //产品分类当前号
            po.setvCpfldqh("00000000");
            //产品分类止号
            po.setvCpflzh("00000000");
        }

        { //编号
            po.setvQsh("00000000");
        }

        zyZytybhbMapper.insert(po);
    }

    //09,999,997系统管理员(super);
    @Test
    public void testInsertSuper() {
        ZyZytybhb po = new ZyZytybhb();
        po.setvId("09999997");
        zyZytybhbMapper.insert(po);
    }

    @Test
    public void testInsertAnQuan() {
//        09,999,998系统安全员(secsuper);
        ZyZytybhb po = new ZyZytybhb();
        po.setvId("09999998");
        zyZytybhbMapper.insert(po);
    }

    //  09,999,999系统审计员(auditsuper),
    @Test
    public void testInsertShenJi() {
        ZyZytybhb po = new ZyZytybhb();
        po.setvId("09999999");
        zyZytybhbMapper.insert(po);
    }

    //10，000，000-19，999，999物流中心、直销店、销售企业
    @Test
    public void testInsertWuLiuZhiXiaoXiaoShou() {
        ZyZytybhb po = new ZyZytybhb();
        po.setvId("10000000");
        zyZytybhbMapper.insert(po);
    }

    //        20，000,000-29，999,999生产企业；
    @Test
    public void testInsertShengChanQiYe() {
        ZyZytybhb po = new ZyZytybhb();
        po.setvId("20000000");
        zyZytybhbMapper.insert(po);
    }

    //30,000,000-79,999,999用户；
    @Test
    public void testInsertYongHu() {
        ZyZytybhb po = new ZyZytybhb();
        po.setvId("30000000");
        zyZytybhbMapper.insert(po);
    }

    //80,000,000-99,999,999菜团
    @Test
    public void testInsertCaiTuan() {
        ZyZytybhb po = new ZyZytybhb();
        po.setvId("80000000");
        zyZytybhbMapper.insert(po);
    }

    @Test
    public void addAll() {
        //得益总部
        testInsertFuDeYiZongBu();
        //系统管理员(super)
        testInsertSuper();
        //系统安全员(secsuper)
        testInsertAnQuan();
        //09,999,999系统审计员(auditsuper),
        testInsertShenJi();
        //10，000，000-19，999，999物流中心、直销店、销售企业
        testInsertWuLiuZhiXiaoXiaoShou();
        //20，000,000-29，999,999生产企业；
        testInsertShengChanQiYe();
        //30,000,000-79,999,999用户；
        testInsertYongHu();
        //80,000,000-99,999,999菜团
        testInsertCaiTuan();
    }
}
