$(document).ready(function(){
	$.get( "/booking/list", function() {
  		alert( "Data Loaded: " );
	});
});

$("#bookingbtn").on("click", function() {
	$.post( "/booking/", function() {
  		alert( "Data Loaded: " );
	});
});

$("#updatebtn").on("click", function() {
	$.put( "/booking/", function() {
  		alert( "Data Loaded: " );
	});
});

$("#cancelbtn").on("click", function() {
	$.delete( "/booking/", function() {
  		alert( "Data Loaded: " );
	});
});