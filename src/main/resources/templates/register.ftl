<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8"><meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>注册|Client</title>
    <link rel="stylesheet" type="text/css" href="../layui/css/layui.css">
    <link rel="stylesheet" type="text/css" href="../css/header.css">
    <link rel="stylesheet" type="text/css" href="../css/register.css">
    <script type="application/javascript" src="../js/jquery.min.js"></script>
    <script type="application/javascript" src="../layui/layui.js"></script>
    <script type="application/javascript" src="../js/crud.js"></script>
    <script type="application/javascript" src="../js/header.js"></script>
    <script type="application/javascript" src="../js/register.js"></script>
    <script type="application/javascript" src="../js/jsencrypt.min.js"></script>
</head>
<body>
<header class="layui-header header">
    <div class="layui-main">
        <div class="logo">
            <a href="#">
                <img src="../image/9a056f85f3bd9b731734bbbb8309bb05.jpg">
            </a>
        </div>
        <ul class="layui-nav">
            <li class="layui-nav-item"><a href="#">首页</a></li>
            <li class="layui-nav-item"><a href="#">单机</a></li>
            <li class="layui-nav-item"><a href="#">集群</a></li>
            <li class="layui-nav-item"><a href="/user/login-page">登录</a></li>
            <li class="layui-nav-item layui-this"><a href="/user/regist-page">注册</a></li>
            <li class="layui-nav-item">
                <a href="javascript:;">127.0.0.1</a>
                <dl class="layui-nav-child">
                    <dd><a href="/link">新连接</a></dd>
                    <dd><a href="#">意见反馈</a></dd>
                    <dd><a href="javascript:;">退出</a></dd>
                </dl>
            </li>
        </ul>
    </div>
</header>
<div>
    <div class="login-form">
        <div class="login-text">
            <span>REGISTER ACCOUNT</span>
        </div>
        <div class="form">
            <div class="layui-form">
                <div class="layui-form-item">
                    <div class="layui-input-block">
                        <input type="checkbox" name="account" lay-filter='account' title="Account" lay-skin="primary" checked>
                        <input type="checkbox" name="email" lay-filter='email' title="Email" lay-skin="primary" checked>
                        <input type="checkbox" name="phone" lay-filter='phone' title="Phone" lay-skin="primary" checked>
                    </div>
                </div>
                <div class="layui-form-item">
                    <div class="layui-input-block">
                        <input type="text" name="account" required  lay-verify="required" placeholder="enter the account name of this site." autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <div class="layui-input-block">
                        <input type="text" name="email" required  lay-verify="required" placeholder="enter the email of this site." autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <div class="layui-input-block">
                        <input type="text" name="phone" required  lay-verify="required" placeholder="enter the phone of this site." autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <div class="layui-input-block">
                        <input type="password" name="password" required  lay-verify="required" placeholder="enter the password of the account." autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <div class="layui-input-block">
                        <input type="password" name="confirm" required  lay-verify="required" placeholder="confirm your password." autocomplete="off" class="layui-input">
                    </div>
                </div>
            </div>
            <!-- 提交submit -->
            <div class="layui-form-item">
                <div class="layui-input-block">
                    <button id="regist-submit" type="button" class="layui-btn" lay-filter="loginSubmit">START LOGIN</button>
                </div>
            </div>
        </div>
        <label class="go-login">
            have account? <a href="/user/login-page">go login</a>
        </label>
        <script>
            var height = window.screen.height / 6;
            $('.login-form').css('top', height);
        </script>
    </div>
</div>
</body>
</html>