
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
 <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap demo</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<div class="container">
 <h1>Report Application </h1>
 
 
 <form:form action="search"   modelAttribute="search"  method="POST">
 <table>
          <tr>
               <td>Plan Name :-</td>
               <td>
                 <form:select path="planName">
                 <form:option value="">-Select</form:option>
                  <form:options items="${names }"/>
                 </form:select>
               </td>
               
                <td>Plan Status :-</td>
               <td>
                 <form:select path="planStatus">
                 <form:option value="">-Select</form:option>
                 <form:options items="${status }"/>
                 </form:select>
               </td>
               
                <td>Gender :-</td>
               <td>
                <form:select path="gender">
                 <form:option value="">-Select</form:option>
                 <form:option value="Male">Male</form:option>
                 <form:option value="Female">Fe-Male</form:option>
                 </form:select>
                 </td>
               </td>
          </tr>
          
          <tr>
            <td>Start Date:-</td>
            <td>
            <form:input path="startDate"  type="date" date-date-format="mm/dd/yyyy"/>
            </td>
          
            <td>End Date:-</td>
            <td>
            <form:input path="endDate" type="date" date-date-format="mm/dd/yyyy"/>
            </td>
          </tr>
          
          <tr>
          <td>
          <input type="submit" value="search" class="btn btn-primary">
          </td>
          
          </tr>
          
          
 
 
 </table>
 
 </form:form>

 
 
 <hr>
 
 <table class="table table-striped table-hover">
 
 <thead>
  <tr>
       <th>ID</th>
       <th>Holder Name</th>
       <th>Plan Name</th>
       <th>Gender</th>
       <th>Plan Status</th>
       <th>Start Date</th>
       <th>End Date</th>
  
  </tr>
 </thead>
 <tbody>
 
 <c:forEach  items="${plans}" var="p" varStatus="index" >
   <tr>
  
   <td>${index.count}</td>
   <td>${p.citizenName}</td>
   <td>${p.planName}</td>
   <td>${p.gender}</td>
   <td>${p.planStartDate}</td>
    <td>${p.planStartDate}</td>
     <td>${p.planEndDate}</td>
   </tr>        

    </c:forEach>
    
    <tr>
				<c:if test="${empty p}">
					<td colspan="8" style="text-align: center;">No Record found</td>
				</c:if>
				</tr>
 </tbody>
 
 
 
 </table>
 
 
 <hr>
   Export:- <a href="excel">Excel</a><a href="pdf">PDF</a>
   
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>