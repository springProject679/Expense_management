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

  
    <title>NetConnect | Expense Management</title>

   
    <link rel="stylesheet" href="..\luna\vendor\fontawesome\css\font-awesome.css">
    <link rel="stylesheet" href="..\luna\vendor\animate.css\animate.css">
    <link rel="stylesheet" href="..\luna\vendor\bootstrap\css\bootstrap.css">
    <link rel="stylesheet" href="..\luna\vendor\toastr\toastr.min.css">

  <link rel="stylesheet" href="http://code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
  
    <link rel="stylesheet" href="..\luna\styles\pe-icons\pe-icon-7-stroke.css">
    <link rel="stylesheet" href="..\luna\styles\pe-icons\helper.css">
    <link rel="stylesheet" href="..\luna\styles\stroke-icons\style.css">
    <link rel="stylesheet" href="..\luna\styles\style2.css">
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
                  
                  <li class="dropdown" style="margin-top:10px;">
                  <a href="#" data-toggle="dropdown" data-play="fadeIn" class="dropdown-toggle">
                     <!-- <em class="fa fa-tencent-weibo"></em> --><small>Welcome : <c:out value="${sessionScope['user']}"/></small>
                  </a>
                  <input type="hidden" id="sesUserName" value="<c:out value="${sessionScope['user']}"/>">
                  <!-- START Dropdown menu-->
                  <ul class="dropdown-menu">
                     <li><a href="update_password">Account details</a>
                     </li>
                     
                     <li><a href='<c:url value="/j_spring_security_logout"/>' class="logoff">Log out</a></li>
                     </ul>
                     </li>
                </ul>
            </div>
        </div>
    </nav>
   
    <aside class="navigation">
        <nav>
            <ul class="nav luna-nav">
              
                <li class="">
                    <a href="#">Request List</a>
                </li>
                <li>
                    <a href="#">Expenses</a>
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

							     <div class="panel panel-filled">
                        <div class="panel-heading">
                         
                            <h3></h3>
                         
                        </div>
                        <div class="panel-body">
							     <div class="row">
						<div class="col-lg-12">
                       
                            <div class="table-responsive">
                                    <%-- <table class="table table-condensed table-bordered">
                                    
                                     <tr>
                                            <th>Employee Name</th>
                                            <th>Reason for Travel</th>
                                            <th>Transport Type</th>
                                            <th>Traveling Date From</th>
                                            <th>Traveling Date To</th>
                                            <th>Total Expense</th>
                                            <th></th>
                                       </tr>
                                        <c:forEach items ="${masterList}" var="ma">
                                   
                                        <tr>
                                         <td>${ma.employee_name}</td>
                                         <td>${ma.reason_of_travel}</td>
                                         <td>${ma.transport_type}</td>
                                         <td>${ma.travelling_date_from}</td>
                                         <td>${ma.travelling_date_to}</td> 
                                         <td>${ma.total_expense_price}</td>
                                        
											<td>
											<a href="showExpenseViewData?master_id=${ma.id}" class="btn btn-sm btn-warning button3" data-toggle="modal" id="${ma.id}">View Expenses</a>
											</td>
                                        </tr>
                                        </c:forEach>
                                   
										                     </table>
                               --%>
                               
                               
                               <table class="table table-condensed table-hover">
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
                                
                                </div>
                                </div>
                         
							
                         
            </div>
      
				</div>

          
    </section>
  

</div>



<script src="<spring:url value="../assets/js/gsap/main-gsap.js"  htmlEscape="true"/>" id="script-resource-1"></script>
	<script src="<spring:url value="../assets/js/jquery-ui/js/jquery-ui-1.10.3.minimal.min.js"  htmlEscape="true"/>"
		id="script-resource-2"></script>
<script src="..\luna\vendor\pacejs\pace.min.js"></script>
<script src="..\luna\vendor\jquery\dist\jquery.min.js"></script>
<script src="..\luna\vendor\bootstrap\js\bootstrap.min.js"></script>
<script src="..\luna\vendor\toastr\toastr.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.3.0/js/bootstrap-datepicker.js"></script>


    <script src="http://code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
       

 
<script src="..\luna\scripts\luna.js"></script>
	
  

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