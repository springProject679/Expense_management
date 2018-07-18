<!DOCTYPE html>
<html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <head>
        <meta charset="UTF-8">
        <title>NetConnect</title>
        <meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
        
        <link href="../assets/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
        
        <link href="../assets/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
        
        <link href="../assets/css/ionicons.min.css" rel="stylesheet" type="text/css" />
        
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
						<div class="col-lg-12">
                                
						<div class="box box-warning">
                                <div class="box-body no-padding">
                                    <table class="table table-condensed">
                                    
                                     <tr>
                                            <th>Employee Name</th>
                                            <th>Reason for Travel</th>
                                            <th>Transport Type</th>
                                            <th>Traveling Date From</th>
                                            <th>Traveling Date To</th>
                                            
                                       </tr>
                                        <c:forEach items ="${masterList}" var="ma">
                                   
                                        <tr>
                                         <td>${ma.employee_name}</td>
                                         <td>${ma.reason_of_travel}</td>
                                         <td>${ma.transport_type}</td>
                                         <td>${ma.travelling_date_from}</td>
                                         <td>${ma.travelling_date_to}</td> 
                                        <%--  <td>${ma.total_expense_price}</td> --%>
                                        <td></td>
											
                                        </tr>
                                        </c:forEach>
                                        
										                     </table>
                                </div><!-- /.box-body -->
                               </div>
                               
						</div>
						</div>	
 
                </section>
            </aside>
			
			
</div>



 <div class="modal fade" id="myModal1" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Request Details</h4>
        </div>
        <div class="modal-body">
          <div class="box box-info">
                                <div class="box-header">
                                    
                                </div>
                                <div class="box-body">
                                    
                                </div>
                            </div>
        </div>
        
      </div>
      
    </div>
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
        

		
		
	
		

    </body>
</html>