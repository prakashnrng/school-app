
$(document).ready(function(){
$("[data-toggle=popover1]").popover({
	
		title:"CoreJava",
	    html: true, 
		content: function() {
	          return $('#popover-content').html();
	        }
	});
});


$(document).ready(function(){
    
    $('.btn-default').popover({title: "CoreJava", content: "JavaBasic", placement: "right"}); 
});  