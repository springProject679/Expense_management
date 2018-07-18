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
                               <thead>
                               <tr>
                                 <th>Sl.No</th>
                                 <th>Employee Name</th>
                                 <th>Email-ID</th>
                                 <th>Amount</th> 
                                 <th>Summary</th>
                                 <th>Start Date</th>
                                 <th>End Date</th>
                                 </tr>
                               </thead>
                               <tbody><% int count=0; %>
                              <c:forEach items = "${userExpenses}" var="ve">
                              <tr>
                              <% count ++; %>
                                 <td><%= count %></td>
                                 <td>${ve.empName}</td>
                                 <td>${ve.email_address} </td>
                                 <td>${ve.estimated_amount}</td> 
                                 <td>${ve.summary}</td>
                                 <td>${ve.start_date}</td>
                                 <td>${ve.end_date}</td>
                                 
                              </tr>
                              </c:forEach> 
                               
                               </tbody>
                             
                             </table>   
						
                               </div>
                               </div>
						</div>
						</div>	
 
                </section>
            </aside>
			
			
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