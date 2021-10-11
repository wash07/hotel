$("#updatebtn").on("click", function() {
	$.ajax({
	  method: "PUT",
	  url: "/booking/" + $("#id").val(),
	  data: { customerName: $("#customerName").val(), checkIn: $("#checkIn").val(), checkOut: $("#checkOut").val() }
	});
});

$("#cancelbtn").on("click", function() {
	$.ajax({
	  method: "DELETE",
	  url: "/booking/" + $("#id").val(),
	});
});

function book() {
	var booking = {}
    booking["customerName"] = $("#customerName").val();
    booking["checkIn"] = $("#checkIn").val();
    booking["checkOut"] = $("#checkOut").val();
 
	$.ajax({
	  type: "POST",
	  contentType: "application/json",
	  url: "/bookings",
	  data: JSON.stringify(booking),
	  dataType: 'json',
	}).done(function(){
         listBook();
	})
	.fail(function(jqXHR, textStatus, msg){
	     listBook();
	});
}

function updateBook() {
	var booking = {}
    booking["customerName"] = $("#customerName").val();
    booking["checkIn"] = $("#checkIn").val();
    booking["checkOut"] = $("#checkOut").val();
 
	$.ajax({
	  type: "PUT",
	  contentType: "application/json",
	  url: "/bookings/" + $this.attr("name"),
	  data: JSON.stringify(booking),
	  dataType: 'json',
	}).done(function(){
         listBook();
	})
	.fail(function(jqXHR, textStatus, msg){
	     listBook();
	});
}

function cancelBook() {
	$.ajax({
	  type: "DELETE",
	  url: "/bookings/1",
	});
}

function listBook() {
	$.ajax({
	  type: "GET",
	  url: "/bookings",
	}).done(function(data){
		$.each(data, function(index, value) {
		  $("#tblBook").append(`
			 <tr>
			    <td>`+value.customerName+`</td>
			    <td>`+value.checkIn+`</td>
			    <td>`+value.checkOut+`</td>
			    <td class="text-center"><i class="fa fa-pen"></i></td>
		    </tr>
		  `);
		  console.log(value.customerName);    
		});
	}).fail(function(jqXHR, textStatus, data){
	     
	});
}

$.when(listBook()).then(function( x ) {
  
});