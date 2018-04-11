package cn.zhsit.enums;

import cn.zhsit.annotations.Disable;

public enum OrgEnum {
    FuDeYiZongBu("fdyzb", 0, 0, "富德益总部"),
    @Disable
    BaoLiu("bl", 1, 999999, "保留"),
    CaiTuan("ct", 80000000, 99999999, "菜团"),
    ShengChanQiYe("sc", 20000000, 29999999, "生产企业"),
    WuLiu("wl", 10000000, 19999999, "物流中心、直销店、销售企业"),
    YongHu("yh", 30000000, 79999999, "用户"),
    Super("super", 9999997, 9999997, "系统管理员"),
    Security("security", 9999998, 9999998, "系统安全员"),
    Audit("audit", 9999999, 9999999, "系统审计员"),;

    private final String zzlb;//组织类别
    private final int qsh;//起始号
    private final  int jzh;//截至号
    private final  String bz;//备注
    public static final int Length = 8;//起止号段长度


    private OrgEnum(String zzlb, int qsh, int jzh, String bz) {
        this.zzlb = zzlb;
        this.qsh = qsh;
        this.jzh = jzh;
        this.bz = bz;
    }

    public static OrgEnum of(String zzlb) {
        OrgEnum[] zz = OrgEnum.values();
        for (OrgEnum z : zz) {
//            if ()
            if (z.getZzlb().equals(zzlb)) {
                return z;
            }
        }
        return null;
    }

    public String getZzlb() {
        return zzlb;
    }

    public int getQsh() {
        return qsh;
    }

    public int getJzh() {
        return jzh;
    }

    public String getBz() {
        return bz;
    }
}