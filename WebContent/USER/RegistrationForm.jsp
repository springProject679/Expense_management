<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
    <head>
       <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link href='http://fonts.googleapis.com/css?family=Roboto:300,400,500,700,900' rel='stylesheet' type='text/css'>

  
    <title>Netconnect 360</title>

   
    <link rel="stylesheet" href=".\luna\vendor\fontawesome\css\font-awesome.css">
    <link rel="stylesheet" href=".\luna\vendor\animate.css\animate.css">
    <link rel="stylesheet" href=".\luna\vendor\bootstrap\css\bootstrap.css">
    <link rel="stylesheet" href=".\luna\vendor\toastr\toastr.min.css">

  <link rel="stylesheet" href="http://code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
  
    <link rel="stylesheet" href=".\luna\styles\pe-icons\pe-icon-7-stroke.css">
    <link rel="stylesheet" href=".\luna\styles\pe-icons\helper.css">
    <link rel="stylesheet" href=".\luna\styles\stroke-icons\style.css">
    <link rel="stylesheet" href=".\luna\styles\style2.css">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.3.0/css/datepicker.css" rel="stylesheet" type="text/css" />
    </head>
    <body>


<div class="wrapper">
 <nav class="navbar navbar-default navbar-fixed-top">
        <div class="container-fluid">
            <div class="navbar-header">
                <div id="mobile-menu">
                    <div class="left-nav-toggle">
                        <a href="#">
                            <i class="stroke-hamburgermenu"></i>
                        </a>
                    </div>
                </div>
                <a class="navbar-brand" href="index.htm" style="letter-spacing:0px;font-size:24px">
                   NetConnect 
                    <span>EM</span>
                </a>
            </div>
            <div id="navbar" class="navbar-collapse collapse">
                <div class="left-nav-toggle">
                    <a href="">
                        <i class="stroke-hamburgermenu"></i>
                    </a>
                </div>
           
                <ul class="nav navbar-nav navbar-right">
          
                </ul>
            </div>
        </div>
    </nav>
   
    <aside class="navigation">
        <nav>
            <ul class="nav luna-nav">
              
                <li class="">
                    <a href="#">Home</a>
                </li>
<%-- 
                <li>
                    <a href="#monitoring" data-toggle="collapse" aria-expanded="false">
                        Purchase Order<span class="sub-nav-icon"> <i class="stroke-arrow"></i> </span>
                    </a>
                    <ul id="monitoring" class="nav nav-second collapse">
                    <spring:url value="createPurchaseOrder" var="createPurchaseOrder" htmlEscape="true" />
                        <li><a href="${createPurchaseOrder}">Create Purchase Order</a></li>
                        <spring:url value="purchase_order" var="purchase_order" htmlEscape="true" />
                        <li><a href="po_landing.jsp">View Purchase Order</a></li>
                       
                    </ul>
                </li> --%>
                
                
                
            </ul>
        </nav>
    </aside>
   
  
    <section class="content">
            <div class="container-fluid">
            <div class="row">
<div class="col-md-12">
<form role="form" action="reemberse_request" method="post" enctype="multipart/form-data">
                 <div class="panel panel-filled">
                        <div class="panel-heading">
                         
                            <h3>Reimbursement Form</h3>
                         
                        </div>
                        <div class="panel-body">
                        
             
                    
                               
                                
                                    
                                        <!-- text input -->
										<div class="row">
											<div class="col-md-4">
											<div class="form-group">
												
												<input type="text" class="form-control" name="employee_id" placeholder="Employee ID"/>
											</div>
											</div>
											<div class="col-md-4">
											<div class="form-group">
												
												<input type="text" class="form-control" name="employee_name" placeholder="Employee Name"/>
											</div>
											</div>
											<div class="col-md-4">
											<div class="form-group">
												
												<input type="text" class="form-control" name="division" placeholder="Division"/>
											</div>
											</div>
										</div>
										<div class="row">
											<div class="col-md-4">
											<div class="form-group">
												
												<input type="text" class="form-control" name="department" placeholder="Department"/>
											</div>
											</div>
											<div class="col-md-4">
											<div class="form-group">
												
												<input type="text" class="form-control" name="manager_name" placeholder="Manager Name"/>
											</div>
											</div>
											<div class="col-md-4">
											<div class="form-group">
												
												<input type="text" class="form-control" name="designation" placeholder="Designation"/>
											</div>
											</div>
										</div>
										<div class="row">
											<div class="col-md-4">
											<div class="form-group">
												<label>Transport Type</label>
												<div>
												
                                                <label>Air
                                                    <input type="radio" name="transport_type" value="Air"/>
                                                    
                                                </label>                                                
                                                 
											
                                                <label>Bus
                                                    <input type="radio" name="transport_type" value="Bus"/>
                                                    
                                                </label>                                                
                                            
											
                                                <label>Train
                                                    <input type="radio" name="transport_type" value="Train"/>
                                                    
                                                </label>      
                                                </div>                                          
                                            
											</div>
											</div>
											<div class="col-md-4">
											<div class="form-group">
												 <input type="text" class="form-control" name="travelling_from" placeholder="From"/>                                              
                                            
											</div>
											</div>
												<div class="col-md-4">
											<div class="form-group">
												 <input type="text" class="form-control" name="travelling_to" placeholder="To"/>                                              
                                            
											</div>
											</div>
											
										</div>
										<div class="row">
											<div class="col-md-4">
											<div class="form-group">
												<input type="text" id="start" class="form-control" name="travelling_date_from" placeholder="Start Date"/>                                                 
                                            
											</div>
											</div>
											<div class="col-md-4">
											<div class="form-group">
												 <input type="text" id="end" class="form-control" name="travelling_date_to" placeholder="End Date"/>                                              
                                            
											</div>
											</div>
											<div class="col-md-4">
											<div class="form-group">
												 <input type="text" id="end" class="form-control" name="cost_center" placeholder="Cost Center"/>                                              
                                            
											</div>
											</div>
											
											
										</div>
										<div class="row">
										<div class="col-md-12">
											<div class="form-group">
												 <textarea rows="" cols="" name="" class="form-control" name="reason_of_travel" placeholder="Brief About Expenses"></textarea>                                              
                                            
											</div>
											</div>
										</div>
									</div>
									</div>

                          <div class="panel panel-filled">
                        <div class="panel-heading">
                         
                            <h3>Expenses List</h3>
                         
                        </div>
                        <div class="panel-body">
						 <div class="table-responsive">
								<table class="table table-bordered">
								<thead>
								<tr>
								<th>Date</th>
								<th>Description</th>
								<th>Amount</th>
								<th>Attachments</th>
								<th style="width:150px;"></th>
								</tr>
								</thead>
								<tbody id="expenses_div">
								<tr>
								 <td><input type="text" name="date_of_event" class="form-control table1"/> </td>
								<td><input type="text" name="description" class="form-control"/> </td>
								<td><input type="text" name="amount" class="form-control"/> </td>
								<td><input type="file" name="attachment" class="form-control"/></td>
								<td><input type="button" value="Add" class="btn btn-success add_btn"></td>
								</tr>
								
								</tbody>
								</table>
								</div>
								<div class="row">
								<div class="col-lg-6">
								<input type="submit" class="btn btn-success"/></div>
								<div class="col-lg-6">
								<div class="pull-right">
										<input type="reset" class="btn btn-danger"/></div></div>
										
										</div>
										
								</div>
                                    
                                </div>
                                </form>
                                </div>
                                </div>
                         
							
                         
            </div>
      
				

          
    </section>
  

</div>



<script src="<spring:url value="./assets/js/gsap/main-gsap.js"  htmlEscape="true"/>" id="script-resource-1"></script>
	<script src="<spring:url value="./assets/js/jquery-ui/js/jquery-ui-1.10.3.minimal.min.js"  htmlEscape="true"/>"
		id="script-resource-2"></script>
<script src=".\luna\vendor\pacejs\pace.min.js"></script>
<script src=".\luna\vendor\jquery\dist\jquery.min.js"></script>
<script src=".\luna\vendor\bootstrap\js\bootstrap.min.js"></script>
<script src=".\luna\vendor\toastr\toastr.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.3.0/js/bootstrap-datepicker.js"></script>


    <script src="http://code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
       

 
<script src=".\luna\scripts\luna.js"></script>
<script>
		$(function () {
  $("#start").datepicker({ 
        autoclose: true, 
        todayHighlight: true
  });
   $("#end").datepicker({ 
        autoclose: true, 
        todayHighlight: true
  });
   $(".table1").datepicker({ 
       autoclose: true, 
       todayHighlight: true
 });
});

		
		</script>
		<script>
		$(document).ready(function(){
			$("#expenses_div").on("click",".add_btn",function(){
				$("#expenses_div").append("<tr><td><input type='text' name='date_of_event' class='form-control table1'/></td><td><input type='text' name='description' class='form-control'/></td><td><input type='text' name='amount' class='form-control'/> </td><td><input type='file' name='attachment' class='form-control'/></td><td><input type='button' value='Add' class='btn btn-success add_btn'> <input type='button' value='Del' class='btn btn-danger del_btn'></td></tr>");
				
				 $(".table1").datepicker({ 
				       autoclose: true, 
				       todayHighlight: true
				 });
			});
			
			$("#expenses_div").on("click",".del_btn",function(){
				$(this).closest ('tr').remove ();
			});
			
		});
		
		</script>
  

    <script>
        (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
            (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
                m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
        })(window,document,'script','//www.google-analytics.com/analytics.js','ga');

        ga('create', 'UA-4625583-2', 'webapplayers.com');
        ga('send', 'pageview');

    </script>
   
   
</body>
</html>