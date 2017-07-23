<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
 
<html>
 
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
       <title><tiles:getAsString name="title" /></title>
    <link href="<c:url value='/static/css/bootstrap.css' />"  rel="stylesheet"></link>
    <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
</head>
<body>
<table width="100%" height="100%">

<tr height="10%">
<td colspan="2" align="center">

<tiles:insertAttribute name="header"/>
</td></tr>

<tr height="90%">
<td width="10%" height="100%" align="left" >
<tiles:insertAttribute name="lmenu" />
</td> 


 
<td width="100%" bgcolor="#c3d599" align="center">
 <tiles:insertAttribute name="body" />
 </td></tr>
 
 
 
 <tr height="10%">
 <td colspan="2" bgcolor="red" align="center">
 
 <tiles:insertAttribute name="footer" />
</td></tr>
</table>

	<%-- 	<header id="header"> 
        <tiles:insertAttribute name="header" />
        </header> 
     
        <section id="sidemenu">
            <tiles:insertAttribute name="lmenu" />
        </section>
            
        <section id="site-content">
            <tiles:insertAttribute name="body" />
        </section>
         
        <footer id="footer">
            <tiles:insertAttribute name="footer" />
        </footer>  --%>
</body>
</html>