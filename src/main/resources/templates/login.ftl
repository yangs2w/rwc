<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8"><meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>登录|Client</title>
    <link rel="stylesheet" type="text/css" href="../layui/css/layui.css">
    <link rel="stylesheet" type="text/css" href="../css/header.css">
    <link rel="stylesheet" type="text/css" href="../css/login.css">
    <script type="application/javascript" src="../js/jquery.min.js"></script>
    <script type="application/javascript" src="../layui/layui.js"></script>
    <script type="application/javascript" src="../js/crud.js"></script>
    <script type="application/javascript" src="../js/header.js"></script>
    <script type="application/javascript" src="../js/login.js"></script>
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
            <li class="layui-nav-item layui-this"><a href="/user/login-page">登录</a></li>
            <li class="layui-nav-item"><a href="/user/regist-page">注册</a></li>
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
            <span>LOGIN ACCOUNT</span>
        </div>
        <div class="form">
            <div class="layui-form">
                <div class="layui-form-item">
                    <div class="layui-input-block">
                        <input type="text" name="account" required  lay-verify="required" placeholder="enter the account name / email / phone of this site." autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <div class="layui-input-block">
                        <input type="password" name="password" required  lay-verify="required" placeholder="enter the password of the account." autocomplete="off" class="layui-input">
                    </div>
                </div>
            </div>
            <!-- 提交submit -->
            <div class="layui-form-item">
                <div class="layui-input-block">
                    <#--<button id="loginSubmit" class="layui-btn" lay-submit lay-filter="loginSubmit">START LOGIN</button>-->
                    <button id="loginSubmit" type="button" class="layui-btn" lay-filter="loginSubmit">START LOGIN</button>
                </div>
            </div>
        </div>
        <label class="go-regist">
            no account? <a href="/user/regist-page">go regist</a>&nbsp;&nbsp;&nbsp;&nbsp;forget password? <a href="/user/regist-page">retrieve password</a>
        </label>
        <script>
            var height = window.screen.height / 5;
            $('.login-form').css('top', height);
        </script>
    </div>
</div>
</body>
</html>