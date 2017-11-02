<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="t" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
 <head>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
     <script type="text/javascript" src="/static/js/toggle.js">
   
  
  </script>
  
   
  
</head>
 
 
<body>

  
<div> 
<div>
<%-- <a href='<c:url value="/feePaymentDetails"></c:url>'>FeePaymentDetails</a><br/></div> --%>
<sec:authorize access="hasRole('ADMIN') or hasRole('ADMIN') or hasRole('USER') or hasRole('DIRECTOR')">
<ul class="dropdown-menu">
<li class="dropdown-header">StudentInformation</li>

<li><a href='<c:url value="/studentSearch"/>'>search Student</a></li>


</ul>
<div><a href='<c:url value="/studentSearch"/>'>Student Search</a><br/></div>
<div class="dropdown">

 <button class="btn btn-default dropdown-toggle" type="button" data-toggle="dropdown">Fee
<span class="caret"></span></button>
<ul class="dropdown-menu">
      <li class="dropdown-header">Student Fee Info</li>
      <li><a href='<c:url value="/feePaymentDetails"/>'>FeePaymentDetails</a></li>
      <li><a href="/feePaymentDetailsForm">Fee Payment Receipt</a></li>
      <li><a href="#">Dumy</a></li>
           
    </ul>
    </div>
    </sec:authorize>
    
</div>


<%-- <div><a href='<c:url value="/feepaymentRecipts"/>'>FeePymentReceipt</a></div> --%>
<div>
<a href="<c:url value='/listofStudent' />">Users List</a>
 </div>
<%-- <sec:authorize access="hasRole('ADMIN')"> --%>
<div class="dropdown">
<button class="btn btn-default dropdown-toggle" type="button" data-trigger="hover" data-toggle="dropdown">Student
<span class="caret"></span></button>
<ul class="dropdown-menu">
<li class="dropdown-header">Student Info</li>

<sec:authorize access="hasRole('ADMIN') or hasRole('ADMIN') or hasRole('USER') or hasRole('DIRECTOR')">
<li><a href='<c:url value="/addStudent"/>'>AddNewStudent </a></li>

<li><button class="btn btn-default dropdown-toggle" type="button" ></button></li>
<li><a href='<c:url value='/selecStudCriteria'/>'>SelctStudentBasedonYear</a></li>
<%-- <li><a href="<c:url value='/listofStudent'/>">Student List</a></li> --%>
<li><a href="<c:url value='/addQuestion'/>">Add Question</a></li>

</sec:authorize>
</ul>
</div>
<sec:authorize access="hasRole('STUDENT')">

 
<div class="dropdown">
    <button class="btn btn-default dropdown-toggle" type="button" data-toggle="dropdown1">Tutorials
    <span class="caret"></span></button>
    <ul class="dropdown-menu">
    <li class="dropdown-header">TakeTest</li></ul>
    <%-- <a href="<c:url value='/taketest'/>"> --%>
    <!-- <li><a href="#">chapter level test</a>  -->
    
     
    
    
    
    
    
  <%--   <li><a href='<c:url value="/chapterlevel"/>'>chapter level test</a></li>
      <li><a href="#">difficulty</a></li>
      <li><a href="#">MockTest</a></li>
      <li><a href="#">QuickTest</a></li>
        --%>
     
    
   
  </div>
  <div>
  
   <ul class="list-unstyled">
     
    <li><a data-placement="right" data-toggle="popover1"   data-container="body" data-placement="left" type="button" data-html="true" href="#" id="login">ChapterLevelTest</a></li> 
    <div id="popover-content" class="hide">
      <%-- <form class="form-inline" role="form"> --%>
        <div class="form-group"> 
       <!--  <a href="">Hi</a><br/>
        <a href="">Hi</a><br/>
        <a href="">Hi</a><br/>
        <a href="">Hi</a><br/> -->
      
     <a href="<c:url value='/taketest1-JavaBasics'/>">JavaBasics</a><br/>
     <a href='<c:url value="/taketest1-{Operators}"/>'>Operators</a><br/>
     <a href='<c:url value="/taketest1-{Oops}"/>'>Oops</a><br/>
     <a href='<c:url value="/taketest1-{Threading}"/>'>Threading</a><br/>
     <a href='<c:url value="/taketest1-{Exception}"/>'>Exception</a><br/>
     <a href='<c:url value="/taketest1-{JavaBasics}"/>'>Collections</a><br/>
     <a href='<c:url value="/taketest1-{JavaBasics}"/>'>JavaBasics</a><br/>
      
     <%-- <form:form action="/taketest1" commandName="QUEST">
     <form:hidden path="chaptername" value="Operators" />
     <input class="btn btn-primary btn-xs" type="submit" value="Operators"/><br/>
    </form:form>
    <form:form action="/taketest1" commandName="QUEST">
     <form:hidden path="chaptername" value="Oops" />
     <input class="btn btn-primary btn-xs" type="submit" value="Oops"/><br/>
    </form:form>
    <form:form action="/taketest1" commandName="QUEST">
     <form:hidden path="chaptername" value="Threading" />
     <input class="btn btn-primary btn-xs" type="submit" value="Threading"/><br/>
    </form:form>
    <form:form action="/taketest1" commandName="QUEST">
     <form:hidden path="chaptername" value="Exception" />
     <input class="btn btn-primary btn-xs" type="submit" value="Exception"/><br/>
    </form:form>
    <form:form action="/taketest1" commandName="QUEST">
     <form:hidden path="chaptername" value="Collections" />
     <input class="btn btn-primary btn-xs" type="submit" value="Collections"/><br/>
    </form:form> --%>
             
            
         
    
        </div>
     <%--  </form> --%>
    </div>
   
    </ul>
  
</div>
<%-- <li><a href="<c:url value='/taketest'/>">Take Test</a>
 --%>
</sec:authorize>

<%-- <div><a href='<c:url value="/addStudent"/>'>AddNewStudent </a></div> --%>
<%-- </sec:authorize> --%>
</div>

</div>
</body>
</html>