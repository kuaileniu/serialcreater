package cn.zhsit.helpers;

import cn.zhsit.enums.OrgEnum;
import cn.zhsit.enums.ProductEnum;
import cn.zhsit.enums.SourceEnum;
import cn.zhsit.models.po.OrgProduct;
import cn.zhsit.utils.ZhsNumberUtil;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class SerialHelper {

    public String serial(OrgProduct orgProduct) {
        String org=ZhsNumberUtil.getBitNum(OrgEnum.Length,orgProduct.getOrgId());
        String product = ZhsNumberUtil.getBitNum(ProductEnum.Length, orgProduct.getProductId());
        String sourceId = ZhsNumberUtil.getBitNum(SourceEnum.Length, orgProduct.getLastSourceId());
        return org+product+sourceId;
    }

    public String serial(Map<String,String> orgProduct) {
        String org=ZhsNumberUtil.getBitNum(OrgEnum.Length,orgProduct.get("orgId"));
        String product = ZhsNumberUtil.getBitNum(ProductEnum.Length, orgProduct.get("productId"));
        String sourceId = ZhsNumberUtil.getBitNum(SourceEnum.Length, orgProduct.get("lastSourceId"));
        return org+product+sourceId;
    }
}
