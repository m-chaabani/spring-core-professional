<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form"
	prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="static/style/style.css" />
</head>
<body>
	<header>
		<p>Bienvenue à la formation Spring</p>
	</header>

	<nav class="nav-main">
		<ul>
			<li class="btn"><a href="#">Accueil</a></li>
			<li class="btn"><a href="#">Formations</a></li>
			<li class="btn"><a href="#">Actualité</a></li>
			<li class="btn"><a href="#">Inscription</a></li>
			<li class="btn"><a href="#">Contact</a></li>
		</ul>
	</nav>

	<div id="content">

	
		<div class="right">
			<spring:form method="post" action="j_security_check"
				modelAttribute="user">
				<table>
					<tr>
						<td>username:</td>
						<td><spring:input path="username" /></td>
					</tr>
					<tr>
						<td>login:</td>
						<td><spring:input path="password" /></td>
					</tr>
					<tr>
						<td><input type="submit"  value="se connecter" /></td>
						<td></td>
					</tr>
				</table>
			</spring:form>
		</div>


	</div>

	<footer>
		<p>Copyright &copy; - 2022-2023 - Chaabani</p>
	</footer>




</body>
</html>