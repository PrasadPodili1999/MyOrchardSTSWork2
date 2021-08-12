$(Document).ready(function(){
	
	//to display add form
	$("#add").click(function(){
		
		$("#addOrder").slideToggle("slow");
	});
	
	//to submit form data
	$("#orderForm").submit(function(event){
		
		event.preventDefault();
		ajaxPost();
	});
	
	function ajaxPost(){
		
		// PREPARE FORM DATA
		var formData={
			customer:{
				id:$("#cId").val()
			},
			stock:{
				id:$("#sId").val(),
				productType:$("#productType").val()
			},
			quantity:$("#quantity").val()
		}
		
		console.log("formData before post: " + formData);
		
		// DO POST
		$.ajax({
			
			type : "POST",
			contentType : "application/json",
			url : "order/addOrder",
			data : JSON.stringify(formData),
			dataType : 'json',
			success:function(result){
				
				$("#postOrderDiv").html("<p style='background-color:#7FA7B0; color:white; padding:20px 20px 20px 20px'>"+
				"post successfully!<br>"+
				"-->{OrderId:"+result.id+"}</p>");
				
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
    	$("#cId").val("");
    	$("#sId").val("");
    	$("#productType").val("");
		$("#quantity").val("");
    }
});