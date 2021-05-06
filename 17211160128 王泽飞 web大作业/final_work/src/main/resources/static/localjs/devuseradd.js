$(function(){
    devCode = $("#devCode");
    devName = $("#devName");
    devPassword = $("#devPassword");
    devPassword1 = $("#devPassword1");
    devEmail = $("#devEmail");

    //初始化的时候，要把所有的提示信息变为：* 以提示必填项，更灵活，不要写在页面上
    devCode.next().html("*");
    devName.next().html("*");
    devPassword.next().html("*");
    devPassword1.next().html("*");
    devEmail.next().html("*");


    /*
     * 验证
     * 失焦\获焦
     * jquery的方法传递
     */
    devCode.on("blur",function(){
        if(devCode.val() != null && devCode.val() != ""){
            validateTip(devCode.next(),{"color":"green"},"用户编码输入正确",true);
        }else{
            validateTip(devCode.next(),{"color":"red"},"用户编码不能为空，请重新输入",false);
        }
    }).on("focus",function(){
        //显示友情提示
        validateTip(devCode.next(),{"color":"#666666"},"* 请输入用户编码",false);
    }).focus();

    devName.on("focus",function(){
        validateTip(devName.next(),{"color":"#666666"},"* 请输入用户名称",false);
    }).on("blur",function(){

        if(devName.val() != null && devName.val() != "" && /^[0-9a-zA-Z]+$/.test(devName.val())){
            validateTip(devName.next(),{"color":"green"},"用户名称输入正确",true);
        }else{
            validateTip(devName.next(),{"color":"red"}," 商品名称不能为空，请重新输入",false);
        }

    });

    devPassword.on("focus",function(){
        validateTip(devPassword.next(),{"color":"#666666"},"* 密码格式正确",false);
    }).on("blur",function(){
        if(devPassword.val() != null && devPassword.val() != ""){
            validateTip(devPassword.next(),{"color":"green"},"密码格式正确",true);
        }else{
            validateTip(devPassword.next(),{"color":"red"}," 密码格式不正确，请重新输入",false);
        }

    });

    devPassword1.on("focus",function(){
        validateTip(devPassword1.next(),{"color":"#666666"},"* 请选择供应商",false);
    }).on("blur",function(){
        if(devPassword1.val() != null && devPassword1.val() != "" && devPassword1.val() == devPassword.val()){
            validateTip(devPassword1.next(),{"color":"green"},"两次密码输入相同",true);
        }else{
            validateTip(devPassword1.next(),{"color":"red"},"两次密码输入不相同",false);
        }

    });


});