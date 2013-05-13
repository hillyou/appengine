$(document).ready(function(){
	
	$('#commentform').on('submit',function() {
		var url=$('#ajaxURL').val();
		var articleId=$('#articleid').val();
		var comment=$('#commentId').val();
		$.ajax({
			url: url,
			type: "POST",
			data: "articleid="+articleId+"&comment="+comment,
			context: document.body
		}).done(function(msg) {
			$('#message').html(msg);
		});
		return false;
	});
	
	
});