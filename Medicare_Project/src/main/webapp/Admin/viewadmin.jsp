<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>View Admin</title>
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
				<h1 class="text-center text-warning bg-dark">View Admin</h1>
				<div class="card-body" id="categoryData">
					<table class="table ">
						<thead class="table-dark">
							<tr>
								<th scope="col">Id</th>
								<th scope="col">Admin Name</th>
								<th scope="col">Admin Email</th>
								<th scope="col">Admin Password</th>
								<th scope="col">Admin Confirm Password</th>
								<th scope="col">Admin Phone</th>
								<th scope="col">Admin Image</th>
								<th scope="col">Action</th>
							</tr>
						</thead>
						<tbody id="admin">
						
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
					<h5 class="modal-title" id="exampleModalLabel">Admin</h5>
					<button type="button" class="btn-close" data-bs-dismiss="modal"	aria-label="Close"></button>
				</div>
				<div class="modal-body">
					<form id="updateadmin" enctype='multipart/form-data'>
						<div class="mb-3">
							<label for="exampleFormControlInput1" class="form-label">Admin Name</label> 
								<input type="text" class="form-control" name="aname" id="adminname" value=""> 
							</div>
							
							<div class="mb-3">
							<label for="exampleFormControlInput1" class="form-label">Admin Email</label> 
								<input type="text" class="form-control" name="aemail" id="adminemail" value=""> 
							</div>
							
							<div class="mb-3">
							<label for="exampleFormControlInput1" class="form-label">Admin Password</label> 
								<input type="text" class="form-control" name="apassword" id="adminpassword" value=""> 
							</div>
							
							<div class="mb-3">
							<label for="exampleFormControlInput1" class="form-label">Admin Confirm Password</label> 
								<input type="text" class="form-control" name="aconfirmpassword" id="adminconfirmpasswword" value=""> 
							</div>
							
							<div class="mb-3">
							<label for="exampleFormControlInput1" class="form-label">Admin image</label> 
							<img src="'images/slide/" data-mdb-img="" alt="Table Full of Spices" name="admin_image" id="admin_image" class="w-100" />
             				  <input type="hidden" name="old_image" id="old_image" value="OldImage">  
								<input type="file" class="form-control" name="flu_admin_image" id="flu_admin_image" value=""> 
							</div>
							
							<div class="mb-3">
							<label for="exampleFormControlInput1" class="form-label">Admin Phone</label> 
								<input type="text" class="form-control" name="aphone" id="adminphone" value=""> 
							</div>
							
							<div>
								<input type="hidden" name="aid" id="adminid" value=""> 
								<input type="hidden" name="event" value="updateadmin">
							</div>
						<div class="mb-3">
						<input type="submit" class="form-control btn btn-info" value="update">
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
									url : '../Admin',
									method : 'post',
									data : {'event' : 'viewadmin'},  
										dataType : 'json',
										success : function(response) {
											console.log(response);
											let s = "";
											for ( var key in response) {
												if (response.hasOwnProperty(key)) {
													s += "<tr>";
													s += "<td>"+ response[key].admin_id+ "</td>";   
													s += "<td>"+ response[key].admin_name+ "</td>"; 
													s += "<td>"+ response[key].admin_email+ "</td>"; 
													s += "<td>"+ response[key].admin_password+ "</td>"; 
													s += "<td>"+ response[key].admin_con_password+ "</td>"; 
													s += "<td>"+ response[key].admin_phone+ "</td>"; 
													s += "<td><img src='images/slide/"+response[key].admin_image+"' width='50' height='50'></td>"; 
													s += "<td><div class='d-flex align-items-center gap-3 fs-6'> ";
													s += "<a href='#' class=' editAdm btn btn-primary' data-bs-toggle='modal' data-bs-target='#exampleModal' id='"+response[key].admin_id+"' >Edit</a>";  //customer_id from db
													s += " <a href='#' class=' deleteAdm btn btn-danger' id='"+response[key].admin_id+"' >Delete</a>";  // customer_id from db
													s += "</td>"
													s += "</tr>";
												}
											}
											$('#admin').html(s);     
										},
										error : function(response, errorThrown) {
											console.log('Something went wrong on server!');
										}
									})
						})
	</script>
	
	<script type="text/javascript">
		$(document).on('click', '.deleteAdm', function() {    
			admin_id = $(this).attr('id');
			if (confirm("Are you sure you want to delete this ?")) {
				$.ajax({
					type : 'post',
					url : '../Admin',
					method : 'post',
					data : {'event' : 'deleteadmin','Admin_id' : admin_id	},   //from servlet equal event   'Customer_id' --> from servlet line 2
					success : function(response) {
						if (response.trim() === 'done') {
							alert('Successfully Deleted !');
							window.location.href = "viewadmin.jsp";
						} else {
							alert('Category Not Deleted !');
							window.location.href = "viewadmin.jsp";
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
		$(document).on('click', '.editAdm', function() {  
			admin_id = $(this).attr('id');
			$("#exampleModal").modal("show");  
			$.ajax({
				type : 'POST',
				url : '../Admin',
				method : 'post',
				data : {'event' : 'getAdminId','admin_id' : admin_id},    //getCustomerById from servlet equal method   //'customer_id' from servlet line 2
				dataType : "JSON",
				success : function(response) {
					$("#adminid").val(response[0].admin_id);    //customerid from modal hidden field id name
					$("#adminname").val(response[0].admin_name);  //customername  modal name id
					$("#adminemail").val(response[0].admin_email); //from modal mail id 
					$("#adminpassword").val(response[0].admin_password);
					$("#old_image").val(response[0].admin_image);
					$("#flu_admin_image").val(response[0].admin_image);
					$("#adminconfirmpasswword").val(response[0].admin_con_password);
					$("#adminphone").val(response[0].admin_phone);
					
				},
				error : function(response, errorThrown) {
					console.log('Something went wrong on server!');
				}
			})
		})
	</script>
	
	<script>
		$(document).ready(function() {
			$('#updateadmin').on('submit', function(event) {    
				event.preventDefault();
				var formData = $(this).serialize();
				$.ajax({
					method : 'POST',
					url : '../Admin',
					data : formData,
					enctype : 'multipart/form-data',
			          data : formData,
			          processData : false,
			          contentType : false,
			          cache : false,
					success : function(response) {
						if (response.trim() == "done") {
							alert("Admin Edited Sussessfully !");
							window.location.href = "viewslideshow.jsp";
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
