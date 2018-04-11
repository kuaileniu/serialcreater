package cn.zhsit.models.po;

import java.io.Serializable;
import java.util.Date;

/**
* 冯先生 
* 61947666@qq.com 
* 15652963646 
*/
public class ZyZybhzb implements Serializable {
    /**
     * 组织ID
     */
    private String vId;

    /**
     * 产品类别
     */
    private String vCplb;

    /**
     * 资源ID
     */
    private String vZyid;

    /**
     * 分号时间
     */
    private Date dFhrq;

    private static final long serialVersionUID = 1L;

    public String getvId() {
        return vId;
    }

    public void setvId(String vId) {
        this.vId = vId == null ? null : vId.trim();
    }

    public String getvCplb() {
        return vCplb;
    }

    public void setvCplb(String vCplb) {
        this.vCplb = vCplb == null ? null : vCplb.trim();
    }

    public String getvZyid() {
        return vZyid;
    }

    public void setvZyid(String vZyid) {
        this.vZyid = vZyid == null ? null : vZyid.trim();
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
        sb.append(", vCplb=").append(vCplb);
        sb.append(", vZyid=").append(vZyid);
        sb.append(", dFhrq=").append(dFhrq);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}