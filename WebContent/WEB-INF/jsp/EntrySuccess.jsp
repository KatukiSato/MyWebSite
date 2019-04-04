
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


<title>ユーザー登録完了</title>

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
		<form class="form-inline">
			<div class="container">
				<div class="row">
					<div class="col-12 form-inline" style="padding: 3px;">
						<input class="form-control mr-sm-1" type="search" size="140">
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

	<div class="card-midium">
		<div class="form-signin2">
			<div class="important">
				<h1>登録が完了しました！</h1>
				<br>
			</div>
			<div class="big">
				<p>素敵な買い物をお楽しみください！</p>
				<br>
			</div>

			<a class="btn btn-lg btn-primary" type="submit" href="http://localhost:8080/MyWebSite/TopPage">ＴＯＰページへ戻る</a>

		</div>
	</div>
</body>
</html>