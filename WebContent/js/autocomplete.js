
$(function() {

	$("#navbar-search-bar").autocomplete(
		{
			source: function(request, response) {
				$.ajax({
					url: 'NavbarSearch',
					type: 'post',
					dataType: "json",
					data : { nombreProducto: $("#navbar-search-bar").val() },
					success: function(data) {
						response( $.map(data, function (item) {
							return{label: item.NombreProducto, value:item.NombreProducto}
						}))
					},
					error: function(xhr, status, error){
						alert("Error");
					}	
				});
			}
		}
		
		,
		{
			delay: 0,
			minLength: 1
		}
		);



});