function form_submit(){
	Helper.message.confirm('작성하겠습니까？', function(index)
	{
		$.ajax({
			url: Helper.basePath + '/api/board/create',
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
					Helper.message.suc('작성 되었습니다!');
					window.location.href = Helper.basePath + "/board/list";
				}else{
					layer.alert("잠시 후 다시 시도 부탁드립니다.");
				}

			},
			error: function(data){
				Helper.message.err('작성 실패：' + data.message);
			}
		});
	});
}