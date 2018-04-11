package cn.zhsit.models.po;

import java.io.Serializable;

/**
* 冯先生 
* 61947666@qq.com 
* 15652963646 
*/
public class ZyZzidzdbhb implements Serializable {
    /**
     * 组织类别
     */
    private String vZzlb;

    /**
     * 起始号
     */
    private String vQsh;

    /**
     * 当前号
     */
    private String vDqh;

    /**
     * 截至号
     */
    private String vJzh;

    /**
     * 备注
     */
    private String vBz;

    private static final long serialVersionUID = 1L;

    public String getvZzlb() {
        return vZzlb;
    }

    public void setvZzlb(String vZzlb) {
        this.vZzlb = vZzlb == null ? null : vZzlb.trim();
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
        sb.append(", vZzlb=").append(vZzlb);
        sb.append(", vQsh=").append(vQsh);
        sb.append(", vDqh=").append(vDqh);
        sb.append(", vJzh=").append(vJzh);
        sb.append(", vBz=").append(vBz);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}