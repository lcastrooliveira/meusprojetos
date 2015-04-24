(function() {
	'use strict';
	
	var module = angular.module('StarterApp', ['ngMaterial','ui.router'])

	.controller('AppCtrl', ['$scope', '$mdSidenav', function($scope, $mdSidenav){
	  $scope.toggleSidenav = function(menuId) {
	    $mdSidenav(menuId).toggle();
	  };
	}])
	//Referencia da diretiva
	//http://blog.brunoscopelliti.com/angularjs-directive-to-check-that-passwords-match/
	.directive('pwCheck', [function () {
	    return {
	      require: 'ngModel',
	      link: function (scope, elem, attrs, ctrl) {
	        var firstPassword = '#' + attrs.pwCheck;
	        elem.add(firstPassword).on('keyup', function () {
	          scope.$apply(function () {
	            var v = elem.val()===$(firstPassword).val();
	            ctrl.$setValidity('pwmatch', v);
	          });
	        });
	      }
	    }
	  }]);
	
	
	module.config( function( $stateProvider, $urlRouterProvider ) {
		
		//-------
		//URL Router
		//-------

		//HOME
        $urlRouterProvider.otherwise("/");

        $stateProvider
        .state('user-list', {
			url : "/listar",
			controller : 'UserController',
			templateUrl : "./ui/user-view.jsp"
		}).state('user-novo', {
			url : "/novo",
			controller : 'UserController',
			templateUrl : "./ui/user-novo.jsp"
		}).state('user-editar', {
			url : "/editar/:id",
			controller : 'UserController',
			templateUrl : "./ui/user-editar.jsp"
		}).state('projeto-list', {
			url : "/listarProjeto",
			controller : 'ProjetoController',
			templateUrl : "./ui/projeto-view.jsp"
		}).state('projeto-novo', {
			url : "/novoProjeto",
			controller : 'ProjetoController',
			templateUrl : "./ui/projeto-novo.jsp"
		}).state('projeto-editar', {
			url : "/editarProjeto/:id",
			controller : 'ProjetoController',
			templateUrl : "./ui/projeto-editar.jsp"
		}).state('atividade-novo', {
			url : "/novaAtividade",
			params: {projeto: null,modo:'inserir'},
			controller : 'ProjetoController',
			templateUrl : "./ui/atividade-novo.jsp"
		}).state('atividade-editar', {
			url : "/editarAtividade/:id",
			params: {projeto: null,modo:'editar'},
			controller : 'ProjetoController',
			templateUrl : "./ui/atividade-novo.jsp"
		});
	});

	module.run( function( $rootScope, $window ) {
		
	});

//	angular.element(document).ready( function() {
//		angular.bootstrap( document, ['projetos']);
//	});
})();