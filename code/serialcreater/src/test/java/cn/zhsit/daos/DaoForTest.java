package cn.zhsit.daos;


import cn.zhsit.daos.beans.Table;
import cn.zhsit.models.po.ZhsLockPO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface DaoForTest {
    @Update("truncate table t_org_product")
    int truncateTableOrgProduct();


}