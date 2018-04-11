package cn.zhsit.daos;

import cn.zhsit.models.po.ZyZybhzb;
import cn.zhsit.models.po.ZyZybhzbExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ZyZybhzbMapper {
    long countByExample(ZyZybhzbExample example);

    int deleteByExample(ZyZybhzbExample example);

    int insert(ZyZybhzb record);

    int insertSelective(ZyZybhzb record);

    List<ZyZybhzb> selectByExample(ZyZybhzbExample example);

    int updateByExampleSelective(@Param("record") ZyZybhzb record, @Param("example") ZyZybhzbExample example);

    int updateByExample(@Param("record") ZyZybhzb record, @Param("example") ZyZybhzbExample example);
}