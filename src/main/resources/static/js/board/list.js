$(function() {
	ajaxList(queryParams);
});

function ajaxList(queryParams) {
	$("#bootTable")
		.bootstrapTable({
			url: Helper.basePath + "/api/board/ajaxList",
			method: "post",
			contentType: 'application/json',
			dataType: "json",
			pagination: true,
			sidePagination: 'server',
			pageList: Helper.bootPageList,
			queryParamsType: "",
			pageSize: 10,
			pageNumber: 1,
			queryParams: queryParams,
			responseHandler: responseHandler,

			showColumns: true,
			minimumCountColumns: 2,
			striped: true,
			cache: false,
			// sortable : true,
			clickToSelect: true,
			height: 430,
			cardView: false,
			detailView: false,
			// showExport : true,
			// exportTypes : [ 'csv', 'txt', 'excel', 'doc' ],

			cookie: true,
			cookiesEnabled: ['bs.table.columns'],
			cookieIdTable: "board",

			uniqueId: "id",
			columns: [
				{
					field: 'index',
					title: '번호',
					width: 40,
					formatter: function (value, row, index) {
						return index + 1;
					},
				},
				{
					field: 'title',
					title: '제목',
					width: 100,
				},
				{
					field: 'attachment',
					title: '첨부 파일명',
					width: 100,
				},
				{
					field: 'userNickname',
					title: '작성자',
					width: 100,
				},
				{
					field: 'readCnt',
					title: '조회수',
					width: 60,
				},
				{
					field: 'operator',
					title: '처리',
					width: 60,
					formatter: function (value, row, index) {
						var operator = "";
						operator += '<span class="table_operator"><a title="보기" href="javascript:;" onclick="detail_content('
							+ row.id
							+ ')" style="padding: 0 8px; color: green"><i class="fa fa-search"></i></a>';
						operator += '<a title="편집" href="javascript:;" onclick="pair_update('
							+ row.id
							+ ')" style="padding: 0 8px; color: green"><i class="fa fa-pencil"></i></a>';
						operator += '<a title="삭제" href="javascript:;" onclick="delete_content('
							+ row.id
							+ ')" style="padding: 0 8px; color: red"><i class="fa fa-trash-o"></i></a></span>';
						return operator;
					}
				}
			],
			onSort: function (name, order) {
				// $("#sortName").val(name);
				// $("#sortOrder").val(order);
				// $("#bootTable").bootstrapTable("refreshOptions",{pageNumber:1});
			},
			onClickRow: function (row, $element) {
				$element.addClass("tr_active").siblings().removeClass("tr_active");
			},
			onDblClickRow: function (row) {
				if (row.id == null) {
					return;
				}
				detail_content(row.id);
			}
		});
	$("#bootTable").on('load-success.bs.table column-switch.bs.table page-change.bs.table search.bs.table', function () {
		if ($(".glyphicon-th").next().html() == '') {
			$(".fixed-table-toolbar").after("<button class='nav_btn' type='button' onclick='write_content()' >글쓰기</button>" +
				"<select id='searchType' name='searchType' style='width: 3em; height: 2em; margin-left: 20em;'>" +
				// "<option value='empty' selected>---</option>" +
				"<option value='title' selected>제목</option>" +
				"<option value='nickname'>작성자</option>" +
				"</select>" +
				"<input type='text' id='value' name='value' placeholder='검색어 작성'/>" +
				"<input class='nav_btn' type='button' value='검색' id='search_btn' onclick='search()'/>");
			$(".glyphicon-th").after("<span class='glyphicon_font'>항목</span>");
			if (!Helper.basic.hasPermission('produce:work_detail:export')) {
				$(".export.btn-group").remove();
			}
			$(".glyphicon-export").after("<span class='glyphicon_font'>내보내기</span>");
		}
	});
}

function responseHandler(res) {
	return {
		rows: res.result,
		total : res.count
	};
}

function queryParams(params) {
	params['searchType'] = $("#searchType").val();
	params['value'] = $("#value").val();
	return params;
}

function search() {
	$("#bootTable").bootstrapTable("refresh");
	ajaxList(queryParams);
}

function getSelectedRows()
{
	return $("#bootTable").bootstrapTable('getAllSelections');
}

function write_content(){
	window.location.href = Helper.basePath + "/board/create"
}


function detail_content(id) {
	window.location.href = Helper.basePath + "/board/get/" + id;
}

function delete_content(id){
	Helper.message.confirm('정말로 삭제하겠습니까？', function(index)
	{
		Helper.post(Helper.basePath + '/api/board/delete/' + id, function(data) {
			if(data.success)
			{
				$("#bootTable").bootstrapTable("removeByUniqueId", id);
				$("#bootTable").bootstrapTable("refresh");
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
}
