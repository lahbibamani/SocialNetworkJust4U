$(document)
		.ready(
				function() {
					initialize();
					console.log(localStorage.getItem("seen")=="false")
					if(localStorage.getItem("seen")=="false"){
						$("#notif").removeClass("hidden");
						$("#details").html(localStorage.getItem("details"));
						$("#col").attr('href',localStorage.getItem("href"));
					}

					$("#group_notif").click(function(){
						$("#notif").addClass("hidden");
						localStorage.setItem("seen",true);
					});
					
					var msgs = $(".chat-messages");
					for (var i = 0; i < msgs.length; i++)
						if ($(msgs[i]).height() > 150) {
							$(msgs[i]).slimscroll({
								height : "150px",
								size : "5px",
								alwaysVisible : !0,
								railVisible : !0
							});
							msgs[i].scrollTop = msgs[i].scrollHeight;
						}

					if ($(".services").height() > 200)
						$(".services").slimscroll({
							height : "200px",
							size : "5px",
							alwaysVisible : !1,
							railVisible : !0
						});

					$(".new-message").keypress(
							function(a) {
								if (13 != a.keyCode)
									return;
								var id = $(this).parent().closest('div[id]')
										.get(0).id;

								addComment(
										$("#" + id + ".chat-messages footer"),
										$(this).val(), id);

								$(this).val("");

							});

					$(".new-message-btn")
							.click(
									function(a) {
										var id = $(this).parent().closest(
												'div[id]').get(0).id;
										addComment($("#" + id
												+ ".chat-messages footer"), $(
												"#" + id + " .new-message")
												.val(), id);
										$("#" + id + ".new-message").val("");

									});

					function addComment(el, val, id) {
						if (!val)
							return;
						if (!name) {
							var myRegexp = /(?:^|\s)name=(.*?),(?:\s|$)/g;
							var name = myRegexp.exec($("#role").val())[1];
						}
						if (!firstName) {
							myRegexp = /(?:^|\s)firstName=(.*?),(?:\s|$)/g;
							var firstName = myRegexp.exec($("#role").val())[1];
						}
						if (!img) {
							var myRegexp = /(?:^|\s)img=(.*?)(?:\s|$)/g;
							var img = myRegexp.exec($("#role").val())[1];
						}

						$(
								' <div class="chat-message"><div class="sender pull-right"><div class="icon">'
										+ '<img src="resources/img/avatars/'+img+'.png" class="img-circle" alt="">'
										+ '</div><div class="time">'
										+ "3 sec"
										+ '</div></div>'
										+ '<div class="chat-message-body on-left">'
										+ '<span class="arrow"></span><div class="sender">'
										+ '<a href="#">'
										+ name + " " + firstName
										+ '</a></div>' + '<div class="text">'
										+ val + '</div></div></div>')
								.insertBefore(el);

						if ($("#" + id).closest("div.slimScrollDiv").length == 0
								&& $("#" + id + ".chat-messages").height() > 150)
							$("#" + id + ".chat-messages").slimscroll({
								height : "150px",
								size : "5px",
								alwaysVisible : !0,
								railVisible : !0
							});
						var b = $("#" + id + ".chat-messages")[0];
						b.scrollTop = b.scrollHeight;

						$.post("addcomment.html", {
							content : val,
							userService : id
						});
					}
				});
var socket = sessionStorage.socket;
var email = null;
function initialize() {
	if (!email) {
		var myRegexp = /\w+@[\w.-]+|\{(?:\w+, *)+\w+\}@[\w.-]+/g;
		email = myRegexp.exec($("#role").val());
	}
	//if (!socket) {
		socket = new WebSocket(
				"ws://localhost:8080/presentation-layer/notifications/"
						+ email[0]);
		sessionStorage.socket = socket;
		
	//}
	//socket.send("cccccc")
	console.log("Sending email: " + email[0]);
	socket.onopen = function(evt) { socket.send("opened"); 
	$.ajax({
		"type" : "GET",
		"contentType" : "text/html;charset=utf-8",
		"url" : "notif.html",
		"success" : function(resp) {
			console.log(resp)
		}
	});
	};
	socket.onmessage = onSocketMessage;
	
}

function onSocketMessage(event) {
	//console.log(event);
	if (event.data) {
		// var receivedSticker = JSON.parse(event.data);
		console.log("Received Object: " + event.data);
		//if(event.data == "add"){
		data = event.data.split(":");
			localStorage.setItem("seen",false);
			$("#notif").removeClass("hidden");
			$("#details").html(data[0]+" voudrait collaborer avec vous");
			path = window.location.pathname.split("/");
			$("#col").attr('href',path[0]+"/"+path[1]+"/collab/"+data[1]);
			localStorage.setItem("href",path[0]+"/"+path[1]+"/collab/"+data[1]);
			localStorage.setItem("details",data[0]+" voudrait collaborer avec vous");
		
	}
}