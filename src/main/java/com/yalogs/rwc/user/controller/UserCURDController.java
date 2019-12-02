package com.yalogs.rwc.user.controller;

import com.yalogs.rwc.common.service.RSACookieService;
import com.yalogs.rwc.user.entity.Result;
import com.yalogs.rwc.user.entity.User;
import com.yalogs.rwc.user.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserCURDController {

    private static final Logger logger = LoggerFactory.getLogger(UserCURDController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private RSACookieService rsaCookieService;

    @ApiOperation(value = "用户登录")
    @RequestMapping(value = "/user/login", method = RequestMethod.POST)
    @ResponseBody
    public Result userLogin(@RequestParam(value = "account") String account, @RequestParam(value = "password") String password) {
        if (StringUtils.isBlank(account) || StringUtils.isBlank(password))
            return new Result(500, "account or password error");
        // 判断account类型
        int type = userService.accountType(account);
        // 开始login
        User user = userService.startLogin(type, account, password);
        return null != user ? new Result(200, null, rsaCookieService.generateToken4User(user)) : new Result(500, "Account or password error.");
    }
}
