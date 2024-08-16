<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>Add Admin</title>
<link	href="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/style.min.css" rel="stylesheet" />
<link href="css/styles.css" rel="stylesheet" />
<script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>
</head>
<body class="sb-nav-fixed">
	<%@include file="include/header.jsp"%>
	<div id="layoutSidenav">
		<%@include file="include/sidebar.jsp"%>
		<div id="layoutSidenav_content">
			<div class=" row col-lg-8 mx-auto">
				<div class="card shadow-lg border-0 rounded-lg mt-5">
					<div class="card-header">
						<h3 class="font-weight-light ">Add Admin</h3>
					</div>
					<div class="card-body">
						<form id="myform" enctype="multipart/form-data">
						
							<div class=" mb-3">
							<label >Admin Name</label> 
									<input type="text" class="form-control" id="admin_name" name="aname" required> 									 								
							     </div>
							     
							     <div class=" mb-3">
									<label >Admin Email</label> 
								<input type="text" class="form-control" id="admin_email" name="aemail" required> 									 								
							     </div>
							     
							     <div class=" mb-3">
									<label >Admin Password</label> 
								<input type="text" class="form-control" id="admin_password" name="apassword" required> 									 								
							     </div>
							     
							     <div class=" mb-3">
									<label >Admin Confirm Password</label> 
								<input type="text" class="form-control" id="admin_confirm_password" name="aconfirmpassword" required> 									 								
							     </div>
							     
							     <div class=" mb-3">
									<label >Admin Phone</label> 
								<input type="text" class="form-control" id="admin_phone" name="aphone" required> 									 								
							     </div>
							     
							     <div class=" mb-3">
							    	 <label >Admin Image</label> 
									<input type="file" class="form-control" id="admin_img"  name="aimg" required> 
									<input type="hidden" name="event" value="addadmin">	
							     </div>
							     
						       	<div class="form-floating mb-3">
								<input class="form-control btn btn-info" type="submit" />
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
	<script src="js/scripts.js"></script>
	<script	src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js" crossorigin="anonymous"></script>
	<script src="assets/demo/chart-area-demo.js"></script>
	<script src="assets/demo/chart-bar-demo.js"></script>
	<script	src="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/umd/simple-datatables.min.js" crossorigin="anonymous"></script>
	<script src="js/datatables-simple-demo.js"></script>
	<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>

 <script>
        $(document).ready(function() {
            $('#myform').on('submit', function(event) {
            	event.preventDefault();
				var f=new FormData($(this)[0]);

                $.ajax({
                    url: '../Admin',
                    type: 'POST',
                    data: f,
                    contentType: false,
                    processData: false,
                    success: function(response) {
                        alert('Image uploaded successfully!');
                    },
                    error: function(xhr, status, error) {
                        alert('Error uploading image: ' + error);
                    }
                });
            });
        });
    </script>

</body>
</html>
