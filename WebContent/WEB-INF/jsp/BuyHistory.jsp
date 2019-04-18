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

<title>購入履歴一覧</title>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">

<link href="css/bootstrap.min.css" rel="stylesheet">

<!--オリジナルのcssの導入  -->
<link href="css/original/common.css" rel="stylesheet">

</head>
<!--JS -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>

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
<body>
	<span class="display-3">購入履歴一覧</span>

	<br>
	<h2>日時をクリックすると購入詳細が確認出来ます。</h2>

	<br>
	<h2>日時の絞り込みができます</h2>

	<br>
	<br>

	<form class="form-inline">
		<div class="container">
			<div class="text-center" style="padding: 3px;">
				<input class="form-control mr-sm-1" type="date" size="140">
				～ <input class="form-control mr-sm-1" type="date" size="140">
				<a class="btn btn-primary" type="submit" href="BuyHistory">検索</a>
			</div>
		</div>
	</form>

	<div class="card-History">
		<div class="panel-group" id="accordion">
			<c:forEach var="otamesi" items="${test}">
				<div class="panel panel-default">
					<div class="panel-heading">
						<div class="row">
							<div class="col-6">
								<h4 class="panel-title">
									<a data-toggle="collapse" data-parent="#accordion${otamesi.id}"
										href="#accordion${otamesi.id}">${otamesi.formatDate} </a>
								</h4>
							</div>
							<div class="col-6">${otamesi.total_priceStr}円</div>
						</div>
					</div>
					<div id="accordion${otamesi.id}" class="panel-collapse collapse">

						<br>

						<div class="row">
							<div class="col-1"></div>
							<div class="col-6">商品</div>
							<div class="col-2">単価</div>
							<div class="col-1">数量</div>
							<div class="col-2">価格</div>
						</div>


						<hr class="borderline">

						<div class="row">
							<div class="col-1"></div>
							<div class="col-sm-2">
								<a href="ItemDetail.html"><img src="img/5c35bd53.jpg"
									alt="サンプル" width="150" height="100%" class="card-img-top"></a>
							</div>
							<div class="col-4">
								<a href="ItemDetail.html">商品を書くんだひゃっはああああああああああああああああひゃっはああああああああああああああああ</a>
							</div>
							<div class="col-2">123456789円</div>
							<div class="col-1">○○個</div>
							<div class="col-2">123456789円</div>
						</div>

						<br>

						<hr class="borderline">

						<div class="row">
							<div class="col-2">支払方法</div>
							<div class="col-6">${otamesi.pay_method_name}</div>
							<div class="col-4"></div>
						</div>

						<br>

						<div class="row">
							<div class="col-2">配送方法</div>
							<div class="col-6">${otamesi.delivery_method_name}</div>
							<div class="col-2"></div>
							<div class="col-2">${otamesi.delivery_method_price}円</div>
						</div>

						<br>
						<div class="row">
							<div class="col-9"></div>
							<div class="col-1">合計</div>
							<div class="col-2">${otamesi.total_priceStr}円</div>
						</div>
						<br>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
</body>
</html>