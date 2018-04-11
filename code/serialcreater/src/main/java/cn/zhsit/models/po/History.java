package cn.zhsit.models.po;

import java.io.Serializable;
import java.util.Date;

/**
* 冯先生 
* 61947666@qq.com 
* 15652963646 
*/
public class History implements Serializable {
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
     * 资源号
     */
    private Integer sourceId;

    /**
     * 序号状态：1初始状态；2已使用；3跳空；4;早期已使用
     */
    private Byte serialStatus;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 使用时间
     */
    private Date useTime;

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

    public Integer getSourceId() {
        return sourceId;
    }

    public void setSourceId(Integer sourceId) {
        this.sourceId = sourceId;
    }

    public Byte getSerialStatus() {
        return serialStatus;
    }

    public void setSerialStatus(Byte serialStatus) {
        this.serialStatus = serialStatus;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUseTime() {
        return useTime;
    }

    public void setUseTime(Date useTime) {
        this.useTime = useTime;
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
        sb.append(", sourceId=").append(sourceId);
        sb.append(", serialStatus=").append(serialStatus);
        sb.append(", createTime=").append(createTime);
        sb.append(", useTime=").append(useTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}