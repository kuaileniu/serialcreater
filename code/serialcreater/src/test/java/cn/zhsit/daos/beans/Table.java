package cn.zhsit.daos.beans;


public class Table {
    private String  tableName;
    private Long tableId;

    public Table(String tableName, Long tableId) {
        this.tableName = tableName;
        this.tableId = tableId;
    }

    public Table(String tableName) {
        this.tableName = tableName;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }
}
