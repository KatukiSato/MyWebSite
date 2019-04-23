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
		<a class="navbar-brand" href="TopPage">ＥＣサイト</a>
	</nav>

	<div class="text-center">

		<form action="Login" method="POST" class="form-signin">

			<h1>ログイン画面</h1>

			<c:if test="${loginErrorMessage != null}">
				<h3><font color ="red">${loginErrorMessage}</font></h3>
				<br>
			</c:if>

			<input type="text" class="form-control" placeholder="ログインID"
				required="" autofocus="" name="login_id" value="${inputLoginId}">

			<input type="password" class="form-control" placeholder="Password"
				required="" name="password">

			<div class="checkbox mb-3">

				<br> <br> <a type="button"
					class="btn btn-sm btn-outline-gray"
					href="NewEntry">
					初めての方はこちらからユーザ情報を登録してください。 </a>

			</div>

			<button class="btn btn-lg btn-primary btn-block" type="submit"
				name="action">ログイン</button>

			<a class="btn btn-lg btn-danger btn-block"
				href="TopPage">ＴＯＰページへ</a>

		</form>
	</div>

</body>
</html>