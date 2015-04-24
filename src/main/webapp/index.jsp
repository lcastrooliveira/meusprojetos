<%@taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en" ng-app="StarterApp">
<head>
<link rel="stylesheet"
	href="https://ajax.googleapis.com/ajax/libs/angular_material/0.8.3/angular-material.min.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=RobotoDraft:300,400,500,700,400italic">
<meta name="viewport" content="initial-scale=1" />
<style>
	form {
		padding: 10px 30px 20px 25px;
	}
</style>
</head>
<body layout="column" ng-controller="AppCtrl">
	<md-toolbar layout="row">
	<h1 class="md-toolbar-tools" layout-align-gt-sm="center">Meus Projetos</h1>
	</md-toolbar>
	<div layout="row" flex>
		<md-sidenav layout="row" class="md-sidenav-left md-whiteframe-z2" md-component-id="left" md-is-locked-open="$mdMedia('gt-sm')">
			<md-list layout="column">
				<md-item>
					<md-button ui-sref="user-list">
						Usuarios
					</md-button>
				</md-item>
				<md-item>
					<md-button ui-sref="projeto-list">
						Projetos
					</md-button>
				</md-item>
				<md-item>
					<md-button href="j_spring_security_logout">
						Logout
					</md-button>
				</md-item>
			</md-list>
		</md-sidenav>
		<md-content flex id="content">
			<ui-view/>
		</md-content>
	</div>

	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<!-- AngularJS -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/angularjs/1.3.15/angular.min.js"></script>
	<script
		src="https://ajax.googleapis.com/ajax/libs/angularjs/1.3.15/angular-animate.min.js"></script>
	<script
		src="https://ajax.googleapis.com/ajax/libs/angularjs/1.3.15/angular-aria.min.js"></script>
	<script
		src="https://ajax.googleapis.com/ajax/libs/angular_material/0.8.3/angular-material.min.js"></script>
	<script type="text/javascript"
		src="https://cdnjs.cloudflare.com/ajax/libs/angular-ui-router/0.2.13/angular-ui-router.min.js"></script>


	<!-- DWR Scripts -->
	<script type='text/javascript' src='/meusprojetos/dwr/engine.js'></script>
	<script type='text/javascript' src='/meusprojetos/dwr/interface/userServiceDwr.js'></script>
	<script type='text/javascript' src='/meusprojetos/dwr/interface/projetoServiceDwr.js'></script>

	<script src="assets/js/app.js"></script>
	<script src="assets/js/controllers/user-controller.js"></script>
	<script src="assets/js/controllers/projeto-controller.js"></script>
</body>
</html>
