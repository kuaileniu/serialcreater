package cn.zhsit.daos;

import cn.zhsit.models.po.ZyZzidzdbhb;
import cn.zhsit.models.po.ZyZzidzdbhbExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ZyZzidzdbhbMapper {
    long countByExample(ZyZzidzdbhbExample example);

    int deleteByExample(ZyZzidzdbhbExample example);

    int deleteByPrimaryKey(String vZzlb);

    int insert(ZyZzidzdbhb record);

    int insertSelective(ZyZzidzdbhb record);

    List<ZyZzidzdbhb> selectByExample(ZyZzidzdbhbExample example);

    ZyZzidzdbhb selectByPrimaryKey(String vZzlb);

    int updateByExampleSelective(@Param("record") ZyZzidzdbhb record, @Param("example") ZyZzidzdbhbExample example);

    int updateByExample(@Param("record") ZyZzidzdbhb record, @Param("example") ZyZzidzdbhbExample example);

    int updateByPrimaryKeySelective(ZyZzidzdbhb record);

    int updateByPrimaryKey(ZyZzidzdbhb record);
}