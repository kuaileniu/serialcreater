package cn.zhsit.daos;

import cn.zhsit.models.po.ZhsLock;
import cn.zhsit.models.po.ZhsLockExample;
import cn.zhsit.models.po.ZhsLockPO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface ZhsLockDao {
    @Update("UPDATE  t_zhs_lock set record_owner=#{recordOwner},modify_time=NOW(), record_owner_expire = DATE_SUB(NOW(),INTERVAL -#{seconds} SECOND) " +
            "WHERE id=#{id} and (record_owner=#{recordOwner} or record_owner_expire is null or record_owner_expire<NOW())")
    int lock(ZhsLockPO record);

    @Update("UPDATE  t_zhs_lock set record_owner=null,modify_time=NOW(), record_owner_expire = null" +
            " WHERE id=#{id} and " +
            "(record_owner=#{recordOwner} or ((record_owner != #{recordOwner} or  record_owner is null) and (record_owner_expire is null or record_owner_expire<NOW())))")
    int releaseLock(ZhsLockPO record);
}