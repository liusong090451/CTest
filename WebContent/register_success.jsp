<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册成功</title>
</head>
<body>
	<center>
		<h1>
			<font color="red" align="center">恭喜您，注册成功！</font>
		</h1>
		<br/>
		<div id="ShowDiv">
			<s:a href="/Struts2HibernateLogin/login.jsp">
				<font color="blue">
					<h5>登录？</h5>
				</font>
			</s:a>
		</div>
	</center>
</body>
</html>