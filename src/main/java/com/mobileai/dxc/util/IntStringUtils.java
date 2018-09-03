package com.mobileai.dxc.util;

import javax.xml.ws.Service;
import java.util.StringTokenizer;

//todo：抛异常的处理
/**
 *功能：数组形式和String形式的转换，
 *
 * 从网页是数组形式传过来
 * 在后端使用中，是数组形式使用
 * 在数据库存储中是服务编号;服务编号;服务编号...形式存储
 * */
public class IntStringUtils {
    /**
     * @param :int数组类型的服务编号
     * @return ：服务编号;服务编号;服务编号...形式的String，用于存储数据库
     * */
    public static String intArray2String(int[] services)
    {
        StringBuilder stringForm=new StringBuilder();
        for(int service:services)
        {
            stringForm.append(service+"");
            stringForm.append(";");
        }
        return stringForm+"";
    }
    /**
     * @param :服务编号;服务编号;服务编号...形式的String，用于存储数据库
     * @return ：int数组类型的服务编号
     * */
    public static int[] string2IntArray(String services)
    {
        int[] intArrayForm;
        String[] strArrayForm=services.split(";");

        intArrayForm=new int[strArrayForm.length];
        int i;
        for(i=0;i<strArrayForm.length;i++)
        {
            intArrayForm[i]=Integer.valueOf(strArrayForm[i]);
        }
        return  intArrayForm;
    }


    /**
     * @function:从字符形式里面删除某一个数字
     * @param :服务编号;服务编号;服务编号...形式的String，用于存储数据库
     * @return ：int数组类型的服务编号
     * */
    public  static String deleteIntFormString(int deldeteInt,String targetString)
    {

        if(targetString.indexOf(deldeteInt+"") != -1)
        {
            targetString=targetString.replace(deldeteInt+";","");
        }
        else
        {
            System.out.println("error:无此子字符串");
        }
        return targetString;
    }
    /**
     * @function:把String数组形式的按照分号间隔合并成一个string
     * @param :
     * @return ：合并成的String
     * */
    public  static String mergeStringArray(String[] strings)
    {
        String mergeStr="";
        for(String str:strings)
        {
            mergeStr += (str+";");
        }
        return mergeStr;
    }
    /**
     * @function:把String数中两个分号间的string去掉。
     * @Attention：①该substring没有在String里面的异常，
     *              ②该substring不是正好在两个" ;"之间的异常
     * @param :
     * @return ：去掉subString的String
     * */
    public  static String deleteSubString(String subString,String targetString)
    {

        int index;

        if(subString.indexOf(";")!=-1)
        {
            return ("error:子字符串格式不合法，不能包含“;”");
        }

        index=targetString.indexOf(subString);

        if( index == -1)
        {
            return ("error:没有该子字符串");
        }

        if( ( index==0 || (targetString.charAt(index-1) == ';') )
                && targetString.charAt(index+subString.length()) ==';')
        {

            targetString =targetString.replace(subString+";","");
        }
        else
        {
            //todo：是不是只是在picture路径会用
            return("error:路径不完整");
        }

        return targetString;
    }
    /**
     * @function:把subString添加到targetString末尾，加上“;”
     *
     * @param :
     * @return ：加上subString和“；”的String
     * */
    public  static String addSubString(String subString,String targetString)
    {
        return targetString+subString+";";
    }

    public static String replaceString(String oldStr,String newStr,String targetStr)
    {
        //replace之前要确定这是一个完整的句子，要把3；换成5；的时候，不能把13换成15；
        targetStr=deleteSubString(oldStr,targetStr);
        targetStr=addSubString(newStr,targetStr);
        return targetStr;
    }


}
