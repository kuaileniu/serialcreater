package cn.zhsit.caches.redis.serializers;


import cn.zhsit.constants.ZhsConstants;
import cn.zhsit.utils.ZhsByteUtil;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

public class ZhsStringSerializer implements RedisSerializer<String> {
    @Override
    public byte[] serialize(String s) throws SerializationException {
        try {
            return s.getBytes(ZhsConstants.ChaSet_UTF_8);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String deserialize(byte[] bytes) throws SerializationException {
        try {
            if(null==bytes){
                return null;
            }
            return new String(bytes, ZhsConstants.ChaSet_UTF_8);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
