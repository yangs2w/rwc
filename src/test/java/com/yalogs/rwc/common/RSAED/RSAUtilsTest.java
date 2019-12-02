package com.yalogs.rwc.common.RSAED;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class RSAUtilsTest {

    @Autowired
    private RSAUtils rsaUtils;

    @Test
    public void testUpdate() {
        rsaUtils.upKey2Redis();
    }

    @Test
    public void testDownKey() {
        String private_key = rsaUtils.downKey4Redis("private_key");
        String public_key = rsaUtils.downKey4Redis("public_key");
        System.out.println(private_key);
        System.out.println(public_key);
    }


    @Test
    public void testDeleteKey() {
        rsaUtils.deleteKey4Redis();
    }

}