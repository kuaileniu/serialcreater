package cn.zhsit.helpers;


import cn.zhsit.annotations.Global;
import cn.zhsit.annotations.Specified;
import cn.zhsit.enums.OrgEnum;
import cn.zhsit.enums.ProductEnum;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;

public class OrgProductEnumHelper {

    public static List<OrgEnum> allEnableOrgEnum(Class... disableAnnotations) {
        List<OrgEnum> list = new ArrayList<OrgEnum>();
        try {
            OrgEnum[] orgEns = OrgEnum.values();
            orgLoop:
            for (OrgEnum org : orgEns) {
                Annotation[] ans = OrgEnum.class.getDeclaredField(org.name()).getDeclaredAnnotations();
                for (Annotation a : ans) {
                    Class cs = a.annotationType();
                    for (Class clazz : disableAnnotations) {
                        if (cs.getName().equals(clazz.getName())) {
                            continue orgLoop;
                        }
                    }
                }
                list.add(org);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static List<ProductEnum> allProductEnumByOrg(OrgEnum org, Class... disableAnnotations) {
        List<ProductEnum> list = new ArrayList<ProductEnum>();
        ProductEnum[] pds = ProductEnum.values();

        try {
            productFieldLoop:
            for (ProductEnum pd : pds) {
                Annotation[] ans = ProductEnum.class.getDeclaredField(pd.name()).getDeclaredAnnotations();
                for (Annotation a : ans) {
                    Class cs = a.annotationType();
                    for (Class clazz : disableAnnotations) {
//                        System.out.println(cs.getName() + "       " + clazz.getName());
                        if (cs.getName().equals(clazz.getName())) {
                            continue productFieldLoop;
                        }
                    }
                }
                filedAnnotations:
                for (Annotation a : ans) {
                    Class cs = a.annotationType();
                    //排除Disable

                    //添加Global
                    if (cs.getName().equals(Global.class.getName())) {
                        list.add(pd);
                        continue productFieldLoop;
                    }
                    //添加Specified 中含自己的
                    if (cs.getName().equals(Specified.class.getName())) {
                        Specified sf = (Specified) a;
                        OrgEnum[] oes = sf.orgType();
                        for (OrgEnum oe : oes) {
//                            System.out.println("pd.name()" + pd.name() + "     oe.name():" + oe.name() + "  org.name():" + org.name());
                            if (org.name().equals(oe.name())) {
                                list.add(pd);
                                continue productFieldLoop;
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

}
