<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta http-equiv="Cache-Control" content="no-siteapp" />
<meta name="keywords" content="인쇄,프린팅웍스">
<meta name="description" content="인쇄">
<meta name="viewport"
	content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<!--[if lt IE 9]>
<script type="text/javascript" src="/static/plugins/html5.js"></script>
<script type="text/javascript" src="/static/plugins/respond.min.js"></script>
<script type="text/javascript" src="/static/plugins/PIE_IE678.js"></script>
<![endif]-->

<!--[if IE 6]>
<script type="text/javascript" src="/static/plugins/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->

<script type="text/javascript"
	src="/static/plugins/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript"
	src="/static/plugins/jquery.form/jquery.form.js"></script>
<script type="text/javascript"
	src="/static/plugins/jquery.cookie/jquery.cookie.js"></script>
<script type="text/javascript"
	src="/static/plugins/jquery.validation/1.14.0/jquery.validate.min.js"></script>
<script type="text/javascript"
	src="/static/plugins/jquery.validation/1.14.0/validate-methods.js"></script>
<script type="text/javascript"
	src="/static/plugins/jquery.validation/1.14.0/messages_zh.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="${ctxStatic}/plugins/jquery.select2/css/select2.css" />
<script type="text/javascript"
	src="${ctxStatic}/plugins/jquery.select2/js/select2.js"></script>
<script type="text/javascript"
	src="${ctxStatic}/plugins/jquery.select2/js/i18n/zh-CN.js"></script>
<!-- date -->
<script type="text/javascript"
	src="${ctxStatic}/plugins/My97DatePicker/WdatePicker.js"></script>
<!-- layer -->
<link rel="stylesheet" type="text/css"
	href="${ctxStatic}/plugins/laypage/1.3/skin/laypage.css" />
<link rel="stylesheet" type="text/css"
	href="${ctxStatic}/plugins/layer/skin/default/layer.css" />
<script type="text/javascript"
	src="${ctxStatic}/plugins/layer/layer.js"></script>
<script type="text/javascript"
	src="${ctxStatic}/plugins/laypage/1.3/laypage.js"></script>
<!-- bootstrap -->
<link rel="stylesheet" type="text/css"
	href="${ctxStatic}/plugins/bootstrap-table/bootstrap.min.css" />
<script type="text/javascript"
	src="${ctxStatic}/plugins/bootstrap-table/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="${ctxStatic}/plugins/bootstrap-table/bootstrap-table.min.css" />
<script type="text/javascript"
	src="${ctxStatic}/plugins/bootstrap-table/bootstrap-table.js"></script>
<script type="text/javascript"
	src="${ctxStatic}/plugins/bootstrap-table/bootstrap-table-zh-CN.min.js"></script>
<!-- bootstrap extensions -->
<script type="text/javascript"
	src="${ctxStatic}/plugins/bootstrap-table/extensions/cookie/bootstrap-table-cookie.js"></script>
<script type="text/javascript"
	src="${ctxStatic}/plugins/bootstrap-table/extensions/export/bootstrap-table-export.js"></script>
<script type="text/javascript"
	src="${ctxStatic}/plugins/bootstrap-table/extensions/export/tableExport.min.js"></script>
<script type="text/javascript"
	src="${ctxStatic}/plugins/bootstrap-table/extensions/export/jspdf.min.js"></script>
<script type="text/javascript"
	src="${ctxStatic}/plugins/bootstrap-table/extensions/export/jspdf.plugin.autotable.js"></script>
<script type="text/javascript"
	src="${ctxStatic}/plugins/bootstrap-table/extensions/export/html2canvas.min.js"></script>
<script type="text/javascript"
	src="${ctxStatic}/plugins/bootstrap-table/extensions/resizable/bootstrap-table-resizable.js"></script>
<!-- colResizable -->
<script type="text/javascript"
	src="${ctxStatic}/plugins/colResizable/colResizable-1.6.min.js"></script>
<!-- guidebook -->
<script type="text/javascript" src="${ctxStatic}/site/public.js?v=${v }"></script>
<script type="text/javascript"
	src="${ctxStatic}/plugins/ueditor/ueditor.config.js"></script>
<script type="text/javascript"
	src="${ctxStatic}/plugins/ueditor/ueditor.all.js"></script>
<!-- 공급가액转大写  -->
<script type="text/javascript" src="${ctxStatic}/plugins/print/formatMoney.js"></script>
<script type="text/javascript" src="${ctxStatic}/layout/js/main.js"></script>
<script type="text/javascript" src="${ctxStatic}/plugins/jquery.powerFloat/js/mini/jquery-powerFloat-min.js"></script>
<link rel="stylesheet" type="text/css"
	href="${ctxStatic}/plugins/jquery.powerFloat/css/powerFloat.css?${v }" />
<link rel="stylesheet" type="text/css"
	href="${ctxStatic}/layout/css/style.css?${v }" />
<link rel="stylesheet" type="text/css"
	href="${ctxStatic}/layout/font-awesome/css/font-awesome.css?${v }" />
<!-- 皮肤样式  -->
<link id="frameskin" rel="stylesheet" type="text/css" href="" />
<script type="text/javascript">
    //$.noConflict(true);  // <- this：Uncaught TypeError: Cannot read property 'addMethod' of undefined

    Helper.basePath = "${ctx}";
    Helper.staticPath = "${ctxStatic}";
    Helper.bootPageList = [ 10,20,50,100,500,'ALL'];
    $(document).ready(function()
    {
        try {
            // 링크去掉虚框1
            $("a").bind("focus", function()
            {
                if(this.blur) {
                    this.blur()
                }
                ;
            });
            //所有下拉框使用select2
            $(".hy_select2").select2({
                language: "zh-CN",
                minimumResultsForSearch: 8,
            });
            /*表格列拖动-针对没用bootstrap-table的表格*/
            $(".table_resizable").colResizable({
                resizeMode: 'overflow'
            });
        }catch(e) {
            // blank
        }
        //回车键저장表单
        $(document).keyup(function(event){
       	  if(event.keyCode ==13){
       		  	//优先级：검색按钮->ok按钮->견적按钮->表单저장按钮
	       		if($("#btn_search").length>0){
					$("#btn_search").trigger("click");
				}else if($("#btn_ok").length>0){
					$("#btn_ok").trigger("click");
				}else if($("#offer_btn").length>0){
					$("#offer_btn").trigger("click");
				}else{
					$("input[type=submit]").trigger("click");
				}
       	  }
       	});
        //设置可편집下拉框
        $(document).on("change", ".slt_val_change", function()
        {
            $(this).next().val($(this).find("option:selected").text());
        })

        /*전체-선택所有复选框*/
        $(document).on('click', 'thead input[type=checkbox]', function()
        {
            if($(this).attr('checked') != 'checked') {
                $(this).attr('checked', 'checked');
                $(this).parentsUntil('table').next().children().addClass('chang_color').find('input[type=checkbox]').prop('checked', true);
            }else if($(this).attr('checked') == 'checked') {
                $(this).removeAttr('checked');
                $(this).parentsUntil('table').next().children().removeClass('chang_color').find('input[type=checkbox]').removeAttr('checked');
            }
        });

        //전화号码的控制
        $(document).on('keypress', ".constraint_tel", function()
        {
            return (/\d|\-/.test(String.fromCharCode(event.keyCode)));
        });
        //전화号码的控制
        $(document).on('blur', ".constraint_tel", function()
        {
            $(this).val($(this).val().trim());
            if(Helper.isEmpty($(this.val())) || Helper.validata.isTelephone($(this).val())) {

            }else {
                Helper.message.tips("전화번호를 입력해주세요", this);
                $(this).focus();//触发再次获得焦点事件
            }
        });

        //전화번호的控制
        $(document).on('keypress', ".constraint_mobile", function()
        {
            return (/\d/.test(String.fromCharCode(event.keyCode)));
        });
        //전화번호的控制
        $(document).on('blur', ".constraint_mobile", function()
        {
            $(this).val($(this).val().trim());
            if(Helper.validata.isMobile($(this).val())) {

            }else {
                if(Helper.isNotEmpty($(this).val())) {
                    Helper.message.tips("전화번호를 입력해주세요", this);
                    $(this).focus();//触发再次获得焦点事件
                }
            }
        });

        //메일的控制
        $(document).on('blur', ".constraint_email", function()
        {
            $(this).val($(this).val().trim());
            if(Helper.validata.isEmail($(this).val())) {

            }else {
                if(Helper.isNotEmpty($(this).val())) {
                    Helper.message.tips("메일을 입력해주세요", this);
                    $(this).focus();//触发再次获得焦点事件
                }

            }
        });

        //数字的键盘입력控制
        $(document).on('keypress', ".constraint_number,.constraint_negative", function()
        {
            return (/\d/.test(String.fromCharCode(event.keyCode)));
        });
        //数字、负号键盘입력控制
        $(document).on('keypress', ".constraint_positive", function()
        {
            return (/\d|\-/.test(String.fromCharCode(event.keyCode)));
        });
        //数字、小数控制
        $(document).on('blur', ".constraint_number,.constraint_decimal", function()
        {
            $(this).val($(this).val().trim());
            if($(this).val().trim() == "") {
                $(this).val(0);
                return;
            }
            if(/^\-?\d+(\.\d+)?$/.test($(this).val())) {
                if(Number($(this).val()) == 0) {
                    $(this).val(0);
                }
            }else {
                $(this).val(0);
                $(this).blur();//触发再次失去焦点事件
                Helper.message.tips("숫자및소수만 입력가능합니다", this);
                $(this).focus();
            }
            $(this).val(Number($(this).val()));
        });
        //正数控制
        $(document).on('blur', ".constraint_negative", function()
        {
            $(this).val($(this).val().trim());
            if($(this).val().trim() == "") {
                $(this).val(0);
                return;
            }
            if(/^\d+$/.test($(this).val())) {

                $(this).val(Number($(this).val()));
            }else {
                //Helper.message.warn("只能입력数字");
                $(this).val(0);
                $(this).blur();//触发再次失去焦点事件
                Helper.message.tips("정수를 입력해주세요", this);
                $(this).focus();
            }
            $(this).val(Number($(this).val()));
        });
        //点击table之外지역触发
        $(document).bind("click", function(e)
        {
            if($(e.target).closest("table").length == 0) {
                //点击table之外，则触发
                $("tr").removeClass("tr_active");
            }
        })
        //负数控制
        $(document).on('blur', ".constraint_positive", function()
        {
            $(this).val($(this).val().trim());
            if($(this).val() == "") {
                $(this).val(-1);
                return;
            }
            if(/^\-?\d+$/.test($(this).val())) {
                $(this).val($(this).val().replace("-", ""));//删除'-'
                if(Number($(this).val()) == 0) {
                    $(this).val(-1);
                }else {
                    $(this).val("-" + Math.abs(Number($(this).val())));//在最前面加入'-'
                }
            }else {
                //Helper.message.warn("只能입력数字");
                //$(this).val(-1);
                //$(this).blur();//触发再次失去焦点事件

                Helper.message.tips("음수를 입력해주세요", this);
                $(this).focus();
            }
        });

        //数字、小数点、 负号的键盘입력控制
        $(document).on('keypress', ".constraint_decimal", function()
        {
            return (/\d|\-|\./.test(String.fromCharCode(event.keyCode)));
        });
        //数字、小数点 的键盘입력控制
        $(document).on('keypress', ".constraint_decimal_negative", function()
        {
            return (/\d|\./.test(String.fromCharCode(event.keyCode)));
        })
        //数字、负号、小数点键盘입력控制
        $(document).on('keypress', ".constraint_decimal_positive", function()
        {
            return (/\d|\-|\./.test(String.fromCharCode(event.keyCode)));
        });

        //正数、正小数控制
        $(document).on('blur', ".constraint_decimal_negative", function()
        {
            $(this).val($(this).val().trim());
            if($(this).val() == "") {
                $(this).val(0);
                return;
            }
            if(/^\d+(\.\d+)?$/.test($(this).val())) {
                $(this).val(Number($(this).val()));
            }else {
                $(this).val(0);
                $(this).blur();//触发再次失去焦点事件

                Helper.message.tips("정수및소수를 입력해주세요", this);
                $(this).focus();


            }
        });
        //负数控制
        $(document).on('blur', ".constraint_decimal_positive", function()
        {
            $(this).val($(this).val().trim());
            if($(this).val() == "") {
                $(this).val(-1);
                return;
            }
            if(/^\-?\d+(\.\d+)?$/.test($(this).val())) {
                $(this).val($(this).val().replace("-", ""));//删除'-'
                $(this).val("-" + Math.abs(Number($(this).val())));//在最前面加入'-'
            }else {
                //Helper.message.warn("只能입력数字和小数");
               	$(this).val(-1);
                $(this).blur();//触发再次失去焦点事件
                Helper.message.tips("음수및소수를 입력해주세요", this);
                $(this).focus();
            }
        });
        $(document).on("click", ".table-container .addrow", function(){
                add_tablerow(this);
        });
        $(document).on("click", ".table-container .deleterow", function(){
                delete_tablerow(this);
        });

        $(document).on("click",".memo",function(){
            	var this_=$(this);
            	Helper.message.prompt('비고란을 입력해주세요',this_.val(),function(text,index){
            	    layer.close(index);
            	    this_.val(text);
            	})
        })
         //bootTable悬浮显示title
         $(document).on("mouseenter","#bootTable tbody td",function(){
        	 if(!$(this).attr("title")){
        		 $(this).attr("title",$(this).text());
        	 }
        })
        /* 初始化frame肤色 */
        function initSkin()
        {
            var cssType = $.cookie("ygj_skin"), topDoc = $(window.parent.document), frameskin = $("#frameskin"), title = topDoc.find("title").html(), topskin = topDoc.find("#topskin"), head = topDoc.find("head");
            skin_default_i = topDoc.find(".skin_default"), skin_brown_i = topDoc.find(".skin_brown"), skin_blue_i = topDoc.find(".skin_blue");
            if(cssType == "" || cssType == null || cssType == "default") {
                skin_default_i.addClass("active");
                skin_blue_i.removeClass("active");
                skin_brown_i.removeClass("active");
                frameskin.attr("href", '${ctxStatic}/layout/css/skin/skin_default.css?${v }');
            }else if(cssType == "brown") {
                skin_brown_i.addClass("active");
                skin_default_i.removeClass("active");
                skin_blue_i.removeClass("active");
                frameskin.attr("href", '${ctxStatic}/layout/css/skin/skin_brown.css?${v }');
            }else if(cssType == "blue") {
                skin_blue_i.addClass("active");
                skin_default_i.removeClass("active");
                skin_brown_i.removeClass("active");
                frameskin.attr("href", '${ctxStatic}/layout/css/skin/skin_blue.css?${v }');
            }
        }
        initSkin();
        /* 切换frame皮肤 */
        $(window.parent.document).find(".skin_list").children("ul").children("li").children("span").click(function()
        {
            var cssType = $(this).siblings("input").val(), frameskin = $("#frameskin");
            frameskin.attr("href", '${ctxStatic}/layout/css/skin/skin_' + cssType + '.css?${v }');
        })
    });

    function redirect(title, url)
    {
        admin_tab($("<a _href='"+Helper.basePath+url+"' data-title='"+title+"' />"));
    }

    //处理键盘事件
    function doKey(e)
    {
        var ev = e || window.event; //获取event对象
        var obj = ev.target || ev.srcElement; //获取事件源
        var t = obj.type || obj.getAttribute('type'); //获取事件源유형
        if(ev.keyCode == 8 && t != "password" && t != "text" && t != "textarea") { return false; }

    }
    //禁止后退键 作用于Firefox、Opera
    document.onkeypress = doKey;
    //禁止后退键  作用于IE、Chrome
    document.onkeydown = doKey;
    //单据详情主表数据填充方法
    function viewResponseHandler(data)
    {
        //console.log(data);
        //按钮控制
        $("#forceComplete" + data.isForceComplete).show();
        $("#isCheck" + data.isCheck).show();
        //控制盖章
        if(data.isCheck == 'YES') {
            $(".review").show();
        }else {
            $(".review").hide();
        }
        //循环赋值input
        $("input[type=text],input[type=hidden]").each(function(index, item)
        {
            var inputName = item.id;
            var value = data[inputName];
            if(inputName == undefined || inputName == null || value == undefined || value == null) { return; }
            if($(item).attr('pattern') != undefined && $(item).attr('pattern') == 'yyyy-MM-dd') {
                $(item).val(new Date(value).format('yyyy-MM-dd'));
                return;
            }
            $(item).val(value);
        });
        //循环赋值textarea
        $("textarea").each(function(index, item)
        {
            var inputName = item.id;
            var value = data[inputName];
            $(item).html(value);
        });
        return {
            rows: data.detailList,
            total: eval(data.detailList).length
        };
    }
    /*加载同事*/
    function loadColleague(){
       var url=Helper.basePath+"/basic/employee/sameBusinessEmployee?userId=${user.id }";
       Helper.request({
            url:url,
            success:function (data){
            if(data.success){
                var div ='<div>' ;
                $.each(data.obj,function (index,item){
                    div +='<label><input type="checkbox" name="employeeIds" value="'+item.id+'" '+item.checked+'>'+item.name+'</label>';
                });
                div +='</div>';
                $("#colleague").empty();
                $("#colleague").append(div);
               /*  var arrayDiv=new Array()
                var arrayInput=new Array()
                $.each(data.obj,function (index,item){
                    if(!arrayDiv.contains(item.departmentName)){
                        arrayDiv.push(item.departmentName);
                        arrayInput.push('<label><input type="checkbox" name="employeeIds" value="'+item.id+'" '+item.checked+'>'+item.name+'</label>');
                    }else{
                        var index=arrayDiv.indexOf(item.departmentName);

                        arrayInput[index]=arrayInput[index]+'<label><input type="checkbox" name="employeeIds" value="'+item.id+'" '+item.checked+'>'+item.name+'</label>';
                    }
                });
                $("#colleague").empty();
                $.each(arrayDiv,function (index,item){
                    var div =item+'<div  style="border-top: 1px dashed #ccc">'+arrayInput[index]+'</div>'
                    $("#colleague").append(div);
                }); */
            }
        }});
    };

    //템플릿解析数据 data: 数据   content:템플릿
    function decodeTemplateData(data,content) {
                    var HTML = content;
                    var detailMap={};
                    for( var key in data) {
                        if(key.indexOf("List") > 0) {
                            var preKey=key.replace("List","");
                            var indexValue=HTML.indexOf("{"+preKey+".");
                            if(indexValue>-1){
                                detailMap[indexValue+'_'+preKey]=data[key];
                            }
                            continue;
                        }
                        if(key.indexOf("Time") > 0){
                            HTML=HTML.replace(eval("/{" + key + "}/gi"), new Date(data[key]).format("yyyy-MM-dd"));
                            continue;
                        }
                        HTML = HTML.replace(eval("/{" + key + "}/gi"), data[key]);
                    }
                    //공급가액转大写SAY()函数
                    var fnHTML=HTML.match(/SAY\([0-9.]+\)/gi);

                    if(fnHTML!=null){
                        $.each(fnHTML,function (index,item){
                            var num=item.toString().match(/[0-9.]+/gi);
                            HTML=HTML.replace(eval("/SAY\\("+num+"\)/gi"), digitUppercase(num));
                        });
                    }
                    HTML = HTML.replace(eval("/null/gi"), '');
                    var tableMap={};
                    //순서后数据和页面对应 start
                    var sortDetailMap={};
                    var keys=new Array();
                    $.each(detailMap ,function (key,detail){
                        keys.push(key);
                    });
                    $.each(keys.sort(sortNumber) ,function (index,key){
                        sortDetailMap[key.split("_")[1]]=detailMap[key];
                    });
                    // 순서结束  end
                    // console.log(sortDetailMap);
                    //截取table标签的起始位
                    window.fromindex =0;
                    $.each(sortDetailMap ,function (key,detail){
                    	//console.log(detail);
                        var startIndex=HTML.indexOf("<table",window.fromindex);
                        var endIndex=HTML.indexOf("</table>",window.fromindex)+8;
                        window.fromindex=endIndex;
                        if(startIndex>-1){
                            var table=HTML.substring(startIndex,endIndex);
	                        var tbody=table.substring(table.indexOf("<tbody"),table.indexOf("</tbody>")+8)
		                    var TR=tbody.substring(tbody.indexOf("<tr"),tbody.indexOf("</tr>")+5);
		                    var tr='';
		                    var outkey=key;
		                    //如果无数据，则删除页面的table
		                    if(detail.length==0){
		                        tableMap[table]="";
		                        return;
		                    }
		                    $.each(detail,function (index,item){
		                        var _tr=TR;
		                        for(var key in item){
		                            if(key.indexOf("Time") > 0){
		                                _tr=_tr.replace(eval("/{"+outkey+"." + key + "}/gi"), new Date(item[key]).format("yyyy-MM-dd"));
		                                continue;
		                            }
		                            if(key.indexOf("Qty")>0){
		                            	if(item[key] !== null)
										{
											_tr=_tr.replace(eval("/{"+outkey+"." + key + "}/gi"), item[key].toLocaleString());
											continue;
										}

		                            	_tr=_tr.replace(eval("/{"+outkey+"." + key + "}/gi"), item[key]);
										continue;
									}
									if(key.indexOf("Num")>0){
										if(item[key] !== null)
										{
											_tr=_tr.replace(eval("/{"+outkey+"." + key + "}/gi"), item[key].toLocaleString());
											continue;
										}

										_tr=_tr.replace(eval("/{"+outkey+"." + key + "}/gi"), item[key]);
										continue;
									}
									if(key.indexOf("price")>0 ){
										if(item[key] !== null)
										{
											_tr=_tr.replace(eval("/{"+outkey+"." + key + "}/gi"), item[key].toLocaleString());
											continue;
										}

										_tr=_tr.replace(eval("/{"+outkey+"." + key + "}/gi"), item[key]);
										continue;
									}
									if(key.indexOf("Price")>0 ){
										if(item[key] !== null)
										{
											_tr=_tr.replace(eval("/{"+outkey+"." + key + "}/gi"), item[key].toLocaleString());
											continue;
										}

										_tr=_tr.replace(eval("/{"+outkey+"." + key + "}/gi"), item[key]);
										continue;
									}
									if(key.indexOf("tax")>0){
										if(item[key] !== null)
										{
											_tr=_tr.replace(eval("/{"+outkey+"." + key + "}/gi"), item[key].toLocaleString());
											continue;
										}

										_tr=_tr.replace(eval("/{"+outkey+"." + key + "}/gi"), item[key]);
										continue;
									}
									if(key.indexOf("Tax")>0){
										if(item[key] !== null)
										{
											_tr=_tr.replace(eval("/{"+outkey+"." + key + "}/gi"), item[key].toLocaleString());
											continue;
										}

										_tr=_tr.replace(eval("/{"+outkey+"." + key + "}/gi"), item[key]);
										continue;
									}
									if(key.indexOf("Money")>0){
										if(item[key] !== null)
										{
											_tr=_tr.replace(eval("/{"+outkey+"." + key + "}/gi"), item[key].toLocaleString());
											continue;
										}

										_tr=_tr.replace(eval("/{"+outkey+"." + key + "}/gi"), item[key]);
										continue;
									}
									if(key.indexOf("money")>0){
										if(item[key] !== null)
										{
											_tr=_tr.replace(eval("/{"+outkey+"." + key + "}/gi"), item[key].toLocaleString());
											continue;
										}

										_tr=_tr.replace(eval("/{"+outkey+"." + key + "}/gi"), item[key]);
										continue;
									}
		                            _tr=_tr.replace(eval("/{"+outkey+"." + key + "}/gi"), item[key]);
		                            _tr=_tr.replace(eval("/{detail.statusIndex}/gi"), ++index);
		                        }
		                        _tr= _tr.replace(eval("/null/gi"), '')
		                       tr+=_tr
		                      //console.log(tr);
		                    });
		                    tableMap[table]=  table.replace(TR, tr);
		                    //HTML = HTML.replace(table, table.replace(TR, tr));
                        }
                    });

                    //执行替换
                    $.each(tableMap ,function (key,detail){
                        HTML = HTML.replace(key, detail);
                    });
                   return HTML;
                };
    //数组sort方法순서条件函数
    function sortNumber(a,b)
    {
        return a.split("_")[0]-b.split("_")[0];
    }
   //HTML反转义
    function HTMLDecode(text)
    {
       var temp = document.createElement("div");
       temp.innerHTML = text;
       var output = temp.innerText || temp.textContent;
       temp = null;
       return output;
    }
</script>
