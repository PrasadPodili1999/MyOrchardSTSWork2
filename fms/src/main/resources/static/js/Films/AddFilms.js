$(Document).ready(function() {

	var i=0;
	$("#add").click(function() {

		$("#addFilm").slideToggle("slow");
	});

	$("#addNewDirector").click(function(event){
	
		event.preventDefault();
		$("#fig").append("<div>DirectorId:<input type='number' class='form-control' id='id"+i+"'></div>");
		i++;
	})

	$("#submit").click(function(){

		event.preventDefault();
		ajaxPost();
	});
	function ajaxPost() {

		var director=[];
		for(var j=0;j<i;j++)
		{
			var directors={};
			id="id"+j;
			console.log(id);
			directors.id=document.getElementById(id).value;
			director.push(directors);
		}
		var formData={
		
			name:$("#name").val(),
			boxOfficeCollection:$("#boxOfficeCollection").val(),
			rating:$("#rating").val(),
			directors:director
		}
		
		console.log(formData);

		$.ajax({

			type: "POST",
			contentType: "application/json",
			url : "film/addFilm",
			data: JSON.stringify(formData),
			dataType: 'json',
			success: function(result) {
				$("#postFilmDiv").html("<p style='background-color:#7FA7B0; color:white; padding:20px 20px 20px 20px'>" +
					"post successfully!<br>" +
					"-->{id:" + result.id +
					",name:" + result.name +
					", " + "}</p>");

				console.log(formData);
			},
			error: function(e) {
				alert("Error!!");
				console.log("Error :" + e);
			}
		});
		// Reset FormData after Posting
		resetData();
	}
	function resetData() {
		$("#name").val("");
		$("#boxOfficeCollection").val("");
		$("#rating").val("");
	}

});