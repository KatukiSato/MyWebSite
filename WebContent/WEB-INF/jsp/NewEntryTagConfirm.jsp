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

<title>新規タグ登録</title>

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
				<li class="nav-item active"><a class="nav-link"
					href="AdminCommand">管理者コマンド</a></li>

			</ul>
		</div>

	</nav>
	<h1>タグ登録確認</h1>

	<h2>以下のタグを登録します。 よろしいですか？</h2>


	<div class="card-midium2">
		<form action ="TagEntrySuccess" method ="POST" class="form-signin">
			<div class="bottom">
				<p></p>

				<p>登録予定のタグ</p>
				<p>${tag }</p>
				<hr class="borderline">

			<br><br>

		<div class= row>
			<div class="col-6">

			<button class="btn btn-lg btn-danger btn-block" type="submit"
				name="tag_button" value="cancel">タグ入力画面へ</button>

			</div>

			<div class="col-6">

			<button class="btn btn-lg btn-primary btn-block" type="submit"
				name="tag_button" value="entry">登録する</button>
			</div>

		</div>

<br><br>

				<a class="btn btn-lg btn-danger btn-block" type="submit"
					href="AdminCommand">管理者コマンドへ</a>
			</div>
		</form>
	</div>
</body>
</html>