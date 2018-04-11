package cn.zhsit.daos;

import cn.zhsit.models.po.OrgProduct;
import cn.zhsit.models.po.OrgProductExample;
import cn.zhsit.models.po.ZhsLockPO;
import cn.zhsit.models.vo.OrgProductVo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;


@Mapper
public interface OrgProductDao {
    @Select("select max(id) from t_org_product")
    public Long getMaxId();


//    INSERT INTO t_org_product set id=1 , stop_time = NOW();
//    INSERT INTO t_org_product set id=2 , stop_time = DATE_SUB(now(),INTERVAL -60 SECOND);

    /**
     * //     * @param recordOwner 所有者
     * //     * @param  recordOwnerExpireSeconds 锁行秒数，需是负值，小于0
     *
     * @return 影响行数
     */
//    UPDATE  t_org_product set record_owner='fff', record_owner_expire = DATE_SUB(now(),INTERVAL -120 SECOND)    WHERE id=2 and record_status=-1 and (record_owner='fff1' or record_owner_expire<NOW());
    @Update("UPDATE  t_org_product set record_owner=#{recordOwner}, record_owner_expire = DATE_SUB(NOW(),INTERVAL -#{recordOwnerExpireSeconds} SECOND)  " +
            "WHERE id=#{id} and record_status=-1 and " +
            "(record_owner=#{recordOwner} or record_owner_expire is null or record_owner_expire<NOW())")
    public int lockRecord(OrgProductVo orgProduct);


    @Update("UPDATE  t_org_product set record_owner=null,modify_time=NOW(), record_owner_expire = null" +
            " WHERE id=#{id} and " +
            "(record_owner=#{recordOwner} or ((record_owner != #{recordOwner} or  record_owner is null) and (record_owner_expire is null or record_owner_expire<NOW())))")
    int releaseLockRecord(OrgProductVo record);


    @Select("SELECT id,org_code,org_id,product_code,product_id from t_org_product " +
            "where record_status=-1 and org_code=#{orgCode} and product_code=#{productCode} ORDER BY org_id ,product_id " +
            "LIMIT 1")
    @Results({
            @Result(column = "org_code", property = "orgCode")
            , @Result(column = "org_id", property = "orgId")
            , @Result(column = "product_code", property = "productCode")
            , @Result(column = "product_id", property = "productId")
            , @Result(column = "stop_time", property = "stopTime")
    })
    public OrgProduct selectMinOrgProduct(OrgProduct op);


    @Select("select id,org_code,org_id,product_code,product_id,last_source_id,serial_status" +
            ",record_status,record_owner,record_owner_expire,create_time,stop_time" +
            " from t_org_product where id=#{id}")
    @Results({
            @Result(column = "org_code", property = "orgCode")
            , @Result(column = "org_id", property = "orgId")
            , @Result(column = "product_code", property = "productCode")
            , @Result(column = "product_id", property = "productId")
            , @Result(column = "last_source_id", property = "lastSourceId")
            , @Result(column = "record_status", property = "recordStatus")
            , @Result(column = "record_owner", property = "recordOwner")
            , @Result(column = "record_owner_expire", property = "recordOwnerExpire")
            , @Result(column = "create_time", property = "createTime")
            , @Result(column = "stop_time", property = "stopTime")
    })
    public OrgProduct selectById(Long id);


    @Select("select id,org_id,product_id,last_source_id from t_org_product where id=#{id}")
    @Results({
             @Result(column = "id", property = "id")
            , @Result(column = "org_id", property = "orgId")
            , @Result(column = "product_id", property = "productId")
            , @Result(column = "last_source_id", property = "lastSourceId")
    })
    public OrgProduct selectByIdForRedisRecord(Long id);

    @Update("UPDATE t_org_product set last_source_id=#{lastSourceId},modify_time=NOW() where id=#{id} and (last_source_id is null or last_source_id<#{lastSourceId})")
    public int updateLastSourceId(OrgProduct record);
    @Update("UPDATE t_org_product set record_status=2,stop_time=NOW(),modify_time=NOW() where id=#{id} and record_status!=2")
    public int updateRecordStatus(OrgProduct record);


    @Select("SELECT id,org_code,org_id,product_code,product_id from t_org_product " +
            "where record_status=-1 and org_code=#{op.orgCode} and product_code=#{op.productCode} ORDER BY org_id ,product_id " +
            "LIMIT #{n}")
    @Results({
              @Result(column = "org_code", property = "orgCode")
            , @Result(column = "org_id", property = "orgId")
            , @Result(column = "product_code", property = "productCode")
            , @Result(column = "product_id", property = "productId")
    })
    public List<OrgProduct> selectMinOrgProductN(@Param("op") OrgProduct op,@Param("n")int n);
}