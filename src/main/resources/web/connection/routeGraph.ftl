<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>ECharts</title>
    <script src="js/jquery-1.12.1.js"></script>
    <!-- 引入 echarts.js -->
    <script src="js/echarts.js"></script>
    <!-- bootstrap的核心css包 -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- bootstrap的核心js包 -->
    <script type="text/javascript" src="js/bootstrap.min.js"></script>
</head>
<body>
    <!-- 为ECharts准备一个具备大小（宽高）的Dom -->
    <div id="main" style="width:870px;height:200px;margin:50px auto;"></div>
	
	<div class="col-md-10 col-md-offset-1">
	    <div class="panel panel-info">
	        <div class="panel-heading">
	        <h2 class="panel-title">方案</h2>
	        </div>
	        <div class="panel-body">
	            <strong>${route.source}</strong>您好，您可以通过<strong>${route.transfer}</strong>来联系<strong>${route.target}</strong>，以此达到拓展人脉的目的。
	        </div>
	    </div>
	</div>

    <script type="text/javascript">
        //获取放置图表的元素
        var dom=document.getElementById('main');
        // 初始化echarts实例
        var myChart = echarts.init(dom);
        var nodes = [{
                x: '0',
                y: '0',
                name: '${route.source}',
                img: 'ren.png'
            },
            {
                x: '3',
                y: '0',
                name: '${route.transfer}',
                img: 'renmai.png'
            },
            {
                x: '6',
                y: '0',
                name: '${route.target}',
                img: 'ren_1.png'
            }
        ]
        var links = [{
                source: '${route.source}',
                target: '${route.transfer}'
            }, {
                source: '${route.transfer}',
                target: '${route.target}'
            }
        ]
        var charts = {
            nodes: [],
            links: [],
            linesData: []
        }
        var dataMap = new Map()
        for (var j = 0; j < nodes.length; j++) {
            var x = parseInt(nodes[j].x)
            var y = parseInt(nodes[j].y)
            var node = {
                name: nodes[j].name,
                value: [x, y],
                symbolSize: 50,
                symbol: 'image://routeImages/'+nodes[j].img
            }
            dataMap.set(nodes[j].name, [x, y])
            charts.nodes.push(node)
        }
        for (var i = 0; i < links.length; i++) {
            var link = {
                source: links[i].source,
                target: links[i].target,
                lineStyle: {
                    normal: {
                        color: '#12b5d0'
                    }
                }
            }
            charts.links.push(link)
            // 组装动态移动的效果数据
            var lines = [{
                coord: dataMap.get(links[i].source)
            }, {
                coord: dataMap.get(links[i].target)
            }]
            charts.linesData.push(lines)
        }
        option = {
            title: {
                text: '拓展人脉'
            },
            backgroundColor: "#F5F5F5",
            xAxis: {
                show: false,
                type: 'value'
            },
            yAxis: {
                show: false,
                type: 'value'
            },
            series: [{
                type: 'graph',
                layout: 'none',
                coordinateSystem: 'cartesian2d',
                symbolSize: 50,
                label: {
                    normal: {
                        show: true,
                        position: 'bottom',
                        color: '#000'
                    }
                },
                lineStyle: {
                    normal: {
                        width: 2,
                        shadowColor: 'none'
                    }
                },
                edgeSymbolSize: 8,
                data: charts.nodes,
                links: charts.links,
                itemStyle: {
                    normal: {
                        label: {
                            show: true,
                            formatter: function(item) {
                                return item.data.name
                            }
                        }
                    }
                }
            }, {
                name: 'A',
                type: 'lines',
                coordinateSystem: 'cartesian2d',
                effect: {
                    show: true,
                    trailLength: 0,
                    symbol: 'arrow',
                    color: '#12b5d0',
                    symbolSize: 8
                },
                data: charts.linesData
            }]
        };
        myChart.setOption(option);
    </script>
</body>
</html>