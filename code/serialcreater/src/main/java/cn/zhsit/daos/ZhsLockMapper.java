package cn.zhsit.daos;

import cn.zhsit.models.po.ZhsLock;
import cn.zhsit.models.po.ZhsLockExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ZhsLockMapper {
    long countByExample(ZhsLockExample example);

    int deleteByExample(ZhsLockExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ZhsLock record);

    int insertSelective(ZhsLock record);

    List<ZhsLock> selectByExample(ZhsLockExample example);

    ZhsLock selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ZhsLock record, @Param("example") ZhsLockExample example);

    int updateByExample(@Param("record") ZhsLock record, @Param("example") ZhsLockExample example);

    int updateByPrimaryKeySelective(ZhsLock record);

    int updateByPrimaryKey(ZhsLock record);
}