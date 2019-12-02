package com.yalogs.rwc.user.dao;

import com.yalogs.rwc.user.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {

    void insertUser(User user);

    User selectUserByUserName(String userName);

    User selectUserByEmail(String email);

    User selectUserByPhone(String phone);
}
