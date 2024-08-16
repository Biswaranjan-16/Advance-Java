
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>
        @import url('https://fonts.googleapis.com/css?family=Open+Sans:400,700&display=swap');

/*-- VARIABLES CSS--*/
/*Colores*/
:root{
    --first-color: #E3F8FF;
    --second-color: #DCFAFB;
    --third-color: #FFE8DF;
    --accent-color: #FF5151;
    --dark-color: #161616;
}

/*Tipografia responsive*/
:root{
    --body-font: 'Open Sans';
    --h1-font-size: 1.5rem;
    --h3-font-size: 1rem;
    --normal-font-size: 0.938rem;
    --smaller-font-size: 0.75rem;
}
@media screen and (min-width: 768px){
    :root{
        --h1-font-size: 2rem;
        --normal-font-size: 1rem;
        --smaller-font-size: 0.813rem;
    }
}

/*-- BASE --*/
*,::after,::before{
    box-sizing: border-box;
}
body{
    margin: 2rem 0 0 0;
    background-color: #fff;
    color: var(--dark-color);
    font-family: var(--body-font);
}
h1{
    font-size: var(--h1-font-size);
}
img{
    max-width: 100%;
    height: auto;
}
a{
    text-decoration: none;
}

/*-- LAYAOUT --*/
.main {
    padding: 2rem 0;
}
.bd-grid{
    display: grid;
    grid-template-columns: repeat(auto-fit, minmax(220px, 1fr));
    max-width: 1200px;
    margin-left: 2.5rem;
    margin-right: 2.5rem;
    align-items: center;
    gap: 2rem;
}

/*-- PAGES --*/
.title-shop{
    position: relative;
    margin: 0 2.5rem;
}
.title-shop::after{
    content: '';
    position: absolute;
    top: 50%;
    width: 72px;
    height: 2px;
    background-color: var(--dark-color);
    margin-left: .25rem;
}

/*-- COMPONENT --*/
.card{
    position: relative;
    display: flex;
    flex-direction: column;
    align-items: center;
    padding: 1.5rem 2rem;
    border-radius: 1rem;
    overflow: hidden;
}
article:nth-child(1){
    background-color: var(--first-color);
}
article:nth-child(2){
    background-color: var(--second-color);
}
article:nth-child(3){
    background-color: var(--third-color);
}
article:nth-child(4){
    background-color: var(--second-color);
}
.card__img{
    width: 180px;
    height: auto;
    padding: 3rem 0;
    transition: .5s;
}
.card__name{
    position: absolute;
    left: -25%;
    top: 0;
    width: 3.5rem;
    height: 100%;
    writing-mode: vertical-rl;
    transform: rotate(180deg);
    text-align: center;
    background-color: var(--dark-color);
    color: #fff;
    font-weight: bold;
    transition: .5s;
}
.card__icon{
    font-size: 1.5rem;
    color: var(--dark-color);
}
.card__icon:hover{
    color: var(--accent-color);
}
.card__precis{
    width: 100%;
    display: flex;
    justify-content: space-between;
    align-items: flex-end;
    transition: .5s;
}
.card__preci{
    display: block;
    text-align: center;
}
.card__preci--before{
    font-size: var(--smaller-font-size);
    color: var(--accent-color);
    margin-bottom: .25rem;
}
.card__preci--now{
    font-size: var(--h3-font-size);
    font-weight: bold;
}
/*Move left*/
.card:hover{
    box-shadow: 0 .5rem 1rem #D1D9E6;
}
.card:hover .card__name{
    left: 0;
}
.card:hover .card__img{
    transform: rotate(30deg);
    margin-left: 3.5rem;
}
.card:hover .card__precis{
    margin-left: 3.5rem;
    padding: 0 1.5rem;
}

/*-- FOOTER --*/

footer{
  text-align: center;
}

/*-- MEDIA QUERIES --*/
@media screen and (min-width: 1200px){
    body{
        margin: 3rem 0 0 0;
    }
    .title-shop{
        margin: 0 5rem;
    }
    .bd-grid{
        margin-left: auto;
        margin-right: auto;
    }
}
    </style>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>

<%-- <%@include file="Admin/include/header.jsp"%>
	<div id="layoutSidenav">
		<%@include file="Admin/include/sidebar.jsp"%> --%>
		
    <h1 class="title-shop">MEDICARE</h1>
    <main class="main bd-grid" id="viewproduct"></main>
    
     <div>
     
     <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
       
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <form id="cartform" >
        <div class="row">
        <div class="col-sm">
         <div id="productimage">
         <label for="exampleFormControlInput1" class="form-label"> Image</label> 
          <img src="'images/slide/" data-mdb-img="" alt="Table Full of Spices" name="admin_image" id="admin_image" class="w-100" />
           <input type="hidden" name="old_image" id="old_image" value="OldImage">  
         
         </div>
        <div class="col-sm">
         <div class="product-container">
        <label for="exampleFormControlInput1" class="form-label"> Product Price</label> 
        <input type="hidden" name="unitprice" id="unitprice" value=""> 
        
        <p id="pprice"></p>
        <label for="exampleFormControlInput1" class="form-label"> Product Name</label>
        <input type="text" class="form-control" name="pname" id="productname" value="">
        <div>
		<input type="hidden" name="pid" id="productid"> 
	  	<input type="hidden" name="event" value="addtocart">
		</div>
		
          <div class="product-quantity">
              <input type="number" name="productquantity" id="productquantity"class="quantity-input" min="1" max="10" value="1">
          </div>
          
      </div>
        </div>
        </div>
        </div>
        <div class="modal-footer">
        <input type="submit" value="add to cart" class="btn btn-primary">
    
      </div>
        </form>
      </div>
     
    </div>
  </div>
</div>
     </div>
    <!-- ICONS -->
    <script src="https://unpkg.com/ionicons@5.0.0/dist/ionicons.js"></script>
    <script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
   <script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
  
   <script>
  $(document).ready(function () {
	    $('#cartform').on('submit', function (event) {
	        event.preventDefault(); 
  			var formData = $(this).serialize(); 
	        $.ajax({
	            type: 'POST',
	            url: 'cartservlet', 
	            data: formData,
	            success: function (response) {	            	
	                if(response.trim()=="done"){
	                	alert("Product Added Sussessfully !");
	                	window.location.href="cart.jsp";
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
   
    <script type="text/javascript">
		$(document)	.ready(function() {
			
							$.ajax({
									type : 'POST',
									url : 'Product',
									method : 'post',
									data : {'event' : 'viewproduct'},  
										dataType : 'json',
										success : function(response) {
											console.log(response);
											let s = "";
											for ( var key in response) {
												if (response.hasOwnProperty(key)) {
													console.log(key);
													
													s+="<div class='card' style='width: 18rem;'>";
													s+="<img src='Admin/images/product/"+response[key].product_img+"' class='card-img-top' alt='...''>";
													s+="<div class='card-body'>";
													s+="<h5 class='card-title'>"+ response[key].product_name+ "</h5>";
													s+="<p class='card-text'>$"+ response[key].product_price+ "</p>";
													s+="<p class='card-text'>$"+ response[key].product_discount+ "</p>";
													s+="<a href='#' class='btn btn-primary cart'id='"+response[key].product_id+"'>Buy Now</a>";
													s+="</div>";
													s+="</div>";
														
													
												}
													
											}
											$('#viewproduct').html(s);     
										},
										error : function(response, errorThrown) {
											console.log('Something went wrong on server!');
										}
									})
						})
	</script>
	
	
	<script>
		$(document).on('click', '.cart', function() {  
			
			product_id = $(this).attr('id');
			
			$("#exampleModal").modal("show"); 
			
			$.ajax({
				type : 'POST',
				url : 'Product',
				method : 'post',
				data : {'event' : 'getProductId','product_id' : product_id},   
				dataType : "JSON",
				success : function(response) {
				$("#productid").val(response[0].product_id);
				$("#productprice").val(response[0].product_price);
				$("#pprice").html("<strong>"+response[0].product_price+"</strong>");
				$("#productname").val(response[0].product_name);
			    $("#admin_image").attr('src' ,'Admin/images/product/'+response[0].product_img);
			    $("#unitprice").val(response[0].product_price);
					str=response[0].product_price;
					var num = parseInt(str,10); 
					
							
				},
				error : function(response, errorThrown) {
					console.log('Something went wrong on server!');
				}
			})
		})
	</script>
	
	<script>
	$(document).ready(function() { 	
		$("#productquantity").change(function(){
			const price=$('#unitprice').val();
			$('#pprice').html(($(this).val()*price)); 
		} );
		
	});
	</script>
	

	
</body>

</html>