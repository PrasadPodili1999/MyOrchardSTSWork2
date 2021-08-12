$(Document).ready(function(){
	
	//to display add form
	$("#add").click(function(){
		
		$("#addDirector").slideToggle("slow");
	});
	
	//to submit form data
	$("#directorForm").submit(function(event){
		
		event.preventDefault();
		ajaxPost();
	});
	
	function ajaxPost(){
		
		// PREPARE FORM DATA
		var formData={
			name:$("#name").val(),
			age:$("#age").val(),
			gender:$("#gender").val(),
			awardCount:$("#awardCount").val()
		}
		
		console.log("formData before post: " + formData);
		
		// DO POST
		$.ajax({
			
			type : "POST",
			contentType : "application/json",
			url : "director/addDirector",
			data : JSON.stringify(formData),
			dataType : 'json',
			success:function(result){
				
				$("#postDirectorDiv").html("<p style='background-color:#7FA7B0; color:white; padding:20px 20px 20px 20px'>"+
				"post successfully!<br>"+
				"-->{name:"+result.name+"}</p>");
				
				console.log(result);
			},
			error:function(e){
				alert("Error!!");
				console.log("Error :"+e);
			}
		});
		// Reset FormData after Posting
		resetData();	
		
	}
	 function resetData(){
    	$("#name").val("");
    	$("#age").val("");
		$("#gender").val("");
		$("#awardCount").val("");
    }
});