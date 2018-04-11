package cn.zhsit.models.vo;


import io.swagger.annotations.ApiModelProperty;

public class SerialResp {
    public static final String CODE_OK = "ok";
    public static final String CODE_ERROR = "err";
    @ApiModelProperty(value = "ok,当返回索要数据时；err,不能返回索要数据时")
    private String code;
    private String msg;

    public SerialResp() {
        this.code = CODE_ERROR;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
