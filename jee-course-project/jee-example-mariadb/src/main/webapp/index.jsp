<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
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

            </style>
        </head>
        <body>  

            <div id="head">
                <img src="https://yjpj7w.by.files.1drv.com/y4m9xiLhxG7ZMsavZXQWtuDj8vipad9zaXA5vTxAC1am13ihw1Du2BdbQbpjCE9DPA2Dy2GsUnQpitL9DihHqKVKPx-iLo1mtfjAuyudjNGNPJ8RosLnN_rz58zUfwLzRVqId_J9S4qh48jM7z5apNIYkDGr_Q3Vstm99QSSs7b06qNw_Zca4z5-97RjA6J1aIhvcnNwxHN7fETzAHxDCK8Ug?width=660&height=197&cropmode=none" width="660" height="197" />
                <h2>Welcome to Ticket Monster</h2>
                <h4>The First Intergalactic Concert Agency</h4>
                <a href="./StudentServlet" onclick="return showInfo()">Fly me to the Tickets</a>
            </div>

            <div id="login" style="display:none">
                    <form action="./StudentServlet" method="POST">
                        <div class="container">
                            <label for="uname"><b>Username</b></label>
                            <input type="text" placeholder="Enter Username" name="loginUsername" required>
                            <br>
                            <label for="psw"><b>Password</b></label>
                            <input type="password" placeholder="Enter Password" name="loginPassword"  required>
                            <br>   
                            <button type="submit" onClick=showInfo()>Login</button>
                            <label> <input type="checkbox" checked="checked" name="remember"> Remember me </label>
                        </div>

                        <div class="container" style="background-color:#f1f1f1">
                            <button type="button" class="cancelbtn">Cancel</button>  <span class="psw">Forgot <a href="#">password?</a></span>
                            <br>
                            <input type="submit" name="action" value="login" />
                        </div>
                    </form>
                </div>

                <div class="user_info">
                    <h1 class="user_info">Ticket Information</h1>
                    <!--   <form action="./StudentServlet" method="POST">
                          <table>
                              <tr>
                                  <td>Ticket ID</td>
                                  <td><input type="text" name="studentId" value="${student.studentId}" /></td>
                              </tr>
                              <tr>
                                  <td>Event Name</td>
                                  <td><input type="text" name="firstname" value="${student.firstname}" /></td>
                              </tr>
                              <tr>
                                  <td>Location</td>
                                  <td><input type="text" name="lastname" value="${student.lastname}" /></td>
                              </tr>
                              <tr>
                                  <td>Price</td>
                                  <td><input type="text" name="yearLevel" value="${student.yearLevel}" /></td>
                              </tr>
                            
                              <tr>
                                  <td>Reserve now</td>
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
                      </form>   -->     
                    <br>
                    <table border="1" class="user_info">
                        <th>Ticket ID</th>
                        <th>Event Name</th>
                        <th>Location</th>
                        <th>Price </th>
                        <th>Reserve now </th>
                        <!--    <th>Year Level</th> -->
                        <c:forEach items="${allStudents}" var="stud">
                            <tr>
                                <td>${stud.studentId}</td>
                                <td>${stud.firstname}</td>
                                <td>${stud.lastname}</td>
                                <td>${stud.userName}</td>
                                <td><button class="reserve_button" id=${stud.studentId} value=${stud.studentId} onClick=reserveTicket(${stud.studentId})> Reserve  </button> </td>
                          <!--    <td>${stud.yearLevel}</td>  --> 
                            </tr>
                        </c:forEach>
                    </table>  
                </div>

                <script>

                    $(document).ready(function () {
                        $('#add').attr("disabled", true); 												//disable the add button on the form
                        $('#no_pass_message').html('Password cannot be empty').css('color', 'red');
                        //        	$('.user_info').css("display", "none");									//hide the user info table
                        //        	$('#login').css("display", "none")

                    });

                    $('#password, #confirm_password').on('keyup', function () {
                        if ($('#password').val() == "") {
                            $('#no_pass_message').html('Password cannot be empty').css('color', 'red');
                            $('#add').attr("disabled", true);
                            return;
                        }

                        $('#message').html('').css('color', 'red');
                        if ($('#password').val() == $('#confirm_password').val()) {
                            $('#add').attr("disabled", false);
                            $('#message').html('Matching').css('color', 'green');
                            $('#no_pass_message').html('').css('color', 'red');
                        } else {
                            $('#message').html('Not Matching').css('color', 'red');
                            $('#add').attr("disabled", true);
                        }
                    });

                    function showInfo() {
                        $('.user_info').css("display", "block");
                        $('#login').css("display", "none");
                    }

                    function reserveTicket(ticket_number) {
                        alert(ticket_number);
                    	var dataString ={"ticket_number":ticket_number,"action":"add"};

                    	$.ajax({
                            type: "POST",
                            data:dataString,
                            url: "./StudentServlet",
                            success: function(){
                                console.log("success");
                            //pairno ta dedomena
                            //$('#results').show();

                            //vazo ta dedomena sto results div tag.
                            //$('#results').html(data);
                        }
                     });


                    	
                        $("#" + ticket_number).html("Reserved");
                        $("#" + ticket_number).attr("disabled", "disabled");
                       // alert("Ticket Reserved");
                    }


                </script>
            </body>
        </html>
