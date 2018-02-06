<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix = "fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	
	<head>
		<meta charset="utf-8" />
    	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
    	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1"/>
    	<title><fmt:message key="label.title.login"/></title>
    	
    	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap/bootstrap.min.css" >
    	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/fonts/css/fontawesome-all.min.css" >
    	
    	<script  src="${pageContext.request.contextPath}/resources/js/jQuery/jquery-3.3.1.min.js"></script>
    	<script  src="${pageContext.request.contextPath}/resources/js/bootstrap/bootstrap.min.js"></script>
    	
    	<script  src="${pageContext.request.contextPath}/resources/js/index.js"></script>
    	<script  src="${pageContext.request.contextPath}/resources/js/util.js"></script>
    	
    	<script type="text/javascript">
			var contextPath = "${pageContext.request.contextPath}";
		</script>
    	
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
		         
		      </div>
	    </nav>
	    <!-- /. HEADER -->

    <!-- BODY -->
    <div class="jumbotron">
      <div class="container">
      
      	<form id="loginForm" class='form-horizontal' action="/" method="post">
      			
      			<div class='row col col-md-12'>
      			
      				<div class='col col-md-4'></div>
      				
      				<div class='col col-md-4'>
      					<fieldset>
      						
      						<legend>Login</legend>
      					
		      					<!-- USER -->    
					        	<div class="row">
					        		<section class="col col-md-12">
							        	<div class="form-group">
							    			<div class="input-group">
							    				<span class="input-group-addon"><i class="fas fa-user"></i></span>
							    				<input id="username" type="text" class="form-control" name="username" maxlength="75" value="" placeholder="<fmt:message key="label.user"/>">
							  				</div>
							 			 </div>
						 			 </section>
					 			 </div>
					            <!-- /. USER -->
					            
					            <!-- PASSWORD -->    
					        	<div class="row">
					        		<section class="col col-md-12">
							        	<div class="form-group">
							    			<div class="input-group">
							    				<span class="input-group-addon"><i class="fas fa-key"></i></span>
							    				<input id="password" type="password" class="form-control" name="password" maxlength="75" value="" placeholder="<fmt:message key="label.password"/>">
							  				</div>
							 			 </div>
						 			 </section>
					 			 </div>
					            <!-- /. PASSWORD -->
					            
					            <div class="row">
					            	<section class="col col-md-12">
					        			<button class="btn btn-outline-success burguer-btn-login" type="submit">
				 							<i class="fas fa-sign-in-alt"></i>
				 						</button>
				 					</section>
					 			 </div>
      				
      					</fieldset>
      				</div>
      				
      				<div class='col col-md-4'></div>
      			
      			</div>
      	
      	</form>
      		
      </div>
    </div>
    <!--  /. BODY -->

    <div class="container">
      
      <hr>

      <footer>
        <p>© Company 2017</p>
      </footer>
    </div> <!-- /container -->
   

</body>
</html>