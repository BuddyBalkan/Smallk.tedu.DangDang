$(function () {
   // 邮箱email验证
   $("#email").blur(function () {
       // alert("Hi"); // Test
        var emailContent = $("#email").val();
       // alert(emailContent); //Test
       if (emailContent.length == 0){ // 输入为空的判断
           $("#emailInfo")
               .text("注册账号可是需要一个邮箱账号的")
                .css("color","#ff0000");
       }else { //输入不为空 判断格式
            var reg = /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;
            if (reg.test(emailContent)){ // 邮箱正确
                $("#emailInfo")
                    .text("本AI宣布：这个邮箱可以有")
                    .css("color","#11ab83");
                // 在邮箱格式正确的情况下 判断是否该邮箱是否被注册
                // Ajax技术 实现局部刷新
                $.ajax({
                   type:"get",
                   url:"/checkEmail",
                   data:{email:$(this).val()}
                });
            }else { // 邮箱不正确
                $("#emailInfo")
                    .text("这个真的是个邮箱？别逗了")
                    .css("color","#ff0000");
            }
       }
   });

   // 昵称txtNickName验证
    $("#txtNickName").blur(function () {
        if ($("#txtNickName").val().length == 0){
            $("#nameInfo")
                .text("昵称不能为空诶，不然别人不知道怎么叫你了")
                .css("color","#ff0000");
        }else {
            var reg = /^[a-z\d\u4e00-\u9fa5]{4,20}$/;
            if (reg.test($("#txtNickName").val())){
                $("#nameInfo")
                    .text("我觉得这个昵称可以")
                    .css("color","#04a980");
            }else {
                $("#nameInfo")
                    .text("你输入的是什么鬼啊，我要严格一点，我觉得不行")
                    .css("color","#ff0000");
            }
        }
    })

   // 密码txtPassword验证
    $("#txtPassword").blur(function () {
        if($("#txtPassword").val().length == 0){
            $("#passwordInfo")
                .text("空密码不安全，别图一时方便，哪天说不定账户里的资料啥的就全没了")
                .css("color","#ff0000");
        }else {
            var reg = /^[a-zA-Z\d]{6,20}$/;
            if (reg.test($("#txtPassword").val())){
                $("#passwordInfo")
                    .text("这个密码不错哟")
                    .css("color","#04a980");
            }else {
                $("#passwordInfo")
                    .text("这个存到服务器里会报错的，按照要求想个密码吧")
                    .css("color","#ff0000");
            }
        }
    })

   // 重复密码txtRepeatPass验证
    $("#txtRepeatPass").blur(function () {
        if ($("#txtRepeatPass").val().length == 0){
            $("#password1Info")
                .text("本AI在存储你的密码之前要确认你没有输入错误噢，再核实一下你想的密码吧")
                .css("color","#ff0000");
        }else if($("#txtRepeatPass").val() == $("#txtPassword").val()){
            $("#password1Info")
                .text("哟哟切克闹，核实成功啦，以后别轻易忘掉噢")
                .css("color","#04a980");
        }else {
            $("#password1Info")
                .text("啧啧啧，是不是小手抖一下，不小心输入错误了")
                .css("color","#ff0000");
        }
    })


   // 验证码imageCode验证


});