package cn.zhsit.models.po;

import java.io.Serializable;

/**
* 冯先生 
* 61947666@qq.com 
* 15652963646 
*/
public class ZyZytybhb implements Serializable {
    /**
     * 组织ID
     */
    private String vId;

    /**
     * 产品类别
     */
    private String vCplb;

    /**
     * 产品分类起号
     */
    private String vCpflqh;

    /**
     * 产品分类当前号
     */
    private String vCpfldqh;

    /**
     * 产品分类止号
     */
    private String vCpflzh;

    /**
     * 起始号
     */
    private String vQsh;

    /**
     * 当前号
     */
    private String vDqh;

    /**
     * 截止号
     */
    private String vJzh;

    /**
     * 备注
     */
    private String vBz;

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

    public String getvCpflqh() {
        return vCpflqh;
    }

    public void setvCpflqh(String vCpflqh) {
        this.vCpflqh = vCpflqh == null ? null : vCpflqh.trim();
    }

    public String getvCpfldqh() {
        return vCpfldqh;
    }

    public void setvCpfldqh(String vCpfldqh) {
        this.vCpfldqh = vCpfldqh == null ? null : vCpfldqh.trim();
    }

    public String getvCpflzh() {
        return vCpflzh;
    }

    public void setvCpflzh(String vCpflzh) {
        this.vCpflzh = vCpflzh == null ? null : vCpflzh.trim();
    }

    public String getvQsh() {
        return vQsh;
    }

    public void setvQsh(String vQsh) {
        this.vQsh = vQsh == null ? null : vQsh.trim();
    }

    public String getvDqh() {
        return vDqh;
    }

    public void setvDqh(String vDqh) {
        this.vDqh = vDqh == null ? null : vDqh.trim();
    }

    public String getvJzh() {
        return vJzh;
    }

    public void setvJzh(String vJzh) {
        this.vJzh = vJzh == null ? null : vJzh.trim();
    }

    public String getvBz() {
        return vBz;
    }

    public void setvBz(String vBz) {
        this.vBz = vBz == null ? null : vBz.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", vId=").append(vId);
        sb.append(", vCplb=").append(vCplb);
        sb.append(", vCpflqh=").append(vCpflqh);
        sb.append(", vCpfldqh=").append(vCpfldqh);
        sb.append(", vCpflzh=").append(vCpflzh);
        sb.append(", vQsh=").append(vQsh);
        sb.append(", vDqh=").append(vDqh);
        sb.append(", vJzh=").append(vJzh);
        sb.append(", vBz=").append(vBz);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}