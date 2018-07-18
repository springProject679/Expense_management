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

    <!-- Vendor styles -->
    <link rel="stylesheet" href="..\luna\vendor\fontawesome\css\font-awesome.css">
    <link rel="stylesheet" href="..\luna\vendor\animate.css\animate.css">
    <link rel="stylesheet" href="..\luna\vendor\bootstrap\css\bootstrap.css">

    <!-- App styles -->
    <link rel="stylesheet" href="..\luna\styles\pe-icons\pe-icon-7-stroke.css">
    <link rel="stylesheet" href="..\luna\styles\pe-icons\helper.css">
    <link rel="stylesheet" href="..\luna\styles\stroke-icons\style.css">
    

    
    
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
<div class="row">


</div>


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
                                 <th>TL Name</th>
                                 <th>Total Budget Allotted</th>
                                 <th>Budget in Hand</th>
                                 <th>View Expenses</th>
                                 </tr>
                               </thead>
                               <tbody>
                              <c:forEach items = "${TL_Info}" var="mi">
                              <tr>
                                 <td>${mi.id}</td>
                                 <td>${mi.tl_name}</td>
                                 <td>${mi.total_budget} </td>
                                 <td>${mi.budget_in_hand}</td>
                                 <td>${mi.id}</td>
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






<!-- App scripts -->


<script src="..\luna\vendor\pacejs\pace.min.js"></script>
<script src="..\luna\vendor\jquery\dist\jquery.min.js"></script>
<script src="..\luna\vendor\chart.js\dist\Chart.min.js"></script>
<script src="..\luna\vendor\bootstrap\js\bootstrap.min.js"></script>




       

 

<script src="..\luna\vendor\pacejs\pace.min.js"></script>
<script src="..\luna\vendor\jquery\dist\jquery.min.js"></script>
<script src="..\luna\vendor\bootstrap\js\bootstrap.min.js"></script>
<script src="..\luna\vendor\chart.js\dist\Chart.min.js"></script>

<script src="..\luna\scripts\luna.js"></script>

  
<script>
    $(document).ready(function () {


        /**
         * Options for Line chart
         */

        var globalOptions = {
            responsive: true,
            legend: {
                labels:{
                    fontColor:"#90969D"
                }
            },
            scales: {
                xAxes: [{
                    ticks: {
                        fontColor: "#90969D"
                    },
                    gridLines: {
                        color: "#37393F"
                    }
                }],
                yAxes: [{
                    ticks: {
                        fontColor: "#90969D"
                    },
                    gridLines: {
                        color: "#37393F"
                    }
                }]
            }
        };

        var lineData = {
            labels: ["January", "February", "March", "April", "May", "June", "July"],
            datasets: [

                {
                    label: "Data 1",
                    backgroundColor: 'transparent',
                    borderColor: "#f6a821",
                    pointBorderWidth: 0,
                    pointRadius: 2,
                    pointBorderColor: '#f6a821',
                    borderWidth: 1,
                    data: [16, 32, 18, 26, 42, 33, 44]
                },
                {
                    label: "Data 2",
                    backgroundColor: 'transparent',
                    borderColor: "#676B73",
                    pointBorderWidth: 0,
                    pointRadius: 2,
                    pointBorderColor: '#676B73',
                    borderWidth: 1,
                    data: [22, 44, 67, 43, 76, 45, 12]
                }
            ]
        };

        var c1 = document.getElementById("lineOptions").getContext("2d");
        new Chart(c1, {type: 'line', data: lineData, options: globalOptions});

        /**
         * Options for Sharp Line chart
         */
        var sharpLineData = {
            labels: ["January", "February", "March", "April", "May", "June", "July"],
            datasets: [
                {
                    label: "Example dataset",
                    backgroundColor: 'rgba(246,168,33, 0.1)',
                    borderColor: "#f6a821",
                    pointBorderWidth: 0,
                    pointRadius: 2,
                    pointBorderColor: '#f6a821',
                    borderWidth: 1,
                    data: [33, 48, 40, 19, 54, 27, 54],
                    lineTension: 0
                }
            ]
        };

        var c2 = document.getElementById("sharpLineOptions").getContext("2d");
        new Chart(c2, {type: 'line', data: sharpLineData, options: globalOptions});


        /**
         * Data for Bar chart
         */
        var barData = {
            labels: ["January", "February", "March", "April", "May", "June", "July"],
            datasets: [
                {
                    label: "Data 1",
                    backgroundColor: 'transparent',
                    borderColor: "#f6a821",
                    borderWidth: 1,
                    data: [9, 8, 5, 6, 3, 2, 16]
                },
                {
                    label: "Data 2",
                    backgroundColor: 'transparent',
                    borderColor: "#676B73",
                    borderWidth: 1,
                    data: [5, 5, 5, 4, 5, 2, 23]
                }
            ]
        };

        var c3 = document.getElementById("barOptions").getContext("2d");
        new Chart(c3, {type: 'bar', data: barData, options: globalOptions});

        /**
         * Options for Bar chart
         */

        /**
         * Data for Bar chart
         */
        var singleBarData = {
            labels: ["January", "February", "March", "April", "May", "June", "July"],
            datasets: [
                {
                    label: "Data 0",
                    backgroundColor: 'transparent',
                    borderColor: "#f6a821",
                    borderWidth: 1,
                    data: [15, 20, 30, 40, 30, 50, 60]
                }
            ]
        };

        var c4 = document.getElementById("singleBarOptions").getContext("2d");
        new Chart(c4, {type: 'bar', data: singleBarData, options: globalOptions});


        var polarData = {
            datasets: [{
                data: [
                    120,
                    130,
                    100
                ],
                borderWidth: 0,
                backgroundColor: [
                    "rgba(246,168,33, 0.1)",
                    "rgba(246,168,33, 0.4)",
                    "rgba(246,168,33, 0.8)"
                ],
                label: 'My dataset' // for legend
            }],
            labels: [
                "Homer",
                "Inspinia",
                "Luna"
            ]
        };

        var c5 = document.getElementById("polarOptions").getContext("2d");
        new Chart(c5, {type: 'polarArea', data: polarData, options: globalOptions});


        var doughnutData = {
            labels: [
                "App",
                "Software",
                "Laptop"
            ],
            datasets: [
                {
                    data: [20, 120, 100],
                    borderWidth: 0,
                    backgroundColor: [
                        "rgba(246,168,33, 0.1)",
                        "rgba(246,168,33, 0.4)",
                        "rgba(246,168,33, 0.8)"
                    ],
                    hoverBackgroundColor: [
                        "#F6A821",
                        "#F6A821",
                        "#F6A821"
                    ]
                }]
        };


        var c6 = document.getElementById("doughnutChart").getContext("2d");
        new Chart(c6, {type: 'doughnut', data: doughnutData, options: globalOptions});

    });
</script>
   
   
</body>
</html>