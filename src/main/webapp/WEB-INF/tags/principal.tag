<%@ tag language="java" pageEncoding="utf-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix = "fmt" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset="utf-8" />
    	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
    	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1"/>
    	<title><fmt:message key="label.title"/></title>
    	
    	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap/bootstrap.min.css" >
    	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/fonts/css/fontawesome-all.min.css" >
    	
    	<script  src="${pageContext.request.contextPath}/resources/js/jQuery/jquery-3.3.1.min.js"></script>
    	<script  src="${pageContext.request.contextPath}/resources/js/bootstrap/bootstrap.min.js"></script>
    	<script  src="${pageContext.request.contextPath}/resources/js/util.js"></script>
    	<script  src="${pageContext.request.contextPath}/resources/js/message_${pageContext.response.locale}.js"></script>
	</head>

	<body>

		<!-- HEADER -->
	    <nav class="navbar navbar-toggleable-md navbar-inverse fixed-top bg-inverse">
	      
	    	<button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
	        	<span class="navbar-toggler-icon"></span>
	      	</button>
	      
	      	<a class="navbar-brand" href="#"><fmt:message key="label.title"/></a>
	
		      <div class="collapse navbar-collapse" id="navbarsExampleDefault">
		      	<div class="mr-auto"></div>
		      	
		      	<!-- LANGUAGE -->
		      	<ul class="navbar-nav navbar-right">
		        	<li class="nav-item dropdown">
		          		<button type="button" class="btn btn-secondary dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
				   			<fmt:message key="label.language"/>
				  		</button>
				  
				  		<div class="dropdown-menu dropdown-menu-right">
				  	
				  			<!-- PORTUGUESE -->
						  	<a href="?lang=pt" rel="nofollow" class='dropdown-item'>
								<fmt:message key="label.language.pt"/>
							</a>
					
							<!-- ENGLISH -->
							<a href="?lang=en" rel="nofollow" class='dropdown-item'>
								<fmt:message key="label.language.en"/>
							</a>
				  		</div>
		          	</li>
		      	</ul>
		      	<!-- /. LANGUAGE -->
		        
		         <!-- SIGNOUT -->
		         <button class="btn btn-outline-success burguer-btn-logout" style="margin-left: 1%;">
				 	<i class="fas fa-sign-out-alt"></i> <fmt:message key="label.signout"/>
				 </button>
				 <!-- /. SIGNOUT -->
		         
		      </div>
	    </nav>
	    <!-- /. HEADER -->

    <!-- BODY -->
    <div class="jumbotron">
    
    <div class="burguer-message"></div>
    
		
      	<jsp:doBody />
    </div>
    <!--  /. BODY -->

    <div class="container">
      
      <hr>

      <footer>
      <p><c:out value = "${locale}"/></p>
        <p>© Company 2017</p>
      </footer>
    </div> <!-- /container -->
   

</body>
</html>


