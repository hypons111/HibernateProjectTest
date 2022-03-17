<%@ page import="tw.hibernateproject.product.model.ProductDao"%>
<%@ page import="java.util.List"%>
<%@ page import="tw.hibernateproject.product.model.Product"%>
<%@ page import="com.google.gson.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form id="editForm" method="post" action="/HibernateProject/admin/product/update" enctype="multipart/form-data">
		<table border="1">
			<thead>
				<tr>
					<th>產品種類</th>
					<th>產品編號</th>
					<th>產品名稱</th>
					<th>產品存量</th>
					<th>產品買價</th>
					<th>產品售價</th>
					<th>產品圖片</th>
				</tr>
			</thead>
			<tbody id="resultTable"></tbody>
		</table>
	</form>
	<p id="submitResult"></p>
	</div>
	<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
	<script src="https://code.jquery.com/jquery-3.6.0.js"
		integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
		crossorigin="anonymous"></script>
	<script src="js/productEdit.js"></script>
</body>
</html>

