$(function() {
	$("#sous01").keyup(function() {
		var word = $("#sous01").val();
		var div01 = $("#div01");

		if (word == "") {
			div01.hide();
		} else {
			$.post("wordServlet", {
				word : word
			}, function(data) {

				if (data.indexOf("<tr") < 0) {
					 div01.hide();
				} else {
					div01.show();
					div01.html(data);
				}
			})
		}

	})

});