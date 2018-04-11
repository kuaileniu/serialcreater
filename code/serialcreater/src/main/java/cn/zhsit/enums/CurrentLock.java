package cn.zhsit.enums;


public enum CurrentLock {

    TableHistoryIdLock("lock.table_history_id"),
    TableOrgProductIdLock("lock.table_org_product_id"),;
    private String lock;

    private CurrentLock(String lock) {
        this.lock = lock;
    }

    public String lock() {
        return this.lock;
    }

}
