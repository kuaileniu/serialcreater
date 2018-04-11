package cn.zhsit.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.ByteBuffer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigInteger;

public class ZhsByteUtil {
    private static Logger log = LoggerFactory.getLogger(ZhsByteUtil.class);

    public static byte[] long2Byte(long number) {
        BigInteger bi = BigInteger.valueOf(number);
        return bi.toByteArray();
    }

    public static long byte2Long(byte[] bytes) {
        BigInteger bi = new BigInteger(bytes);
        return bi.longValue();
    }


    @SuppressWarnings("finally")
    public static Object toObject(byte[] bytes) throws Exception {
        if (bytes == null) {
            throw new Exception("参数值为null");
        }
        Object obj = null;
        ByteArrayInputStream is = null;
        ObjectInputStream os = null;
        try {
            is = new ByteArrayInputStream(bytes);
            os = new ObjectInputStream(is);
            obj = os.readObject();
        } catch (Exception e) {
            log.error("将字节转换成Java对象时异常", e);
        } finally {
            try {
                if (os != null)
                    os.close();
            } catch (IOException e) {
                log.error("关闭ObjectInputStream时异常", e);
            }
            try {
                if (is != null)
                    is.close();
            } catch (IOException e) {
                log.error("关闭ByteArrayInputStream时异常", e);
            }
            return obj;
        }
    }

    @SuppressWarnings("finally")
    public static byte[] toBytes(Object obj) {
        byte[] bytes = null;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream os = null;
        try {
            os = new ObjectOutputStream(bos);
            os.writeObject(obj);
            os.flush();
            bytes = bos.toByteArray();
        } catch (Exception e) {
            log.error("对象转换成字节时异常", e);
        } finally {
            try {
                if (os != null)
                    os.close();
            } catch (IOException e) {
                log.error("关闭ObjectOutputStream时异常", e);
            }
            try {
                if (bos != null)
                    bos.close();
            } catch (IOException e) {
                log.error("关闭ByteArrayOutputStream时异常", e);
            }
            return bytes;
        }
    }

}
