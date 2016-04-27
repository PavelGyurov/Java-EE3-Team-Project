<%@ page language="java" contentType="text/html; charset=UTF-8" 
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<meta charset="utf-8" />
		<meta name="viewport" content="user-scalable=no, initial-scale=1, maximum-scale=1, minimum-scale=1" />
	    <title>PhotoWolrd</title>
	   	<link href="style1.css" rel="stylesheet">
	</head>
	<body>
	<% pageContext.setAttribute("forward", "index.jsp");%>
		<%@ include file="header.jsp" %>
			
	  	    <input type="radio" name="nav-group" id="nav-close" class="nav-close-option">
	  	    
	  	    <div class="main-image">
	  	    	<img alt="" src="maui.jpg">
	  	    </div>
	  	    <div class="right">
	  	    
             
             	<div class="second-picture">
             		
	             		
	             		<img id="photo-forum" alt="" src="https://www.book.store.bg/lstimg/160039/fotomania-broj-37-maj-2015.jpg">
	             		<p>second picture</p>
             		
             	</div>
       		</div>   
	</body>
</html>