$(document)
		.ready(
				function() {
					
					// Custom autocomplete instance.
					$
							.widget(
									"app.autocomplete",
									$.ui.autocomplete,
									{

										// Which class get's applied to matched
										// text in the menu items.
										options : {
											highlightClass : "ui-state-highlight"
										},

										_renderItem : function(ul, item) {

											// Replace the matched text with a
											// custom span. This
											// span uses the class found in the
											// "highlightClass" option.
											var re = new RegExp("(" + this.term
													+ ")", "gi"), cls = this.options.highlightClass, template = "<span class='"
													+ cls + "'>$1</span>", label = item.label
													.replace(re, template), $li = $(
													"<li/>").appendTo(ul);

											// Create and return the custom menu
											// item content.
											$("<a/>").attr("href", "#").html(
													label).appendTo($li);

											return $li;

										}

									});

				});

var data;
$("#search").keypress(function() {
	if (!data)
		$.ajax({
			"type" : "GET",
			"contentType" : "text/html;charset=utf-8",
			"url" : "services.html",
			"success" : function(resp) {
				data = resp.substr(1, resp.length - 2).split(",")
				$("#search").autocomplete({
					highlightClass : "bold-text",
					minLength : 2,
					source : data
				});
			}
		});
});

$("#categorie").keypress(function() {
	if (!data)
		$.ajax({
			"type" : "GET",
			"contentType" : "text/html;charset=utf-8",
			"url" : "categories.html",
			"success" : function(resp) {
				data = resp.substr(1, resp.length - 2).split(",");
				$("#categorie").autocomplete({
					highlightClass : "bold-text",
					minLength : 1,
					source : data
				});
			}
		});
});
