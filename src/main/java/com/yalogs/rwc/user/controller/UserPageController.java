package com.yalogs.rwc.user.controller;

import com.yalogs.rwc.common.service.RSACookieService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;

@Controller
public class UserPageController {

    @Autowired
    private RSACookieService rsaCookieService;

    @ApiOperation(value = "用户登录界面", notes = "")
    @RequestMapping(value = "/user/login-page", method = RequestMethod.GET)
    public ModelAndView loginPage(HttpServletResponse response) {
        // 让response返回给前端一个cookie
        // cookie携带的是我们的public_key公钥
        response.addCookie(rsaCookieService.publicKeyCookie());
        return new ModelAndView("login");
    }

    @ApiOperation(value = "用户主页页面链接")
    @RequestMapping(value = "/user/regist-page", method = RequestMethod.GET)
    public ModelAndView registerPage(HttpServletResponse response) {
        // 让response返回给前端一个cookie
        // cookie携带的是我们的public_key公钥
        response.addCookie(rsaCookieService.publicKeyCookie());
        return new ModelAndView("register");
    }


    @RequestMapping(value = "/crud/link", method = RequestMethod.POST)
    public ModelAndView link() {
        return new ModelAndView("link");
    }

}
