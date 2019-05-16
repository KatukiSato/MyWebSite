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

<title>タグ更新確認</title>

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

	<h1>タグ更新確認</h1>

	<h2>以下のタグを更新します。 よろしいですか？</h2>

	<div class="card-midium2">
		<div class="form-signin">
			<div class="bottom">
				<p></p>

				<p>更新前のタグ</p>
				<c:forEach var="tag" items="${tagName }">
					<p>${tag.name }</p>
					<hr class="borderline">

					<div class="text-center">
						<h2>&#8659;</h2>
					</div>

					<form action="TagUpdateSuccess" method="POST">

						<p>更新後のタグ</p>
						<p>
							<strong>${newTag }</strong>
						</p>
						<hr class="borderline">

						<br> <br>

						<div class=row>
							<div class="col-6">
								<button class="btn btn-lg btn-primary btn-block" type="submit"
									name="update_button" value="correction">訂正する</button>
							</div>

							<div class="col-6">
								<input type="hidden" value="${tag.id}" name="tagId">
								<button class="btn btn-lg btn-success btn-block" type="submit"
									name="update_button" value="update">更新する</button>
							</div>
						</div>
					</form>
				</c:forEach>
			</div>

		</div>
	</div>
</body>
</html>