<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<form name="myForm" novalidate>
<div flex layout="row">
	<md-content flex id="content">
		<h1>Usuarios Cadastrados</h1> 
		<md-list layout="column">
			<md-list-item class="md-3-line" ng-repeat="it in usuarios"> 
			<div class="md-list-item-text">
				<h3><a ng-href="#" ng-click="editarUsuario(it.username)">{{it.username}}</a></h3>
				<h4>{{it.email}}</h4>
				<md-divider ></md-divider>
			</div> 
			</md-item> 
		</md-list-item> 
	</md-content>
</div>
<sec:authorize ifAnyGranted="ROLE_ADMIN">
	<md-button class="md-raised md-primary" ui-sref="user-novo"> Novo Usuario </md-button>
</sec:authorize>
</form>