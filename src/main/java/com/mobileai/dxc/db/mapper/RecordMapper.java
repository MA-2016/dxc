package com.mobileai.dxc.db.mapper;


import com.mobileai.dxc.db.pojo.Record;
import org.apache.ibatis.annotations.*;

@Mapper
public interface RecordMapper {

    @Insert("insert into record(order_id,pay_status) values (#{orderId },#{payStatus })")
    int addRecord(@Param("recordId")int recordId,@Param("orderId")int orderId,@Param("payStatus")int payStatus);

    @Update("update record set pay_status = #{payStatus} where record_id = #{recordId}")
    int updateStatusByRecordId(@Param("recordId")int recordId,@Param("payStatus")int payStatus);

    @Update("update record set pay_status = #{payStatus} where record_id = #{orderId}")
    int updateStatusByOrderId(@Param("orderId")int orderId,@Param("payStatus")int payStatus);

    @Select("select fee from record where record_id = #{recordId}")
    int selectFeeById( @Param("recordId")int recordId);


    @Select("select * from record where record_id = #{recordId}")
    Record selectById(@Param("recordId")int recordId);

}
