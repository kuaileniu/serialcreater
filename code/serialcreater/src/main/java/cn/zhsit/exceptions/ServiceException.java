package cn.zhsit.exceptions;

/**
 * @author Darren
 * 61947666@qq.com
 * @description:自定义异常类
 */
public class ServiceException extends RuntimeException {
    public ServiceException(String msg) {
        super(msg);
    }
}
