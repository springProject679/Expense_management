<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
    <head>
        <meta charset="UTF-8">
        <title>NetConnect</title>
        <meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
        
        <link href="/assets/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
        
        <link href="/assets/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
        
        <link href="/assets/css/ionicons.min.css" rel="stylesheet" type="text/css" />
        
        <link href="../assets/css/morris/morris.css" rel="stylesheet" type="text/css" />
        
        <link href="../assets/css/jvectormap/jquery-jvectormap-1.2.2.css" rel="stylesheet" type="text/css" />
        
        <link href="../assets/css/fullcalendar/fullcalendar.css" rel="stylesheet" type="text/css" />
        
        <link href="../assets/css/daterangepicker/daterangepicker-bs3.css" rel="stylesheet" type="text/css" />
        
        <link href="../assets/css/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css" rel="stylesheet" type="text/css" />
        
		<link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.3.0/css/datepicker.css" rel="stylesheet" type="text/css" />
       
	   <link href="../assets/css/AdminLTE.css" rel="stylesheet" type="text/css" />

        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
          <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
        <![endif]-->
		
<style>
		.main-footer {
    background: #fff;
    padding: 15px;
    color: #444;

    border-top: 1px solid #d2d6de;
}
		</style>
    </head>
    <body class="skin-black">
        
        <header class="header">
            <a href="index.html" class="logo">
        
                NetConnect
            </a>
        
            <nav class="navbar navbar-static-top" role="navigation">
        
                <div class="navbar-right">
                    <ul class="nav navbar-nav">
                      
                        
                    </ul>
                </div>
            </nav>
        </header>
        <div class="wrapper row-offcanvas row-offcanvas-left">
          
            

            
            <aside class="">
              
                <section class="content">
                   <div class="row">
				   <div class="col-md-12">
                    <div class="box box-primary">
                                <div class="box-header">
                                    <h3 class="box-title">Travel Reimbursement Form</h3>
                                </div><!-- /.box-header -->
                                <div class="box-body">
                                    <form role="form">
                                        <!-- text input -->
										<div class="row">
											<div class="col-md-4">
											<div class="form-group">
												
												<input type="text" class="form-control" placeholder="Employee ID"/>
											</div>
											</div>
											<div class="col-md-4">
											<div class="form-group">
												
												<input type="text" class="form-control" placeholder="Employee Name"/>
											</div>
											</div>
											<div class="col-md-4">
											<div class="form-group">
												
												<input type="text" class="form-control" placeholder="Division"/>
											</div>
											</div>
										</div>
										<div class="row">
											<div class="col-md-4">
											<div class="form-group">
												
												<input type="text" class="form-control" placeholder="Department"/>
											</div>
											</div>
											<div class="col-md-4">
											<div class="form-group">
												
												<input type="text" class="form-control" placeholder="Manager Name"/>
											</div>
											</div>
											<div class="col-md-4">
											<div class="form-group">
												
												<input type="text" class="form-control" placeholder="Designation"/>
											</div>
											</div>
										</div>
										<div class="row">
											<div class="col-md-4">
											<div class="form-group">
												<label>Transport Type</label>
												</br>
                                                <label>Air
                                                    <input type="radio"/>
                                                    
                                                </label>                                                
                                                 
											
                                                <label>Bus
                                                    <input type="radio"/>
                                                    
                                                </label>                                                
                                            
											
                                                <label>Train
                                                    <input type="radio"/>
                                                    
                                                </label>                                                
                                            
											</div>
											</div>
											<div class="col-md-4">
											<div class="form-group">
												 <input type="text" class="form-control" placeholder="From"/>                                              
                                            
											</div>
											</div>
												<div class="col-md-4">
											<div class="form-group">
												 <input type="text" class="form-control" placeholder="To"/>                                              
                                            
											</div>
											</div>
											
										</div>
										<div class="row">
											<div class="col-md-4">
											<div class="form-group">
												<input type="text" id="start" class="form-control" placeholder="Start Date"/>                                                 
                                            
											</div>
											</div>
											<div class="col-md-4">
											<div class="form-group">
												 <input type="text" id="end" class="form-control" placeholder="End Date"/>                                              
                                            
											</div>
											</div>
												<div class="col-md-4">
											<div class="form-group">
												 <textarea rows="" cols="" class="form-control" placeholder="Aim of Travelling"></textarea>                                              
                                            
											</div>
											</div>
											
										</div>
										
										</div>
										
                                       
                                        </div>


                                    
                                </div>
                            </div>
							
							<div class="row">
							   <div class="col-md-12">
								<div class="box box-success">
                                 <div class="box-header">
                                    <h3 class="box-title">Expenses List</h3>
                                </div>
                                <div class="box-body">
								<table class="table table-hover">
								<thead>
								<tr>
								<th>Date</th>
								<th>Description</th>
								<th>Amount</th>
								<th></th>
								</tr>
								</thead>
								<tbody>
								<tr>
								 <td><input type="text" class="form-control"/> </td>
								<td><input type="text" class="form-control"/> </td>
								<td><input type="text" class="form-control"/> </td>
								<td></td>
								</tr>
								
								</tbody>
								</table>
								<div style="text-align:center;">
								<input type="submit" class="btn btn-success"/>
										<input type="reset" class="btn btn-danger"/></div>
								</div>
                                    
                                </div>
                            </div>
							</div>
 </form>
                </section>
            </aside>
			
			<footer class="main-footer" style="font-size: 12px !important; ">
    <div class="pull-right ">
      <a  href="#">Privacy Policy</a> | <a  href="https://poshsecure.com/terms.html">Terms and Conditions</a> | <a href="https://poshsecure.com/refundpolicy.html">Refund Policy</a>
    </div>
    <strong>Copyright © 2018 <a  href="#">  NetConnect</a></strong> All Rights
    Reserved.
</footer>
</div>

       <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>  
        
        
        <script src="../assets/js/bootstrap.min.js" type="text/javascript"></script>
        
        <script src="../assets/js/AdminLTE/app.js" type="text/javascript"></script>
        <script src="../assets/js/plugins/flot/jquery.flot.min.js" type="text/javascript"></script>
        
        <script src="../assets/js/plugins/flot/jquery.flot.resize.min.js" type="text/javascript"></script>
        
        <script src="../assets/js/plugins/flot/jquery.flot.pie.min.js" type="text/javascript"></script>
        
        <script src="../assets/js/plugins/flot/jquery.flot.categories.min.js" type="text/javascript"></script>
        
        <script src="../assets/js/plugins/jqueryKnob/jquery.knob.js" type="text/javascript"></script>
        
        <script src="../assets/js/plugins/sparkline/jquery.sparkline.min.js" type="text/javascript"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.3.0/js/bootstrap-datepicker.js"></script>
        
		<script>
		$(function () {
  $("#start").datepicker({ 
        autoclose: true, 
        todayHighlight: true
  }).datepicker('update', new Date());
   $("#end").datepicker({ 
        autoclose: true, 
        todayHighlight: true
  }).datepicker('update', new Date());
});

		
		</script>
		
		
	
		

    </body>
</html>