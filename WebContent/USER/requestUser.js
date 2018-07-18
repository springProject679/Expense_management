	$(document).ready(function(){
		
		
	    $("#start_date").keyup(function(){
	    	$(this).val("");
	    });
	    
	    
	    $("#end_date").keyup(function(){
	    	$(this).val("");
	    });
	    
	    
	    $("#start_date").datepicker({
			numberOfMonths: 1,
			changeYear: true,
		    dateFormat: 'dd-mm-yyyy',
		    changeMonth: true,
	        onSelect: function (selected) {
	        	var tt = selected;
	            $("#end_date").datepicker("option", "minDate", tt);
	        }
	    });
	    
	    $("#end_date").datepicker({
	    	numberOfMonths: 1,
	    	changeYear: true,
		    dateFormat: 'dd-mm-yyyy',
		    changeMonth: true,
	        onSelect: function (selected) {
	        	var tt = selected;
	            $("#start_date").datepicker("option", "maxDate", tt);
	        }
	    });
	});