var dashboard = {
	
	init: function() {
		setInterval( dashboard.readTemperature, 5000 );
	},
		
	readTemperature: function() {
		$.ajax({
			method: "POST",
			url: "/cputemperatureview",
			headers: {'X-CSRF-Token': $('input[name=_csrf]').val()},
			success: function(data) {
				$("#cpu-temperature-container").html(data);
			}
		});
	}
		
};
 
$(document).ready( dashboard.init );