var isAuthenticated = false;

$.validator.addMethod("isPassAuthentication", function(value, element) {
    // validate check function
    return this.optional(element) || isAuthenticated;
});

$("#registerForm").validate({
    submitHandler: function(form)
    {
        form.submit();
    },
    rules: {
        "name": {
            required: true,
            maxlength:30,
            stringCheck:true,
            remote: {
                type: "POST",
                url: Helper.basePath + '/api/user/register/exist/name',
                dataType: "json",
                data: {
                    userName: function()
                    {
                        return $("#name").val()
                    }
                }
            }
        },
        "mobile": {
            required: true,
            isMobile: true,
            remote: {
                type: "POST",
                url: Helper.basePath + '/api/user/register/exist/mobile',
                dataType: "json",
                data: {
                    mobile: function()
                    {
                        return $("#mobile").val()
                    }
                }
            }
        },
        "userCode": {
            required: true,
            isPassAuthentication: true
        },
        "email": {
            required: true,
            isEmail: true,
            remote: {
                type: "POST",
                url: Helper.basePath + '/api/user/register/exist/email',
                dataType: "json",
                data: {
                    email: function()
                    {
                        return $("#email").val()
                    }
                }
            }
        },
        "password": {
            minlength: 6,
            required: true,
            isPwd:false
        },
        "confirm_password": {
            required: true,
            minlength: 6,
            equalTo: "#password"
        },
    },
    messages: {
        name: {
            required: '<span class="m_error"><i>*</i>아이디를 입력해주세요</span>',
            maxlength: '<span class="m_error"><i>*</i>최대 {0}자 입력가능합니다</span>',
            stringCheck:'<span class="m_error"><i>*</i>영문/숫자 및 일부특수문자만 가능합니다</span>',
            remote: '<span class="m_error"><i>*</i>아이디가 존재합니다</span>'
        },
        mobile: {
            required: '<span class="m_error"><i>*</i>전화번호를 입력해주세요</span>',
            isMobile: '<span class="m_error"><i>*</i>올바른 전화번호를 입력해주세요</span>',
            remote: '<span class="m_error"><i>*</i>전화번호가 이미 존재합니다</span>'
        },
        userCode: {
            required: '<span class="m_error"><i>*</i>인증번호를 입력해주세요</span>',
            isPassAuthentication: '<span class="m_error"><i>*</i>휴대폰 인증 후 회원가입 해주세요</span>',
        },
        email: {
            required: '<span class="m_error"><i>*</i>이메일 주소를 입력해 주세요</span>',
            isEmail: '<span class="m_error"><i>*</i>이메일 주소 형식이 아닙니다</span>',
            remote: '<span class="m_error"><i>*</i>이미 사용중인 이메일 주소입니다</span>'
        },
        password: {
            minlength:'<span class="m_error"><i>*</i>6자리이상 입력해주세요</span>',
            required: '<span class="m_error"><i>*</i>비밀번호를 입력해주세요</span>',
            isPwd:'<span class="m_error"><i>*</i>영문/숫자 혼합하여 6~12자리 이상 입력해주세요</span>',
        },
        confirm_password: {
            required: '<span class="m_error"><i>*</i>비밀번호를 입력해주세요</span>',
            minlength: '<span class="m_error"><i>*</i>6자리이상 입력해주세요</span>',
            equalTo: '<span class="m_error"><i>*</i>입력하신 비밀번호가 일치하지않습니다</span>'
        }
    },
    onkeyup: false,
    onfocusout: false,
    onsubmit: true
});


function sendSms(){
    let mobileNo = $("#mobile").val();
    if (mobileNo != null){
        Helper.post(Helper.basePath + "/register/authentication/send-sms" ,{
            "mobile": mobileNo
        },function(result){
            if(result.success) {
                sessionStorage.setItem("authenticateCode", result.message);
                Helper.message.suc("발송완료！");
            }else {
                Helper.message.warn(result.message);
            }
        },function(){
            Helper.message.warn("발송실패！");
        });
    } else {
        Helper.message.warn("휴대폰 번호를 입력해주세요！");
    }
}

function confirm_authenticateCode() {
    Helper.post(Helper.basePath + "/register/authentication/confirm-code" , {
        "authenticateCode": sessionStorage.getItem("authenticateCode"),
        "userCode": $("#userCode").val()
    },function(result){
        if(result.success) {
            isAuthenticated = true;
            Helper.message.suc("인증 성공！");
        }else {
            $("#userCode").val("");
            Helper.message.warn(result.message);
        }
    },function(){
        Helper.message.warn("인증 실패！");
    })
}