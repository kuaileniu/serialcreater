package cn.zhsit.daos;

import cn.zhsit.models.po.ZyZzbhzb;
import cn.zhsit.models.po.ZyZzbhzbExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ZyZzbhzbMapper {
    long countByExample(ZyZzbhzbExample example);

    int deleteByExample(ZyZzbhzbExample example);

    int insert(ZyZzbhzb record);

    int insertSelective(ZyZzbhzb record);

    List<ZyZzbhzb> selectByExample(ZyZzbhzbExample example);

    int updateByExampleSelective(@Param("record") ZyZzbhzb record, @Param("example") ZyZzbhzbExample example);

    int updateByExample(@Param("record") ZyZzbhzb record, @Param("example") ZyZzbhzbExample example);
}