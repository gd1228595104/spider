layui.use('table',function () {
    var table = layui.table;
    table.render({
        elem: '#demo',
        size: "sm",
        skin: 'none',
        loading: true,
        url: 'infoList',
        toolbar: "default",
        height: 550,
        request: {
            pageName: 'pageNum',
            limitName: 'pageSize'
        },
        response: {
            statusCode: 200
        },
        page: {
            limit: 20,
            limits: [10, 20, 50, 100],
        }, group: 4,
        page: true,
        parseData: function (res) {
            return {
                "code": res.code, //解析接口状态
                "msg": res.msg, //解析提示文本
                "count": res.count, //解析数据长度
                "data": res.data //解析数据列表
            }
        },
        cols: [[
            {field:'job', width:150, title: '职位', sort: true}
            ,{field:'company', width:150, title: '公司'}
            ,{field:'place', width:150, title: '地点', sort: true}
            ,{field:'salar', width:80, title: '工资'}
            ,{field:'date', title: '日期', width: '30%', minWidth: 80} //minWidth：局部定义当前单元格的最小宽度，layui 2.2.1 新增
        ]]
    });
})