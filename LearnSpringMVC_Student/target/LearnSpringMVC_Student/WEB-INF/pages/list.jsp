<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "<a class="vglnk" href="http://www.w3.org/TR/html4/loose.dtd" rel="nofollow"><span>http</span><span>://</span><span>www</span><span>.</span><span>w3</span><span>.</span><span>org</span><span>/</span><span>TR</span><span>/</span><span>html4</span><span>/</span><span>loose</span><span>.</span><span>dtd</span></a>">
<%@ taglib uri="<a class="vglnk" href="http://java.sun.com/jsp/jstl/core" rel="nofollow"><span>http</span><span>://</span><span>java</span><span>.</span><span>sun</span><span>.</span><span>com</span><span>/</span><span>jsp</span><span>/</span><span>jstl</span><span>/</span><span>core</span></a>" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Student Management Screen</title>
</head>
<body>
    <div align="center">
        <h1>Student List</h1>
        <h3>
            <a href="newStudent">New Student</a>
        </h3>
        <table border="1">
            <th>Name</th>
            <th>Email</th>
            <th>Address</th>
            <th>Telephone</th>
            <th>Action</th>
            <c:forEach var="student" items="${studentList}">
                <tr>
                    <td>${student.name}</td>
                    <td>${student.email}</td>
                    <td>${student.address}</td>
                    <td>${student.telephone}</td>
                    <td>
                    	<a href="editStudent?id=${student.id}">Edit</a>
          				<a href="deleteStudent?id=${student.id}">Delete</a>
          			</td>
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>