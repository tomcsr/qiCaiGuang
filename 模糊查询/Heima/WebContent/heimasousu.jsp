<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>黑马搜索</title>
<script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="js/words.js"></script>
</head>
<body>
<center>
<h2>黑马</h2>
<%  
String cs=request.getParameter("cs"); 
if(cs==null)
cs="";
%>
<input type="text" id="sous01" name="sous01" value="<%=   cs  %>"style="width:700px;height:50px; font-size:22px;"> 
<input type="button" value="黑马一下" style="width:100px;height:55px;"><br>
<div   id="div01" style="position:relative;  left:-50px;width:700px;height:400px;border:1px solid blue; display: none"></div>
 
</center>
</body>
</html>