package cn.zhsit.models.po;

import java.io.Serializable;
import java.util.Date;

/**
* 冯先生 
* 61947666@qq.com 
* 15652963646 
*/
public class OrgProduct implements Serializable {
    /**
     * id
     */
    private Long id;

    /**
     * 组织类别编号
     */
    private String orgCode;

    /**
     * 组织类别id
     */
    private Integer orgId;

    /**
     * 产品类别编号
     */
    private String productCode;

    /**
     * 产品类别id
     */
    private Integer productId;

    /**
     * 最后资源号
     */
    private Integer lastSourceId;

    /**
     * 此行记录状态：-1，未满仍可用；2已满，停用
     */
    private Byte recordStatus;

    /**
     * 所有者
     */
    private String recordOwner;

    /**
     * 所有者期满时间
     */
    private Date recordOwnerExpire;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 停用时间
     */
    private Date stopTime;

    /**
     * 修改时间
     */
    private Date modifyTime;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode == null ? null : orgCode.trim();
    }

    public Integer getOrgId() {
        return orgId;
    }

    public void setOrgId(Integer orgId) {
        this.orgId = orgId;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode == null ? null : productCode.trim();
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getLastSourceId() {
        return lastSourceId;
    }

    public void setLastSourceId(Integer lastSourceId) {
        this.lastSourceId = lastSourceId;
    }

    public Byte getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(Byte recordStatus) {
        this.recordStatus = recordStatus;
    }

    public String getRecordOwner() {
        return recordOwner;
    }

    public void setRecordOwner(String recordOwner) {
        this.recordOwner = recordOwner == null ? null : recordOwner.trim();
    }

    public Date getRecordOwnerExpire() {
        return recordOwnerExpire;
    }

    public void setRecordOwnerExpire(Date recordOwnerExpire) {
        this.recordOwnerExpire = recordOwnerExpire;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getStopTime() {
        return stopTime;
    }

    public void setStopTime(Date stopTime) {
        this.stopTime = stopTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", orgCode=").append(orgCode);
        sb.append(", orgId=").append(orgId);
        sb.append(", productCode=").append(productCode);
        sb.append(", productId=").append(productId);
        sb.append(", lastSourceId=").append(lastSourceId);
        sb.append(", recordStatus=").append(recordStatus);
        sb.append(", recordOwner=").append(recordOwner);
        sb.append(", recordOwnerExpire=").append(recordOwnerExpire);
        sb.append(", createTime=").append(createTime);
        sb.append(", stopTime=").append(stopTime);
        sb.append(", modifyTime=").append(modifyTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}