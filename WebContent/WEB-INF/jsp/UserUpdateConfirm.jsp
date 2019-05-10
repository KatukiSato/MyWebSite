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


<title>更新確認</title>

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

	<div class="text-center">
		<span class="display-3">お客様情報 変更内容確認</span>
		<div class="important">
			<h3>以下の内容で情報を変更します。 よろしいですか？</h3>
		</div>
	</div>

	<div class="card-midium2">

		<form class="form-signin3" action="UpdateSuccess" method="POST">
				<p>ログインID</p>
				<p>${updateInfoExceptPass.login_id}</p>
				<hr class="borderline2">

				<p>ユーザ名</p>
				<p>${updateInfoExceptPass.name}</p>
				<hr class="borderline2">

				<p>メールアドレス</p>
				<p>${updateInfoExceptPass.mail}</p>
				<hr class="borderline2">

				<p>電話番号</p>
				<p>${updateInfoExceptPass.phone}</p>
				<hr class="borderline2">

				<p>住所</p>
				<p>${updateInfoExceptPass.address}</p>
				<hr class="borderline2">

			<div class="form-inline">
				<button class="btn btn-lg btn-danger btn-block" type="submit"
					name = "updete_button" value = "cancel">修正</button>
				<button class="btn btn-lg btn-primary btn-block" type="submit"
					name = "updete_button" value = "update">登録</button>
			</div>
		</form>
	</div>
</body>
</html>