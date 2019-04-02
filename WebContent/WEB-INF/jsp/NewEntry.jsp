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


<title>新規登録</title>

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
	</nav>

	<form  action="NewEntryConfirm" method="POST" class="form-signin">
			<h1>新規ユーザ登録</h1>
			<div class ="bottom">

			<label for="inputloginId">ログインID</label>
				<input type="text" id="inputloginId" class="form-signin" value="${udb.login_id}" placeholder="ログインID" required="" autofocus="" >

			<label for="inputName">ユーザ名</label>
				<input type="text" id="inputName" class="form-signin" value="${udb.name}" placeholder="ユーザ名" required="" autofocus="">

			<label for="inputMail">メールアドレス</label>
				<input type="text" id="inputMail" class="form-signin"  value="${udb.mail}" placeholder="メールアドレス" required="" autofocus="">

			<label for="inputPhone">電話番号</label>
				<input type="text" id="inputPhone" class="form-signin"  value="${udb.phone}" placeholder="電話番号" required="" autofocus="">

			<label for="inputAddress">住所</label>
				<input type="text" id="inputAddress" class="form-signin" value="${udb.address}" placeholder="住所" required="" autofocus="">

			<label for="inputPassword">パスワード</label>
				<input name = "password" type="password" id="inputPassword" class="form-signin"  placeholder="パスワード" required="" autofocus="">

			<label for="inputCheck">確認のためもう一度パスワードを入力してください。</label>
				<input name = "checkpassword" type="password" id="inputCheck" class="form-signin" placeholder="パスワード（確認）" required="" autofocus="">

			<button class="btn btn-lg btn-primary btn-block" type="submit" name ="action">確認画面へ</button>
</div>
		</form>
</body>
</html>