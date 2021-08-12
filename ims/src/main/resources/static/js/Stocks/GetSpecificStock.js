$(Document).ready(function(){
	
	
	
	$(Document).on("click","#get",function(){
		
		var productType=$("#productType").val();
		
		$.ajax({
			
			type:"GET",
			url : "stock/get/"+productType,
			success: function(result){
				
					
					var stockRow = '<tr>' +
										'<td>' + result.id + '</td>' +
										'<td>' + result.productType.toUpperCase() + '</td>' +
										'<td>' + result.price + '</td>' +
										'<td>' + result.quantity + '</td>' +
									  '</tr>';
					
					$('#specificStockTable tbody').append(stockRow);
				
				console.log(result);
				$( "#specificStockTable tbody tr:odd" ).addClass("info");
				$( "#specificStockTable tbody tr:even" ).addClass("success");
			},
			error : function(e) {
				alert("ERROR: ", e);
				console.log("ERROR: ", e);
			}
		});	
		
	});
	
});