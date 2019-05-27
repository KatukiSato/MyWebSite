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


<title>新規商品登録</title>

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

		<div class="collapse navbar-collapse justify-content-end">
			<ul class="navbar-nav">
					<li class="nav-item"><a class="nav-link"
						href="Cart?login_id=${logId}">買い物かご</a></li>
					<li class="nav-item"><a class="nav-link" href="UserDetail">お客様情報</a></li>
					<li class="nav-item active"><a class="nav-link" href="Logout">ログアウト</a></li>
					<li class="nav-item active"><a class="nav-link" href="AdminCommand">管理者コマンド</a></li>

			</ul>
		</div>

	</nav>

		<h1>新規商品登録</h1>

			<div class="card-midium2">
				<form class="form-signin" method="POST" enctype="multipart/form-data" action="ItemNewEntryConfirm">
					<div class ="bottom">
					<label for="inputName">商品名</label>
					<input type="text" id="inputName" class=".form-signin"
						placeholder="商品名" required="" name="name" value="${item.name }">

					<label for="inputDetail">商品説明</label>
					<textarea rows="10" cols="48" id="inputDetail" placeholder="商品情報の説明" name="detail" value="${item.detail }"></textarea>

					<label for="inputPrice">価格</label>
					<input type="text" id="inputPrice" class=".form-signin"
						placeholder="価格" required="" autofocus="" name="price" value="${item.price }">

					<label for="inputFileName">画像</label>
					<input type="file" id="inputFileName" class=".form-signin"
						placeholder="画像" autofocus="" name="img">

					<br>

					<button class="btn btn-lg btn-primary btn-block" type="submit">確認画面へ</button>
					</div>
				</form>
			</div>
</body>
</html>