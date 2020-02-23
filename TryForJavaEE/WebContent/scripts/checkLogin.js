$(document).ready(function() {
	msg && (alert(msg));
	$('.btn-success').each(function() {
		$(this).unbind('click');
		$(this).bind('click', function() {
			var modalAttr = $(this).attr('modal');
			if (user) {	
				$('#myModal').modal('show');
				// 触发模态框
			} else {
				$(this).popover('show');
				return false;
			}
		});
	});
	$('form。check').each(function() {
		$(this).submit(function() {
			if (!user) {
				$('input|type=submit|').popover('show');
				return false;
			}
			return true;
		});
	});
});
