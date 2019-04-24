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


<title>購入完了</title>

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
					<li class="nav-item active"><a class="nav-link" href="Login">ログイン</a></li>
					<li class="nav-item"><a class="nav-link" href="NewEntry">新規登録</a></li>
				</c:if>

				<!--ログイン状態の時に出すコマンド  -->
				<c:if test="${logId != null}">
					<li class="nav-item"><a class="nav-link"
						href="Cart?login_id=${logId}">買い物かご</a></li>
					<li class="nav-item"><a class="nav-link"
						href="UserDetail">お客様情報</a></li>
					<li class="nav-item active"><a class="nav-link" href="Logout">ログアウト</a></li>
				</c:if>
			</ul>
		</div>

	</nav>

	<div class="important">
		<span class="display-3">購入完了！</span>
	</div>

	<br>
	<span class="display-4">以下の商品を購入完了しました</span>

	<div class="card">
		<div class="container">
			<div class="row">
				<div class="col-1"></div>
				<div class="col-6">商品</div>
				<div class="col-2">単価</div>
				<div class="col-1">数量</div>
				<div class="col-2">価格</div>
			</div>
			<hr class="borderline2">
			<c:forEach var="item" items="${show}">
				<div class="row">
					<div class="col-1"></div>
					<div class="col-sm-2">
						<a href="ItemDetail?item_id=${item.item_id}"><img
							src="img/${item.file_name}" alt="サンプル" class="item-card"></a>
					</div>
					<div class="col-4">
						<a href="ItemDetail?item_id=${item.item_id}">${item.name}</a>
					</div>
					<div class="col-2">
						<strong>${item.priceStr}円</strong>
					</div>
					<div class="col-1">${item.quality}個</div>
					<div class="col-2">
						<strong>${item.totalpriceStr}円</strong>
					</div>
				</div>
				<br>
				<br>
				<br>
			</c:forEach>
		</div>
		<div class="container">
			<hr class="borderline">

			<div class="row">
				<div class="col-2">支払方法</div>
				<div class="col-6">${dmb.name}</div>
				<div class="col-4"></div>
			</div>
			<br>
			<div class="row">
				<div class="col-2">配送方法</div>
				<div class="col-6">選択したもの</div>
				<div class="col-2"></div>
				<div class="col-2">
					<strong>${dmb.priceStr}円</strong>
				</div>
			</div>

			<br> <br>

			<div class="row">
				<div class="col-9"></div>
				<div class="col-1">合計</div>
				<div class="col-2">
					<strong>${test}円</strong>
				</div>
			</div>
			<br> <a class="btn btn-primary btn-block" type="submit" href="TopPage">ＴＯＰページへ戻る</a>
			<br>
			<br> <a class="btn btn-success btn-block" type="submit" href="BuyHistory">購入履歴一覧へ戻る</a>
		</div>
	</div>
</body>
</html>