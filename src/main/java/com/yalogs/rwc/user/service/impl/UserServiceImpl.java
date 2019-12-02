package com.yalogs.rwc.user.service.impl;

import com.yalogs.rwc.common.RSAED.RSAFactory;
import com.yalogs.rwc.common.RSAED.RSAUtils;
import com.yalogs.rwc.common.Utils;
import com.yalogs.rwc.user.dao.UserMapper;
import com.yalogs.rwc.user.entity.User;
import com.yalogs.rwc.user.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RSAUtils rsaUtils;

    @ApiOperation("使用私钥对密码进行解密")
    @Override
    public String dePassword(String password) {
        // 获取私钥
        String private_key = rsaUtils.downKey4Redis("private_key");
        // 使用私钥进行解密密码
        try {
            return RSAFactory.decrypt(password, private_key);
        } catch (Exception e) {
            logger.error("密码解密失败,{}", e.getMessage());
            return null;
        }
    }

    /**
     * 判断account的类型
     * 1:account
     * 2:email
     * 3:phone
     * @param account
     * @return 1/2/3
     */
    @ApiOperation(value = "判断account的类型", notes = "account的类型包括account,email,phone")
    @Override
    public int accountType(String account) {
        // 判断是否是手机号
        if (Utils.isPhone(account))
            return 3;
        // 判断是否是邮箱
        if (Utils.isEmail(account))
            return 2;
        return 1;
    }

    /**
     * 通过账号密码等进行登录
     * @param type
     * @param account
     * @param password
     * @return
     */
    @ApiOperation("登录服务")
    @Override
    public User startLogin(int type, String account, String password) {
        User user = null;
        if (1 == type)
            user = userMapper.selectUserByUserName(account);
        else if (2 == type)
            user = userMapper.selectUserByEmail(account);
        else if (3 == type)
            user = userMapper.selectUserByPhone(account);
        else
            return null;
        if (null == user)
            return null;
        String pass = user.getPassword();
        String de_pass = dePassword(password);
        String hexPass = DigestUtils.md5DigestAsHex((de_pass + "redis_web_client").getBytes());
        boolean equals = hexPass.equals(pass);
        return equals ? user : null;
    }

    /**
     * 添加用户
     * @param user
     * @return
     */
    @ApiOperation("添加x用户")
    @Override
    public Boolean addUser(User user) {
        if (null == user) {
            logger.error("传入的user对象为null");
            return false;
        }
        user.setPassword(DigestUtils.md5DigestAsHex((user.getPassword() + "redis_web_client").getBytes()));
        userMapper.insertUser(user);
        return true;
    }


}
