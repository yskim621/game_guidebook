window.dataLayer = window.dataLayer || [];
function gtag(){dataLayer.push(arguments);}
gtag('js', new Date());

gtag('config', 'G-2H59G05B23');

// $("#btn_list").click(function () {
//     window.location.href = Helper.basePath + "/board/list"
// });

var id = $("#id").val();
// $("#btn_update").click(function () {
//     window.location.href = Helper.basePath + "/board/update/" + id
// });

$("#btn_delete").click(function () {
    Helper.message.confirm('정말로 삭제하겠습니까？', function(index)
    {
        Helper.post(Helper.basePath + '/api/board/delete/' + id, function(data) {
            if(data.success)
            {
                $("#bootTable").bootstrapTable("removeByUniqueId", id);
                $("#bootTable").bootstrapTable("refresh");
                Helper.message.suc('삭제됨!');
                window.location.href = Helper.basePath + '/board/list';
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