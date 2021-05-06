$(".deleteApp").on("click",function(){
    var obj = $(this);
    if(confirm("你确定要删除分类【"+obj.attr("catname")+"】吗？")){
        $.ajax({
            type:"GET",
            url:"delcat.json",
            data:{id:obj.attr("catid")},
            dataType:"json",
            success:function(data){
                if(data.delResult == "true"){//删除成功：移除删除行
                    alert("删除成功");
                    obj.parents("tr").remove();
                }else if(data.delResult == "false"){//删除失败
                    alert("对不起，删除分类【"+obj.attr("catname")+"】失败");
                }
            },
            error:function(data){
                alert("对不起，删除失败");
            }
        });
    }
});