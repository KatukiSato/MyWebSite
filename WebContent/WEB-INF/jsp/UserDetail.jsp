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


<title>お客様情報</title>

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
					<li class="nav-item"><a class="nav-link" href="UserDetail">お客様情報</a></li>
					<li class="nav-item active"><a class="nav-link" href="Logout">ログアウト</a></li>
				</c:if>
			</ul>
		</div>

	</nav>

	<div class="text-center">
		<span class="display-3">お客様情報</span>
	</div>

	<div class="card-midium2">
		<div class="form-signin3">
			<div class="text-left">

				<c:forEach var="info" items="${userInfo}">
					<p>ログインID</p>
					<p>${info.login_id}</p>

					<hr class="borderline2">

					<p>ユーザ名</p>
					<p>${info.name}</p>
					<hr class="borderline2">

					<p>メールアドレス</p>
					<p>${info.mail}</p>
					<hr class="borderline2">

					<p>電話番号</p>
					<p>${info.phone}</p>
					<hr class="borderline2">

					<p>住所</p>
					<p>${info.address}</p>
					<hr class="borderline2">


					<div class="row">
						<div class="col align-self-start">
							<div class="text-center">
								<a class="btn btn-danger btn-block" type="submit"
									href="UserUpdate.html">情報修正</a>
							</div>
						</div>

						<div class="col align-self-	center">
							<form action="BuyHistory" method="POST">

								<div class="text-center">
									<a class="btn btn-success btn-block" type="submit"
										href="BuyHistory">購入履歴</a>
								</div>
							</form>
						</div>

						<div class="col align-self-end">
							<div class="text-center">
								<a class="btn btn-primary btn-block" type="submit"
									href="TopPage">ＴＯＰページ</a>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>

	</form>

</body>
</html>