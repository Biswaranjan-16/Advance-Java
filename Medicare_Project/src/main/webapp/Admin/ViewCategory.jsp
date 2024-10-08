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
				<h1 class="text-center text-warning bg-dark">View Category</h1>
				<div class="card-body" id="categoryData">
					<table class="table ">
						<thead class="table-dark">
							<tr>
								<th scope="col">Category Id</th>
								<th scope="col">Category Name</th>
								<th scope="col">Action</th>
							</tr>
						</thead>
						<tbody id="category">
						
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
					<h5 class="modal-title" id="exampleModalLabel">Category</h5>
					<button type="button" class="btn-close" data-bs-dismiss="modal"	aria-label="Close"></button>
				</div>
				<div class="modal-body">
					<form id="updatecategory">
						<div class="mb-3">
							<label for="exampleFormControlInput1" class="form-label">CategoryName</label> 
								<input type="text" class="form-control" name="cname" id="categoryname" value=""> 
								<input type="hidden" name="categoryid" id="categoryid" value=""> 
								<input type="hidden" name="event" value="updatecategory">
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
									url : '../category',
									method : 'post',
									data : {'event' : 'viewCategory'},
										dataType : 'json',
										success : function(response) {
											console.log(response);
											let s = "";
											for ( var key in response) {
												if (response.hasOwnProperty(key)) {
													s += "<tr>";
													s += "<td>"+ response[key].cid+ "</td>";
													s += "<td>"+ response[key].cname+ "</td>";
													s += "<td><div class='d-flex align-items-center gap-3 fs-6'> ";
													s += "<a href='#' class=' editCategory btn btn-primary' data-bs-toggle='modal' data-bs-target='#exampleModal' id='"+response[key].cid+"' >Edit</a>";
													s += " <a href='#' class=' deleteCat btn btn-danger' id='"+response[key].cid+"' >Delete</a>";
													s += "</td>"
													s += "</tr>";
												}
											}
											$('#category').html(s);
										},
										error : function(response, errorThrown) {
											console	.log('Something went wrong on server!');
										}
									})
						})
	</script>

	<script type="text/javascript">
		$(document).on('click', '.deleteCat', function() {
			cid = $(this).attr('id');
			if (confirm("Are you sure you want to delete this ?")) {
				$.ajax({
					type : 'post',
					url : '../category',
					method : 'post',
					data : {'event' : 'deleteCategory','cid' : cid	},
					success : function(response) {
						if (response.trim() === 'done') {
							alert('Successfully Deleted !');
							window.location.href = "ViewCategory.jsp";
						} else {
							alert('Category Not Deleted !');
							window.location.href = "ViewCategory.jsp";
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
		$(document).on('click', '.editCategory', function() {
			cid = $(this).attr('id');
			$("#exampleModal").modal("show");
			$.ajax({
				type : 'POST',
				url : '../category',
				method : 'post',
				data : {'event' : 'getCategoryById','cid' : cid},
				dataType : "JSON",
				success : function(response) {
					$("#categoryid").val(response[0].cid);
					$("#categoryname").val(response[0].cname);
				},
				error : function(response, errorThrown) {
					console.log('Something went wrong on server!');
				}
			})
		})
	</script>

	<script>
		$(document).ready(function() {
			$('#updatecategory').on('submit', function(event) {
				event.preventDefault();
				var formData = $(this).serialize();
				$.ajax({
					type : 'POST',
					url : '../category',
					data : formData,
					success : function(response) {
						if (response.trim() == "done") {
							alert("Category Updated Sussessfully !");
							window.location.href = "ViewCategory.jsp";
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
