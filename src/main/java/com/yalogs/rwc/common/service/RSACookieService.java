package com.yalogs.rwc.common.service;


import com.yalogs.rwc.user.entity.User;

import javax.servlet.http.Cookie;

public interface RSACookieService {


    public Cookie privateKeyCookie();

    public Cookie publicKeyCookie();

    public String generateToken4User(User user);
}
