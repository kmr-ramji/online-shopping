<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url var="images" value="/resources/images" />
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Online Shopping - ${title}</title>

<script type="text/javascript">
	window.menu = '${title}';
	window.contextRoot = '${contextRoot}';
</script>

<!-- Bootstrap core CSS -->
<link href="<c:url value="/resources/css/bootstrap.min.css"/>" rel="stylesheet">
<!-- Bootstrap Theme -->
<%-- <link href="<c:url value="/resources/css/bootstrap-flatly-theme.css"/>" rel="stylesheet"> --%>
<!-- Bootstrap DataTables -->
<link href="<c:url value="/resources/css/dataTables.bootstrap4.css"/>" rel="stylesheet">

<link href="<c:url value="/resources/font-awesome/css/font-awesome.min.css"/>" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="<c:url value="/resources/css/myapp.css"/>" rel="stylesheet">

</head>

<body>
	<div class="wrapper">
		<!-- Navigation -->
		<%@include file="./shared/navbar.jsp"%>

		<!-- Page Content -->
		<div class="content">
			<c:if test="${userClickHome == true}">
				<%@include file="home.jsp"%>
			</c:if>

			<c:if test="${userClickAbout == true}">
				<%@include file="about.jsp"%>
			</c:if>

			<c:if test="${userClickContact == true}">
				<%@include file="contact.jsp"%>
			</c:if>
			
			<c:if test="${userClickAllProducts == true or userClickCategoryProduct == true}">
				<%@include file="listProducts.jsp"%>
			</c:if>
			
			<c:if test="${userClickShowProduct == true}">
				<%@include file="singleProduct.jsp"%>
			</c:if>
		</div>
		<!-- Footer -->
		<%@include file="./shared/footer.jsp"%>

		<!-- Bootstrap core JavaScript -->
		<script src="<c:url value="/resources/js/jquery/jquery.min.js"/>"></script>
		<script src="<c:url value="/resources/js/bootstrap.bundle.min.js"/>"></script>
		
		<script src="<c:url value="/resources/js/jquery/jquery.dataTables.js"/>"></script>
		
		<script src="<c:url value="/resources/js/dataTables.bootstrap4.js"/>"></script>

		<script src="<c:url value="/resources/js/myapp.js"/>"></script>
	</div>
</body>

</html>