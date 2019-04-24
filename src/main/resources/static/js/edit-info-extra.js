$(document).ready(
    function(){
        $("#editBtn").click(
            function () {
                $("#display").hide();
                $("#edit").show();
            }
        );
        $("#cancelBtn").click(
            function () {
                $("#display").show();
                $("#edit").hide();
            }
        );

    }
);
function getchilds() {
    //获取第一个下拉列表的值
    var pid=$("#p_industry_id").val();
    //获取第二个下拉列表对象
    var obj=document.getElementById("c_industry_id");
    obj.options.length=1;//第一个下拉列表不管选哪个，第二个下拉列表都应该首先显示第一个
    if (pid!=null){
        //通过Ajax获取childs的数据
        $.ajax({
            type : 'GET',
            contentType : 'application/json',
            url : 'p2c?p_industry_id='+pid,
            dataType : 'json',
            success : function(data) {
                $.each(data,function(i,item) {
                    obj.options.add(new Option(item.c_industry_name,item.c_industry_id));
                });
            }
        });
    }
}
