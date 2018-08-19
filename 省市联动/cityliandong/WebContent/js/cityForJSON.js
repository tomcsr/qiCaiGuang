$(function(){
	$("#province2").change(function (){
		//获取省份的id
		var id=$("#province2").val();
		var city2=$("#city2");
		//把id发送给servlet
		$.post("cityServlet",{"pid":id,"lx":"json"},function(data){		 
			/*[
		[{"city":"龙岩市","id":1,"pid":1},
		{"city":"厦门市","id":2,"pid":1},
		{"city":"三明市","id":3,"pid":1},
		{"city":"福州市","id":4,"pid":1},
		{"city":"漳州市","id":5,"pid":1}]			...
			]*/
			//清空数据
			city2.html("<option  value='0'>-请选择-");
			//遍历返回的json数据
			$(data).each(function(index,c){
			//  alert(index);
			city2.append("<option  value='"+c.id+"'>"+c.city);
			});
		},"json");
		
	});
});