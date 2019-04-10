
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html lang="en" class="">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">


<title>お買い物かご</title>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">

<link href="css/bootstrap.min.css" rel="stylesheet">

<link href="css/original/common.css" rel="stylesheet">

</head>

<body class="text-center">

	<nav class="navbar navbar-expand-sm navbar-dark bg-dark mt-3 mb-3">
		<a class="navbar-brand" href="http://localhost:8080/MyWebSite/TopPage">ＥＣサイト</a>

		<!--bootstrap.minの変更-->
		<form action="Index" class="form-inline">
			<div class="container">
				<div class="row">
					<div class=".col-lg-12 form-inline" style="padding: 3px;">
						<input class="form-control mr-sm-1" type="search" size="130"
							name="search">
						<button class="btn btn-primary" type="submit">検索</button>
					</div>
				</div>
			</div>
		</form>

		<!--非ログイン状態の時に出すコマンド  -->
		<div class="collapse navbar-collapse justify-content-end">
			<ul class="navbar-nav">
				<c:if test="${logId == null}">
					<li class="nav-item active"><a class="nav-link"
						href="http://localhost:8080/MyWebSite/Login">ログイン</a></li>
					<li class="nav-item"><a class="nav-link"
						href="http://localhost:8080/MyWebSite/NewEntry">新規登録</a></li>
				</c:if>

				<!--ログイン状態の時に出すコマンド  -->
				<c:if test="${logId != null}">
					<li class="nav-item"><a class="nav-link"
						href="http://localhost:8080/MyWebSite/Cart">買い物かご</a></li>
					<li class="nav-item"><a class="nav-link"
						href="UserDetail.html">お客様情報</a></li>
					<li class="nav-item active"><a class="nav-link"
						href="http://localhost:8080/MyWebSite/Logout">ログアウト</a></li>
				</c:if>
			</ul>
		</div>

	</nav>


	<span class="display-3"><font color="limegreen">${logId}</font>さんの買い物かごの中身</span>

	<div class="card">
		<div class="container">
			<div class="row">
				<div class="col-1"></div>
				<div class="col-6">商品</div>
				<div class="col-2">単価</div>
				<div class="col-1">数量</div>
				<div class="col-2">価格</div>
			</div>
			<c:forEach var="item" items="${show}">
				<hr class="borderline2">
				<div class="row">
					<div class="col-1">
						<input type="checkbox" value="select">
					</div>
					<div class="col-sm-2">
						<a href="ItemDetail?item_id=${item.id}"><img
							src="img/${item.fileName}" alt="サンプル" class="item-card"></a>
					</div>
					<div class="col-4">
						<a href="ItemDetail?item_id=${item.id}">${item.name}</a>
					</div>
					<div class="col-2">${item.price}円</div>
					<div class="col-1">
						<select name="example">
							<option value="1">1</option>
							<option value="2">2</option>
							<option value="3">3</option>
							<option value="4">4</option>
							<option value="5">5</option>
						</select>
					</div>
					<div class="col-2">123456789円</div>
				</div>
				<br>
				<br>
			</c:forEach>
			<hr class="borderline ">

			<div class="row">
				<div class="col-9"></div>
				<div class="col-1">合計</div>
				<div class="col-2">○○円</div>
			</div>
			<br>

			<form action="Cart" method="POST">
				<div class="container">
					<div class="row">
						<div class="col align-self-start">
							<div class="text-left">
								<button class="btn btn-danger btn-block" type="submit"
									name="cart_button" value="delete">チェックした商品を買い物かごから削除</button>
							</div>
						</div>

						<div class="col align-self-center">
							<button class="btn btn-primary btn-block" type="submit"
								name="cart_button" value="qualityChange">購入数の変更</button>
						</div>

						<div class="col align-self-end">
							<a class="btn btn-success btn-block" type="submit"
								href="Register.html">レジへ進む</a>
						</div>
					</div>
				</div>
			</form>
		</div>
	</div>
</body>
</html>