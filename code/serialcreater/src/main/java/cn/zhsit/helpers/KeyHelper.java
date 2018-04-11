package cn.zhsit.helpers;

import cn.zhsit.constants.ZhsConstants;
import cn.zhsit.enums.OrgEnum;
import cn.zhsit.enums.ProductEnum;
import cn.zhsit.enums.TableId;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class KeyHelper {
    private static final String separator = "_";
    @Resource
    private RedisHelper redisHelper;

    public  String getSourceKey(OrgEnum org, ProductEnum product) {
        return org.getZzlb()+separator+product.getCplb()+separator+"sourceId";
    }
    public String getOrgProductRecordKey(OrgEnum org, ProductEnum product){
        return org.getZzlb()+separator+product.getCplb()+separator+"record";
    }

    public String getOrgProductHistoryListKey(){
        return "list_org_product_his";
    }

    public Long tableIdCreate(TableId table) {
       return redisHelper.incr(table.id());
//        return redisHelper.increment(table.id());
    }


    public String currentId(){
        return ZhsConstants.SystemId+separator+Thread.currentThread().getId();
    }
}
