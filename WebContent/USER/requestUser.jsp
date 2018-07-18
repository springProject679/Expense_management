<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>

  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>NetConnect | Expense Management</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.3.0/css/datepicker.css" rel="stylesheet" type="text/css" />
<link href='http://fonts.googleapis.com/css?family=Raleway:500' rel='stylesheet' type='text/css'>

<style>

body {
    width:100px;
	height:100px;
  background: -webkit-linear-gradient(90deg, #16222A 10%, #3A6073 90%); 
  background:    -moz-linear-gradient(90deg, #16222A 10%, #3A6073 90%); 
  background:     -ms-linear-gradient(90deg, #16222A 10%, #3A6073 90%); 
  background:      -o-linear-gradient(90deg, #16222A 10%, #3A6073 90%); 
  background:         linear-gradient(90deg, #16222A 10%, #3A6073 90%); 
font-family: 'Raleway', sans-serif;
}

p {
	color:#CCC;
}

.spacing {
	padding-top:7px;
	padding-bottom:7px;
}
.middlePage {
	width: 680px;
    height: 500px;
    position: absolute;
    top:0;
    bottom: 0;
    left: 0;
    right: 0;
    margin: auto;
}

.logo {
	color:#CCC;
}


</style>
</head>
<body>

<div class="middlePage" style="margin-top:-32px">
<a href="../RegistrationForm.jsp" class="btn btn-default pull-right" style="margin-top:47px;">Go for Reimbursement</a>
<div class="page-header">
  <h1 class="logo">NetConnect<small>   Expense Management</small></h1>
  
</div>
<div class="pull-right">
       <li class="dropdown" style="margin-top:10px;list-style: none;margin-right: 10px;">
                  <a href="#" data-toggle="dropdown" data-play="fadeIn" class="dropdown-toggle">
                     <!-- <em class="fa fa-tencent-weibo"></em> --><small>Welcome : <c:out value="${sessionScope['user']}"/></small>
                  </a>
                  <input type="hidden" id="sesUserName" value="<c:out value="${sessionScope['user']}"/>">
                  <!-- START Dropdown menu-->
                  <ul class="dropdown-menu">
                
                     
                     <li><a href='<c:url value="/j_spring_security_logout"/>' class="logoff">Log out</a></li>
                     </ul>
                     </li>
                     </div>

<div class="panel panel-info" style="height:500px;">
  <div class="panel-heading">
    <h3 class="panel-title">Raise Your Request</h3>
  </div>
  <div class="panel-body">
  
  <div class="row">
  
<div class="col-md-5" >
<a href="#"><img src="logo.png" style="width:181px;margin-top:150px;margin-left:46px;"/></a><br/>

</div>

    <div class="col-md-7" style="border-left:1px solid #ccc;height:428px">

<fieldset>
  <form role="form" action="requestform" method="post" enctype="multipart/form-data">
                
                <input type="hidden" name="manager_id_fk" value="1">
                <input type="hidden" name = "user_id" value = "${userInfo.user_id}"/>
  <select class="form-control input-md" required name="reimbursement_type" id="reimbursement_type">
												
												<option value="">Select Expenses Category</option>
												<option value="Travel">Travel</option>
												<option value="Shopping">Shopping</option>
												<option value="Food">Food</option>
												<option value="others">others</option>
											</select><br>
											 <input id="textinput" name="EmpID" type="text" value="${userInfo.employee_code}"  placeholder="Employee ID" class="form-control input-md"  readonly/><br>
											<div class="row">
											<div class="col-lg-6">
  <input id="textinput" name="EmpName" type="text" placeholder="Employee Name" value="${userInfo.first_name} ${userInfo.last_name}"
													 class="form-control input-md" readonly/></div>
 <div class="col-lg-6">
  <input id="textinput" name="EmailId" type="text" placeholder="Employee Email" value="${userInfo.email_id}"  class="form-control input-md" readonly /><br></div></div>
  <div class="row">
											<div class="col-lg-6">
  <input id="textinput" name="manager_name" type="text" placeholder="Manager Name" value="${userInfo.manager_name}" class="form-control input-md" readonly/></div>
 <div class="col-lg-6">
  <input id="textinput" name="Manager EmailID" type="text" value="${userInfo.manager_email_id}"  placeholder="Manager Email" class="form-control input-md" readonly /><br></div></div>
  
   <input id="textinput" name="estimated_amount" type="number" placeholder="Estimated Amount" class="form-control input-md" /><br>
   <div class="row">
   <div class="col-md-6">
    <input type="text" id="start" name="start_date" placeholder="Start Date" class="form-control input-md" autocomplete="off"/><br></div>
     <div class="col-md-6">
  <input type="text" id="end" name="end_date" placeholder="End Date" class="form-control input-md" autocomplete="off"/>  </div>
  </div>
<textarea name="summary" class="form-control input-md" placeholder="Brief About Trip"></textarea><br>
 <input type="submit" id="singlebutton" name="singlebutton" value="Submit" class="btn btn-info btn-sm"/>
 </form>
</fieldset>

</div>
    
</div>
    
</div>
</div>


</div>

		<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.3.0/js/bootstrap-datepicker.js"></script>
		
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
			 
			});
		
		
		</script>
</body>
</html>