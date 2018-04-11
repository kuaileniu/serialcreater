package cn.zhsit.services;

import cn.zhsit.models.vo.SerialReq;
import cn.zhsit.models.vo.SerialResp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Darren
 * 61947666@qq.com
 * @description:
 */
public interface SerialService {

    public void handle(HttpServletRequest request, HttpServletResponse resp, SerialReq serial);
}
