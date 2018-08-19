<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>

 <script type="text/javascript" >

	 function over(i){
	     var tr=$("#"+i+"");
	   tr.css("background-color","#ccc");
		 
	 };
	 
	 function out(i){
	     var tr=$("#"+i+"");
		 tr.css("background-color","white");
			 
		 };
    function up(i){
         var td=$("#td"+i+"").text();
		/* 传递参数给搜索框	
		 1:只能把参数传给 text 的value
		 2:然后form表单提交把参数传递给heimasousu.jsp
		 */ 
          $("#cs").val(td);
		  $("#form1").submit();
		  
		  
		 
    };
 </script> 
 <table  style="width:700px;">
 <% int i=1;
 %>
 <c:forEach items="${list }" var="word" > 
 <tr onmouseover="over(<%=i %>)"   onmouseout="out(<%=i%>)"  onmouseup="up(<%=i %>)" id="<%=i %>" >
 <td  id="td<%=i %>" >${word.word }</td>
 </tr>
 <% i++; %>
 </c:forEach>
 </table>
<form  id="form1" action="heimasousu.jsp" method="get">
    <input type="hidden" name="cs" id="cs" >
    </form>