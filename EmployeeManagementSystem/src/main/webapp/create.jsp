<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form:form action="save" modelAttribute="employee">
<form:label path="id">ID:</form:label>
<form:input path="id"/>
<br><br>
<form:label path="name">NAME:</form:label>
<form:input path="name"/>
<br><br>
<form:label path="designation">DESIGNATION:</form:label>
<form:input path="designation"/>
<br><br>
<form:label path="salary">SALARY:</form:label>
<form:input path="salary"/>
<br><br>
<input type="submit" value="SAVE EMPLOYEE">

</form:form>

</body>
</html>