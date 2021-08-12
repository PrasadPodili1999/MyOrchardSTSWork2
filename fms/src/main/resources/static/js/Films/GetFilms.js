$(Document).ready(function(){
	
	
	
	$(Document).on("click","#get",function(){
		
		var directorName=$("#directorName").val();
		
		$.ajax({
			
			type:"GET",
			url : "film/getAllFilms/"+directorName,
			success: function(result){
				$.each(result, function(index,film){
					
					var directorData="";
					$.each(result.directors, function(index,director){
					
						directorData =directorData+director.name.toUpperCase()+" ";
					});
					var filmRow = '<tr>' +
										'<td>' + film.id + '</td>' +
										'<td>' + film.name.toUpperCase() + '</td>' +
										'<td>' + film.boxOfficeCollection + '</td>' +
										'<td>' + film.rating + '</td>' +
										'<td>' + directorData + '</td>' +
										'<td class="text-center">' +
								        	'<input type="hidden" value=' + film.name + '>' +
								        	'<a class="deletelink" style="cursor:pointer">' +
						          				'<span >Delete</span>' +
						        			'</a>' +
								        '</td>' +
									  '</tr>';
					
					$('#filmTable tbody').append(filmRow);
		        });
				
				$( "#filmTable tbody tr:odd" ).addClass("info");
				$( "#filmTable tbody tr:even" ).addClass("success");
			},
			error : function(e) {
				alert("ERROR: ", e);
				console.log("ERROR: ", e);
			}
		});	
		
	});
	
//to delete a particular Film
	
	$(document).on("click","a.deletelink",function() {
		
		var filmName = $(this).parent().find('input').val();
		var workingObject = $(this);
		
		$.ajax({
			type : "DELETE",
			url : "film/delete/" + filmName,
			success: function(resultMsg){
				$("#resultMsgDiv").html("<p style='background-color:#67597E; color:white; padding:20px 20px 20px 20px'>" +
											"Film with Name=" + filmName + " is deleted successfully!"  +
										"</p>");
				
				workingObject.closest("tr").remove();
				
				// re-css for table
				$( "#filmTable tbody tr:odd" ).addClass("info");
				$( "#filmTable tbody tr:even" ).addClass("success");
			},
			error : function(e) {
				alert("ERROR: ", e);
				console.log("ERROR: ", e);
			}
		});
	});
});