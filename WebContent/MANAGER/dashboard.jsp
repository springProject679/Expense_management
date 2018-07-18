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
    
    <style type="text/css">
    .Row
{
    display: table;
    width: 50%; /*Optional*/
    table-layout: fixed; /*Optional*/
    border-spacing: 10px; /*Optional*/
}
.Column
{
    display: table-cell;
    background-color: lightgoldenrodyellow; /*Optional*/
}
    </style>
    
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
                
                
            </ul>
        </nav>
    </aside>


		<section class="content">
			<div class="container-fluid">
				<div class="row">
					<div class="col-md-12">
						<div class="row">
							<div class="col-lg-12">
								<div
									style="background: url('12345.jpg'); background-size: cover; height: 333px;"></div>
							</div>
						</div>
						<br>
						<br>
						<div class="Row">
							<div class="Column">
								<b>Manager Name</b></br>${managerData.name}</div>
							<div class="Column">
								<b>Total Budget</b></br>${managerData.total_budget}</div>
							<div class="Column">
								<b>Budget In Hand</b></br>
								<input type="text" id="abc" value = "${managerData.budget_in_hand}" readonly class="Column"
								style = "background: transparent; background: transparent;
								           border-top: transparent !important;
								           border-left: transparent !important;
								           border-right: transparent !important;
								           border-bottom: transparent !important;
								           padding-left: 0;
								        "/>
							</div>

						</div>
					</div>
				</div>
				<br>
				<br>
				<div class="row">
					<div class="col-lg-12">

						<div class="box box-warning">
							<div class="box-body no-padding">
								<table class="table table-condensed">

									<tr>
										<th>Employee Name</th>
										<th>Email ID</th>
										<th>Expected Budget</th>
										<th>Reason</th>
										<th>Start Date</th>
										<th>End Date</th>

										<th>Status</th>

									</tr>
									<c:forEach items="${masterList}" var="ma">
										<tr>
											<td>${ma.first_name}${ma.last_name}</td>
											<td>${ma.email_address}</td>
											<td>${ma.estimated_amount}</td>
											<td>${ma.reimbursement_type}</td>
											<td>${ma.start_date}</td>
											<td>${ma.end_date}</td>

											<td><c:choose>
													<c:when test="${ma.manager_approval == '0'}">
														<input type="button" class=" btn-danger no_btn"
															onclick='approve(this.id,0,${ma.requestId},${ma.estimated_amount});'
															id="${ma.requestId}" value="Approve" />

														<input type="button" class=" btn-success yes_btn"
															onclick='reject(this.id,1,${ma.requestId});'
															id="${ma.requestId}rj" value="Reject" />
														<p style="width: 68px; padding: 1px;"
															id="${ma.requestId}pid" /></p>
													</c:when>
													<c:when test="${ma.manager_approval == '1'}">
														<input type="button" class=" btn-success yes_btn"
															id="${ma.requestId}wt" value="Approved" />

													</c:when>
													<c:when test="${ma.manager_approval == '2'}">
														<input type="button" class=" btn-success yes_btn"
															id="${ma.requestId}rjxt" value="Rejected" />
													</c:when>
													<c:otherwise>
														<p></p>
													</c:otherwise>
												</c:choose></td>
										</tr>
									</c:forEach>
									</tr>
								</table>
							</div>
							<!-- /.box-body -->
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

function approve(id,flag,requestId,estimated_amount){
	var budgetInHand = document.getElementById('abc').value;
	//alert(budgetInHand);
	if(estimated_amount < budgetInHand){
		var LatestbudgetInHand = budgetInHand - estimated_amount;
		//alert(LatestbudgetInHand);
		$("#abc").val(LatestbudgetInHand);
		hideApproveButton(id,flag);
		approveAjaxCall(requestId,LatestbudgetInHand);	
		LatestbudgetInHand = 0;
	}		
}

function reject(id,flag,requestId){
	hideRejectButton(id,flag);
	rejectAjaxCall(requestId);		
} 

function hideApproveButton(id,flag){
	//flag =0 means approve hide approved show
	if(flag == 0){
		$('#'+id).hide();
		hideRejectButton(id,flag);//reject hide
		$('#'+id+'wt').show(); //approved show
	}
	else if(flag == 1){
		var str = id;
		var len = str.length;
		str = str.substring(0,len-2);
		$('#'+str).hide(); // approve hide
	}
}

function approveAjaxCall(requestId,budgetInHand){
	$.ajax({
		type : 'POST',
		url : 'ApproveRequest/'+requestId+'/'+budgetInHand,
		success : function(res){
			console.log('success = '+res);
			//$(abc).html(budgetInHand);
			$('#'+requestId+'pid').html('<b>Approved</b>');
			
		},
		error : function(res){
			console.log('error = '+res);
		}
	});	
	
}

function hideRejectButton(id,flag){
	//flag = 0 reject hide 
	if(flag == 0){
		$('#'+id+'rj').hide(); //
	}//flag =1 reject hide rejected show
	else if(flag == 1){
		$('#'+id).hide(); //reject hide
		$('#'+id+'xt').show(); //rejected show
		hideApproveButton(id,flag);//approve hide		
	}	
}

function rejectAjaxCall(requestId){
	 $.ajax({ 
		 type : 'POST', 
		 url : 'RejectRequest/'+requestId, 
		 success : function(data) { 
		 	console.log('data := success'+data);
		 	$('#'+requestId+'pid').html('<b>Rejected</b>');
		 } ,
	     error: function(data){
	    	 console.log('data---- error'+data);
	     }
		 });	
}
</script>


 

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