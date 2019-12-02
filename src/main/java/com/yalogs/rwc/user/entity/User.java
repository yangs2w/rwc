package com.yalogs.rwc.user.entity;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

@ApiModel(value = "用户类", description = "一般用于表示一个用户对象")
public class User implements Serializable {

    // 用户的id
    @ApiModelProperty(value = "用户ID", notes = "在创建用户的时候，你需要ID，数据库自增的INT类型数据，对应数据库中的ID")
    private int id;
    // 用户名
    @ApiModelProperty(value = "用户名", notes = "必须：no，但是userName,email,phone三种必须有一种存在")
    private String userName;
    // 密码
    @ApiModelProperty(value = "密码", notes = "必须：yes")
    private String password;
    // email
    @ApiModelProperty(value = "邮箱", notes = "必须： no")
    private String email;
    // phone
    @ApiModelProperty(value = "手机号", notes = "必须：否")
    private String phone;
    // create date
    @ApiModelProperty(value = "创建时间", notes = "必须：是")
    private Date createDate;
    // update date
    @ApiModelProperty(value = "修改时间", notes = "必须：是，创建时和createDate时间一样")
    private Date updateDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}
