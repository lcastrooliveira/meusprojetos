/**
 * 
 */
(function(angular)  {
	'use strict';
	
	
	var module = angular.module('StarterApp').controller('UserController',['$scope','$log','$state','$mdDialog',UserController]);
	
	
	function UserController($scope,$log,$state,$mdDialog) {
		var self = this;
		
		$scope.usuarios = [];
		
		$scope.currentState = $state.current.name;
		
		$scope.LIST_STATE = 'user-list';
		$scope.INSERT_STATE = 'user-novo';
		$scope.EDIT_STATE = 'user-editar';
		
		if($state.current.name == $scope.LIST_STATE) {
			userServiceDwr.findaAll({
				callback: function(result) {
					$log.log(result);
					$scope.usuarios = result;
					$scope.$apply();
				},
				errorHandler: function(message,error) {
					$log.log(message)
				}
			});
		} else if($state.current.name == $scope.INSERT_STATE) {
			$scope.usuario = {
					enabled : true,
					username : "",					
					password : "",
					email : "",
					role : 'user'
			};
		} else if($state.current.name == $scope.EDIT_STATE) {
			$log.log($state.params.id);
			$scope.roles = [];
			$scope.usuario = [];
			
			userServiceDwr.findByUsername($state.params.id,{
				callback: function(result) {
					$log.log(result);
					$scope.usuario = result;
					$scope.usuario.password = "";
					
					userServiceDwr.findRolesByUsername($state.params.id,{
						callback: function(result) {
							$log.log(result);
							$scope.roles = result;
							if($scope.roles[0]=="ROLE_ADMIN") {
								$scope.usuario.role = 'admin';
							} else {
								$scope.usuario.role = 'user';
							}
							$scope.$apply();
						},
						errorHandler: function(message,error) {
							$log.log(message)
						}
					});
				},
				errorHandler: function(message,error) {
					$log.log(message)
				}
			});
			
		}
		
		$scope.editarUsuario = function(username) {
			$state.go('user-editar',{id:username});
			$log.log(username);
			
		}
		
		$scope.removerUsuario = function() {
			$log.log("remover usuario");
			$log.log($state.params.id);
			userServiceDwr.removeUser($state.params.id,{
				callback: function(result) {
					$log.log(result);
					$state.go('user-list');
				},
				errorHandler: function(message,error) {
					$log.log(message);
					$state.go('user-list');
				}
			});
		}
		
		$scope.showConfirm = function(ev) {
		    // Appending dialog to document.body to cover sidenav in docs app
		    var confirm = $mdDialog.confirm()
		      //.parent(angular.element(document.body))
		      .title('Alerta')
		      .content('Tem certeza que deseja excluir usuario ?')
		      .ariaLabel('Excluir Usuario')
		      .ok('Aham')
		      .cancel('Nao to afim')
		      .targetEvent(ev);
		    $mdDialog.show(confirm).then(function() {
		      $scope.removerUsuario();
		    }, function() {
		      //$scope.alert = 'You decided to keep your debt.';
		    });
		  };
		
		$scope.adicionarUsuario = function(modo) {			
			$log.log($scope.usuario);
			//$log.log($scope.role);
			if($scope.usuario.role == 'user') {
				$scope.roles = [{authority: "ROLE_USER",user : {username : $scope.usuario.username}}];
				$log.log('usuario comum');
				$log.log($scope.roles);
			} else if($scope.usuario.role == 'admin') {
				$scope.roles = [{authority: "ROLE_ADMIN",user : {username : $scope.usuario.username}},
				                {authority: "ROLE_USER" ,user : {username : $scope.usuario.username}}
				               ];
				$log.log('administrador');
				$log.log($scope.roles);
			}
			if(modo=="inserir") {
				userServiceDwr.addUserAndRole($scope.usuario,$scope.roles,{
					callback: function(result) {
						$log.log(result);
						$state.go('user-list');
					},
					errorHandler: function(message,error) {
						$log.log(message);
						$state.go('user-list');
					}
				});
			} else if(modo="alterar") {
				userServiceDwr.updateUser($scope.usuario,$scope.roles,{
					callback: function(result) {
						$log.log(result);
						$state.go('user-list');
					},
					errorHandler: function(message,error) {
						$log.log(message);
						$state.go('user-list');
					}
				});
			}
			
		}
	}
	
})(window.angular);