$(function(){
	$("#province").change(function(){
		var pid=$("#province").val();
		var city=$("#city"); 
		$.post("cityServlet",{"pid":pid,"lx":"xml"},function(data){
			 /* 1:初始化city的数据
			  * 1:分析data数据的城市
			  * 2:把城市插入到下拉项中去			
			*/
			city.html("<option  value='0'>-请选择-");
			
			$(data).find("citys").each(function (){
				//遍历出来的每一个city，取它的孩子。 id , cname
				var id=$(this).children("id").text();
				var cname=$(this).children("city").text();
				
				
				city.append("<option  value='"+id+"'>"+cname);
			});
		});
		
	});
	
	
	
});