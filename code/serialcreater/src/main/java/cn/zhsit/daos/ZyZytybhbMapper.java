package cn.zhsit.daos;

import cn.zhsit.models.po.ZyZytybhb;
import cn.zhsit.models.po.ZyZytybhbExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ZyZytybhbMapper {
    long countByExample(ZyZytybhbExample example);

    int deleteByExample(ZyZytybhbExample example);

    int insert(ZyZytybhb record);

    int insertSelective(ZyZytybhb record);

    List<ZyZytybhb> selectByExample(ZyZytybhbExample example);

    int updateByExampleSelective(@Param("record") ZyZytybhb record, @Param("example") ZyZytybhbExample example);

    int updateByExample(@Param("record") ZyZytybhb record, @Param("example") ZyZytybhbExample example);
}