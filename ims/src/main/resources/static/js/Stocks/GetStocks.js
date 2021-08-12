$(Document).ready(function(){
	
	
	
	$(Document).on("click","#getAll",function(){
		
		
		$.ajax({
			
			type:"GET",
			url : "stock/get",
			success: function(result){
				$.each(result, function(index,stock){
					
					var stockRow = '<tr>' +
										'<td>' + stock.id + '</td>' +
										'<td>' + stock.productType.toUpperCase() + '</td>' +
										'<td>' + stock.price + '</td>' +
										'<td>' + stock.quantity + '</td>' +
									  '</tr>';
					
					$('#stockTable tbody').append(stockRow);
		        });
				
				console.log(result);
				$( "#stockTable tbody tr:odd" ).addClass("info");
				$( "#stockTable tbody tr:even" ).addClass("success");
			},
			error : function(e) {
				alert("ERROR: ", e);
				console.log("ERROR: ", e);
			}
		});	
		
	});
	
});