<%-- 
    Document   : signup
    Created on : Dec 15, 2019, 1:06:19 PM
    Author     : ROSHAB
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:set var="cp" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">

<head>

  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>SignUp</title>

  <!-- Custom fonts for this template-->
  <link href="${cp}/static/backend/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
  <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

  <!-- Custom styles for this template-->
  <link href="${cp}/static/backend/css/sb-admin-2.min.css" rel="stylesheet">

</head>

<body class="bg-gradient-primary">

  <div class="container">

    <div class="card o-hidden border-0 shadow-lg my-5">
      <div class="card-body p-0">
        <!-- Nested Row within Card Body -->
        <div class="row">
          <div class="col-lg-5 d-none d-lg-block bg-register-image"></div>
          <div class="col-lg-7">
            <div class="p-5">
              <div class="text-center">
                <h1 class="h4 text-gray-900 mb-4">Create Account</h1>
              </div>
                <form class="user" action="${pageContext.request.contextPath}/signup" method="post" enctype="multipart/form-data">
                <div class="form-group row">
                  <div class="col-sm-6 mb-3 mb-sm-0">
                      <label> First Name</label>
                    <input type="text" class="form-control form-control-user" name="firstName" placeholder="First Name">
                  </div>
                  <div class="col-sm-6">
                      <label>Last Name</label>
                    <input type="text" class="form-control form-control-user" name="lastName" placeholder="Last Name">
                  </div>
                </div>
                <div class="form-group">
                    <label>Email</label>
                  <input type="email" class="form-control form-control-user" name="email" placeholder="Email Address">
                </div>
                <div class="form-group row">
                  <div class="col-sm-6 mb-3 mb-sm-0">
                      <label>Phone</label>
                    <input type="text" class="form-control form-control-user" name="phone" placeholder="PhoneNumber">
                  </div>
                  <div class="col-sm-6">
                      <label>Date OF Birth</label>
                    <input type="date" class="form-control form-control-user" name="dob" >
                  </div>
                    <div class="col-sm-6">
                        <label>User Name</label>
                    <input type="text" class="form-control form-control-user" name="username" placeholder="Enter User Name">
                  </div>
                    <div class="col-sm-6">
                        <label>Password</label>
                    <input type="password" class="form-control form-control-user" name="password" placeholder="Enter Password">
                  </div>
                    <div class="col-sm-6">
                        <label>Confirm Password</label>
                    <input type="password" class="form-control form-control-user" name="confirmPassword" placeholder="Re-Enter Password">
                  </div>
                    <div 
                    <div class="col-sm-6">
                        <label>Photo</label>
                     <input type="file" class="form-control form-control-user" name="image" placeholder="image">
                  </div>
                    <div class="col-sm-6">
                        <label>Authority</label>
                    <select class="form-control" name="authority" >
                        <option value="ROLE_ADMIN">Administrator</option>
                        <option value="ROLE_USER">User</option>
                    </select>
                  </div>
                    
                </div>
                <button type="submit" class="btn btn-primary btn-user btn-block">
                  Register Account
                </button>
                <hr>
                <a href="#" class="btn btn-google btn-user btn-block">
                  <i class="fab fa-google fa-fw"></i>Google
                </a>
                <a href="#" class="btn btn-facebook btn-user btn-block">
                  <i class="fab fa-facebook-f fa-fw"></i> Facebook
                </a>
              </form>
              <hr>
              <div class="text-center">
                <a class="small" href="#">Forgot Password?</a>
              </div>
              <div class="text-center">
                <a class="small" href="${pageContext.request.contextPath}/login">Already have an account? Login!</a>
              </div>
            </div>
          </div>
        </div> 
      </div>
    </div>

  </div>

  <!-- Bootstrap core JavaScript-->
  <script src="${cp}/static/backend/vendor/jquery/jquery.min.js"></script>
  <script src="${cp}/static/backend/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

  <!-- Core plugin JavaScript-->
  <script src="${cp}/static/backend/vendor/jquery-easing/jquery.easing.min.js"></script>

  <!-- Custom scripts for all pages-->
  <script src="${cp}/static/backend/js/sb-admin-2.min.js"></script>

</body>

</html>