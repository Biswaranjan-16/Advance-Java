<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>View category</title>
<link href="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/style.min.css" rel="stylesheet" />
<link href="css/styles.css" rel="stylesheet" />
<script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js"	crossorigin="anonymous"></script>
</head>

<body class="sb-nav-fixed">
	<%@include file="include/header.jsp"%>
	<div id="layoutSidenav">
		<%@include file="include/sidebar.jsp"%>
		<div id="layoutSidenav_content">
			<div class="card mb-4">
				<h1 class="text-center text-warning bg-dark">View Customer</h1>
				<div class="card-body" id="categoryData">
					<table class="table ">
						<thead class="table-dark">
							<tr>
								<th scope="col">Id</th>
								<th scope="col">Name</th>
								<th scope="col">Email</th>
								<th scope="col">Address</th>
								<th scope="col">City</th>
								<th scope="col">Phone No</th>
								<th scope="col">Action</th>
							</tr>
						</thead>
						<tbody id="customer">
						
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
	
	<!-- Modal start-->
	
	<div class="modal fade" id="exampleModal" tabindex="-1"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Customer</h5>
					<button type="button" class="btn-close" data-bs-dismiss="modal"	aria-label="Close"></button>
				</div>
				<div class="modal-body">
					<form id="updatecustomer">
						<div class="mb-3">
							<label for="exampleFormControlInput1" class="form-label">Customer Name</label> 
								<input type="text" class="form-control" name="cuname" id="customername" value=""> 
								
								<label for="exampleFormControlInput1" class="form-label">Customer Email</label> 
								<input type="text" class="form-control" name="cuemail" id="customeremail" value=""> 
								
								<label for="exampleFormControlInput1" class="form-label">Customer Address</label> 
								<input type="text" class="form-control" name="cuadd" id="customeraddress" value=""> 
								
								<label for="exampleFormControlInput1" class="form-label">Customer City</label> 
								<input type="text" class="form-control" name="cucity" id="customercity" value=""> 
								
								<label for="exampleFormControlInput1" class="form-label">Customer Phone</label> 
								<input type="text" class="form-control" name="cuphone" id="customerphone" value=""> 
								
								<input type="hidden" name="cuid" id="customerid" value=""> 
								<input type="hidden" name="event" value="updatecustomer">
						</div>
						<div class="mb-3">
						<input type="submit" class="form-control btn btn-info" value="Update">
					</div>
				</form>
			</div>
		</div>
	</div>
</div>

	<!-- modal end -->

	<script	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"	integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"	crossorigin="anonymous"></script>
	<script	src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"	integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p"	crossorigin="anonymous"></script>
	<script	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"	integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF"  crossorigin="anonymous"></script>
	<script	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"	integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
	<script src="https://code.jquery.com/jquery-3.7.1.min.js"	integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
	<script	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
	<script src="js/scripts.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/umd/simple-datatables.min.js" crossorigin="anonymous"></script>
	<script src="js/datatables-simple-demo.js"></script>

	<script type="text/javascript">
		$(document)	.ready(function() {
							$.ajax({
									type : 'POST',
									url : '../Customer',
									method : 'post',
									data : {'event' : 'viewCustomer'},   // from servlet equal event
										dataType : 'json',
										success : function(response) {
											console.log(response);
											let s = "";
											for ( var key in response) {
												if (response.hasOwnProperty(key)) {
													s += "<tr>";
													s += "<td>"+ response[key].customer_id+ "</td>";   //customer_id from db
													s += "<td>"+ response[key].customer_name+ "</td>"; //from db
													s += "<td>"+ response[key].customer_email+ "</td>"; //from db
													s += "<td>"+ response[key].customer_address+ "</td>";  //from db
													s += "<td>"+ response[key].customer_city+ "</td>";  //from db
													s += "<td>"+ response[key].customer_phone+ "</td>";  //from db
													s += "<td><div class='d-flex align-items-center gap-3 fs-6'> ";
													s += "<a href='#' class=' editCus btn btn-primary' data-bs-toggle='modal' data-bs-target='#exampleModal' id='"+response[key].customer_id+"' >Edit</a>";  //customer_id from db
													s += " <a href='#' class=' deleteCus btn btn-danger' id='"+response[key].customer_id+"' >Delete</a>";  // customer_id from db
													s += "</td>"
													s += "</tr>";
												}
											}
											$('#customer').html(s);    //customer jsp tbody id
										},
										error : function(response, errorThrown) {
											console.log('Something went wrong on server!');
										}
									})
						})
	</script>

	<script type="text/javascript">
		$(document).on('click', '.deleteCus', function() {    // 'deleteCus' jsp view ajax delete class
			Customer_id = $(this).attr('id');
			if (confirm("Are you sure you want to delete this ?")) {
				$.ajax({
					type : 'post',
					url : '../Customer',
					method : 'post',
					data : {'event' : 'deleteCustomer','Customer_id' : Customer_id	},   //from servlet equal event   'Customer_id' --> from servlet line 2
					success : function(response) {
						if (response.trim() === 'done') {
							alert('Successfully Deleted !');
							window.location.href = "ViewCustomer.jsp";
						} else {
							alert('Category Not Deleted !');
							window.location.href = "ViewCustomer.jsp";
						}
					},
					error : function(response, errorThrown) {
						console.log('Something went wrong on server!');
					}
				})
			}
		})
	</script>
	<script>
		$(document).on('click', '.editCus', function() {  //'editCus'  jsp view ajax edit class
			customer_id = $(this).attr('id');
			$("#exampleModal").modal("show");   //exampleModal modal id
			$.ajax({
				type : 'POST',
				url : '../Customer',
				method : 'post',
				data : {'event' : 'getCustomerById','customer_id' : customer_id},    //getCustomerById from servlet equal method   //'customer_id' from servlet line 2
				dataType : "JSON",
				success : function(response) {
					$("#customerid").val(response[0].customer_id);    //customerid from modal hidden field id name
					$("#customername").val(response[0].customer_name);  //customername from modal name id
					$("#customeremail").val(response[0].customer_email); //from modal mail id 
					$("#customeraddress").val(response[0].customer_address); //from modal address id 
					$("#customercity").val(response[0].customer_city);  //from modal city id 
					$("#customerphone").val(response[0].customer_phone);  //from modal phone id 
				},
				error : function(response, errorThrown) {
					console.log('Something went wrong on server!');
				}
			})
		})
	</script>

	<script>
		$(document).ready(function() {
			$('#updatecustomer').on('submit', function(event) {    //updatecustomer servlet event name
				event.preventDefault();
				var formData = $(this).serialize();
				alert(formData);
				$.ajax({
					type : 'POST',
					url : '../Customer',
					data : formData,
					success : function(response) {
						if (response.trim() == "done") {
							alert("Customer Edited Sussessfully !");
							window.location.href = "ViewCustomer.jsp";
						} else {
							alert("Something wrong on Server!");
						}
					},
					error : function(jqXHR, textStatus, errorThrown) {

						alert('Error submitting form: ' + textStatus);
					}
				});
			});
		});
	</script>

</body>
</html>
