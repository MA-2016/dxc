package com.mobileai.dxc.util;

import javax.xml.ws.Service;
import java.util.StringTokenizer;

/**
 * Service从网页是数组形式传过来
 * 在后端使用中，是数组形式使用
 * 在数据库存储中是服务编号：服务编号：服务编号...形式存储
 * */
public class ServiceIntStringSwitch {
    /**
     * @param :int数组类型的服务编号
     * @return ：服务编号：服务编号：服务编号...形式的String，用于存储数据库
     * */
    public static String intArray2String(int[] services)
    {
        StringBuilder stringForm=new StringBuilder();
        for(int service:services)
        {
            stringForm.append(service+"");
            stringForm.append(":");
        }
        stringForm.deleteCharAt(stringForm.length()-1);
        return stringForm+"";
    }
    /**
     * @param :服务编号：服务编号：服务编号...形式的String，用于存储数据库
     * @return ：int数组类型的服务编号
     * */
    public static int[] string2IntArray(String services)
    {
        int[] intArrayForm;
        String[] strArrayForm=services.split(":");
        intArrayForm=new int[strArrayForm.length];
        int i;
        for(i=0;i<strArrayForm.length;i++)
        {
            intArrayForm[i]=Integer.valueOf(strArrayForm[i]);
        }
        return  intArrayForm;
    }


}
