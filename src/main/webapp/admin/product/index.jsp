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
				<th><a href="insertform.jsp"><button>新增</button></a></th>
				<th><button id="showAll">顯示全部</button></th>
			</tr>
		</tbody>
	</table>
	<table border="2" class="table table-bordered">
		<thead>
			<tr>
				<th><p id="totalNum"></p></th>
				<th><button class="P_Type" id="sort">產品種類</button>
					<form class="columnSearch">
						<input id="type" class="columnSearchInput" type="text" placeholder="">
						<button class="" type="submit">查詢</button>
					</form></th>
				<th><button class="P_ID" id="sort">產品編號</button>
					<form class="columnSearch">
						<input id="id" class="columnSearchInput" type="text" placeholder="">
						<button class="" type="submit">查詢</button>
					</form></th>
				<th><button class="P_Name" id="sort">產品名稱</button>
					<form class="columnSearch">
						<input id="name" class="columnSearchInput" type="text"
							placeholder="">
						<button class="" type="submit">查詢</button>
					</form></th>
				<th><button class="P_Stock" id="sort">產品進貨量</button>
					<form class="columnSearch">
						<input id="stock" class="columnSearchInput" type="text"
							placeholder="">
						<button class="" type="submit">查詢</button>
					</form></th>
				<th><button class="P_Cost" id="sort">產品買價</button>
					<form class="columnSearch">
						<input id="cost" class="columnSearchInput" type="text"
							placeholder="">
						<button class="" type="submit">查詢</button>
					</form></th>
				<th><button class="P_Price" id="sort">產品售價</button>
					<form class="columnSearch">
						<input id="price" class="columnSearchInput" type="text"
							placeholder="">
						<button class="" type="submit">查詢</button>
					</form></th>
				<th>產品圖片</th>
			</tr>

		</thead>
		<tbody id="resultTable"></tbody>
	</table>
	</div>
	<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
	<script src="js/product.js"></script>

</body>
</html>