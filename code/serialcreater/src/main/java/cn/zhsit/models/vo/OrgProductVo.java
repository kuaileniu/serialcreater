package cn.zhsit.models.vo;

import cn.zhsit.models.po.OrgProduct;


public class OrgProductVo extends OrgProduct {
    //过期秒数
    private Integer recordOwnerExpireSeconds;

    public Integer getRecordOwnerExpireSeconds() {
        return recordOwnerExpireSeconds;
    }

    public void setRecordOwnerExpireSeconds(Integer recordOwnerExpireSeconds) {
        this.recordOwnerExpireSeconds = recordOwnerExpireSeconds;
    }
}
