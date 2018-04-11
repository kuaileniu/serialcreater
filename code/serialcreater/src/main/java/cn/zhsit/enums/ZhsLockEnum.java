package cn.zhsit.enums;


public enum ZhsLockEnum {
    OrgProductInsertLock(1L,"t_org_product_insert"),
    OrgProductUpdateSourceIdLock(2L,"t_org_product_update_sourceId"),

    ;
    private Long tableId;
    //业务id
    private String serviceId;//长度不要超过100
    private ZhsLockEnum(Long tableId,String serviceId){
        this.tableId=tableId;
        this.serviceId=serviceId;
    }

    public String serviceId(){
        return this.serviceId;
    }
    public Long tableId(){
        return this.tableId;
    }
}
