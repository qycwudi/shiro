package com.qyc;

import org.apache.shiro.crypto.hash.Md5Hash;

/**
 * @author qyc
 * @time 2020/4/19 - 20:16
 */
public class Test01 {
    public static void main(String[] args) {
        Md5Hash md5Hash = new Md5Hash("123456","qyc",10);
        System.out.println(md5Hash);
    }
}
