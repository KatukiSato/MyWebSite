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


<title>登録情報確認</title>

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
	<div class="card-midium2">
		<div class="text-center">
			<h3>登録する情報を確認してください</h3>
			<p>${validationMessage}</p>
		</div>

		<form class="form-signin3">
			<p class="text-left">ログインID</p>
			<p>${udb.login_id}</p>
			<hr class="borderline">

			<br>
			<br>

			<p class="text-left">ユーザ名</p>
			<p>${udb.name}</p>
			<hr class="borderline">

			<br>
			<br>

			<p class="text-left">メールアドレス</p>
			<p>${udb.mail}</p>
			<hr class="borderline">

			<br>
			<br>

			<p class="text-left">電話番号</p>
			<p>${udb.phone}</p>
			<hr class="borderline">

			<br>
			<br>

			<p class="text-left">住所</p>
			<p>${udb.address}</p>
			<hr class="borderline">



			<br> <br> <br>
			<br> <a class="btn btn-lg btn-danger btn-block" type="submit"
				href="http://localhost:8080/MyWebSite/NewEntry">修正</a> <a
				class="btn btn-lg btn-primary btn-block" type="submit"
				href="EntrySuccess.html">登録</a>
	</div>
	</form>

</body>
</html>