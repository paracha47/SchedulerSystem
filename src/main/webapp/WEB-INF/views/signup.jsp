<!DOCTYPE html>
<html lang="en">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"></c:set>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
    <title>Sign Up</title>

    <!-- Font Icon -->
    <link rel="stylesheet" href="resources/fonts/material-icon/css/material-design-iconic-font.min.css">

    <!-- Main css -->
    <link rel="stylesheet" href="resources/css/style.css">
</head>
<body>

    <div class="">

        <!-- Sign up form -->
        <section class="signup">
            <div class="container">
                <div class="signup-content">
                    <div class="signup-form">
                        <h2 class="form-title">Sign up</h2>
                        <form method="Post" class="register-form" action="${contextPath}/createUser">
                            <div class="form-group">
                                <label for="name"><i class="zmdi zmdi-account material-icons-name"></i></label>
                                <input type="text" name="name" id="name" placeholder="Your Name" required/>
                            </div>
                            <div class="form-group">
                                <label for="email"><i class="zmdi zmdi-email"></i></label>
                                <input type="email" name="email" id="email" placeholder="Your Email" required/>
                            </div>
                             <div class="form-group">
                                <label for="phone"><i class="zmdi zmdi-phone"></i></label>
                                <input type="number" name="phone_no" id="phone_no" placeholder="Your Number" required/>
                            </div>
                            <div class="form-group">
                                <label for="pass"><i class="zmdi zmdi-lock"></i></label>
                                <input type="password" name="password" title="Must contain at least 8 or more characters" id="password" placeholder="Password" required/>
                            </div>
                            <div class="form-group">
                                <label for="re-pass"><i class="zmdi zmdi-lock-outline"></i></label>
                                <input type="password" name="re_password"  title="Must contain at least 8 or more characters" id="re_password" placeholder="Confirm password" required/>
                            </div>
                            <div class="form-group">
                                <input type="checkbox" name="agree-term" id="agree-term" class="agree-term" required />
                                <label for="agree-term" class="label-agree-term"><span><span></span></span>I agree all statements in  <a href="#" class="term-service">Terms of service</a></label>
                            </div>
                            <div class="form-group form-button">
                               <input type="submit" onclick="val()" name="signup" id="signup" class="form-submit" value="Register"/>
                            
                             </div>
                             
                         
                        </form>
                    </div>
                    
                    <div class="signup-image">
                        <figure><img src="resources/images/signup-image.jpg" alt="sing up image"></figure>
                        
                        <c:if test="${!empty message }">
                            <div class="alert alert-success" >
 								 <strong> Success:</strong> <c:out value="${message}"></c:out> <strong> <a href="index">Login</a></strong>
							</div>
							</c:if>
                    </div>
                </div>
            </div>
        </section>
<script>
var a=document.getElementById("phone_no").value;
function val(){
if(a<11){
	alert{"Kindly Enter valid Phone number"};
}}
</script>
    

    </div>

    <!-- JS -->
    <script src="resources/vendor/jquery/jquery.min.js"></script>
    <script src="resources/js/main.js"></script>
</body>
</html>