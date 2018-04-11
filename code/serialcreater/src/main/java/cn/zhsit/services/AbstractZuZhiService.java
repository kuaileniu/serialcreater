package cn.zhsit.services;

import cn.zhsit.models.dto.CommonDTO;
import cn.zhsit.models.vo.SerialReq;
import cn.zhsit.utils.io.ZhsIOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class AbstractZuZhiService implements ZuZhiService {
    protected Logger log = LoggerFactory.getLogger(getClass());

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse resp, SerialReq serial) {
        CommonDTO dto = null;
        try {
//            serial.setZuZhiCode(getZuZhiCode());
            dto = before(serial);
            checkRepeat(dto);
        } catch (Exception e) {
            log.error("", e);
        } finally {
            after(request, resp, serial, dto);
        }
    }


    //获取组织编号
    public abstract String getZuZhiCode() throws Exception;


    //从数据库加载数据
    public void loadFromDb() {
        //先判断redis中是否有存在，当不存在时做加载（使用并发锁）
    }

    //检查是否需要调整新数据（前面的数据已经用完）
    public abstract CommonDTO before(SerialReq serial);
    //校验生成的id是否重复，通过redis缓存有效期为1个月，在有效期内是否有重复，
    // 尝试list是否可以做重复功能
    //把生成的序号存储到redis的list中，右侧加进去
    //另起shedule 定时从redis中把list转存到mysql中，从左侧获取

    /**
     * @param dto
     * @return true 重复；
     */
    public abstract boolean checkRepeat(CommonDTO dto);

    public void after(HttpServletRequest request, HttpServletResponse resp, SerialReq serial, CommonDTO dto) {
        ZhsIOUtils.writeJsonAndClose(resp, dto.obj);
    }
}
