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

<div class="page-header">
  <h1 class="logo">NetConnect<small>   Expense Management</small></h1>
  
</div>

<div class="panel panel-info" style="height:500px;">
  <div class="panel-heading">
    <h3 class="panel-title">Raise Your Request</h3>
  </div>
  <div class="panel-body">
  
  <div class="row">
  
<div class="col-md-5" >
<a href="#"><img src="logo.png" style="width:138px;"/></a><br/>

</div>

    <div class="col-md-7" style="border-left:1px solid #ccc;height:323px">
    
    
<form role="form" action="requestform" method="post" enctype="multipart/form-data">
<fieldset>

  <input id="textinput" name="EmailId" type="text" placeholder="Employee Email" class="form-control input-md" required/> <br>
 
  <input id="textinput" name="EmpName" type="password" placeholder="Employee Name" class="form-control input-md" /><br>
  <input id="textinput" name="ManagerID" type="password" placeholder="Aim of Travelling" class="form-control input-md" /><br>
   <input id="textinput" name="manager_name" type="password" placeholder="Estimated Amount" class="form-control input-md" /><br>
   <div class="row">
   <div class="col-md-6">
    <input type="text" id="start" name="Start" placeholder="Start Date" class="form-control input-md" autocomplete="off"/><br></div>
     <div class="col-md-6">
  <input type="text" id="end" name="End" placeholder="End Date" class="form-control input-md" autocomplete="off"/>  </div>
  </div>
<textarea name="summary" class="form-control input-md" placeholder="Brief About Trip"></textarea><br>
 <input type="submit" id="singlebutton" name="singlebutton" value="Submit" class="btn btn-info btn-sm"/>
</fieldset>
</form>
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