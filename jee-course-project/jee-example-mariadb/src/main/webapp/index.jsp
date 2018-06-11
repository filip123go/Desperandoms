<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>!Student Information!</title>
        <style>
table {
    font-family: arial, sans-serif;
    border-collapse: collapse;
    width: 100%;
}

td, th {
    border: 1px solid #dddddd;
    text-align: left;
    padding: 8px;
}

tr:nth-child(even) {
    background-color: #dddddd;
}
</style>
    </head>
    <body>
        <h1>User Information</h1>
        <form action="./StudentServlet" method="POST">
            <table>
                <tr>
                    <td>ID</td>
                    <td><input type="text" name="studentId" value="${student.studentId}" /></td>
                </tr>
                <tr>
                    <td>First Name</td>
                    <td><input type="text" name="firstname" value="${student.firstname}" /></td>
                </tr>
                <tr>
                    <td>Last Name</td>
                    <td><input type="text" name="lastname" value="${student.lastname}" /></td>
                </tr>
                <tr>
                    <td>Year Level</td>
                    <td><input type="text" name="yearLevel" value="${student.yearLevel}" /></td>
                </tr>
              
                <tr>
                    <td>User Name</td>
                    <td><input type="text" name="userName" value="" /></td>
                </tr>
                
                <tr>
                    <td>Password</td>
                    <td><input  id="password" type="password" name="password" value="" /><span id='no_pass_message'></span></td>
                </tr>
                
                 <tr>
                    <td>confirm password</td>
                    <td><input id="confirm_password" type="password" name="reTypePassword" value="" /><span id='message'></span></td>
                </tr>
                           
                <tr>
                    <td colspan="2">
                        <input type="submit" id ="add" name="action" value="Add"  />
                        <input type="submit" name="action" value="Edit" />
                        <input type="submit" name="action" value="Delete" />
                        <input type="submit" name="action" value="Search" />
                    </td>                
                </tr>            
            </table>
        </form>        
        <br>
        <table border="1">
            <th>ID</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>User Name </th>
             <th>Password </th>
            <th>Year Level</th>
            <c:forEach items="${allStudents}" var="stud">
                <tr>
                    <td>${stud.studentId}</td>
                    <td>${stud.firstname}</td>
                    <td>${stud.lastname}</td>
                     <td>${stud.userName}</td>
                      <td>${stud.password}</td>
                    <td>${stud.yearLevel}</td>
                </tr>
            </c:forEach>
        </table>  
        
        <script>

        $(document).ready(function(){
        	$('#add').attr("disabled", true);
        	$('#no_pass_message').html('Password cannot be empty').css('color', 'red');
            });
               
        $('#password, #confirm_password').on('keyup', function () {
        	if ($('#password').val() == ""){
        		$('#no_pass_message').html('Password cannot be empty').css('color', 'red');
        		 $('#add').attr("disabled", true);
        		 return;
        	}
           
        	 $('#message').html('').css('color', 'red');
		      if ($('#password').val() == $('#confirm_password').val()) {
		          $('#add').attr("disabled", false);
		          $('#message').html('Matching').css('color', 'green');
		          $('#no_pass_message').html('').css('color', 'red');
		       } else{ 
		           $('#message').html('Not Matching').css('color', 'red');
        	       $('#add').attr("disabled", true);
		            }
        });
        </script>
    </body>
</html>
