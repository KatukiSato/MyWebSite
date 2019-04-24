
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
		<a class="navbar-brand" href="TopPage">ＥＣサイト</a>

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

		<div class="collapse navbar-collapse justify-content-end">
			<ul class="navbar-nav">
				<!--ログイン状態の時に出すコマンド  -->
				<c:if test="${logId != null}">
					<li class="nav-item"><a class="nav-link"
						href="Cart?login_id=${logId}">買い物かご</a></li>
					<li class="nav-item"><a class="nav-link" href="UserDetail">お客様情報</a></li>
					<li class="nav-item active"><a class="nav-link" href="Logout">ログアウト</a></li>
				</c:if>
			</ul>
		</div>

	</nav>

	<span class="display-3"><font color="limegreen">${logId}</font>さんの買い物かごの中身</span>

	<div class="card">

		<c:choose>

			<c:when test="${cartCount == 0}">
				<span class="display-4"><font color="red">買い物かごの中身は空です。</font></span>
				<a class="btn btn-primary btn-block" type="submit" href="TopPage">ＴＯＰページへ</a>
			</c:when>

		<c:otherwise>
			<div class="container">
				<div class="row">
					<div class="col-1"></div>
					<div class="col-4">商品</div>
					<div class="col-2">単価</div>
					<div class="col-1">数量</div>
					<div class="col-2">変更</div>
					<div class="col-2">価格</div>
				</div>
				<c:forEach var="item" items="${show}">
					<hr class="borderline2">
					<div class="row">

						<div class="col-1">
							<form action="CartItemUpdate" method="POST">
								<input type="hidden" value="${item.item_id}"
									name="deleteCartItem">
								<button class="btn btn-danger btn-block" type="submit"
									name="cart_button" value="delete">削除</button>
							</form>
						</div>

						<div class="col-2">
							<a href="ItemDetail?item_id=${item.item_id}"><img
								src="img/${item.file_name}" alt="サンプル" class="item-card"></a>
						</div>
						<div class="col-2">
							<a href="ItemDetail?item_id=${item.item_id}">${item.name}</a>
						</div>
						<div class="col-2">
							<strong>${item.priceStr}円</strong>
						</div>

						<div class="col-1">${item.quality}個</div>

						<div class="col-2">
							<form action="CartItemUpdate" method="POST">
								<select name="qualityChange">
									<option value="1">1</option>
									<option value="2">2</option>
									<option value="3">3</option>
									<option value="4">4</option>
									<option value="5">5</option>
								</select>

								<div class="col align-self-center">
									<input type="hidden" name="test" value="${item.item_id}">
									<button class="btn btn-primary" type="submit"
										name="cart_button" value="Change">変更</button>
								</div>
							</form>
						</div>

						<div class="col-2">
							<strong>${item.totalpriceStr}円</strong>
						</div>
					</div>
					<br>
					<br>
				</c:forEach>
				<hr class="borderline ">

				<div class="row">
					<div class="col-9"></div>
					<div class="col-1">合計</div>
					<div class="col-2">${totalprice}円</div>
				</div>
				<br>
				<div class="container">
					<div class="row">


						<div class="col align-self-end">
							<a class="btn btn-success btn-block" type="submit"
								href="Register">レジへ進む</a>
						</div>
					</div>
				</div>
			</div>
			</c:otherwise>
		</c:choose>
	</div>
</body>
</html>