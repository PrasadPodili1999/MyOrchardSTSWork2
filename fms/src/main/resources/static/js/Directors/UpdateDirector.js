$(document).ready(function() {
	
	
	$("#update").click(function(){
	
	$("#updateDirector").slideToggle("slow");
	});
	
	
	
	$("#customizedForm").submit(function(){
		event.preventDefault();
		ajaxPut();
	});
	
	
	/*
	 * AJAX PUT updated-form
	 */
    function ajaxPut(){
    	// PREPARE FORM DATA
    	var formData = {
    			id: $("#updateId").val(),
    			name : $("#updateName").val(),
    			age : $("#updateAge").val(),
    			awardCount : $("#upateAwardCount").val()
    	}
    	
    	
    	console.log("formData before PUT: " + formData);
    	
    	// DO PUT
    	$.ajax({
			type : "PUT",
			contentType : "application/json",
			url :  "director/update" ,
			data : JSON.stringify(formData),
			dataType : 'json',
			
			// SUCCESS response
			success : function(result) {
				// Create successful message
				$("#putDirectorDiv").html("<p style='background-color:#67597E; color:white; padding:20px 20px 20px 20px'>" + 
											"Put Successfully! <br>" +
											"--> {id: " + result.id +
												"name: " + result.name +
												"age: " + result.age +
												"gender: " + result.gender +
												"awardCount: " + result.awardCount +"}</p>");
				
				console.log(result);
			},
			
			// ERROR response 
			error : function(e) {
				alert("Error!")
				console.log("ERROR: "+ e);
			}
		});
		resetData();
    }
	function resetData(){
		$("#updateId").val()
		$("#updateName").val("");
    	$("#updateAge").val("");
		$("#upateAwardCount").val("");
	}
})