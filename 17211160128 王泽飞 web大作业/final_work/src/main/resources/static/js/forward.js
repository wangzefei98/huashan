function validateTip(element,css,tipString,status){
    element.css(css);
    element.html(tipString);
    element.prev().attr("validateStatus",status);
}

var referer = $("#referer").val();
$(function () {
    var new_name=$("#name");
    new_name.next().html("*");
    new_name.bind("focus",function(){
        validateTip(new_name.next(),{"color":"green"},"* 用户名长度必须是大于1小于10的字符",false);
    }).bind("blur",function(){
        if(new_name.val() != null && new_name.val().length > 1
            && new_name.val().length < 10){
            validateTip(new_name.next(),{"color":"green"},"用户名可用",true);
        }else{
            validateTip(new_name.next(),{"color":"red"}," 用户名输入的不符合规范，请重新输入",false);
        }

    });

    //17211160128 王泽飞
    var patten=/^[A-Za-z0-9\u4e00-\u9fa5]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/;
    var new_email=$("#email");
    new_email.next().html("*");
    new_email.bind("focus",function(){
        validateTip(new_email.next(),{"color":"green"},"*邮箱格式为登录名@主机名.域名",false);
    }).bind("blur",function(){
        if(new_email.val() != null && new_email.match(patten)){
            validateTip(new_email.next(),{"color":"green"},"邮箱格式正确",true);
        }else{
            validateTip(new_email.next(),{"color":"red"}," 邮箱格式不正确，请重新填写",false);
        }

    });

})