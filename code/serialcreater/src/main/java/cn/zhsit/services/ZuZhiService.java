package cn.zhsit.services;

import cn.zhsit.models.vo.SerialReq;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public interface ZuZhiService {

    public void handle(HttpServletRequest request, HttpServletResponse resp, SerialReq serial);
}
