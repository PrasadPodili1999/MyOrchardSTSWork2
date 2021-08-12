$(Document).ready(function(){
	
	
	
	$(Document).on("click","#get",function(){
		
		var filmName=$("#filmName").val();
		
		$.ajax({
			
			type:"GET",
			url : "director/getAllDirectors/"+filmName,
			success: function(result){
				$.each(result, function(index,director){
					
					var directorRow = '<tr>' +
										'<td>' + director.id + '</td>' +
										'<td>' + director.name.toUpperCase() + '</td>' +
										'<td>' + director.age + '</td>' +
										'<td>' + director.gender.toUpperCase() + '</td>' +
										'<td>' + director.awardCount + '</td>' +
									  '</tr>';
					
					$('#directorTable tbody').append(directorRow);
		        });
				
				console.log(result);
				$( "#directorTable tbody tr:odd" ).addClass("info");
				$( "#directorTable tbody tr:even" ).addClass("success");
			},
			error : function(e) {
				alert("ERROR: ", e);
				console.log("ERROR: ", e);
			}
		});	
		
	});
	
});