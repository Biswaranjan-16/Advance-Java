
<%@page import="com.biswa.util.DbConnection" %>
<%@page import="java.sql.*" %>
<!DOCTYPE html>

<html lang="en">
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>Add Slide</title>
<link
	href="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/style.min.css" rel="stylesheet" />
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
						<h3 class="font-weight-light ">Add Product</h3>
					</div>
					<div class="card-body">
						<form id="myform" enctype="multipart/form-data">
						
								
							     
							<div class=" mb-3">
								<label >Product Name</label> 
								<input type="hidden" name="event" value="addproduct">	
								<input type="text" class="form-control" id="productname" name="pname" required> 									 								
							 </div>
							 
							 <div class=" mb-3">
								<label >Custom Url</label> 
								<input type="text" class="form-control" id="customurl" name="curl" required> 									 								
							 </div>
							     
							     <div class=" mb-3">
							     <label >Product Image</label> 
									<input type="file" class="form-control" id="imageFile"  name="pimg" required> 									
							     </div>
							     
							     <div class=" mb-3">
								<label >Product Price</label> 
								<input type="text" class="form-control" id="productprice" name="pprice" required> 									 								
							 </div>
							 
							 <div class=" mb-3">
								<label >Product Discount</label> 
								<input type="text" class="form-control" id="productdiscount" name="pdiscount" required> 									 								
							 </div>
							 
							 <div class=" mb-3">
							
							<label>Manufacture</label>
								<select name="Manufacture"  class="form-control" id="" required>
                           <option><----Select----></option>
								<%
								Connection con1=DbConnection.getcon();
								String query1="select mid,mname from manufacture";
								PreparedStatement pss=con1.prepareStatement(query1);
								ResultSet rs=pss.executeQuery();
							 
									while(rs.next())
									{
									  %>
									   <option   value="<%=rs.getInt(1) %>"><%=rs.getString(2) %></option>
									  <% 
									 }
								 %>
						</select>								 								
							 </div>
							 
							 <div class=" mb-3">
							
							<label>Category</label>
								<select name="Catagory"  class="form-control" id="" required>
                           <option><----Select----> </option>
								<%
								Connection con=DbConnection.getcon();
								String query="select cid,cname from category";
								PreparedStatement ps3=con.prepareStatement(query);
									ResultSet rs2=ps3.executeQuery();  
									while(rs2.next())
									{
									  %>
									   <option   value="<%=rs2.getInt(1) %>"><%=rs2.getString(2) %></option>
									  <% 
									 }
								 %>
						</select>								 								
							 </div>
							 
							 <div class=" mb-3">
								<label >Keyword </label> 
								<input type="text" class="form-control" id="productkeyword" name="pkeyword" required> 									 								
							 </div>
							 
							 <div class=" mb-3">
								<label >Availability </label> 
								<input type="text" class="form-control" id="productavailability" name="pavailability" required> 									 								
							 </div>
							 
							 <div class=" mb-3">
								<label >Expire Date </label> 
								<input type="text" class="form-control" id="productexpire" name="pexpire" required> 									 								
							 </div>
							 
							 <div class=" mb-3">
								<label >Stock </label> 
								<input type="text" class="form-control" id="productstock" name="pstock" required> 									 								
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
                    url: '../Product',
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
