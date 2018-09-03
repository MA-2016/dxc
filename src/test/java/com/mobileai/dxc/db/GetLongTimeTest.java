package com.mobileai.dxc.db;

import org.junit.Test;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GetLongTimeTest {
    @Test
    public void getLongTime(){


        long time_long= 0;
        try {
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            time_long = sdf.parse("2018-09-28 19:38:31").getTime();
            System.out.println(time_long);
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
}
