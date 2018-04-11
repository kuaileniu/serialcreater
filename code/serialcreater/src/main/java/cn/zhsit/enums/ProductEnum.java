package cn.zhsit.enums;


import cn.zhsit.annotations.Disable;
import cn.zhsit.annotations.Global;
import cn.zhsit.annotations.Specified;

//产品分类
//@Global：19
//@Global中单一的11
//CaiTuan  2
//WuLiu 4
//ShengChanQiYe 5
public enum ProductEnum {
    @Global
    RenYuan("ry", "人员", 0, 9),
    @Global
    DingDan("dd", "订单", 10, 29),
    @Global
    YunDan("yd", "运单", 30, 39),
    @Global
    ChuRuKuDan("crkd", "出入库单", 40, 49),
    @Global
    GuanLiPiCi("glpc", "管理批次", 70, 70),
    @Global
    ShiPinTou("spt", "视频头", 71, 71),
    @Global
    KuFang("kf", "库房", 72, 72),
    @Global
    KuWei("kw", "库位", 73, 73),
    @Global
    CheLiang("cl", "车辆", 74, 74),
    @Global
    JieSuanDan("jsd", "结算单", 76, 76),
    @Global
    ZhiFuDan("zfd", "支付单", 77, 77),
    @Global
    XiaoXi("xx", "消息", 1000, 1999),
    @Global
    ZhaoPian("zp", "照片", 2000, 2999),
    @Global
    XiangCe("xc", "相册", 80, 80),
    @Global
    LunTan("lt", "论坛", 78, 78),
    @Global
    TieZi("tz", "帖子", 79, 79),
    @Global
    PingLun("pl", "评论", 3000, 3999),
    @Global
    WeiBo("wb", "微博", 4000, 4999),
    @Global
    XiTong("xt", "系统", 75, 75),

    //******1*****************************************//
    @Specified(orgType = {OrgEnum.ShengChanQiYe})
    LingShouBaoZhuang("lsbz", "零售包装", 5000, 5999),
    @Specified(orgType = {OrgEnum.ShengChanQiYe})
    PiFaBaoZhuang("pfbz", "批发包装", 6000, 6999),
    @Specified(orgType = {OrgEnum.ShengChanQiYe})
    ShengChanPiCi("scpc", "生产批次", 7000, 7999),
    @Specified(orgType = {OrgEnum.ShengChanQiYe})
    ShengChanJiLu("scjl", "生产记录", 8000, 8999),
    @Specified(orgType = {OrgEnum.ShengChanQiYe})
    QiYeQiTa("qyqt", "企业其它", 9000, 9999),
    //******1*****************************************//

    //******2*****************************************//
    @Specified(orgType = {OrgEnum.WuLiu})
    WuLiuQiTa("wlqt", "物流其它", 9000, 9999),
    //******2*****************************************//


    //******3*****************************************//
    @Specified(orgType = {OrgEnum.WuLiu})
    JiaoYi("jy", "交易", 5000, 5999),
    @Specified(orgType = {OrgEnum.WuLiu})
    TuiHuo("th", "退货", 6000, 6999),
    @Specified(orgType = {OrgEnum.WuLiu})
    SongHuo("sh", "送货", 7000, 7999),
    //******3*****************************************//

    //******4*****************************************//
    @Specified(orgType = {OrgEnum.CaiTuan})
    HuoDong("hd", "活动", 5000, 5999),
    @Specified(orgType = {OrgEnum.CaiTuan})
    CaiTuanQiTa("ctqt", "菜团其它", 9000, 9999),
    //******4*****************************************//


    //******5*****************************************//
    @Specified(orgType = {OrgEnum.FuDeYiZongBu})
    FuDeYi("fdy", "富德益", 5000, 5999), //即富德益专有业务
    //******5*****************************************//


    //*****10******************************//
    @Disable
    YuLiu("yl", "预留", 50, 69),
    @Global @Disable
    BaoLiu("bl", "保留", 81, 99),
    //*****10******************************//

    ;
    private final String cplb;//产品类别
    private final String bz;//备注
    private final int cpflqh;//产品分类起号
    private final int cpflzh;//产品分类止号
    public static final int Length = 4;//起止号段长度

    private ProductEnum(String cplb, String bz, int cpflqh, int cpflzh) {
        this.cplb = cplb;
        this.bz = bz;
        this.cpflqh = cpflqh;
        this.cpflzh = cpflzh;
    }

    public static ProductEnum of(String cplb) {
        ProductEnum[] zz = ProductEnum.values();
        for (ProductEnum z : zz) {
            if (z.getCplb().equals(cplb)) {
                return z;
            }
        }
        return null;
    }

    public String getCplb() {
        return cplb;
    }

    public String getBz() {
        return bz;
    }

    public int getCpflqh() {
        return cpflqh;
    }

    public int getCpflzh() {
        return cpflzh;
    }
}