$(function () {
    var isEmail = false;
    var isTxtNickName = false;
    var isTxtPassword = false;
    var isTxtRepeatPass = false;
    var isValidateCode = false;
   // 邮箱email验证
   $("#email").blur(function () {
       // alert("Hi"); // Test
        var emailContent = $("#email").val();
       // alert(emailContent); //Test
       if (emailContent.length == 0){ // 输入为空的判断
           $("#emailInfo")
               .text("注册账号可是需要一个邮箱账号的")
                .css("color","#ff0000");
           isEmail = false;
       }else { //输入不为空 判断格式
            var reg = /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;
            if (reg.test(emailContent)){ // 邮箱正确
                // 在邮箱格式正确的情况下 判断是否该邮箱是否被注册
                // Ajax技术 实现局部刷新
                $.ajax({
                   type:"get",
                   url:"/checkEmail",
                   data:{email:$(this).val()},

                    success:function (flag) {
                        // alert(flag); // Test
                        if (flag == 1){
                            $("#emailInfo")
                                .text("哎呀，这个账户有人注册过啦")
                                .css("color","#ff0000");
                            isEmail = false;
                        };
                        if (flag == 0){
                            $("#emailInfo")
                                .text("本AI宣布：这个邮箱可以有")
                                .css("color","#11ab83");
                            isEmail = true;
                        }
                    }
                });
            }else { // 邮箱不正确
                $("#emailInfo")
                    .text("这个真的是个邮箱？别逗了")
                    .css("color","#ff0000");
                isEmail = false;
            }
       }
   });

   // 昵称txtNickName验证
    $("#txtNickName").blur(function () {
        if ($("#txtNickName").val().length == 0){
            $("#nameInfo")
                .text("昵称不能为空诶，不然别人不知道怎么叫你了")
                .css("color","#ff0000");
            isTxtNickName = false;
        }else {
            var reg = /^[a-z\d\u4e00-\u9fa5]{4,20}$/;
            if (reg.test($("#txtNickName").val())){
                $("#nameInfo")
                    .text("我觉得这个昵称可以")
                    .css("color","#04a980");
                isTxtNickName = true;
            }else {
                $("#nameInfo")
                    .text("你输入的是什么鬼啊，我要严格一点，我觉得不行")
                    .css("color","#ff0000");
                isTxtNickName = false;
            }
        }
    });

   // 密码txtPassword验证
    $("#txtPassword").blur(function () {
        if($("#txtPassword").val().length == 0){
            $("#passwordInfo")
                .text("空密码不安全，别图一时方便，哪天说不定账户里的资料啥的就全没了")
                .css("color","#ff0000");
            isTxtPassword = false;
        }else {
            var reg = /^[a-zA-Z\d]{6,20}$/;
            if (reg.test($("#txtPassword").val())){
                $("#passwordInfo")
                    .text("这个密码不错哟")
                    .css("color","#04a980");
                isTxtPassword = true;
            }else {
                $("#passwordInfo")
                    .text("这个存到服务器里会报错的，按照要求想个密码吧")
                    .css("color","#ff0000");
                isTxtPassword = false;
            }
        }
    });

   // 重复密码txtRepeatPass验证
    $("#txtRepeatPass").blur(function () {
        if ($("#txtRepeatPass").val().length == 0){
            $("#password1Info")
                .text("本AI在存储你的密码之前要确认你没有输入错误噢，再核实一下你想的密码吧")
                .css("color","#ff0000");
            isTxtRepeatPass = false;
        }else if($("#txtRepeatPass").val() == $("#txtPassword").val()){
            $("#password1Info")
                .text("哟哟切克闹，核实成功啦，以后别轻易忘掉噢")
                .css("color","#04a980");
            isTxtRepeatPass = true;
        }else {
            $("#password1Info")
                .text("啧啧啧，是不是小手抖一下，不小心输入错误了")
                .css("color","#ff0000");
            isTxtRepeatPass = false;
        }
    });

   // 验证码imageCode验证
    $("#validateCode").blur(function () {
       if ($("#validateCode").val().length == 0){
           $("#numberInfo")
               .text("本AI需要确认你是不是人类")
               .css("color","#ff0000");
           isValidateCode = false;
       }else { // 将用户输入的验证码 发送至服务器 由服务器来检查输入是否正确
           $.ajax({
               type:"get",
               url:"/checkCode",
               data:{ verificationCode: $(this).val()},
               success:(function (flag) {
                if (flag == 1){
                    $("#numberInfo")
                        .text("呦，输入正确了")
                        .css("color","#04a980");
                    isValidateCode = true;
                };
                if (flag == 0){
                    $("#numberInfo")
                        .text("是不是很难辨认啊，没事再来一次")
                        .css("color","#ff0000");
                    isValidateCode = false;
                }
               })

           })
       }
    });

    $("#f").submit(function () {
        return isEmail && isTxtNickName && isTxtPassword && isTxtRepeatPass && isValidateCode; // 如果为false无法提交表单
    });

});