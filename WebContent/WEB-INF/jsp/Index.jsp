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


<title>検索結果</title>

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
		<a class="navbar-brand" href="TopPage">ＥＣサイト</a>

		<!--bootstrap.minの変更-->
		<form action="Index" class="form-inline">
			<div class="container">
				<div class="row">
					<div class=".col-lg-12 form-inline" style="padding: 3px;">
						<input class="form-control mr-sm-1" type="search" size="130"
							name="search" placeholder="商品名、または商品タグを入力してください">
						<button class="btn btn-primary" type="submit">検索</button>
					</div>
				</div>
			</div>
		</form>

		<!--非ログイン状態の時に出すコマンド  -->
		<div class="collapse navbar-collapse justify-content-end">
			<ul class="navbar-nav">
				<c:if test="${logId == null}">
					<li class="nav-item active"><a class="nav-link" href="Login">ログイン</a></li>
					<li class="nav-item"><a class="nav-link" href="NewEntry">新規登録</a></li>
				</c:if>

				<!--ログイン状態の時に出すコマンド  -->
				<c:if test="${logId != null}">
					<li class="nav-item"><a class="nav-link"
						href="Cart?login_id=${logId}">買い物かご</a></li>
					<li class="nav-item"><a class="nav-link"
						href="http://localhost:8080/MyWebSite/Mock/UserDetail.html">お客様情報</a></li>
					<li class="nav-item active"><a class="nav-link" href="Logout">ログアウト</a></li>
				</c:if>
			</ul>
		</div>

	</nav>

	<div class="album py-5 bg-light">
		<div class="container">
			<h1>検索結果</h1>

			<c:choose>
				<c:when test="${search != null}">
					<h2>検索内容：${search}</h2>
				</c:when>
				<c:otherwise>
					<h3>商品が見つかりませんでした。</h3>
				</c:otherwise>
			</c:choose>

			<div class="row">
				<c:forEach var="item" items="${itemList}" varStatus="status">
					<div class="col-md-3">
						<div class="item-card mb-4 shadow-sm">
							<a href="ItemDetail?item_id=${item.id}"><img
								src="img/${item.fileName}"
								class="img-container--absolute-position"></a>
							<div class="card-body">
								<p class="textOverflow">${item.name}</p>
								<p>
									<strong>${item.priceStr}円</strong>
								</p>
								<div class="d-flex justify-content-between align-items-center">
									<div class="btn-group">
										<a type="button" class="btn btn-sm btn-outline-secondary"
											href="http://localhost:8080/MyWebSite/ItemDetail?item_id=${item.id}">商品詳細</a>
									</div>
								</div>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>

			<div class="row">
				<c:forEach var="item" items="${resultSearchTag}" varStatus="status">
					<div class="col-md-3">
						<div class="item-card mb-4 shadow-sm">
							<a href="ItemDetail?item_id=${item.id}"><img
								src="img/${item.fileName}"
								class="img-container--absolute-position"></a>
							<div class="card-body">
								<p class="textOverflow">${item.name}</p>
								<p>
									<strong>${item.priceStr}円</strong>
								</p>
								<div class="d-flex justify-content-between align-items-center">
									<div class="btn-group">
										<a type="button" class="btn btn-sm btn-outline-secondary"
											href="http://localhost:8080/MyWebSite/ItemDetail?item_id=${item.id}">商品詳細</a>
									</div>
								</div>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>

		</div>
	</div>
</body>
</html>