//合作公司ex表数据集合
var exList=null;
var columnIndex = 0;
var listurl=null;
$().ready(function(){
    readEX();
});
//初始化bootstraptable

function readEX(){
    //获取选中项的值
    var value =$("#form-field-select option:selected").attr("value");
    $.ajax({
        type:"GET",
        url: "/readEx",
        data: {millName:value},
        datatype:"json",
        success:function (data) {
            //把返回数据绑定至页面
            //商品信息集合
            exList=data;
            bindData()

            //绑定查询条件
            $("#selectName").attr('value',exList[columnIndex].goodsname)
            $("#selectMill").attr('value',exList[columnIndex].goodsMill)

        }
    })
}
$("#list").bootstrapTable({
    url: "/findAll",  //请求地址
    striped: true, //是否显示行间隔色
    pageNumber: 1, //初始化加载第一页
    pagination: true,//是否分页
    sidePagination: 'client',//server:服务器端分页|client：前端分页
    pageSize: 10,//单页记录数
    pageList: [5, 15],//可选择单页记录数
    columns: [{
        title: '货号',
        field: 'id',
        sortable: true
    }, {
        title: '商品名称',
        field: 'name',
        sortable: true
    }, {
        title: '别名',
        field: 'alias',
        sortable: true
    }, {
        title: '规格',
        field: 'norms',
        sortable: true
    }, {
        title: '生产企业',
        field: 'mill',
        sortable: true
    }, {
        title: '总部库存',
        field: 'stock',
        sortable: true
    }, {
        title: '最后进价',
        field: 'bid',
        sortable: true
    }, {
        title: '合作价',
        field: 'cooperate',
        sortable: true
    }, {
        title: '零售价',
        field: 'retail',
        sortable: true
    }, {
        title: '采购',
        field: 'purchase',
        sortable: true
    }, {
        title: '采集优势',
        field: 'superiority',
        sortable: true
    }],
    onDblClickCell: function (field,value,row,$element) {
        $('#ynId').val(row.id)
        // alert(value);
        if (field=="id"){
            // $("#treat option:eq(4)").attr("selected","selected");
            $("#treat").val("和盛优价品种购进")
        }
        if(field=="name"){
            $("#treat").val("和盛优势品种替换")
        }
    }
})
//初始化导出表
$("#exList").bootstrapTable({
    url: "/exportExcel",
    striped: true, //是否显示行间隔色
    pageNumber: 1, //初始化加载第一页
    pagination: true,//是否分页
    sidePagination: 'client',//server:服务器端分页|client：前端分页
    pageSize: 10,//单页记录数
    pageList: [5, 15],//可选择单页记录数
    search: true,  //是否显示搜索,客户端搜索不进入后台
    showRefresh: true, //显示刷新按钮
    columns: [{
        title: '货号',
        field: 'id',
        sortable: true
    }, {
        title: '品名',
        field: 'goodsname',
        sortable: true
    }, {
        title: '规格',
        field: 'goods_norm',
        sortable: true
    }, {
        title: '厂家',
        field: 'goods_mill',
        sortable: true
    },{
        title: '购进价',
        field: 'purchase_price',
        sortable: true
    },{
        title: '售价',
        field: 'retail_price',
        sortable: true
    },{
        title: '处理方式',
        field: 'treat',
        sortable: true
    },{
        title: '雨诺编码',
        field: 'ynId',
        sortable: true
    },{
        title: '备注',
        field: 'remark',
        sortable: true
    }],
    showExport: true,              //是否显示导出按钮
    exportDataType: "basic",              //basic', 'all', 'selected'.
    exportTypes:['excel','xlsx'],	    //导出类型
    //exportButton: $('#btn_export'),     //为按钮btn_export  绑定导出事件  自定义导出按钮(可以不用)
    exportOptions:{
        //ignoreColumn: [0,0],            //忽略某一列的索引
        fileName: '数据导出',              //文件名称设置
        worksheetName: 'Sheet1',          //表格工作区名称
        excelstyles: ['background-color', 'color', 'font-size', 'font-weight'],
        //onMsoNumberFormat: DoOnMsoNumberFormat
    }
})
function exportExcel(){
    $.ajax({
        url:"/exportExcel",
        type:"get",
        datatype: "json",
        success:function (data) {
            $("#EXtable").bootstrapTable('load',data);
        }
    })

}

$('#form-field-select').change(function (data) {

    readEX();

})
//单击下一条 保存数据至数据库
function listcont(){
    var cooperation={
        id:$("#id").val(),
        goodsname:$("#goodsname").val(),
        treat:$("#treat").val(),
        goodsMill:$("#goodsMill").val(),
        purchasePrice:$("#purchasePrice").val(),
        retailPrice:$("#retailPrice").val(),
        goodsStock:$("#goodsStock").val(),
        storeStock:$("#storeStock").val(),
        yearSales:$("#yearSales").val(),
        yearSalesAmount:$("#yearSalesAmount").val(),
        yearGrossAmount:$("#yearGrossAmount").val(),
        salesRank:$("#salesRank").val(),
        treat:$("#treat").val(),
        ynId:$("#ynId").val(),
        remake:$("#remake").val(),

    }
    $.ajax({
        type:"post",
        url:"/saveCoop",
        contentType: "application/json;charset=UTF-8",
        data:JSON.stringify(cooperation),
        datatype:"json",
        success:function (data) {
            alert(data);
        }
    })
    columnIndex=columnIndex+1;
    bindData()

}
//绑定数据
function bindData(){
    $("#id").attr('value',exList[columnIndex].id);
    $("#goodsname").attr('value',exList[columnIndex].goodsname)
    $("#goodsNorm").attr('value',exList[columnIndex].goodsNorm)
    $("#goodsMill").attr('value',exList[columnIndex].goodsMill)
    $("#purchasePrice").attr('value',exList[columnIndex].purchasePrice)
    $("#retailPrice").attr('value',exList[columnIndex].retailPrice)
    $("#goodsStock").attr('value',exList[columnIndex].goodsStock)
    $("#storeStock").attr('value',exList[columnIndex].storeStock)
    $("#yearSales").attr('value',exList[columnIndex].yearSales)
    $("#yearSalesAmount").attr('value',exList[columnIndex].yearSalesAmount)
    $("#yearGrossAmount").attr('value',exList[columnIndex].yearGrossAmount)
    $("#salesRank").attr('value',exList[columnIndex].salesRank)
}
//前端分页

//动态刷新table
function selectList(){
    //单击查询发起ajax请求更改bootstraptabledata
    $.ajax({
        url:"/findgoods",
        type:"get",
        data: {name:$("#selectName").val(),mill:$("#selectMill").val()},
        datatype: "json",
        success:function (data) {
            $("#list").bootstrapTable('load',data);
        }
    })
}
// 带有插件选项
$("#input-id").fileinput({'previewFileType': 'any', allowedFileExtensions: ['.xls', '.xlsx']});
$("#data-id").fileinput({'previewFileType': 'any', allowedFileExtensions: ['.xls', '.xlsx']});
function show(tag) {
    var light = document.getElementById(tag);
    light.style.display = 'block';
}

function hide(tag) {
    var light = document.getElementById(tag);
    light.style.display = "none";
}