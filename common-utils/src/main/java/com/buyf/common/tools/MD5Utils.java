package com.buyf.common.tools;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author buyf
 * @date 2021/1/23 9:44
 * @desc
 */
public class MD5Utils {
    public static void main(String[] args) {
        String str = "123456";
        encrypt(str);
    }
    public static String encrypt(String input){
        // 算法
        String algorithm = "MD5";
        // 获取数字摘要对象
        MessageDigest messageDigest = null;
        try {
            messageDigest = MessageDigest.getInstance(algorithm);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        // 消息数字摘要
        byte[] digest = messageDigest.digest(input.getBytes());
        // base64编码
//        System.out.println(Base64.encode(digest));
        // 创建对象用来拼接
        StringBuilder sb = new StringBuilder();

        // 转成 16进制
        for (byte b : digest) {
            String s = Integer.toHexString(b & 0xff);
            if (s.length() == 1){
                // 如果生成的字符只有一个，前面补0
                s = "0"+s;
            }
            sb.append(s);
        }
        System.out.println(sb.toString());
        return sb.toString();
    }
}
