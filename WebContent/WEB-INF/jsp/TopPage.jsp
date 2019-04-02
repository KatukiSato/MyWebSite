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


<title>トップページ</title>

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
		<form class="form-inline">
			<div class="container">
				<div class="row">
					<div class=".col-lg-12 form-inline" style="padding: 3px;">
						<input class="form-control mr-sm-1" type="search" size="130">
						<a class="btn btn-primary" type="submit" href="index.html">検索</a>
					</div>
				</div>
			</div>
		</form>

		<div class="collapse navbar-collapse justify-content-end">
			<ul class="navbar-nav">
				<li class="nav-item active"><a class="nav-link"
					href="Login.html">ログイン</a></li>
				<li class="nav-item"><a class="nav-link" href="http://localhost:8080/MyWebSite/NewEntry">新規登録</a></li>
				<li class="nav-item"><a class="nav-link" href="cart.html">買い物かご</a></li>
				<li class="nav-item"><a class="nav-link" href="UserDetail.html">○○さんの情報</a></li>
				<li class="nav-item"><a class="nav-link" href="Logout.html">ログアウト</a></li>
			</ul>
		</div>

	</nav>

	<main role="main"> <span class="display-1">ＥＣサイト</span>

	<div class="album py-5 bg-light">
		<div class="container">
			<h2>サイトからのオススメ</h2>
			<div class="row">
				<c:forEach var="item" items="${itemList}">
					<div class="col-md-3">
						<div class="item-card mb-4 shadow-sm">
							<a href="ItemDetail.html"><img src="img/${item.fileName}"
								width="150" height="100%" class="card-img-top"></a>
							<div class="card-body">
								<p class="textOverflow">${item.name}</p>
								<p class="textOverflow">${item.price}円</p>
								<div class="d-flex justify-content-between align-items-center">
									<div class="btn-group">
										<a type="button" class="btn btn-sm btn-outline-secondary"
											href="ItemDetail.html">商品詳細</a>
									</div>
								</div>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>

	<div class="album py-5 bg-light">
		<div class="container">
			<h2>ランキング</h2>
			<div class="row">
				<div class="col-4">
					<h1>
						<font color=gold><strong>１位</strong></font>
					</h1>
				</div>
				<div class="col-4">
					<h1>
						<font color=silver><strong>２位</strong></font>
					</h1>
				</div>
				<div class="col-4">
					<h1>
						<font color=brown><strong>３位</strong></font>
					</h1>
				</div>
			</div>

			<div class="row">
				<c:forEach var="item" items="${itemList}">
					<div class="col-md-4">
						<div class="item-card mb-4 shadow-sm">
							<a href="ItemDetail.html"><img src="img/${item.fileName}"
								width="150" height="100%" class="card-img-top"></a>
							<div class="card-body">
								<p class="textOverflow">${item.name}</p>
								<p class="textOverflow">${item.price}円</p>
								<div class="d-flex justify-content-between align-items-center">
									<div class="btn-group">
										<a type="button" class="btn btn-sm btn-outline-secondary"
											href="ItemDetail.html">商品詳細</a>
									</div>
								</div>
							</div>
						</div>
					</div>
				</c:forEach>

			</div>
		</div>
	</div>

	</main>

</body>
</html>