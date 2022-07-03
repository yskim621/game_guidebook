function login_submit(){
    Helper.post(Helper.basePath + '/bom/dw/assy/delete/' + id, function(data) {
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
}

