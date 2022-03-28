<%@ page import="tw.hibernateproject.product.model.ProductDao"%>
<%@ page import="java.util.List"%>
<%@ page import="tw.hibernateproject.product.model.Product"%>
<%@ page import="com.google.gson.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>PRODUCT INDEX PAGE</title>
</head>
<body>

	
	<div style="margin-top: 20px">
	<table>
		<tbody>
			<tr>
				<th><a href="insertform.jsp"><button>Add New Product</button></a></th>
				<th><button id="showAll">Show All Product</button></th>
			</tr>
		</tbody>
	</table>
	<table border="2" class="table table-bordered">
		<thead>
			<tr>
				<th><p id="totalNum"></p></th>
				<th><button class="Product_Type" id="sort">Type</button>
					<!-- <form class="columnSearch"> -->
						<input id="type" class="columnSearchInput" type="text" placeholder="" value="">
						<!-- <button class="" type="submit">Search</button> -->
					<!-- </form></th> -->
				<th><button class="Product_ID" id="sort">ID</button>
					<!-- <form class="columnSearch"> -->
						<input id="id" class="columnSearchInput" type="text" placeholder="" value="">
						<!-- <button class="" type="submit">Search</button> -->
					<!-- </form></th> -->
				<th><button class="Product_Name" id="sort">Name</button>
					<!-- <form class="columnSearch"> -->
						<input id="name" class="columnSearchInput" type="text" placeholder="" value="">
						<!-- <button class="" type="submit">Search</button> -->
					<!-- </form></th> -->
				<th><button class="Product_Stock" id="sort">Stock</button>
					<!-- <form class="columnSearch"> -->
						<input id="stock" class="columnSearchInput" type="text" placeholder="" value="">
						<!-- <button class="" type="submit">Search</button> -->
					<!-- </form></th> -->
				<th><button class="Product_Cost" id="sort">Buy</button>
					<!-- <form class="columnSearch"> -->
						<input id="cost" class="columnSearchInput" type="text"	placeholder="" value="">
						<!-- <button class="" type="submit">Search</button> -->
					<!-- </form></th> -->
				<th><button class="Product_Price" id="sort">Sell</button>
					<!-- <form class="columnSearch"> -->
						<input id="price" class="columnSearchInput" type="text" placeholder="" value="">
						<!-- <button class="" type="submit">Search</button> -->
					<!-- </form></th> -->
				<th>Image</th>
			</tr>

		</thead>
		<tbody id="resultTable"></tbody>
	</table>
	</div>
	<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
	<script src="js/product.js"></script>

</body>
</html>