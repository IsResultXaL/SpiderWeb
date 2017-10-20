<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<html>
<head>
    <meta charset="utf-8">
    <title>世纪佳缘数据分析</title>
    <script type="text/javascript" src="/js/jquery.js"></script>
    <script type="text/javascript" src="/js/echarts.min.js"></script>
    <script type="text/javascript" src="http://echarts.baidu.com/gallery/vendors/echarts/map/js/china.js"></script>
</head>
<body>
<div id="main" style="height:100%;"></div>
<script type="text/javascript">
    // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('main'));

    /*function randomData() {
        return Math.round(Math.random() * 1000);
    }

    var data = [{
        name: '北京',
        valueMale: randomData(),
        valueFemale: randomData(),
    }, {
        name: '天津',
        valueMale: randomData(),
        valueFemale: randomData(),
    }, {
        name: '上海',
        valueMale: randomData(),
        valueFemale: randomData(),
    }, {
        name: '重庆',
        valueMale: randomData(),
        valueFemale: randomData(),
    }, {
        name: '河北',
        valueMale: randomData(),
        valueFemale: randomData(),
    }, {
        name: '河南',
        valueMale: randomData(),
        valueFemale: randomData(),
    }, {
        name: '云南',
        valueMale: randomData(),
        valueFemale: randomData(),
    }, {
        name: '辽宁',
        valueMale: randomData(),
        valueFemale: randomData(),
    }, {
        name: '黑龙江',
        valueMale: randomData(),
        valueFemale: randomData(),
    }, {
        name: '湖南',
        valueMale: randomData(),
        valueFemale: randomData(),
    }, {
        name: '安徽',
        valueMale: randomData(),
        valueFemale: randomData(),
    }, {
        name: '山东',
        valueMale: randomData(),
        valueFemale: randomData(),
    }, {
        name: '新疆',
        valueMale: randomData(),
        valueFemale: randomData(),
    }, {
        name: '江苏',
        valueMale: randomData(),
        valueFemale: randomData(),
    }, {
        name: '浙江',
        valueMale: randomData(),
        valueFemale: randomData(),
    }, {
        name: '江西',
        valueMale: randomData(),
        valueFemale: randomData(),
    }, {
        name: '湖北',
        valueMale: randomData(),
        valueFemale: randomData(),
    }, {
        name: '广西',
        valueMale: randomData(),
        valueFemale: randomData(),
    }, {
        name: '甘肃',
        valueMale: randomData(),
        valueFemale: randomData(),
    }, {
        name: '山西',
        valueMale: randomData(),
        valueFemale: randomData(),
    }, {
        name: '内蒙古',
        valueMale: randomData(),
        valueFemale: randomData(),
    }, {
        name: '陕西',
        valueMale: randomData(),
        valueFemale: randomData(),
    }, {
        name: '吉林',
        valueMale: randomData(),
        valueFemale: randomData(),
    }, {
        name: '福建',
        valueMale: randomData(),
        valueFemale: randomData(),
    }, {
        name: '贵州',
        valueMale: randomData(),
        valueFemale: randomData(),
    }, {
        name: '广东',
        valueMale: randomData(),
        valueFemale: randomData(),
    }, {
        name: '青海',
        valueMale: randomData(),
        valueFemale: randomData(),
    }, {
        name: '西藏',
        valueMale: randomData(),
        valueFemale: randomData(),
    }, {
        name: '四川',
        valueMale: randomData(),
        valueFemale: randomData(),
    }, {
        name: '宁夏',
        valueMale: randomData(),
        valueFemale: randomData(),
    }, {
        name: '海南',
        valueMale: randomData(),
        valueFemale: randomData(),
    }, {
        name: '台湾',
        valueMale: randomData(),
        valueFemale: randomData(),
    }, {
        name: '香港',
        valueMale: randomData(),
        valueFemale: randomData(),
    }, {
        name: '澳门',
        valueMale: randomData(),
        valueFemale: randomData(),
    }];*/

    var data = ${json};

    var resultdata0 = [];
    var resultdata1 = [];
    var resultdata2 = [];
    var sum0 = 0;
    var sum1 = 0;
    var sum2 = 0;
    //var titledata = [];
    for (var i = 0; i < data.length; i++) {
        var d0 = {
            name: data[i].name,
            value: data[i].valueMale + data[i].valueFemale
        };
        var d1 = {
            name: data[i].name,
            value: data[i].valueMale
        };
        var d2 = {
            name: data[i].name,
            value: data[i].valueFemale
        };
        //titledata.push(data[i].name);
        resultdata0.push(d0);
        resultdata1.push(d1);
        resultdata2.push(d2);
        sum0 += data[i].valueMale + data[i].valueFemale;
        sum1 += data[i].valueMale;
        sum2 += data[i].valueFemale;
    }

    function NumDescSort(a,b){
        return a.value-b.value;
    }

    resultdata0.sort(NumDescSort);
    resultdata1.sort(NumDescSort);
    resultdata2.sort(NumDescSort);

    option = {
        title: [{
            text: '世纪佳缘会员统计',
            subtext: '全部:'+sum0+'  男:'+sum1+'  女:'+sum2,
            left: 'center'
        }],
        tooltip: {
            trigger: 'item'
        },
        legend: {
            orient: 'vertical',
            left: 'left',
            data: ['全部', '男', '女'],
            selectedMode: 'single',
        },
        visualMap: {
            min: 0,
            max: 250000,
            left: 'left',
            top: 'bottom',
            text: ['高', '低'],
            calculable: true,
            colorLightness: [0.2, 100],
            color: ['#c05050','#e5cf0d','#5ab1ef'],
            dimension: 0
        },
        /*toolbox: {
            show: true,
            orient: 'vertical',
            left: 'right',
            top: 'center',
            feature: {
                dataView: {
                    readOnly: false
                },
                restore: {},
                saveAsImage: {}
            }
        },*/
        grid: {
            right: 40,
            top: 100,
            bottom: 40,
            width: '30%'
        },
        xAxis: [{
            position: 'top',
            type: 'value',
            boundaryGap: false
        }],
        yAxis: [{
            type: 'category',
            data: []
        }],
        series: [{
            z: 1,
            name: '全部',
            type: 'map',
            map: 'china',
            left: '10',
            right: '35%',
            top: 100,
            bottom: "35%",
            zoom: 0.75,
            label: {
                normal: {
                    show: true
                },
                emphasis: {
                    show: true
                }
            },
            //roam: true,
            data: resultdata0
        }, {
            z: 1,
            name: '男',
            type: 'map',
            map: 'china',
            left: '10',
            right: '35%',
            top: 100,
            bottom: "35%",
            zoom: 0.75,
            label: {
                normal: {
                    show: true
                },
                emphasis: {
                    show: true
                }
            },
            //roam: true,
            data: resultdata1
        }, {
            z: 1,
            name: '女',
            type: 'map',
            map: 'china',
            left: '10',
            right: '35%',
            top: 100,
            bottom: "35%",
            zoom: 0.85,
            label: {
                normal: {
                    show: true
                },
                emphasis: {
                    show: true
                }
            },
            //roam: true,
            data: resultdata2
        }, {
            name: '全部',
            z: 2,
            type: 'bar',
            label: {
                normal: {
                    show: true,
                    position: 'left',
                    formatter: '{b} : {c}',
                    textStyle: {
                        color: '#ff145c'
                    }
                }
            },
            data: resultdata0
        }, {
            name: '男',
            z: 2,
            type: 'bar',
            label: {
                normal: {
                    show: true,
                    position: 'left',
                    formatter: '{b} : {c}',
                    textStyle: {
                        color: '#ff145c'
                    }
                }
            },
            data: resultdata1
        }, {
            name: '女',
            z: 2,
            type: 'bar',
            label: {
                normal: {
                    show: true,
                    position: 'left',
                    formatter: '{b} : {c}',
                    textStyle: {
                        color: '#ff145c'
                    }
                }
            },
            data: resultdata2
        }, {
            name: '全部',
            z: 2,
            type: 'pie',
            radius: ['17%', '25%'],
            center: ['30%', '82.5%'],
            label: {
                normal: {
                    show: true
                },
                emphasis: {
                    show: true,
                }
            },
            itemStyle: {
                emphasis: {
                    color: "rgb(254,153,78)"
                }
            },
            data: resultdata0
        }, {
            name: '男',
            z: 2,
            type: 'pie',
            radius: ['17%', '25%'],
            center: ['30%', '82.5%'],
            label: {
                normal: {
                    show: true
                },
                emphasis: {
                    show: true
                }
            },
            itemStyle: {
                emphasis: {
                    color: "rgb(254,153,78)"
                }
            },
            data: resultdata1
        }, {
            name: '女',
            z: 2,
            type: 'pie',
            radius: ['17%', '25%'],
            center: ['30%', '82.5%'],
            label: {
                normal: {
                    show: true
                },
                emphasis: {
                    show: true
                }
            },
            itemStyle: {
                emphasis: {
                    color: "rgb(254,153,78)"
                }
            },
            data: resultdata2
        }]
    };
    // 使用刚指定的配置项和数据显示图表。
    myChart.setOption(option);
</script>
</body>
</html>

