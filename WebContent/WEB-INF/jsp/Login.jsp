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

	<div class="text-center">

		<form class="form-signin">

			<h1>ログイン画面</h1>

					<input type="text"  class="form-control" placeholder="ログインID" required="" autofocus="">

					<input type="password"  class="form-control" placeholder="Password" required="">

			<div class="checkbox mb-3">

				<br> <br>
				<a type="button" class="btn btn-sm btn-outline-danger" href="http://localhost:8080/MyWebSite/NewEntry">
					初めての方はこちらからユーザ情報を登録してください。
				</a>

			</div>

			<a class="btn btn-lg btn-primary btn-block" href="http://localhost:8080/MyWebSite/TopPage">ログイン</a>

			<a class="btn btn-lg btn-danger btn-block" href="http://localhost:8080/MyWebSite/TopPage">ＴＯＰページへ</a>

		</form>
	</div>

</body>
</html>