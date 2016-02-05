
	var options = {
		valueNames : [ 'serviceTitle', 'serviceDescription' ]
	};

	var userList = new List('servicesList', options);

	$(function() {
		$('#datetimepicker12').datetimepicker({
			inline : true
		});
	});
	var link = '';
	$('.demande, .offre').click(
			function(e) {
				e.preventDefault();
				e.stopPropagation();
				link = $(this).attr('href');
				$('.bs-example-modal-sm').find('.datevalue').val('');
				$('.bs-example-modal-sm').modal('show');
				if ($(this).hasClass('demande')) {
					$('.bs-example-modal-sm').find('.modal-title').html(
							'Précisez la date limite de votre demande');
				}
				if ($(this).hasClass('offre')) {
					$('.bs-example-modal-sm').find('.modal-title').html(
							'Précisez la date limite de votre offre');
				}
			});
	$('.save-assoc').click(function(event) {
		var datevalue = $('.bs-example-modal-sm').find('.datevalue').val();
		console.log(datevalue);
		if (datevalue == "" || datevalue == undefined) {
			console.log("Choisissez la date de limite pour le service");
			var timestampVal = new Date().getTime();
		} else {
			var timestampVal = new Date(datevalue).getTime();
		}
		console.log(timestampVal);
		if (timestampVal < new Date().getTime()) {
			console.log("La date est périmée");
			alert("La date est périmée. Choisissez une bonne date");
			return false;
		}
		link += '/' + timestampVal;
		console.log(link);
		$('.bs-example-modal-sm').modal('hide');
		window.location.replace(link);
	});
