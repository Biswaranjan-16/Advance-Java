
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<div class="row">
			<table class="table">
				<thead>
					<tr>
						<th scope="col">Cart Id</th>
						<th scope="col">Product Image</th>
						<th scope="col">Product Name</th>
						<th scope="col">Cart Quantity</th>
						<th scope="col">Unit Price</th>
						<th scope="col">Total Amount</th>
						<th scope="col">Action</th>
					</tr>
				</thead>
				<tbody id="viewcart">
					
					
				</tbody>
			</table>

		</div>
	</div>
	<!-- ICONS -->
	<script src="https://unpkg.com/ionicons@5.0.0/dist/ionicons.js"></script>
	<script src="https://code.jquery.com/jquery-3.7.1.min.js"
		integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo="
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
		crossorigin="anonymous"></script>
	<script src="https://code.jquery.com/jquery-3.7.1.min.js"
		integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo="
		crossorigin="anonymous"></script>


<script type="text/javascript">
		$(document)	.ready(function() {
			
							$.ajax({
									type : 'POST',
									url : 'cartservlet',
									method : 'post',
									data : {'event' : 'viewcart'},  
										dataType : 'json',
										success : function(response) {
											console.log(response);
											let s = "";
											let v=1;
											for ( var key in response) {
												if (response.hasOwnProperty(key)) {
												
													s += "<tr>";
													s += "<td>"+v+ "</td>";   
													 
													s += "<td><img src='Admin/images/product/"+response[key].product_image+"' width='50' height='50'></td>"; 
													s += "<td>"+ response[key].product_name+ "</td>";
													s += "<td>"+ response[key].cart_qty+ "</td>";
													s += "<td>"+response[key].untprice+ "</td>";
													s += "<td>"+ response[key].total_amount+ "</td>";
													
													s += " <td><a href='#' class=' deletecart btn btn-danger' id='"+response[key].product_id+"' >Delete</a>";  
													s += "</td>"
													s += "</tr>";
													v++;
												}
													
											}
											$('#viewcart').html(s);     
										},
										error : function(response, errorThrown) {
											console.log('Something went wrong on server!');
										}
									})
						})
	</script>

<script type="text/javascript">
		$(document).on('click', '.deletecart', function() {    
			product_id = $(this).attr('id');
			if (confirm("Are you sure you want to delete this ?")) {
				$.ajax({
					type : 'post',
					url : 'cartservlet',
					method : 'post',
					data : {'event' : 'deletefromcart','product_id' : product_id	},
					success : function(response, errorThrown) {
						if (response.trim() === 'done') {
							alert('Successfully Deleted !');
							window.location.href = "cart.jsp";
						} else {
							alert('Product Not Deleted !');
							window.location.href = "cart.jsp";
						}
					},
					error : function(response, errorThrown) {
						console.log('Something went wrong on server!');
					}
				});
			}
		});
	</script>  
	
</body>

</html>