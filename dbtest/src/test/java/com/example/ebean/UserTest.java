package com.example.ebean;

import com.example.ebean.util.UuidUtil;
import org.junit.Test;

/**
 * @author yuzk
 * @date 2017/11/8
 */
public class UserTest {

    @Test
    public void serviceTest() {

        for(int i = 0;i<10;i++) {
            System.out.println(i+"      :        "+UuidUtil.randomUUID());
        }
    }

    @Test
    public void stringEqual() {
        String a = "Dawson@yealink.com,Lydia@yealink.com,zhongh@yealink.com,dawson@yealink.com,xieql@yealink.com,yerj@yealink.com,changk@yealink.com,chenjx@yealink.com,charry@yealink.com,lydia@yealink.com,zjl@yealink.com,huangxp@yealink.com,xiewei@yealink.com,liangf@yealink.com,nibl@yealink.com,zhongh@yealink.com,yuzk@yealink.com,chenyuany@yealink.com,shizh@yealink.com,zhangqy@yealink.com,yxl@yealink.com,shijk@yealink.com,baiyf@yealink.com,923085715@qq.com,wo2024024@163.com,cjq@yealink.com,lyh@yealink.com,wangqiuy@yealink.com,guoj@yealink.com,huangxb@yealink.com,laiyl@yealink.com,linzw@yealink.com,zhangzf@yealink.com,zhongfb@yealink.com,chenjk@yealink.com,zhangj@yealink.com,qixl@yealink.com,linhh@yealink.com,fanghf@yealink.com,fangwq@yealink.com,syz@yealink.com,pjb@yealink.com,suncw@yealink.com,shijk@yealink.com,yxl@yealink.com,wangqiuy@yealink.com,kongdq@yealink.com,lyh@yealink.com,chensw@yealink.com";
        String b = "Dawson@yealink.com,Lydia@yealink.com,zhongh@yealink.com,dawson@yealink.com,xieql@yealink.com,yerj@yealink.com,changk@yealink.com,chenjx@yealink.com,charry@yealink.com,lydia@yealink.com,zjl@yealink.com,huangxp@yealink.com,xiewei@yealink.com,liangf@yealink.com,nibl@yealink.com,zhongh@yealink.com,yuzk@yealink.com,chenyuany@yealink.com,shizh@yealink.com,zhangqy@yealink.com,yxl@yealink.com,shijk@yealink.com,baiyf@yealink.com,923085715@qq.com,wo2024204@163.com,cjq@yealink.com,lyh@yealink.com,wangqiuy@yealink.com,guoj@yealink.com,huangxb@yealink.com,laiyl@yealink.com,linzw@yealink.com,zhangzf@yealink.com,zhongfb@yealink.com,chenjk@yealink.com,zhangj@yealink.com,qixl@yealink.com,linhh@yealink.com,fanghf@yealink.com,fangwq@yealink.com,syz@yealink.com,pjb@yealink.com,suncw@yealink.com,shijk@yealink.com,yxl@yealink.com,wangqiuy@yealink.com,kongdq@yealink.com,lyh@yealink.com,chensw@yealink.com";
        System.out.println(findDifferent(a,b));
    }

    @Test
    public void redisTest() {

    }

    private String findDifferent(String origin, String compare) {
        if(origin.length() != compare.length()) {
            return null;
        }
        char[] arr1 = origin.toCharArray();
        char[] arr2 = compare.toCharArray();
        int errIndex = 0;
        for(int i = 0; i < arr1.length;i++) {
            if(arr1[i] == arr2[i]) {
                continue;
            }
            errIndex = i;
            break;
        }
        String oriErr = arrIndexToString(arr1,errIndex);
        String compErr = arrIndexToString(arr2,errIndex);
        return oriErr + " : " + compErr;
    }

    private String arrIndexToString(char[] arr, int index) {
        StringBuffer buffer = new StringBuffer("");
        for(int i = index-5;i<index+5;i++) {
            buffer.append(arr[i]);
        }
        return buffer.toString();
    }
}
