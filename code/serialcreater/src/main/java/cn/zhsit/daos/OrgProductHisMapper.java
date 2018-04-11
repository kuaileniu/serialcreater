package cn.zhsit.daos;

import cn.zhsit.models.po.OrgProductHis;
import cn.zhsit.models.po.OrgProductHisExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OrgProductHisMapper {
    long countByExample(OrgProductHisExample example);

    int deleteByExample(OrgProductHisExample example);

    int deleteByPrimaryKey(Long id);

    int insert(OrgProductHis record);

    int insertSelective(OrgProductHis record);

    List<OrgProductHis> selectByExample(OrgProductHisExample example);

    OrgProductHis selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") OrgProductHis record, @Param("example") OrgProductHisExample example);

    int updateByExample(@Param("record") OrgProductHis record, @Param("example") OrgProductHisExample example);

    int updateByPrimaryKeySelective(OrgProductHis record);

    int updateByPrimaryKey(OrgProductHis record);
}