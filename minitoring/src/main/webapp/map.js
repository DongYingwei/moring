var map = new window.BMap.Map("map");//创建Map实例
map.centerAndZoom(new BMap.Point(-80.640809,40.544989), 11);  // 初始化地图,设置中心点坐标和地图级别
map.enableScrollWheelZoom();//开启鼠标滚轮缩放

	var polygon = new BMap.Polygon([
		new BMap.Point(-80.140809,40.841989),
		new BMap.Point(-80.840809,40.841989),
		new BMap.Point(-80.840809,40.541989),
		new BMap.Point(-80.140809,40.541989)
	], {strokeColor:"blue", strokeWeight:2, strokeOpacity:0.5});   //创建多边形
	map.addOverlay(polygon);   //添加多边形到地图上
	$.ajax({
		url: 'http://localhost:8080/show/all', // 发送请求的页面
		type: 'post',  //请求方式
		dataType: 'json', //返回的数据类型
		data: {param1: 'value1'}, //发送到服务器的数据
		success: function(data){ //请求成功后调用的回调函数
			var count=0
			var setMap=function(uid,j,w){
			if(j < -80.840809|| j > -80.140809 || w < 40.541989 || w > 40.841989){
				point = new BMap.Point(j,w);
				var opts = {
				  position : point,    // 指定文本标注所在的地理位置
				  offset   : new BMap.Size(30, -30)    //设置文本偏移量
				}
				var label = new BMap.Label("超出范围~id号：" + uid, opts);  // 创建文本标注对象
				label.setStyle({
					 color : "red",
					 fontSize : "12px",
					 height : "20px",
					 lineHeight : "20px",
					 fontFamily:"微软雅黑"
				 });
				map.addOverlay(label); // 将标签添加到地图中
			}
				var newPoint = new BMap.Point(j, w);
				var marker = new BMap.Marker(newPoint);//创建标注
				map.addOverlay(marker); //将标注添加到地图上
			}
				setMap(data[count].uid,data[count].long_pred,data[count].lait_pred);//标记点的位置
				var timerInterval=null;
				timerInterval=setInterval(()=>{ //每一秒显示一个点，直到完显示所有的点
					count++;
					if(count==data.length){
						clearInterval(timerInterval);//取消定时执行操作
					}else{
						setMap(data[count].uid,data[count].long_pred,data[count].lait_pred);//标记点的位置
					}
				},1000)
		},
		error: function(){

		}
	})
