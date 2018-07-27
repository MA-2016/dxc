package com.mobileai.dxc.service.imple;

import com.mobileai.dxc.db.mapper.RecordMapper;
import com.mobileai.dxc.db.pojo.Record;
import com.mobileai.dxc.service.RecordSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecordServiceImple implements RecordSevice {

    @Autowired
    private RecordMapper recordMapper;


    @Override
    public int addRecord(Record record) {


        return recordMapper.addRecord(record.getRecordId(), record.getOrderId(), record.getPayStatus());
    }

    @Override
    public int updateStatusByRecord(int status,int recordId) {

        return recordMapper.updateStatusByRecordId(recordId, status);
    }

    @Override
    public Record getById(int recordId) {
        return recordMapper.selectById(recordId);
    }
}
