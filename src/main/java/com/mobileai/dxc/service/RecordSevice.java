package com.mobileai.dxc.service;

import com.mobileai.dxc.db.pojo.Record;

public interface RecordSevice {
    //插入一个交易记录
    int addRecord(Record record);
    //修改交易状态
    int updateStatusByRecord(int status,int recordId);

    Record getById(int recordId);
}
