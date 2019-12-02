package com.yalogs.rwc.user.service;

import com.yalogs.rwc.user.entity.User;

public interface UserService {

    String dePassword(String password);
    int accountType(String account);
    User startLogin(int type, String account, String password);
    Boolean addUser(User user);
}
