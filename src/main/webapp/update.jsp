<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <h2>Edit User Info</h2>
    <form action="update" method="post">
        <input type="hidden" name="name" value="<%= request.getAttribute("name") %>" />
        
        Email: <input type="text" name="email" value="<%= request.getAttribute("email") %>" required/><br>
        Password: <input type="password" name="password" value="<%= request.getAttribute("password") %>" required/><br>
        <input type="submit" value="Update"/>
    </form>
</body>
</html>