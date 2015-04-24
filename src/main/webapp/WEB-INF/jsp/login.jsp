<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Meus Projetos Login</title>
		<style type="text/css">
			.errorblock {
				color: #ff0000;
				background-color: #ffEEEE;
				border: 3px solid #ff0000;
				padding: 8px;
				margin: 16px;
			}
		</style>		
	</head>
	<body onload="document.f.j_username.focus();">
		<h3>Meus Projetos Login</h3>
		<c:if test="${not empty error}">
			<div class="errorblock">
				Login Falhou.<br/>
				Causado por: ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
			</div>
		</c:if>
		<form action="j_spring_security_check" name="f" method="post">
			<table>
				<tr>
					<td>Usuario:</td>
					<td><input type="text" name="j_username" value=""></td>
				</tr>
				<tr>
					<td>Senha:</td>
					<td><input type="password" name="j_password" value=""></td>
				</tr>				
				<tr>					
					<td colspan="2"><input type="submit" name="Submit" value="Logar"></td>
				</tr>
				<tr>					
					<td colspan="2"><input type="reset" name="reset"></td>
				</tr>
			</table>
		</form>
	</body>
</html>