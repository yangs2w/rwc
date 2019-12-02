$(document).ready(function () {

    var form, layer;

    layui.use(['form', 'layer'], function () {
        form = layui.form;
        layer = layui.layer;

        $('#loginSubmit').click(function () {
            var param = getParam();
            var result = IsNull(param);
            if (result !== true) {
                layer.msg(result);
                return;
            }
            $('#loginSubmit').addClass('layui-btn-disabled');
            $('#loginSubmit').html('LOGGING&nbsp;&nbsp;&nbsp;<i class="layui-anim layui-anim-rotate layui-anim-loop layui-icon layui-icon-loading" style="display: inline-block"></i>');
            // 使用ajax以post请求方式提交请求
            $.ajax({
                url: '/user/login',
                type: 'POST',
                data: param,
                timeout: 10000,
                success: function (result) {
                    if (result.code === 200) {
                        // 获取到token
                        document.cookie = au_token + "=" + result.data + ";";
                        window.location.href = "http://localhost:8080/";
                    } else if (result.code === 500) {
                        alert(result.message);
                        $('#loginSubmit').removeClass('layui-btn-disabled');
                        $('#loginSubmit').html("START LOGIN");
                    }
                },
                error: function (arg1) {
                    layer.msg("Request server error");
                    $('#loginSubmit').removeClass('layui-btn-disabled');
                    $('#loginSubmit').html("START LOGIN");
                }
            });
        });

        // 获取账户名和密码
        function getParam() {
            // 获取账户名
            var account = $('input[name=account]').val();
            var password = $('input[name=password]').val();
            // 对password进行RSA加密，防止数据被拦截时暴露密码
            var encrypt = new JSEncrypt();
            encrypt.setPublicKey(get_cookie_for_name("public_key"));
            var en_pass = encrypt.encrypt(password);
            var param = {account: account, password: en_pass};
            return param;
        }

        /**
         * 判读参数
         * @return {string}
         */
        function IsNull(param) {
            if (typeof param.account == 'undefined' || param.account.length === 0)
                return 'please enter account';
            if (typeof param.password == 'undefined' || param.password.length === 0)
                return 'please enter password';
            return true;
        }

        /**
         * 通过cookie的name获取指点的cookie
         * @param cookie_name
         * @returns {string}
         */
        function get_cookie_for_name(cookie_name) {
            var str_cookie = document.cookie;//获取cookie字符串
            var arr_cookie = str_cookie.split("; ");//分割
            //遍历匹配
            for (var i = 0; i < arr_cookie.length; i++) {
                var arr = arr_cookie[i].split("=");
                if (arr[0] === cookie_name) {
                    return arr[1];
                }
            }
            return "";
        }
    });
});