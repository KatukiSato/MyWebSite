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
	<div class="card-midium2">
		<div class="text-center">
			<h3>登録する情報を確認してください</h3>
		</div>

		<form class="form-signin3">
			<p>ログインID</p>
			<p>サンプル</p>
			<hr class="borderline">

			<p>ユーザ名</p>
			<p>サンプル</p>
			<hr class="borderline">

			<p>メールアドレス</p>
			<p>サンプル</p>
			<hr class="borderline">

			<p>電話番号</p>
			<p>サンプル</p>
			<hr class="borderline">

			<p>住所</p>
			<p>サンプル</p>
			<hr class="borderline">

			<p>パスワード(非表示)</p>
			<p>サンプル</p>
			<hr class="borderline">

			<div class="form-inline">
				<a class="btn btn-lg btn-danger btn-block" type="submit"
					href="NewEntry.html">修正</a> <a
					class="btn btn-lg btn-primary btn-block" type="submit"
					href="EntrySuccess.html">登録</a>
			</div>
	</div>
	</form>

</body>
</html>