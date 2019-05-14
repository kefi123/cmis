<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>ECharts</title>
    <script src="js/jquery-1.12.1.js"></script>
    <!-- 引入 echarts.js -->
    <script src="js/echarts.js"></script>
</head>
<body>
    <!-- 为ECharts准备一个具备大小（宽高）的Dom -->
    <div id="main"></div>
    <script type="text/javascript">
    	const color = ['#E27471', '#00C8FF', '#E6AF15', '#00E3F3', '#CF83F4', '#6B81E1', '#00FBAE'];
        //获取放置图表的元素
        var dom=document.getElementById('main');
        dom.style.width = 780 + 'px';
        dom.style.height = 600 + 'px';
        // 初始化echarts实例
        var myChart = echarts.init(dom);
        //配置选项
        myChart.setOption({
            //设置图表的背景色
            backgroundColor: new echarts.graphic.RadialGradient(0.3, 0.3, 0.8, [{
                offset: 0,
                color: '#f7f8fa'
            }, {
                offset: 1,
                color: '#cdd0d5'
            }]),
            //设置标题
            title: {
                text: "人脉亲密关系图",
                subtext: "graph",
                top: "top",
                left: "center"
            },
            tooltip: {},
            //图例组件
            legend: [{
                //格式化图例文本
                formatter: function(name) {
                    return echarts.format.truncateText(name, 40, '14px Microsoft Yahei', '…');
                },
                //提示框
                tooltip: {
                    show: true
                },
                selectedMode: 'false',
                bottom: 20,
                data: ['人脉']
            }],
            //工具栏
            toolbox: {
                show: true,
                feature: {
                    //导出图片
                    saveAsImage: {
                        show: true
                    }
                }
            },
            animationDuration: 3000,
            animationEasingUpdate: 'quinticInOut',
            //系列列表
            series: [{
                name: '人脉关系图',
                type: 'graph',
                layout: 'force',

                force: {
                    repulsion: 300,
                    edgeLength: [100, 200]
                },
                data: [],
                links: [],
                categories: [{
                    name: '人脉'
                }],
                //是否在鼠标移到节点上的时候突出显示节点以及节点的边和邻接节点。
                focusNodeAdjacency: true,
                //鼠标缩放和平移
                roam: true,
                //标签
                label: {
                    normal: {

                        show: true,
                    }
                },
                //线的样式
                lineStyle: {
                    normal: {
                        color: 'source',
                        curveness: 0.2,
                        type: "solid"
                    }
                }
            }]
        });
        var data=[{
                    name:'${ulogined.us_name}',
                    // "x": 0,
                    // y: 0,
                    symbolSize: 120,
                    draggable: "true"
                }];
        var links=[];
        // 异步加载数据
        $.get('getConByUname').done(function (cons) {
            var size;
            for(var i in cons){
                size=cons[i].co_num*15;
                if(size>45){
                    size=80;
                }
                data.push({name:cons[i].co_name,category:0,symbolSize:size,draggable:"true",value:size,itemStyle:{color:color[i%color.length]}});
                links.push({source:'${ulogined.us_name}',target:cons[i].co_name});
            }
            // 填入数据
            myChart.setOption({
                series: [{
                    // 根据名字对应到相应的系列
                    data: data,
                    links:links
                }]
            });
        });
    </script>
</body>
</html>