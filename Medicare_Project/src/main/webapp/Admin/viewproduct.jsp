<%@page import="com.biswa.util.DbConnection" %>
<%@page import="java.sql.*" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>View Product</title>
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
				<h1 class="text-center text-warning bg-dark">View Product</h1>
				<div class="card-body" id="categoryData">
					<table class="table ">
						<thead class="table-dark">
							<tr>
								<th scope="col">Id</th>
								<th scope="col">Date</th>
								<th scope="col">Name</th>
								<th scope="col">Custom Url</th>
								<th scope="col">Image</th>
								<th scope="col">Price</th>
								<th scope="col">Discount</th>
								<th scope="col">Keyword</th>
								<th scope="col">Availability</th>
								<th scope="col">Expire date</th>
								<th scope="col">Stock</th>
								<th scope="col">Category</th>
								<th scope="col">Manufacture</th>
								<th scope="col">Action</th>
							</tr>
						</thead>
						<tbody id="product">
						
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
					<h5 class="modal-title" id="exampleModalLabel">Product</h5>
					<button type="button" class="btn-close" data-bs-dismiss="modal"	aria-label="Close"></button>
				</div>
				<div class="modal-body">
					<form id="updateproduct">
						<div class="mb-3">
							<label for="exampleFormControlInput1" class="form-label">Date</label> 
								<input type="text" class="form-control" name="pdate" id="productdate" value=""> 
							</div>
							
							<div class="mb-3">
							<label for="exampleFormControlInput1" class="form-label">Name</label> 
								<input type="text" class="form-control" name="pname" id="productname" value=""> 
							</div>
							
							<div class="mb-3">
							<label for="exampleFormControlInput1" class="form-label">Custom Url</label> 
								<input type="text" class="form-control" name="pcustom" id="productcustom" value=""> 
							</div>
							
							<div class="mb-3">
							<label for="exampleFormControlInput1" class="form-label">Price</label> 
								<input type="text" class="form-control" name="pprice" id="productprice" value=""> 
							</div>
							
							<div class="mb-3">
							<label for="exampleFormControlInput1" class="form-label">Discount</label> 
								<input type="text" class="form-control" name="pdiscount" id="productdiscount" value=""> 
							</div>
							
							<div class="mb-3">
							<label for="exampleFormControlInput1" class="form-label">Keyword</label> 
								<input type="text" class="form-control" name="pkeyword" id="productkeyword" value=""> 
							</div>
							
							<div class="mb-3">
							<label for="exampleFormControlInput1" class="form-label">Availability</label> 
								<input type="text" class="form-control" name="pavailable" id="productavailable" value=""> 
							</div>
							
							<div class="mb-3">
							<label for="exampleFormControlInput1" class="form-label">Expire date</label> 
								<input type="text" class="form-control" name="pexpire" id="productexpire" value=""> 
							</div>
							
							<div class="mb-3">
							<label for="exampleFormControlInput1" class="form-label">Stock</label> 
								<input type="text" class="form-control" name="pstock" id="productstock" value=""> 
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
							 </div>s
							
							
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
							
							<div>
								<input type="hidden" name="pid" id="productid" value=""> 
								<input type="hidden" name="event" value="updateproduct">
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
									url : '../Product',
									method : 'post',
									data : {'event' : 'viewproduct'},  
										dataType : 'json',
										success : function(response) {
											console.log(response);
											let s = "";
											for ( var key in response) {
												if (response.hasOwnProperty(key)) {
													console.log(key);
													s += "<tr>";
													s += "<td>"+ response[key].product_id+ "</td>";   
													s += "<td>"+ response[key].date+ "</td>"; 
													s += "<td>"+ response[key].product_name+ "</td>"; 
													s += "<td>"+ response[key].custom_url+ "</td>"; 
													s += "<td><img src='images/product/"+response[key].product_img+"' width='50' height='50'></td>"; 
													s += "<td>"+ response[key].product_price+ "</td>";
													s += "<td>"+ response[key].product_discount+ "</td>";
													s += "<td>"+response[key].keyword+ "</td>";
													s += "<td>"+ response[key].availability+ "</td>";
													s += "<td>"+ response[key].expire_date+ "</td>";
													s += "<td>"+ response[key].stock+ "</td>";
													s += "<td>"+response[key].cname+"</td>";
													s += "<td>"+ response[key].mname+ "</td>";												
													s += "<td><div class='d-flex align-items-center gap-3 fs-6'> ";
													s += "<a href='#' class=' editpro btn btn-primary' sid='"+response[key].product_id+"' >Edit</a>";  
													s += " <a href='#' class=' deletepro btn btn-danger' id='"+response[key].product_id+"' >Delete</a>";  
													s += "</td>"
													s += "</tr>";
												}
													
											}
											$('#product').html(s);     
										},
										error : function(response, errorThrown) {
											console.log('Something went wrong on server!');
										}
									})
						})
	</script>
	
	 <script type="text/javascript">
		$(document).on('click', '.deletepro', function() {    
			product_id = $(this).attr('id');
			if (confirm("Are you sure you want to delete this ?")) {
				$.ajax({
					type : 'post',
					url : '../Product',
					method : 'post',
					data : {'event' : 'deleteproduct','product_id' : product_id	},   
					error : function(response, errorThrown) {
						if (response.trim() === 'done') {
							alert('Successfully Deleted !');
							window.location.href = "viewproduct.jsp";
						} else {
							alert('Category Not Deleted !');
							window.location.href = "viewproduct.jsp";
						}
					},
					error : function(response, errorThrown) {
						console.log('Something went wrong on server!');
					}
				});
			}
		});
	</script>  
	
	<script>
		$(document).on('click', '.editpro', function() {  
			product_id = $(this).attr('id');
			$("#exampleModal").modal("show");  
			$.ajax({
				type : 'POST',
				url : '../Product',
				method : 'post',
				data : {'event' : 'getProductId','product_id' : product_id},   
				dataType : "JSON",
				success : function(response) {
					
					$("#productid").val(response[0].product_id);    
					$("#productdate").val(response[0].date); 
					$("#productname").val(response[0].product_name);  
					$("#productcustom").val(response[0].custom_url);
					$("#productprice").val(response[0].product_price);
					$("#productdiscount").val(response[0].product_discount);
					$("#productkeyword").val(response[0].keyword);
					$("#productavailable").val(response[0].availability);
					$("#productexpire").val(response[0].expire_date);
					$("#productstock").val(response[0].stock);
					$("#category").val(response[0].cname);
					$("#manufacture").val(response[0].mname);
					
				},
				error : function(response, errorThrown) {
					console.log('Something went wrong on server!');
				}
			})
		})
	</script>
	
	<script>
		$(document).ready(function() {
			$('#updateproduct').on('submit', function(event) {    
				event.preventDefault();
				var formData = $(this).serialize();
				$.ajax({
					method : 'POST',
					url : '../Product',
					data : formData,
					success : function(response) {
						if (response.trim() == "done") {
							alert("Admin Edited Sussessfully !");
							window.location.href = "viewproduct.jsp";
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
