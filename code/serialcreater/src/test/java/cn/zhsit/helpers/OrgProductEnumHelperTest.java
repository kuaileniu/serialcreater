package cn.zhsit.helpers;

import cn.zhsit.annotations.Disable;
import cn.zhsit.enums.OrgEnum;
import cn.zhsit.enums.ProductEnum;
import org.junit.Test;
import java.util.List;

public class OrgProductEnumHelperTest {


    @Test
    public void testAllEnableOrgEnum() {
        List<OrgEnum> orgEns = OrgProductEnumHelper.allEnableOrgEnum(Disable.class);
        System.out.println(orgEns);
    }

    @Test
    public void testAllProductEnumByOrg() {
        List<ProductEnum> productEna = OrgProductEnumHelper.allProductEnumByOrg(OrgEnum.Audit,Disable.class);
        System.out.println(productEna);
    }




}
