package com.yalogs.rwc.common;

import org.junit.Test;

import static org.junit.Assert.*;

public class UtilsTest {

    @Test
    public void isEmail() {
        String str = "wuyb2432444ig@ccom";
        boolean email = Utils.isEmail(str);
        System.out.println(email);
    }

    @Test
    public void isPhone() {
        String phone = "35283146390";
        System.out.println(Utils.isPhone(phone));
    }
}