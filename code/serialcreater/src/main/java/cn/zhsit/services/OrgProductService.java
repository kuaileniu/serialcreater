package cn.zhsit.services;

public interface OrgProductService {

    public int transOrgProduct2RDB();

    /**
     * 当少于n时则添加
     * @param n
     * @return
     */
    public int addOrgProductRDBIfLessN(final int n);

    /**
     * 迁移OrgPruduct数据至历史表
     * @return
     */
    public int moveOrgProduct2His();

}
