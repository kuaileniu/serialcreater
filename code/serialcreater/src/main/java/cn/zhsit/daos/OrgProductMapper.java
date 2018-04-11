package cn.zhsit.daos;

import cn.zhsit.models.po.OrgProduct;
import cn.zhsit.models.po.OrgProductExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OrgProductMapper {
    long countByExample(OrgProductExample example);

    int deleteByExample(OrgProductExample example);

    int deleteByPrimaryKey(Long id);

    int insert(OrgProduct record);

    int insertSelective(OrgProduct record);

    List<OrgProduct> selectByExample(OrgProductExample example);

    OrgProduct selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") OrgProduct record, @Param("example") OrgProductExample example);

    int updateByExample(@Param("record") OrgProduct record, @Param("example") OrgProductExample example);

    int updateByPrimaryKeySelective(OrgProduct record);

    int updateByPrimaryKey(OrgProduct record);
}