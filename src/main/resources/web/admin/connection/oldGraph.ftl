<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>route</title>
    <script src="js/jquery-1.12.1.js"></script>
    <!-- 引入 echarts.js -->
    <script src="js/echarts.js"></script>
</head>
<body>
    <!-- 为ECharts准备一个具备大小（宽高）的Dom -->
    <div id="main"></div>
    <script type="text/javascript">
        //获取放置图表的元素
        var dom=document.getElementById('main');
        dom.style.width = 780 + 'px';
        dom.style.height = 600 + 'px';
        // 初始化echarts实例
        var myChart = echarts.init(dom);
        //配置选项
        myChart.setOption({
            tooltip: {},
            //图例组件
            legend: {
                x: "center",
                data: ["人脉"]
            },
            //是否开启动画
            animation: false,
            series: [{
                categories: [{
                    name: '人脉',
                    itemStyle: {
                        normal: {
                            color: "#009800",
                        }
                    }
                }],
                type: 'graph',
                layout: 'force',
                symbol: "circle",
                symbolSize: 40,
                roam: true, //鼠标滚轮缩小放大效果
                //边两边的标记类型
                edgeSymbol: ['circle', 'arrow'],
                //边两边的标记大小
                edgeSymbolSize: [0, 10],
                // 连接线上的文字
                focusNodeAdjacency: true, //划过只显示对应关系
                categories: [{
                    name: '人脉',
                    itemStyle: {
                        normal: {
                            color: "#009800",
                        }
                    }
                }],
                lineStyle: {
                    normal: {
                        opacity: 1,
                        width: 2,
                        curveness: 0
                    }
                },
                // 圆圈内的文字
                label: {
                    normal: {
                        show: true
                    }
                },
                force: {
                    repulsion: 5000
                },
                data: [],
                links: []
            }]
        });
        var data=[{
                    name: 'admin',
                    symbol: 'image://images/portrait.jpg',
                    itemStyle: {
                        normal: {
                                color: '#f90', //圆点的颜色
                                label: {
                                    position: 'bottom',
                                    textStyle: {
                                        color: '#f90'
                                    }
                                }
                            }
                    }
                }];
        var links=[];
        // 异步加载数据
        $.get('getConByUname').done(function (cons) {
            for(var i in cons){
                data.push({name:cons[i].co_name,category:0});
                links.push({source:'admin',target:cons[i].co_name});
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