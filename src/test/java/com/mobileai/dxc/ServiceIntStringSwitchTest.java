package com.mobileai.dxc;

import com.mobileai.dxc.util.ServiceIntStringSwitch;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.Array;
import java.util.Arrays;

import static com.mobileai.dxc.util.ServiceIntStringSwitch.intArray2String;
import static com.mobileai.dxc.util.ServiceIntStringSwitch.string2IntArray;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ServiceIntStringSwitchTest {

    ServiceIntStringSwitch AISswitch;

    int[] intarray={2,3,1};
    @Test
    public void strintTest()
    {
//        String str=intArray2String(intarray);
//        System.out.println(str);

        String str="2:3:1";
        int[] arr=string2IntArray(str);
        System.out.println(Arrays.toString(arr));
    }

}
