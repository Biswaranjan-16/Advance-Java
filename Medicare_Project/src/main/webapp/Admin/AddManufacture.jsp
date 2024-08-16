<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Add Manufacture</title>
        <link href="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/style.min.css" rel="stylesheet" />
        <link href="css/styles.css" rel="stylesheet" />
        <script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>
    </head>
    <body class="sb-nav-fixed">
    <%@include file="include/header.jsp" %>
       <div id="layoutSidenav">
           <%@include file="include/sidebar.jsp" %>
            <div id="layoutSidenav_content">
            <div class=" row col-lg-8 mx-auto">
            	<div class="card shadow-lg border-0 rounded-lg mt-5">
                                    <div class="card-header"><h3 class="font-weight-light ">Add Manufacture</h3></div>
                                    <div class="card-body">
                                        <form id="mymanufacture" >
                                            <div class=" mb-3">
                                             <label><b>Manufacture Name</b></label>
                                         	   <input type="text" class="form-control" id="manufacture_name" name="mname" required>
                   								<input type="hidden" name="event" value="addmanufacture">
                                               
                                            </div>
                                            <div class="form-floating mb-3">
                                                <input class="form-control btn btn-info"  type="submit" />
                                              
                                            </div>
                                        </form>
                                    </div>
                                </div>
                            </div>
                         </div>
                      </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
        <script src="js/scripts.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js" crossorigin="anonymous"></script>
        <script src="assets/demo/chart-area-demo.js"></script>
        <script src="assets/demo/chart-bar-demo.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/umd/simple-datatables.min.js" crossorigin="anonymous"></script>
        <script src="js/datatables-simple-demo.js"></script>
   		<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
   		
<script>
  $(document).ready(function () {
	    $('#mymanufacture').on('submit', function (event) {
	        event.preventDefault();
  			var formData = $(this).serialize();
	        $.ajax({
	            type: 'POST',
	            url: '../manufacture', 
	            data: formData,
	            success: function (response) { 	
	                if(response.trim()=="done"){
	                	alert("Manufacture Added Sussessfully !");
	                	window.location.href="AddManufacture.jsp";
	                }else{
	                	alert("Something wrong on Server!");
	                }
	              },
	            error: function (jqXHR, textStatus, errorThrown) {
	               
	                alert('Error submitting form: ' + textStatus);
	            }
	        });
	    });
	});
</script>  	
  	
    </body>
</html>
