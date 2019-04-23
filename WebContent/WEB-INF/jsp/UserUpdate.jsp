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


<title>ユーザ情報更新</title>

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

	<div class="card-midium2">
		<div class="text-center"></div>

	<form class="form-signin" action ="UserUpdateConfirm" method = "POST">
		<h1>お客様情報変更</h1>
		<br>
			<p><font color=red><strong>${validationMessage}</strong></font></p>
		<br>
		<div class="bottom">
		<c:forEach var="info" items="${user}">
			<label for="inputloginId">ログインID</label>
				<input type="text" id="inputloginId" class=".form-signin" value="${info.login_id}"
				required="" autofocus="" name= "loginId">

			<label for="inputName">ユーザ名</label>
				<input type="text" id="inputName" class=".form-signin"
					value="${info.name}" required="" autofocus="" name="name">

			<label for="inputMail">メールアドレス</label>
				<input type="text" id="inputMail"class=".form-signin"
					value="${info.mail}" required="" autofocus="" name="mail">

			<label for="inputPhone">電話番号</label>
				<input type="text" id="inputPhone" class=".form-signin"
					value="${info.phone}" required=""autofocus="" name ="phone">

			<label for="inputAddress">住所</label>
				<input type="text" id="inputAddress" class=".form-signin" value="${info.address}"
				required="" autofocus="" name ="address">

			<label for="inputPassword">パスワード</label>
			<input type="password" id="inputPassword" class=".form-signin" placeholder="パスワード"
				autofocus="" name ="pass">

			<label for="inputCheck">確認のためもう一度パスワードを入力してください。</label>
				<input type="password" id="inputCheck" class=".form-signin" placeholder="パスワード（確認）"
				autofocus="" name ="check">

			<button class="btn btn-lg btn-primary btn-block" type="submit"
				>確認画面へ</button>
		</c:forEach>
		</div>
	</form>
	</div>
</body>
</html>