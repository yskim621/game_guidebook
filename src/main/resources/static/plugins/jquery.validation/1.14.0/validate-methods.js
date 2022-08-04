/*******************************************************************************
 * jQuery Validate扩展验证方法 (linjq)
 ******************************************************************************/
(function(){
    // 判断整数value是否等于0
    $.validator.addMethod("isIntEqZero", function(value, element) { 
         value=parseInt(value);      
         return this.optional(element) || value==0;       
    }, "정수를 입력해주세요"); 
      
    // 判断整数value是否大于0
    $.validator.addMethod("isIntGtZero", function(value, element) { 
         value=parseInt(value);      
         return this.optional(element) || value>0;       
    }, "정수를 입력해 주세요"); 
      
    // 判断整数value是否大于或等于0
    $.validator.addMethod("isIntGteZero", function(value, element) { 
         value=parseInt(value);      
         return this.optional(element) || value>=0;       
    }, "정수는 0 이거나 0 보다 커야합니다");   
    
    // 判断整数value是否不等于0
    $.validator.addMethod("isIntNEqZero", function(value, element) { 
         value=parseInt(value);      
         return this.optional(element) || value!=0;       
    }, "정수는 0 과 같을수 없습니다");  
    
    // 判断整数value是否小于0
    $.validator.addMethod("isIntLtZero", function(value, element) { 
         value=parseInt(value);      
         return this.optional(element) || value<0;       
    }, "정수는 0 보다 작아야 합니다");  
    
    // 判断整数value是否小于或等于0
    $.validator.addMethod("isIntLteZero", function(value, element) { 
         value=parseInt(value);      
         return this.optional(element) || value<=0;       
    }, "정수는 0 이거나 0 보다 작아야합니다");  
    
    // 判断浮点数value是否等于0
    $.validator.addMethod("isFloatEqZero", function(value, element) { 
         value=parseFloat(value);      
         return this.optional(element) || value==0;       
    }, "실수는 0 이어야 합니다"); 
      
    // 判断浮点数value是否大于0
    $.validator.addMethod("isFloatGtZero", function(value, element) { 
         value=parseFloat(value);      
         return this.optional(element) || value>0;       
    }, "실수를 입력해주세요"); 
      
    // 判断浮点数value是否大于或等于0
    $.validator.addMethod("isFloatGteZero", function(value, element) { 
         value=parseFloat(value);      
         return this.optional(element) || value>=0;       
    }, "실수는 0 이거나 0 보다 커야합니다");   
    
    // 判断浮点数value是否不等于0
    $.validator.addMethod("isFloatNEqZero", function(value, element) { 
         value=parseFloat(value);      
         return this.optional(element) || value!=0;       
    }, "실수는 0 과 같을수 없습니다");  
    
    // 判断浮点数value是否小于0
    $.validator.addMethod("isFloatLtZero", function(value, element) { 
         value=parseFloat(value);      
         return this.optional(element) || value<0;       
    }, "실수는 0 보다 작아야 합니다");  
    
    // 判断浮点数value是否小于或等于0
    $.validator.addMethod("isFloatLteZero", function(value, element) { 
         value=parseFloat(value);      
         return this.optional(element) || value<=0;       
    }, "실수는 0 이거나 0 보다 작아야합니다");  
    
    // 判断浮点型
    $.validator.addMethod("isFloat", function(value, element) {       
         return this.optional(element) || /^[-\+]?\d+(\.\d+)?$/.test(value);       
    }, "숫자만 입력 가능합니다"); 
     
    // 匹配integer
    $.validator.addMethod("isInteger", function(value, element) {       
         return this.optional(element) || (/^[-\+]?\d+$/.test(value) && parseInt(value)>=0);       
    }, "정수와 일치합니다");  
     
    // 判断数值유형，包括整数和浮点数
    $.validator.addMethod("isNumber", function(value, element) {       
         return this.optional(element) || /^[-\+]?\d+$/.test(value) || /^[-\+]?\d+(\.\d+)?$/.test(value);       
    }, "숫자유형과 일치합니다");  
    
    // 只能입력[0-9]数字
    $.validator.addMethod("isDigits", function(value, element) {       
         return this.optional(element) || /^\d+$/.test(value);       
    }, "0-9 숫자만 입력가능합니다");  
    
    // 判断중국어字符
    $.validator.addMethod("isChinese", function(value, element) {       
         return this.optional(element) || /^[\u0391-\uFFE5]+$/.test(value);       
    }, "한글만 입력가능합니다");   
 
    // 判断英文字符
    $.validator.addMethod("isEnglish", function(value, element) {       
         return this.optional(element) || /^[A-Za-z]+$/.test(value);       
    }, "영문만 입력가능합니다");   
 
     // 전화번호验证
    $.validator.addMethod("isMobile", function(value, element) {    
      var length = value.length;    
      return this.optional(element) || (length == 11 && /^(((010)|(13[0-9]{1})|(15[0-35-9]{1})|(17[0-9]{1})|(18[0-9]{1}))+\d{8})$/.test(value));    
    }, "정확한 전화번호를 입력해주세요");

    // 전화号码验证
    $.validator.addMethod("isPhone", function(value, element) {    
      var tel = /^(\d{3,4}-?)?\d{7,9}$/g;    
      return this.optional(element) || (tel.test(value));    
    }, "정확한 전화번호를 입력해주세요");

    // 전화번호(전화번호/전화皆可)验证
    $.validator.addMethod("isTel", function(value,element) {   
        var length = value.length;   
        var mobile = /^(((13[0-9]{1})|(15[0-35-9]{1})|(17[0-9]{1})|(18[0-9]{1}))+\d{8})$/;
        var tel = /^(\d{3,4}-?)?\d{7,9}$/g;       
        return this.optional(element) || tel.test(value) || (length==11 && mobile.test(value));   
    }, "올바른 전화번호를 입력해주세요"); 
 
     // 匹配qq
    $.validator.addMethod("isQq", function(value, element) {       
         return this.optional(element) || /^[1-9]\d{4,12}$/;       
    }, "QQ번호와 일치합니다");   
 
     // 邮政编码验证
    $.validator.addMethod("isZipCode", function(value, element) {    
      var zip = /^[0-9]{6}$/;    
      return this.optional(element) || (zip.test(value));    
    }, "정확한 우편번호를 입력해주세요 ");  
    
    // 匹配비밀번호，영문/숫자 혼합하여 6~12자리 이상 입력해주세요
    $.validator.addMethod("isPwd", function(value, element) {       
         return this.optional(element) || /^[a-zA-Z]\w{5,12}$/.test(value);       
    }, "영문/숫자 혼합하여 6~12자리 이상 입력해주세요");  
    
    // 身份证号码验证
    $.validator.addMethod("isIdCardNo", function(value, element) { 
      // var idCard = /^(\d{6})()?(\d{4})(\d{2})(\d{2})(\d{3})(\w)$/;
      return this.optional(element) || isIdCardNo(value);    
    }, "신분증번호를 입력해주세요"); 

    // IP주소验证
    $.validator.addMethod("ip", function(value, element) {    
      return this.optional(element) || /^(([1-9]|([1-9]\d)|(1\d\d)|(2([0-4]\d|5[0-5])))\.)(([1-9]|([1-9]\d)|(1\d\d)|(2([0-4]\d|5[0-5])))\.){2}([1-9]|([1-9]\d)|(1\d\d)|(2([0-4]\d|5[0-5])))$/.test(value);    
    }, "정확한 IP주소를 입력해주세요");
   
    // 字符验证，영문/숫자 및 일부특수문자만 가능합니다。
    $.validator.addMethod("stringCheck", function(value, element) {       
         return this.optional(element) || /^[a-zA-Z0-9\u4e00-\u9fa5-_]+$/.test(value);       
    }, "영문/숫자 및 일부특수문자만 가능합니다");   
   
    // 匹配english
    $.validator.addMethod("isEnglish", function(value, element) {       
         return this.optional(element) || /^[A-Za-z]+$/.test(value);       
    }, "영문과 일치합니다");   
    
    // 匹配汉字
    $.validator.addMethod("isChinese", function(value, element) {       
         return this.optional(element) || /^[\u4e00-\u9fa5]+$/.test(value);       
    }, "한글과 일치합니다");   
    
    // 匹配중국어(包括汉字和字符)
    $.validator.addMethod("isChineseChar", function(value, element) {       
         return this.optional(element) || /^[\u0391-\uFFE5]+$/.test(value);       
    }, "중문과 일치합니다(한자및부호)"); 
      
    // 判断是否为合法字符(a-zA-Z0-9-_)
    $.validator.addMethod("isRightfulString", function(value, element) {       
         return this.optional(element) || /^[A-Za-z0-9_-]+$/.test(value);       
    }, "다음과 조건과 부합하는지 판단합니다");   
    
    // 判断是否包含中英文特殊字符，除英文"-_"字符外
    $.validator.addMethod("isContainsSpecialChar", function(value, element) {  
         var reg = RegExp(/[(\ )(\`)(\~)(\!)(\@)(\#)(\$)(\%)(\^)(\&)(\*)(\()(\))(\+)(\=)(\|)(\{)(\})(\')(\:)(\;)(\')(',)(\[)(\])(\.)(\<)(\>)(\/)(\?)(\~)(\！)(\@)(\#)(\￥)(\%)(\…)(\&)(\*)(\（)(\）)(\—)(\+)(\|)(\{)(\})(\【)(\】)(\‘)(\；)(\：)(\”)(\“)(\’)(\。)(\，)(\、)(\？)]+/);   
         return this.optional(element) || reg.test(value);       
    }, "특수문자가 포함되어 있습니다");
    
    // 判断是否email
    $.validator.addMethod("isEmail", function(value, element) {  
         var reg = RegExp(/^[_a-zA-Z0-9\-]+(\.[_a-zA-Z0-9\-]*)*@[a-zA-Z0-9\-]+([\.][a-zA-Z0-9\-]+)+$/);   
         return this.optional(element) || reg.test(value);       
    }, "이메일 주소를 입력해주세요");
})(jQuery);
// 身份证号码的验证规则
function isIdCardNo(num){ 
	// if (isNaN(num)) {alert("입력的不是数字！"); return false;}
	var len = num.length, re; 
	if (len == 15) 
		re = new RegExp(/^(\d{6})()?(\d{2})(\d{2})(\d{2})(\d{2})(\w)$/); 
		else if (len == 18) 
			re = new RegExp(/^(\d{6})()?(\d{4})(\d{2})(\d{2})(\d{3})(\w)$/); 
		else {
		// alert("입력的数字位数不对。");
		return false;
	}
	var a = num.match(re); 
	if (a != null) 
	{ 
		if (len==15) 
		{ 
			var D = new Date("19"+a[3]+"/"+a[4]+"/"+a[5]); 
			var B = D.getYear()==a[3]&&(D.getMonth()+1)==a[4]&&D.getDate()==a[5]; 
		}
		else 
		{ 
			var D = new Date(a[3]+"/"+a[4]+"/"+a[5]); 
			var B = D.getFullYear()==a[3]&&(D.getMonth()+1)==a[4]&&D.getDate()==a[5]; 
		} 
		if (!B) {
			// alert("입력的身份证号 "+ a[0] +" 里出生日期不对。");
			return false;
			} 
		} 
		if(!re.test(num)){
			// alert("身份证最后一位只能是数字和字母。");
			return false;
		}
		return true; 
} 
// 车牌号검사
function isPlateNo(plateNo){
    var re = /^[\u4e00-\u9fa5]{1}[A-Z]{1}[A-Z_0-9]{5}$/;
    if(re.test(plateNo)){
        return true;
    }
    return false;
}