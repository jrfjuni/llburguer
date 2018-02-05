<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix = "fmt" %>

<tags:principal>

<script src="${pageContext.request.contextPath}/resources/js/burguer/snackrequest/details.js"></script>

	<div class="container">
		<div class="row row-offcanvas row-offcanvas-right">

        	<div class="col-12 col-md-6">
        		<form id="snackRequestDetailsForm" class="form-horizontal" role="form">
        			<input type="hidden" name="requestId" id="requestId" value="${snackRequest.id}">
        			<input type="hidden" name="requestValueOrder" id="requestValueOrder" value="${snackRequest.valueOrder}">
        			
		        	<!-- NAME -->    
		        	<div class="row">
		        		<section class="col col-md-12">
				        	<div class="form-group">
				    			<label>
				    				<fmt:message key="label.details.hello"/> <span>${snackRequest.nameRequester}</span>
				    			</label>
				 			 </div>
			 			 </section>
		 			 </div>
		            <!-- /. NAME -->

    			</form>
        	    <!--  /. FORM LOGIN -->  
        	</div><!--/span-->

	        <div class="col-6 col-md-6 sidebar-offcanvas" id="sidebar">
	        
	        		<!-- SPLIT THE VALUE -->
	        		<div class="row">
		        		<section class="col col-md-12">
				        	<div class="form-group">
			    				<p><fmt:message key="label.details.order.progress"/></p>
			    				<p><fmt:message key="label.details.use.calculator"/></p>
				 			 </div>
			 			 </section>
		 			 </div>
		 			 <!-- /. SPLIT THE VALUE -->
		 			 
		 			<!-- VALUE ORDER -->
	        		<div class="row">
		        		<section class="col col-md-12">
				        	<div class="form-group">
			    				<p><fmt:message key="label.details.value.order"/> ${snackRequest.valueOrder}</p>
				 			 </div>
			 			 </section>
		 			 </div>
		 			 <!-- /. VALUE ORDER -->
		 			 
		 			 <!-- QTY PEOPLE -->    
		        	<div class="row">
		        		<section class="col col-md-4">
				        	<div class="form-group">
				    			<label for="qtyPeople">
				    				<fmt:message key="label.details.amount.people"/>
				    			</label>
				    			<div class="input-group">
				    				<input id="qtyPeople" type="number" class="form-control" name="qtyPeople">
				  				</div>
				 			 </div>
			 			 </section>
		 			 </div>
		            <!-- /. QTY PEOPLE -->
		            
		            <!-- VALUE PERSON -->
	        		<div class="row">
		        		<section class="col col-md-12">
				        	<div class="form-group">
			    				<fmt:message key="label.details.value.person"/> <span class="burguer-value-person">${snackRequest.valueOrder}</span>
				 			 </div>
			 			 </section>
		 			 </div>
		 			 <!-- /. VALUE PERSON -->
		 			 
		 			 <div class="row">
        				<section class="col col-md-12">
        					<table class="burguer-table-person-percent" >
							  <thead>
							    <tr>
							      <th scope="col"></th>
							      <th scope="col"><fmt:message key="label.details.value"/></th>
							      <th scope="col"><fmt:message key="label.details.percent"/></th>
							    </tr>
							  </thead>
							  <tbody class='burguer-tbody-person-percent'></tbody>
							</table>
        				</section>
        			</div>
        		
	        </div>
     	 </div>
    </div>

</tags:principal>