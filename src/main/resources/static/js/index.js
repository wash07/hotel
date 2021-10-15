function book() {
console.log("entrou");
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
			console.log("entrou2");
		}).fail(function()  {
		    
		}); ;	
}

function updateBook(id) {
	localStorage.setItem('cusName', $("#tblBook #" + id + " #cusName").text());
	localStorage.setItem('checkInDate', $("#tblBook #" + id + " #checkI").text());
	localStorage.setItem('checkOutDate', $("#tblBook #" + id + " #checkO").text());
	$( "#tblBook #" + id + " #cusName").html(`<input type="text" class="form-control" id="updateCustomerName"
	                               autofocus="autofocus" name="name" value="`+$("#tblBook #" + id + " #cusName").text()+`"/>`);
	$( "#tblBook #" + id + " #checkI").html(`<input type="date" class="form-control" id="updateCheckIn" name="checkin" value="`+$("#tblBook #" + id + " #checkI").text()+`"/>`);
   	$( "#tblBook #" + id + " #checkO").html(`<input type="date" class="form-control" id="updateCheckOut" name="checkout" value="`+$("#tblBook #" + id + " #checkO").text()+`"/>`);
   	$( "#tblBook #" + id + " #update").html(`<i class="fas fa-check"></i>`);
   	$( "#tblBook #" + id + " #cancel").html(`<i class="fas fa-times"></i>`);	
	$( "#tblBook #" + id + " #update").removeAttr("onclick");
	$( "#tblBook #" + id + " #update").attr("onclick", "confirmUpdate("+ id +")");
	$( "#tblBook #" + id + " #cancel").removeAttr("onclick");
	$( "#tblBook #" + id + " #cancel").attr("onclick", "cancelUpdate("+ id +")");
}

function cancelBook(id) {
	$.ajax({
	  type: "DELETE",
	  url: "/bookings/" + id,
	}).done(function(){
         listBook();
	});
}

function listBook() {
	$.ajax({
	  type: "GET",
	  url: "/bookings",
	}).done(function(data){
		$("#tblBook tr").remove();
		$.each(data, function(index, value) {
		  $("#tblBook").append(`
			 <tr id=`+value.id+`>
			    <td id="cusName">`+value.customerName+`</td>
			    <td id="checkI">`+value.checkIn+`</td>
			    <td id="checkO">`+value.checkOut+`</td>
			    <td id="update" class="text-center" style="cursor:pointer; size:5px" onclick="updateBook(`+value.id+`)"></td>
			    <td id="cancel" class="text-center" style="cursor:pointer; size:5px" onclick="cancelBook(`+value.id+`)"></td>
		    </tr>
		  `); 
		   $('#update').html(`<i class="fas fa-pen"></i>`);
		   $('#cancel').html(`<i class="fas fa-times"></i>`);
		});
	});
}

function confirmUpdate(id) {
	var booking = {}
    booking["customerName"] = $("#tblBook #" + id + " #cusName #updateCustomerName").val();
    booking["checkIn"] = $("#tblBook #" + id + " #checkI #updateCheckIn").val();
    booking["checkOut"] = $("#tblBook #" + id + " #checkO #updateCheckOut").val();
 
	$.ajax({
	  type: "PUT",
	  contentType: "application/json",
	  url: "/bookings/" + id,
	  data: JSON.stringify(booking),
	  dataType: 'json',
	}).done(function(){
         listBook();
	});
}

function cancelUpdate(id) {
	$( "#tblBook #" + id + " #cusName").html(localStorage.getItem('cusName'));
	$( "#tblBook #" + id + " #checkI").html(localStorage.getItem('checkInDate'));
   	$( "#tblBook #" + id + " #checkO").html(localStorage.getItem('checkOutDate'));
	$( "#tblBook #" + id + " #update").html(`<i class="fas fa-pen"></i>`);
   	$( "#tblBook #" + id + " #cancel").html(`<i class="fas fa-times"></i>`);	
	$( "#tblBook #" + id + " #update").removeAttr("onclick");
	$( "#tblBook #" + id + " #update").attr("onclick", "updateBook("+ id +")");
	$( "#tblBook #" + id + " #cancel").removeAttr("onclick");
	$( "#tblBook #" + id + " #cancel").attr("onclick", "cancelBook("+ id +")");
	localStorage.clear();
}

$.when(listBook()).then(function( ) {
	listBook();
});