package cn.zhsit.utils;


import cn.zhsit.constants.ZhsConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ZhsThreadUtil {
    protected static Logger log = LoggerFactory.getLogger(ZhsThreadUtil.class);

    public static String currentThreadId() {
        return ZhsConstants.SystemId + Thread.currentThread().getId();
    }

    public static void sleep(int seconds) {
        try {
            Thread.sleep(1000 * seconds);
        } catch (Exception e) {
            log.error("线程sleep时异常", e);
        }
    }
}
