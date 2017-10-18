var dashboard = {
	
	init: function() {
		setInterval( dashboard.readTemperature, 5000 );
		setInterval( dashboard.readUptime, 5000 );
	},
		
	readTemperature: function() {
		$.ajax({
			method: "POST",
			url: "/RaspberryDashboard/cputemperatureview",
			headers: {'X-CSRF-Token': $('input[name=_csrf]').val()},
			success: function(data) {
				$("#cpu-temperature-container").html(data);
			}
		});
	},
		
	readUptime: function() {
		$.ajax({
			method: "POST",
			url: "/RaspberryDashboard/uptimeview",
			headers: {'X-CSRF-Token': $('input[name=_csrf]').val()},
			success: function(data) {
				$("#uptime-container").html(data);
			}
		});
	}
		
};
 
$(document).ready( dashboard.init );