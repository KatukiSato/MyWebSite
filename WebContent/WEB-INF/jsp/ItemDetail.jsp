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


<title>商品詳細</title>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">

<link href="css/bootstrap.min.css" rel="stylesheet">

<!--オリジナルのcssの導入  -->
<link href="css/original/common.css" rel="stylesheet">

</head>

<body class="text-center">

	<nav class="navbar navbar-expand-sm navbar-dark bg-dark mt-3 mb-3">
		<a class="navbar-brand" href="http://localhost:8080/MyWebSite/TopPage">ＥＣサイト</a>

		<!--bootstrap.minの変更-->
		<form action ="Index" class="form-inline">
			<div class="container">
				<div class="row">
					<div class=".col-lg-12 form-inline" style="padding: 3px;">
						<input class="form-control mr-sm-1" type="search" size="130" name ="search">
						<button class="btn btn-primary" type="submit">検索</button>
					</div>
				</div>
			</div>
		</form>

		<div class="collapse navbar-collapse justify-content-end">
			<ul class="navbar-nav">
				<c:if test="${logId == null}">
					<li class="nav-item active"><a class="nav-link"
						href="http://localhost:8080/MyWebSite/Login">ログイン</a></li>
				</c:if>
				<li class="nav-item"><a class="nav-link"
					href="http://localhost:8080/MyWebSite/NewEntry">新規登録</a></li>
				<li class="nav-item"><a class="nav-link" href="cart.html">買い物かご</a></li>
				<li class="nav-item"><a class="nav-link" href="UserDetail.html">お客様情報</a></li>
				<c:if test="${logId != null}">
					<li class="nav-item active"><a class="nav-link"
						href="http://localhost:8080/MyWebSite/Logout">ログアウト</a></li>
				</c:if>
			</ul>
		</div>

	</nav>

	<span class="display-3">商品詳細</span>

	<div class="card">
		<div class="container">
			<br> <br> <br> <br>
			<div class="row">
				<div class="col s6">
					<div class="card-image">
						<img src="img/${item.fileName}" alt="サンプル" class ="img-container--absolute-position">
					</div>
				</div>
				<div class="col s6">
					<br>
					<h4>${item.name}</h4>
					<br>
					<h5>${item.price}円</h5>
					<br>
					<p>商品説明</p>
					<p>${item.detail}</p>
				</div>
			</div>

			<br> <br>

			<form action="ItemAdd" method="POST">
				<input type="hidden" name="item_id" value="${item.id}">
				<a class="btn btn-success btn-block" type="submit" href="cart.html"> 買い物かごに追加 </a>
			</form>

			<br><br>
			<a class="btn btn-primary " type="submit" href="Index?search=${search}"> 検索結果へ戻る </a>
		</div>

	</div>

</body>
</html>