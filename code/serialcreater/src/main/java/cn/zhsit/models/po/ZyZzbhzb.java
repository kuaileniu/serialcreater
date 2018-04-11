package cn.zhsit.models.po;

import java.io.Serializable;
import java.util.Date;

/**
* 冯先生 
* 61947666@qq.com 
* 15652963646 
*/
public class ZyZzbhzb implements Serializable {
    /**
     * 组织ID
     */
    private String vId;

    /**
     * 分号日期
     */
    private Date dFhrq;

    private static final long serialVersionUID = 1L;

    public String getvId() {
        return vId;
    }

    public void setvId(String vId) {
        this.vId = vId == null ? null : vId.trim();
    }

    public Date getdFhrq() {
        return dFhrq;
    }

    public void setdFhrq(Date dFhrq) {
        this.dFhrq = dFhrq;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", vId=").append(vId);
        sb.append(", dFhrq=").append(dFhrq);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}