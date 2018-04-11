package cn.zhsit.services.impl;

import cn.zhsit.enums.OrgEnum;
import cn.zhsit.helpers.RedisHelper;
import cn.zhsit.managers.FenLeiManager;
import cn.zhsit.models.dto.CommonDTO;
import cn.zhsit.models.vo.SerialReq;
import cn.zhsit.models.vo.SerialResp;
import cn.zhsit.services.AbstractZuZhiService;
import cn.zhsit.utils.ZhsNumberUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


@Service("caiTuanZuZhiService")
public class CaiTuanZuZhiService extends AbstractZuZhiService {
    @Autowired
    private FenLeiManager fenLeiManager;
    @Autowired
    private RedisHelper redisHelper;

    @Override
    public String getZuZhiCode() throws Exception {
        OrgEnum zuZhi = OrgEnum.CaiTuan;
        int dqh = 80000000; //从分布式缓存获取
        if (zuZhi.getQsh() <= dqh && dqh <= zuZhi.getJzh()) {
            return ZhsNumberUtil.getBitNum(OrgEnum.Length, dqh);
        }
        throw new Exception("未获取到当前组织编号");
    }

    @Override
    public CommonDTO before(SerialReq serial) {
        CommonDTO dto = new CommonDTO();
        dto.status = CommonDTO.ServiceNext;
        SerialResp s = new SerialResp();
        s.setCode(SerialResp.CODE_OK);
        String chanPinCode = fenLeiManager.caiTuan();
        String code = serial.getOrgCode() + "" + chanPinCode;
        s.setMsg(code);
        dto.obj = s;

//        redisHelper.g();
        List<Long> ids = redisHelper.incr("n", 1);
        System.out.println(ids);

        return dto;
    }

    @Override
    public boolean checkRepeat(CommonDTO dto) {
        return false;
    }
}
