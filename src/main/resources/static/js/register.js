$(document).ready(function () {
    layui.use(['layer', 'form'], function () {
        var layer,form;
        layer = layui.layer;
        form = layui.form;
        var checked = 3;
        var a1 = 0;
        var a2 = 0;
        var a3 = 0;
        var account = $('input[type=text]input[name=account]');
        var email = $('input[type=text]input[name=email]');
        var phone = $('input[type=text]input[name=phone]');
        var account_checked = $('input[type=checkbox]input[name=account]');
        var email_checked = $('input[type=checkbox]input[name=email]');
        var phone_checked = $('input[type=checkbox]input[name=phone]');
        form.on('checkbox(account)', function (data) {
            if (false === data.elem.checked) {
                checked--;
                a1 = 1;
                account.attr('disabled', true);
                account.css('background-color', '#c6c6c6');
                account.css('cursor', 'not-allowed');
                console.log('go');
                checkBoxLast(checked);
            } else {
                account.attr('disabled', false);
                account.css('background-color', '#fff');
                account.css('cursor', 'auto');
                checked++;
                a1 = 0;
                checkBoxLast(checked);
            }
        });
        form.on('checkbox(email)', function (data) {
            if (false === data.elem.checked) {
                checked--;
                a2 = 1;
                email.attr('disabled', true);
                email.css('background-color', '#c6c6c6');
                email.css('cursor', 'not-allowed');
                checkBoxLast(checked);
            } else {
                email.attr('disabled', false);
                email.css('background-color', '#fff');
                email.css('cursor', 'auto');
                checked++;
                a2 = 0;
                checkBoxLast(checked);
            }
        });
        form.on('checkbox(phone)', function (data) {
            if (false === data.elem.checked) {
                checked--;
                a3 = 1;
                phone.attr('disabled', true);
                phone.css('background-color', '#c6c6c6');
                phone.css('cursor', 'not-allowed');
                checkBoxLast(checked);
            } else {
                phone.attr('disabled', false);
                phone.css('background-color', '#fff');
                phone.css('cursor', 'auto');
                checked++;
                a3 = 0;
                checkBoxLast(checked);
            }
        });
        function checkBoxLast(count) {
            var val1 = account_checked.is(':checked');
            var val2 = email_checked.is(':checked');
            var val3 = phone_checked.is(':checked');
            if (count === 1) {
                if (val1) {
                    account_checked.attr('disabled', true);
                    account_checked.next('div').addClass('layui-disabled');
                    account_checked.next('div').children('span').css('color', '#c6c6c6');
                    a1 =1;
                }else if(val2) {
                    email_checked.attr('disabled', true);
                    email_checked.next('div').addClass('layui-disabled');
                    email_checked.next('div').children('span').css('color', '#c6c6c6');
                    a2 = 1;
                }else if (val3) {
                    phone_checked.attr('disabled', true);
                    phone_checked.next('div').addClass('layui-disabled');
                    phone_checked.next('div').children('span').css('color', '#c6c6c6');
                    a3 = 1;
                }
            }else {
                console.log('count = ' + count);
                if (val1 && a1 === 1) {
                    console.log('1');
                    account_checked.attr('disabled', false);
                    account_checked.next('div').removeClass('layui-disabled');
                    account_checked.next('div').children('span').css('color', '#666');
                    a1 = 0;
                }else if(val2 && a2 === 1) {
                    console.log('2');
                    email_checked.attr('disabled', false);
                    email_checked.next('div').removeClass('layui-disabled');
                    email_checked.next('div').children('span').css('color', '#666');
                    a2 = 0;
                }else if(val3 && a3 === 1) {
                    console.log('3');
                    phone_checked.attr('disabled', false);
                    phone_checked.next('div').removeClass('layui-disabled');
                    phone_checked.next('div').children('span').css('color', '#666');
                    a3 = 0;
                }
            }
        }
    });
});