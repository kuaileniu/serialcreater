package cn.zhsit.utils;

import io.swagger.models.auth.In;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhsit on 2016/8/21.
 */
public class ZhsBeanUtil {



    // Map --> Bean 1: 利用Introspector,PropertyDescriptor实现 Map --> Bean
    public static void map2Bean(Map<String, Object> map, Object obj) {
        try {
            BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            for (PropertyDescriptor property : propertyDescriptors) {
                String key = property.getName();
                if (map.containsKey(key)) {
                    Object value = map.get(key);
                    // 得到property对应的setter方法
                    Method setter = property.getWriteMethod();
                    setter.invoke(obj, value);
                }
            }
        } catch (Exception e) {
            System.out.println("map2Bean Error " + e);
        }
        return;
    }

    // Bean --> Map 1: 利用Introspector和PropertyDescriptor 将Bean --> Map
    public static Map<String, Object> bean2Map(Object obj) {
        if (obj == null) {
            return null;
        }
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            for (PropertyDescriptor property : propertyDescriptors) {
                String key = property.getName();
                // 过滤class属性
                if (!key.equals("class")) {
                    // 得到property对应的getter方法
                    Method getter = property.getReadMethod();
                    Object value = getter.invoke(obj);
                    if(null!=value){
                        map.put(key, value);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("bean2Map Error " + e);
        }
        return map;
    }

    // Bean --> Map 1: 利用Introspector和PropertyDescriptor 将Bean --> Map
    public static Map<String, String> bean2StingMap(Object obj) {
        if (obj == null) {
            return null;
        }
        Map<String, String> map = new HashMap<String, String>();
        try {
            BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            for (PropertyDescriptor property : propertyDescriptors) {
                String key = property.getName();
                // 过滤class属性
                if (!key.equals("class")) {
                    // 得到property对应的getter方法
                    Method getter = property.getReadMethod();
                    Object value = getter.invoke(obj);
                    String valStr="";
                    if(value instanceof String){
                        valStr=(String)value;
                    } else if (value instanceof Long) {
                        valStr=((Long)value).toString();
                    } else if (value instanceof Integer) {
                        valStr=((Integer)value).toString();
                    }else if(value instanceof Byte){
                        valStr=((Byte)value).toString();
                    }

                    if(null!=value){
                        map.put(key, valStr);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("bean2Map Error " + e);
        }
        return map;
    }


}
