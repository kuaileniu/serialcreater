package cn.zhsit.models.vo;


import io.swagger.annotations.ApiModelProperty;

//@ApiModel(value = "请求序号对象",description="用来接收用户请求的数据")
public class SerialReq {
    @ApiModelProperty(value = "组织编号",name = "zu",required = true,example="ct",position=2,dataType="integer")
    private String orgCode;
    @ApiModelProperty(value = "产品分类编号", required = true)
    private String productCode;
//    @ApiModelProperty(hidden = true)
//    private String zuZhiCode;
    //获取序号数量，当count>1时为批量获取
    @ApiModelProperty(value = "获取序号数量,须>=1,服务器端默认为1",example="1")
    private int count = 1;

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        if (count <= 1) {
            this.count = 1;
        } else {
            this.count = count;
        }
    }
}
