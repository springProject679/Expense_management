<html>
<head>

  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

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
<!-- <div class="row">
<div class="col-lg-6">
<a href="request.jsp" class="btn btn-default" style="margin-left:800px;margin-top:20px;">Raise Request</a>

</div>
<div class="col-lg-6">

<a href="RegistrationForm.jsp" class="btn btn-default" style="margin-left:878px;margin-top:20px;">Go for Reimbursement</a>
</div>
</div> -->
<div class="middlePage">

<div class="page-header">
  <h1 class="logo">NetConnect<small>   Expense Management</small></h1>
  
</div>

<div class="panel panel-info">
  <div class="panel-heading">
    <h3 class="panel-title">Please Sign In</h3>
  </div>
  <div class="panel-body">
  
  <div class="row">
  
<div class="col-md-5" >
<a href="#"><img src="logo.png" style="width:138px;"/></a><br/>

</div>

    <div class="col-md-7" style="border-left:1px solid #ccc;height:160px">
    
    
<form method="post" action="j_spring_security_check">
<fieldset>
  <input id="textinput" name="j_username" type="text" class="form-control input-md" required/> <br>
 
  <input id="textinput" name="j_password" type="password" placeholder="Enter Password" class="form-control input-md" required/><br>
 
  <input type="submit" id="singlebutton" name="singlebutton" value="Sign In" class="btn btn-info btn-sm pull-right"/>
  

</fieldset>
</form>
</div>
    
</div>
    
</div>
</div>

<p><a href="#">About</a>      NetConnect Pvt. Ltd.</p>

</div>
</body>
</html>