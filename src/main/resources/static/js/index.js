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
	if(validateBook() == true) {
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
}

function validateBook() {
	var date = new Date();
	var todayFormatted = date.getFullYear() +"-"+ (date.getMonth < 9 ? "0" + date.getMonth() : (date.getMonth() + 1)) 
	+"-"+ (date.getDate <= 9 ? "0" + date.getDate() : date.getDate());
	
	if($("#checkIn").val() <= todayFormatted) {
		 setTimeout(function() {
        		$("#divError").html("Please select a date after today").addClass("error-msg");
            }, 3000);
		return false;
	} else if ($("#checkOut").val() < $("#checkIn").val()) {
		console.log("validate if checkout > checkin");
		return false;
	} /*else if ($("#checkOut").val() - $("#checkIn").val() > 3) {
		console.log("validate if number of nights is bigger than 3 days");
		return false;
	}*/
		
	return true;
}

function updateBook(id) {
	localStorage.setItem('cusName', $("#tblBook #" + id + " #cusName").text());
	localStorage.setItem('checkInDate', $("#tblBook #" + id + " #checkI").text());
	localStorage.setItem('checkOutDate', $("#tblBook #" + id + " #checkO").text());
	$( "#tblBook #" + id + " #cusName").html(`<input type="text" class="form-control" id="updateCustomerName"
	                               autofocus="autofocus" name="name" value="`+$("#tblBook #" + id + " #cusName").text()+`"/>`);
	$( "#tblBook #" + id + " #checkI").html(`<input type="date" class="form-control" id="updateCheckIn" name="checkin" value="`+$("#tblBook #" + id + " #checkI").text()+`"/>`);
   	$( "#tblBook #" + id + " #checkO").html(`<input type="date" class="form-control" id="updateCheckOut" name="checkout" value="`+$("#tblBook #" + id + " #checkO").text()+`"/>`);
   	$( "#tblBook #" + id + " #u").html(`Y`);
   	$( "#tblBook #" + id + " #c").html(`N`);	
	$( "#tblBook #" + id + " #u").removeAttr("onclick");
	$( "#tblBook #" + id + " #u").attr("onclick", "confirmUpdate("+ id +")");
	$( "#tblBook #" + id + " #c").removeAttr("onclick");
	$( "#tblBook #" + id + " #c").attr("onclick", "cancelUpdate("+ id +")");
}

function cancelBook(id) {
	$.ajax({
	  type: "DELETE",
	  url: "/bookings/" + id,
	}).done(function(){
         listBook();
	})
	.fail(function(jqXHR, textStatus, msg){
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
			    <td id="u" class="text-center" style="cursor:pointer; size:5px" onclick="updateBook(`+value.id+`)">U</td>
			    <td id="c" class="text-center" style="cursor:pointer; size:5px" onclick="cancelBook(`+value.id+`)">X</td>
		    </tr>
		  `); 
		});
	}).fail(function(jqXHR, textStatus, data){
	     
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
	})
	.fail(function(jqXHR, textStatus, msg){
	     listBook();
	});
}

function cancelUpdate(id) {
	$( "#tblBook #" + id + " #cusName").html(localStorage.getItem('cusName'));
	$( "#tblBook #" + id + " #checkI").html(localStorage.getItem('checkInDate'));
   	$( "#tblBook #" + id + " #checkO").html(localStorage.getItem('checkOutDate'));
	$( "#tblBook #" + id + " #u").html(`U`);
   	$( "#tblBook #" + id + " #c").html(`X`);	
	$( "#tblBook #" + id + " #u").removeAttr("onclick");
	$( "#tblBook #" + id + " #u").attr("onclick", "updateBook("+ id +")");
	$( "#tblBook #" + id + " #c").removeAttr("onclick");
	$( "#tblBook #" + id + " #c").attr("onclick", "cancelBook("+ id +")");
	localStorage.clear();
}

$.when(listBook()).then(function( x ) {
  
});