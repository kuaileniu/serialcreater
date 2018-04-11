package cn.zhsit.annotations;

import cn.zhsit.enums.OrgEnum;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Specified {

    OrgEnum[] orgType();
}
