package com.mobileai.dxc;

import org.junit.Test;

import java.util.Arrays;

import static com.mobileai.dxc.util.IntStringUtils.*;

public class IntStringUtilsTest {


    int[] intarray={2,3,1};
    @Test
    public void strintTest()
    {
//        String str=intArray2String(intarray);
//        System.out.println("str"+str);

//        int[] arr=string2IntArray(str);
//        System.out.println("int"+Arrays.toString(arr));
//        System.out.println("deleteIntFormString test "+deleteIntFormString(3,str));;

        String[] strings={"a","b","c","d"};
        String mergeStr=mergeStringArray(strings);

        System.out.println("mergeStr "+mergeStr);
        System.out.println("什么情况" );
        System.out.println("deleteSubString a;"+deleteSubString("a;",mergeStr));
        System.out.println("deleteSubString a 之后"+deleteSubString("a",mergeStr));

    }

}
