package cn.zhsit.enums;


public enum RecordStatusEnum {
//    此行记录状态：-1，未满仍可用；2已满，停用
    Default((byte)-1,"未满仍可用"),
    Full((byte)2,"已满，停用"),

    ;
    private byte code;
    private String descr;

    private RecordStatusEnum(byte code,String descr) {
        this.code=code;
        this.descr=descr;
    }

    public byte code(){
        return this.code;
    }
}
