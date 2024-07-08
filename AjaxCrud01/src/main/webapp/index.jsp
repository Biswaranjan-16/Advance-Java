<html>
<head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">

</head>
<body>
	<div class="container">

		<button type="button" id="addFaculty" class="btn btn-primary mt-5"
			data-bs-toggle="modal" data-bs-target="#exampleModal">Add
			Faculty</button>

		<div class="row col-12 pt-5">
			<table class="table table-dark table-striped table-hover">
				<thead>
					<tr>
						<th scope="col">#</th>
						<th scope="col">Faculty Name</th>
						<th scope="col">Faculty Email</th>
						<th scope="col">Faculty Password</th>
						<th scope="col">Faculty Address</th>
						<th scope="col">Action</th>
					</tr>
				</thead>
				<tbody class="table-success">
					<tr>
						<th scope="row">1</th>
						<td>Mark</td>
						<td>Otto</td>
						<td>@mdo</td>
						<td>Otto</td>
						<td><a href="" class="btn btn-primary">Edit</a>&nbsp; <a
							href="" class="btn btn-danger">Delete</a></td>
					</tr>

				</tbody>
			</table>
		</div>
	</div>


	<!-- modal start -->
	<div class="modal fade" id="exampleModal" tabindex="-1"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Add Faculty</h5>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body">
					<form id="myform">
						<div class="mb-3">
							<label for="f1" class="form-label">Faculty name</label> <input
								type="text" name="fname" class="form-control" id="f1" required>
							<input type="hidden" name="event" value="addFaculty">
						</div>
						<div class="mb-3">
							<label for="f2" class="form-label">Faculty Email</label> <input
								type="email" name="femail" class="form-control" id="f2" required>
						</div>
						<div class="mb-3">
							<label for="f3" class="form-label">Faculty Password</label> <input
								type="text" name="fpass" class="form-control" id="f3" required>
						</div>
						<div class="mb-3">
							<label for="f4" class="form-label">Faculty Address</label>
							<textarea class="form-control" name="fadd" id="f4" rows="3"></textarea>
						</div>
						<div class="mb-3">
							<input type="submit" class="form-control btn btn-info"
								value="Submit">
						</div>
					</form>
				</div>

			</div>
		</div>
	</div>
	<!-- modal end -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
		crossorigin="anonymous"></script>
	<script src="https://code.jquery.com/jquery-3.7.1.min.js"
		integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo="
		crossorigin="anonymous"></script>

	<script>
  $(document).ready(function () {
	    $('#myform').on('submit', function (event) {
	        event.preventDefault(); // Prevent the form from submitting via the browser
  			var formData = $(this).serialize(); // Serialize form data

	        $.ajax({
	            type: 'POST',
	            url: 'faculty', // Replace with your servlet URL
	            data: formData,
	            success: function (response) {
	                if(response.trim()=="done"){
	                	alert("Faculty Added Sussessfully !");
	                	window.location.href="index.jsp";
	                }else{
	                	alert("Something wrong on Server!");
	                }
	            },
	            error: function (jqXHR, textStatus, errorThrown) {
	                // Handle error
	                alert('Error submitting form: ' + textStatus);
	            }
	        });
	    });
	});

  </script>
</body>
</html>
