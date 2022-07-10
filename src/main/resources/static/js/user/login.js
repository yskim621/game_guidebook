function login_submit(){
    $.ajax({
        url: Helper.basePath + '/api/user/login',
        data: $("#loginForm").formToJson(),
        type: "POST",
        dataType: "json",
        beforeSend: function()
        {
            layer.load(1);
        },
        complete: function()
        {
            layer.closeAll('loading');
        },
        success: function(data){
            if(data.success){
                Helper.message.suc('로그인 성공!');
                window.location.href = Helper.basePath + "/board/list"
            }else{
                layer.alert(data.message);
            }

        },
        error: function(data){
            Helper.message.err('로그인 실패：' + data.message);
        }
    });
}

