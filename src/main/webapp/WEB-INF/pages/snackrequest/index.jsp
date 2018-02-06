<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix = "fmt" %>

<tags:principal>

<script src="${pageContext.request.contextPath}/resources/js/burguer/snackrequest/index.js"></script>

	<div class="container">
		<div class="row row-offcanvas row-offcanvas-right">

        	<div class="col-12 col-md-6">
        		<form id="snackRequestForm" class="form-horizontal" role="form">
        			
		        	<!-- NAME -->    
		        	<div class="row">
		        		<section class="col col-md-12">
				        	<div class="form-group">
				    			<label for="name">
				    				<fmt:message key="label.name"/>
				    			</label>
				    			<div class="input-group">
				    				<span class="input-group-addon"><i class="fas fa-user"></i></span>
				    				<input id="name" type="text" class="form-control" name="name" maxlength="75" value="">
				  				</div>
				 			 </div>
			 			 </section>
		 			 </div>
		            <!-- /. NAME -->

					<!-- ADDRESS -->    
		        	<div class="row">
		        		<section class="col col-md-12">
				        	<div class="form-group">
				    			<label for="address">
				    				<fmt:message key="label.address"/>
				    			</label>
				    			<div class="input-group">
				    				<span class="input-group-addon"><i class="fas fa-home"></i></span>
				    				<input id="address" type="text" class="form-control" name="address" maxlength="100">
				  				</div>
				 			 </div>
			 			 </section>
		 			 </div>
		           <!-- /. ADDRESS -->    
                    
		           <!-- LIST OF SNACKS -->   
		           <div class="row">
		           		<section class="col col-md-8">
		           			<div class="form-group">
		           				<label for="snack">
		           					<fmt:message key="label.list.snacks"/>
		           				</label>
		           				<select class="form-control burguer-clean-save" id="snack" name="snack"></select>
		           			</div>
		           		</section>
		           </div>
				  <!-- /. LIST OF SNACKS -->   
		  
				  <!-- TYPE OF BREAD -->   
		           <div class="row">
		           		<section class="col col-md-8">
		           			<div class="form-group">
		           				<label for="bread">
		           					<fmt:message key="label.type.bread"/>
		           				</label>
		           				<select class="form-control burguer-associate-snack burguer-item-selected burguer-recalculate burguer-clean-save" id="bread" name="bread"></select>
		           			</div>
		           		</section>
		           </div>
				  <!-- /. TYPE OF BREAD -->   
		  
				  <!-- CHEESE -->   
		           <div class="row">
		           		<section class="col col-md-8">
		           			<div class="form-group">
		           				<label for="cheese">
		           					<fmt:message key="label.cheese"/>
		           				</label>
		           				<select class="form-control burguer-associate-snack burguer-item-selected burguer-recalculate burguer-clean-save" id="cheese" name="cheese"></select>
		           				
		           				 <!-- DOUBLE CHEESE -->
		           				 <label class="form-check-label">
				            		<input class="form-check-input burguer-double-cheese" type="checkbox" id="doubleCheese" name="doubleCheese"> 
				            			<fmt:message key="label.double.cheese"/>
				          		</label>
		           			</div>
		           		</section>
		           </div>
				  <!-- /. CHEESE -->   
	  
				  <!-- FILLING -->   
			      <div class="row">
		           		<section class="col col-md-8">
		           			<div class="form-group">
		           				<label for="filling">
		           					<fmt:message key="label.filling"/>
		           				</label>
		           				<select class="form-control burguer-associate-snack burguer-item-selected burguer-recalculate burguer-clean-save" id="filling" name="filling"></select>
		           				
		           				<small class='burguer-description-filling'></small>
		           				
		           				<!-- DOUBLE FILLING -->
		           				<label class="form-check-label">
				            		<input class="form-check-input burguer-double-filling" type="checkbox" id="doubleFilling" name="doubleFilling"> 
				            			<fmt:message key="label.double.filling"/>
				          		</label>
		           				
		           			</div>
		           		</section>
			           </div>
					  <!-- /. FILLING -->  
		  
					  <!-- SALAD 
					   <div class="form-group row">
					      
					      <label class="col-sm-2">
					      	<fmt:message key="label.salad"/>
					      </label>
					      	
					      <div class="col-sm-10">
					        <div class="form-check form-check-inline">
							  <label class="form-check-label">
							    <input class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio1" value="option1"> 1
							  </label>
							</div>
							
							<div class="form-check form-check-inline">
							  <label class="form-check-label">
							    <input class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio2" value="option2"> 2
							  </label>
							</div>
							
							<div class="form-check form-check-inline disabled">
							  <label class="form-check-label">
							    <input class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio3" value="option3" disabled> 3
							  </label>
							</div>
					      </div>
					    </div>
					   /. SALAD -->
		  
					    <!-- SAUCES
					    <div class="form-group row">
					      
					      <label class="col-sm-2">
					      	<fmt:message key="label.sauces"/>
					      </label>
					      	
					      <div class="col-sm-10">
					        <div class="form-check">
					          <label class="form-check-label">
					            <input class="form-check-input" type="checkbox"> Check me out
					          </label>
					          
					           <label class="form-check-label">
					            <input class="form-check-input" type="checkbox"> Check me out
					          </label>
					          
					        </div>
					      </div>
					    </div>
					   /. SAUCES -->
					  
					  
					  <!-- SPICE
					  <div class="form-group row">
					      
					      <label class="col-sm-2">
					      	<fmt:message key="label.spices"/>
					      </label>
					      	
					      <div class="col-sm-10">
					        <div class="form-check">
					          <label class="form-check-label">
					            <input class="form-check-input" type="checkbox"> Check me out
					          </label>
					          
					           <label class="form-check-label">
					            <input class="form-check-input" type="checkbox"> Check me out
					          </label>
					          
					           <label class="form-check-label">
					            <input class="form-check-input" type="checkbox"> Check me out
					          </label>
					        </div>
					      </div>
					    </div>
					     /. SPICE -->
					    
					     <div class="form-group row text-center">
						   	<div class="col-sm-2"></div>
						   	
						   	<!-- BUTTONS FINISH/SAVE -->
						   	<div class="col-sm-8">
						   		<label>
						   			<fmt:message key="label.value.snack"/>
						   			<span class='burguer-value-snack'></span>
						   		</label>
						   	</div>
						   	<!-- /. BUTTONS FINISH/SAVE -->
						   	<div class="col-sm-2"></div>
	                    </div>    
					  
					    <div class="form-group row text-center">
						   	<div class="col-sm-2"></div>
						   	
						   	<!-- BUTTONS FINISH/SAVE -->
						   	<div class="col-sm-8">
						   		<button type="button" class="btn btn-outline-success btn-burguer-save">
						   			<fmt:message key="label.btn.save"/>
						   		</button>
						   		<button type="button" class="btn btn-outline-primary btn-burguer-finish">
						   			<fmt:message key="label.btn.finish"/>
						   		</button>
						   	</div>
						   	<!-- /. BUTTONS FINISH/SAVE -->
						   	<div class="col-sm-2"></div>
	                    </div>    
     			 
     				 </form>
        	         <!--  /. FORM LOGIN -->  
        	</div><!--/span-->

	        <div class="col-6 col-md-6 sidebar-offcanvas" id="sidebar">
	        
	        	<!-- LOGO -->
	        	<div class="row">
	        		<img src="${pageContext.request.contextPath}/resources/image/burguer-logo.png" class="rounded mx-auto d-block" alt="L.L Lanches" title="L.L Lanches">
        		</div>
        		<!-- /. LOGO -->
        		
        		<!-- LIST SNACKS -->
        		<div class="row">
        			<section class="col col-md-12">
        				<div class="list-group burguer-list-snackes" count="0">
        				
        					<div class='list-group-item burguer-list-snackes-order'>
        						<label>
        							<fmt:message key="label.value.order"/>
				   					<span class='burguer-value-order'>0.00</span>
				   				</label>	
        					</div>
        				</div>
        			</section>
        		</div>
        		<!-- /. LIST SNACKS -->
        		
	        </div>
     	 </div>
    </div>

</tags:principal>