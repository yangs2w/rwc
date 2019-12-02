package com.yalogs.rwc.common;

import org.apache.commons.lang3.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {

    /**
     * 判断字符串是否是一个邮箱
     * @param email
     * @return
     */
    public static boolean isEmail(String email) {
        if (StringUtils.isBlank(email))
            return false;
//        String regex = "^([a-z0-9A-Z]+[-|\\\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\\\.)+[a-zA-Z]{2,}$";
        String regex = "[\\w!#$%&'*+/=?^_`{|}~-]+(?:\\.[\\w!#$%&'*+/=?^_`{|}~-]+)*@(?:[\\w](?:[\\w-]*[\\w])?\\.)+[\\w](?:[\\w-]*[\\w])?";
        return email.matches(regex);
    }

    /**
     * 判断一个字符串是否是手机号码
     * @param phone
     * @return
     */
    public static boolean isPhone(String phone) {
        if (StringUtils.isBlank(phone))
            return false;
        String regex = "^1[3|4|5|8][0-9]\\d{8}$";
        return phone.matches(regex);
    }
}
