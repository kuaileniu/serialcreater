//package cn.zhsit;
//
//import cn.zhsit.daos.ZyZytybhbMapperTest;
//import cn.zhsit.daos.ZyZzidzdbhbMapperTest;
//import cn.zhsit.enums.ChanPinFenLei;
//import cn.zhsit.enums.ZuZhi;
//import cn.zhsit.helpers.KeyHelper;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import javax.annotation.Resource;
//
///**
// * Created by Administrator on 2017/5/15.
// */
//
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = {Application.class})
//public class CreateKeyMap {
//    @Resource
//    private KeyHelper keyHelper;
//
//    @Test
//    public void createKey() {
//        int max = 0;
//        int count = 0;
//        ZuZhi[] zzs = ZuZhi.values();
//        for (ZuZhi zz : zzs) {
//            ChanPinFenLei[] canPins = ChanPinFenLei.values();
//            for (ChanPinFenLei canPin : canPins) {
//                String key = keyHelper.getKey(zz, canPin);
//                System.out.println(key + (++count));
//                max = max > key.length() ? max : key.length();
//            }
//        }
//
//        System.out.println("max:" + max);
//    }
//}
