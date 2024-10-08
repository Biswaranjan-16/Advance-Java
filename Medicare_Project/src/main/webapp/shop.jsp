<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Product Layout</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <style>
        body {
            font-family: Arial, sans-serif;
        }
        .product-container {
            border: 2px solid black;
            width: 300px;
            padding: 20px;
            margin: 20px auto;
            text-align: center;
        }
        .product-img {
            width: 100px;
            height: 100px;
            background-color: lightgray;
            margin: 0 auto 20px;
        }
        .product-name,
        .product-price,
        .product-quantity {
            margin-bottom: 10px;
        }
        .quantity-input {
            width: 40px;
            text-align: center;
        }
        .add-cart-btn {
            display: inline-block;
            padding: 10px 20px;
            border: 2px solid black;
            text-decoration: none;
            color: black;
            font-weight: bold;
            cursor: pointer;
        }
    </style>
</head>
<body>
  <div class="container">
    <button type="button " id="submit"   class="btn btn-info mt-5" data-bs-toggle="modal" data-bs-target="#exampleModal">add</button>
    </div>
  <!-- Button trigger modal -->


<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <form >
        <div class="product-container">
          <div class="product-img">img</div>
          <div class="product-name">name</div>
          <div class="product-price">price</div>
          <div class="product-quantity">
              <input type="number" class="quantity-input" min="1" max="10" value="1">
          </div>
          <div>
              <a class="add-cart-btn">add cart</a>
          </div>
      </div>
        </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary">Product</button>
      </div>
    </div>
  </div>
</div>

    
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>