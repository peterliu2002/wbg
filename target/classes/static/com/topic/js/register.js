function querusernameis() {

    $.ajax({
        type:"POST",
        url:"/comment/queryusername",
        data:{"username":$("#username").val()},
        success:function (data) {
            if (data > 0){
                $("#username").css({"border":"1px red solid"})
                $("#registerbtn").attr("disabled",true);
            }else {
                $("#username").css({"border":"1px green solid"})
                $("#registerbtn").attr("disabled",false);
            }
        }
    });
}