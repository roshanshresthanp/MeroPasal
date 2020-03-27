<%-- 
    Document   : adminpanel
    Created on : Dec 4, 2019, 1:30:55 PM
    Author     : ROSHAB
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cp" value="${pageContext.request.contextPath}" /> <!-- var cp holds value -->
<!DOCTYPE html>
<html lang="en">

<head>

  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>Category Management</title>

  <!-- Custom fonts for this template-->
  <link href="${cp}/static/backend/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
  <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

  <!-- Custom styles for this template-->
  <link href="${pageContext.request.contextPath}/static/backend/css/sb-admin-2.min.css" rel="stylesheet">

</head>

<body id="page-top">

  <!-- Page Wrapper -->
  <div id="wrapper">

   <!-- sidebar was here -->
   <%@include file ="sidebar.jsp" %>
   
<%--<jsp:include page ="sidebar.jsp"/> --%>
    <!-- Content Wrapper -->
    <div id="content-wrapper" class="d-flex flex-column">

      <!-- Main Content -->
      <div id="content">

      
          <%@include file="header.jsp" %>
        <!-- Begin Page Content -->
        <div class="container-fluid">

          <!-- Page Heading -->
          <div class="d-sm-flex align-items-center justify-content-between mb-4">
            <h1 class="h3 mb-0 text-gray-800">Manage category</h1>
            <a href="#" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"><i class="fas fa-download fa-sm text-white-50"></i> Generate Report</a>
          </div>
<!--page content row -->
          <div class="row">
              <div class="col-lg-9">
                  <div class="card">
                      <div class="card-header bg-info"> Edit Category
                  </div>
                      <div class="card-body">
                          <form action="${pageContext.request.contextPath}/admin/category/edit" method="post" modelAttribute="Category">
                               <div class="form-group">
                                  <label for="catId">Category Id:</label>
                                  <input class="form-control" id ="catId" name="id" value="${category.id}" readonly>
                               </div>
                              <div class="form-group">
                                  <label for="catName"> Enter category Name:</label>
                                  <input class="form-control" id ="catName" name="name" value="${category.name}">
                               </div>
                              <div class="form-group">
                                  <label for="catDesc"> Enter category description:</label>
                                  <input class="form-control" id="catDesc" name="description" value="${category.description}"/>
                              </div>
                              <div class="form-group">
                                  <label for="catParent"> Select category parent:</label>
                                  <select class="form-control" id="catParent" name="parentCat">
                                      <option value="0">Main Category </option>
                                      <c:forEach items="${catlist}" var="cat">
                                          <option value="${cat.id}" <c:if test="${category.parentCat eq cat.id}"> selected </c:if> >${cat.name} </option>
                                      </c:forEach>
                                      
                                  </select>
                              </div>
                              <div class=form-group">
                                  <input class="btn btn-primary" type="submit" value="Save"/>
                                  <input class="btn btn-warning" type="reset" value="Reset"/>
                              </div>
                          </form>    
              </div>
          </div>

        </div>
        <!-- /.container-fluid -->

      </div>
      <!-- End of Main Content -->
      <%@include file="footer.jsp" %>
     
  <!-- Bootstrap core JavaScript-->
  
  <script src="${pageContext.request.contextPath}/static/backend/vendor/jquery/jquery.min.js"></script>
  
  <script src="<c:url value="static/vendor/bootstrap/js/bootstrap.bundle.min.js"/>"</script>

  <!-- Core plugin JavaScript-->
  <script src="${pageContext.request.contextPath}/static/backend/vendor/jquery-easing/jquery.easing.min.js"></script>

  <!-- Custom scripts for all pages-->
  <script src="${pageContext.request.contextPath}/static/backend/js/sb-admin-2.min.js"></script>

</body>

</html>


