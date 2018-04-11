package cn.zhsit.enums;


public enum TableId {

    TableHistory("t_history", "table_history_id"),
//    TableOrgProduct("t_org_product", "table_org_product_id"),//此表id修改为自增

    ;

    private String tableName;
    private String id;
    private TableId(String tableName, String id) {
        this.tableName = tableName;
        this.id = id;
    }

    public String id() {
        return this.id;
    }

    public String tableName() {
        return this.tableName;
    }
}
