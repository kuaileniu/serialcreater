package cn.zhsit.caches.redis.serializers;


import cn.zhsit.constants.ZhsConstants;
import cn.zhsit.utils.ZhsByteUtil;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;
import org.springframework.util.StringUtils;

public class ZhsObjectStringSerializer implements RedisSerializer<Object> {
    @Override
    public byte[] serialize(Object o) throws SerializationException {
//        String v = "";
//        byte[] bbs = null;
//        if (o instanceof Long) {
//            v = ((Long) o).toString();
//        }else if(o instanceof Integer){
//            v = ((Integer) o).toString();
//        }
//
//        try {
//            bbs = v.getBytes(ZhsConstants.ChaSet_UTF_8);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return bbs;

        return ZhsByteUtil.toBytes(o);
    }

    @Override
    public Object deserialize(byte[] bytes) throws SerializationException {
        try {
            String v = new String(bytes, ZhsConstants.ChaSet_UTF_8);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
