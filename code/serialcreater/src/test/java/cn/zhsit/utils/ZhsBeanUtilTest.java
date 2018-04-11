package cn.zhsit.utils;

import cn.zhsit.models.vo.OrgProductVo;
import org.junit.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ZhsBeanUtilTest {

    @Test
    public void testMap2Bean() {
        Map<String, Object> map = new HashMap<>();
        OrgProductVo op = new OrgProductVo();
        map.put("recordOwnerExpireSeconds", 60);
        map.put("orgCode", "ct");
        ZhsBeanUtil.map2Bean(map, op);
        System.out.println(ZhsJsonUtil.toJson(op));
    }

    @Test
    public void testBean2Map(){
        OrgProductVo op=new OrgProductVo();
        op.setCreateTime(new Date());
        op.setRecordOwnerExpireSeconds(10);
        op.setRecordOwner(ZhsThreadUtil.currentThreadId());
        Map map=ZhsBeanUtil.bean2Map(op);
        System.out.println(ZhsJsonUtil.toJson(map));
    }
}
