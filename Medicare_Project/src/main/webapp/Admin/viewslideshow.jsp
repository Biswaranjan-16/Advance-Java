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
				<h1 class="text-center text-warning bg-dark">View Slide</h1>
				<div class="card-body" id="categoryData">
					<table class="table ">
						<thead class="table-dark">
							<tr>
								<th scope="col">Id</th>
								<th scope="col">Slide Name</th>
								<th scope="col">Slide Image</th>
								<th scope="col">Action</th>
							</tr>
						</thead>
						<tbody id="slideshow">
						
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
					<h5 class="modal-title" id="exampleModalLabel">Slide</h5>
					<button type="button" class="btn-close" data-bs-dismiss="modal"	aria-label="Close"></button>
				</div>
				<div class="modal-body">
					<form id="updatecategory">
						<div class="mb-3">
							<label for="exampleFormControlInput1" class="form-label">Slide Name</label> 
								<input type="text" class="form-control" name="sname" id="slidename" value=""> 
								
								<input type="hidden" name="sid" id="slideid" value=""> 
								<input type="hidden" name="event" value="updateslide">
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
									url : '../Slideshow',
									method : 'post',
									data : {'event' : 'viewSlideshow'},  
										dataType : 'json',
										success : function(response) {
											console.log(response);
											let s = "";
											for ( var key in response) {
												if (response.hasOwnProperty(key)) {
													s += "<tr>";
													s += "<td>"+ response[key].slide_id+ "</td>";   
													s += "<td>"+ response[key].slide_name+ "</td>"; 
													s += "<td><img src='images/slide/"+response[key].slide_image+"' width='50' height='50'></td>"; 
													s += "<td><div class='d-flex align-items-center gap-3 fs-6'> ";
													s += "<a href='#' class=' editSli btn btn-primary' data-bs-toggle='modal' data-bs-target='#exampleModal' id='"+response[key].slide_id+"' >Edit</a>";  //customer_id from db
													s += " <a href='#' class=' deleteSli btn btn-danger' id='"+response[key].slide_id+"' >Delete</a>";  // customer_id from db
													s += "</td>"
													s += "</tr>";
												}
											}
											$('#slideshow').html(s);     
										},
										error : function(response, errorThrown) {
											console.log('Something went wrong on server!');
										}
									})
						})
	</script>
	
	<script type="text/javascript">
		$(document).on('click', '.deleteSli', function() {    
			Slide_id = $(this).attr('id');
			if (confirm("Are you sure you want to delete this ?")) {
				$.ajax({
					type : 'post',
					url : '../Slideshow',
					method : 'post',
					data : {'event' : 'deleteSlideshow','Slide_id' : Slide_id	},   //from servlet equal event   'Customer_id' --> from servlet line 2
					success : function(response) {
						if (response.trim() === 'done') {
							alert('Successfully Deleted !');
							window.location.href = "viewslideshow.jsp";
						} else {
							alert('Category Not Deleted !');
							window.location.href = "viewslideshow.jsp";
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
		$(document).on('click', '.editSli', function() {  
		slide_id = $(this).attr('id');
			$("#exampleModal").modal("show");  
			$.ajax({
				type : 'POST',
				url : '../Slideshow',
				method : 'post',
				data : {'event' : 'getSlideId','slide_id' : slide_id},    //getCustomerById from servlet equal method   //'customer_id' from servlet line 2
				dataType : "JSON",
				success : function(response) {
					$("#slideid").val(response[0].slide_id);    //customerid from modal hidden field id name
					$("#slidename").val(response[0].slide_name);  //customername  modal name id
					$("#slideimage").val(response[0].slide_image); //from modal mail id 
					
				},
				error : function(response, errorThrown) {
					console.log('Something went wrong on server!');
				}
			})
		})
	</script>
	
	<script>
		$(document).ready(function() {
			$('#updateslide').on('submit', function(event) {    
				event.preventDefault();
				var formData = $(this).serialize();
				$.ajax({
					type : 'POST',
					url : '../Slideshow',
					data : formData,
					success : function(response) {
						if (response.trim() == "done") {
							alert("Slide Edited Sussessfully !");
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
