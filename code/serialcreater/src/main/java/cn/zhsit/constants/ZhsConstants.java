package cn.zhsit.constants;


import cn.zhsit.utils.ZhsID;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public class ZhsConstants {
    //字符集—UTF-8
    public static final String ChaSet_UTF_8 = "UTF-8";

    public static final String SystemId = ZhsID.id25();

    public volatile static AtomicBoolean goOn = new AtomicBoolean(true);

    //OrgProductRecordLockTime,秒
    public static final int OrgProductRecordLockTime =60;//
    //ZhsLockUpdateSourceIdLockTime
    public static final int ZhsLockUpdateSourceIdLockTime=5;

}
