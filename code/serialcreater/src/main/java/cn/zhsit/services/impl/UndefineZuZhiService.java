package cn.zhsit.services.impl;

import cn.zhsit.models.dto.CommonDTO;
import cn.zhsit.models.vo.SerialReq;
import cn.zhsit.models.vo.SerialResp;
import cn.zhsit.services.AbstractZuZhiService;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Service("undefineZuZhiService")
public class UndefineZuZhiService extends AbstractZuZhiService {

    @Override
    public String getZuZhiCode() throws Exception {
        return null;
    }

    @Override
    public CommonDTO before(SerialReq serial) {
        CommonDTO dto = new CommonDTO();
        dto.status = CommonDTO.ServiceEnd;
        SerialResp sresp = new SerialResp();
        sresp.setCode(SerialResp.CODE_ERROR);
        sresp.setMsg("尚未实现所请求的服务。");
        dto.obj = sresp;
        return dto;
    }

    @Override
    public boolean checkRepeat(CommonDTO dto) {
        return false;
    }
}
