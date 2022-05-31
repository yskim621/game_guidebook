window.dataLayer = window.dataLayer || [];
function gtag(){dataLayer.push(arguments);}
gtag('js', new Date());

gtag('config', 'G-2H59G05B23');

$("#btn_list").click(function () {
	window.location.href = Helper.basePath + "/board/list"
});

function form_submit(){
	Helper.message.confirm('수정하겠습니까？', function(index)
	{
		$.ajax({
			url: Helper.basePath + '/api/board/update/' + $("#id").val(),
			data: $("#board").formToJson(),
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
					Helper.message.suc('수정 되었습니다!');
					window.location.href = Helper.basePath + "/board/list"
				}else{
					layer.alert("잠시 후 다시 시도 부탁드립니다.");
				}

			},
			error: function(data){
				Helper.message.err('수정 실패：' + data.message);
			}
		});
	});
}

$("#btn_delete").click(function () {
	Helper.message.confirm('정말로 삭제하겠습니까？', function(index)
	{
		Helper.post(Helper.basePath + '/board/delete/' + id, function(data) {
			if(data.success)
			{
				$("#bootTable").bootstrapTable("removeByUniqueId", id);
				$("#bootTable").bootstrapTable("refresh");
				$("#detailTable tr").bootstrapTable("removeByUniqueId", id);
				$("#detailTable tr").bootstrapTable("refresh");
				$("#assyNo").val("");
				Helper.message.suc('삭제됨!');
			}else
			{
				Helper.message.err('삭제 실패：' + data.message);
			}
		});
		if (index > 0) {
			$("#bootTable").bootstrapTable("refresh");
		}
	});

});