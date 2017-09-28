$(function () {
   // 邮箱email验证
   $("#email").blur(function () {
       // alert("Hi"); // Test
        var emailContent = $("#email").val();
       // alert(emailContent); //Test
       if (emailContent.length == 0){ // 输入为空的判断
           $("#emailInfo").text("注册账号可是需要一个邮箱账号的")
                            .css("color","#ff0000");
       }else { //输入不为空 判断格式
            var reg = /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;
            if (reg.test(emailContent)){ // 邮箱正确
                $("#emailInfo").text("本AI宣布：这个邮箱可以有")
                                .css("color","#11ab83");
            }else { // 邮箱不正确
                $("#emailInfo").text("这个真的是个邮箱？别逗了")
                                .css("color","#ff0000");
            }
       }
   });

   // 昵称txtNickName验证
    $("#txtNickName").blur(function () {
        if ($("#txtNickName").val().length == 0){
            $("#nameInfo").text("昵称不能为空诶，不然别人不知道怎么叫你了");
        }else {
            var reg = /^[a-z\d\u4e00-\u9fa5]{4,20}$/;
            if (reg.test($("#txtNickName").val())){
                $("#nameInfo").text("我觉得这个昵称可以");
            }else {
                $("#nameInfo").text("你输入的是什么鬼啊，我要严格一点，我觉得不行");
            }
        }
    })

   // 密码txtPassword验证


   // 重复密码txtRepeatPass验证


   // 验证码imageCode验证


});