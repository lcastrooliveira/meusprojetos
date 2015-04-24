/**
 * 
 */
(function(angular)  {
	'use strict';
	
	
	var module = angular.module('StarterApp').controller('ProjetoController',['$scope','$log','$state','$mdDialog',ProjetoController]);
	
	
	function ProjetoController($scope,$log,$state,$mdDialog) {
		var self = this;
		
		$scope.projetos = [];
		
		$scope.currentState = $state.current.name;
		
		$scope.LIST_STATE = 'projeto-list';
		$scope.INSERT_STATE = 'projeto-novo';
		$scope.EDIT_STATE = 'projeto-editar';
		$scope.INSERT_ATIVIDADE_STATE = 'atividade-novo';
		$scope.EDIT_ATIVIDADE_STATE = 'atividade-editar';
		
		if($state.current.name == $scope.LIST_STATE) {
			$log.log("listarProjetos");
			projetoServiceDwr.findAll({
				callback: function(result) {
					$log.log(result);
					$scope.projetos = result;
					$scope.$apply();
				},
				errorHandler: function(message,error) {
					$log.log(message)
				}
			});
		} else if($state.current.name == $scope.INSERT_STATE) {
			$scope.projeto = {
					nomeProjeto : "",
					responsavel : "",
					atividade : []
			};
		} else if($state.current.name == $scope.EDIT_STATE) {
			$scope.projeto = [];
			projetoServiceDwr.findById($state.params.id,{
				callback: function(result) {
					$log.log(result);
					$scope.projeto = result;
					$scope.$apply();
				},
				errorHandler: function(message,error) {
					$log.log(message)
				}
			});
			
		} else if($state.current.name == $scope.INSERT_ATIVIDADE_STATE) {
			$log.log("dentro de inserir atividade");
			$log.log($state.params.projeto);
			$scope.modo = $state.params.modo;
			$scope.projeto = $state.params.projeto;
			$scope.atividade = {
					descricao : "",
					responsavel : ""
			};
			
		} else if($state.current.name == $scope.EDIT_ATIVIDADE_STATE) {
			$log.log("dentro de editar atividade");
			$log.log($state.params.projeto);
			$log.log("id:");
			$log.log($state.params.id);
			$scope.modo = $state.params.modo;
			$log.log($scope.modo);
			$scope.projeto = $state.params.projeto;
			$log.log("log do for: ");
			$scope.atividade = [];
			for(var i = 0; i < $scope.projeto.atividade.length; i++) {
				$scope.atividade = $scope.projeto.atividade[i];
				if($scope.atividade.id == $state.params.id) {
					$scope.indexAtividade = i;
					break;
				}
				
			}
			$log.log($scope.atividade);
		}
		
		$scope.showConfirm = function(ev) {
		    // Appending dialog to document.body to cover sidenav in docs app
		    var confirm = $mdDialog.confirm()
		      //.parent(angular.element(document.body))
		      .title('Alerta')
		      .content('Tem certeza que deseja excluir este projeto ?')
		      .ariaLabel('Excluir Projeto')
		      .ok('Aham')
		      .cancel('Nao to afim')
		      .targetEvent(ev);
		    $mdDialog.show(confirm).then(function() {
		      $scope.removerProjeto();
		    }, function() {
		      //$scope.alert = 'You decided to keep your debt.';
		    });
		  };
		
		$scope.editarProjeto = function(id) {
			$state.go('projeto-editar',{id:id});
		}
		
		$scope.removerProjeto = function(){
			$log.log("remover projeto");
			projetoServiceDwr.remove($state.params.id,{
				callback: function(result) {
					$log.log(result);
					$state.go('projeto-list');
				},
				errorHandler: function(message,error) {
					$log.log(message);
					$state.go('projeto-list');
				}
			});
		}
		
		$scope.inserirProjeto = function(modo) {
			if(modo=="inserir") {
				projetoServiceDwr.add($scope.projeto,{
					callback: function(result) {
						$log.log(result);
						$state.go('projeto-list');
					},
					errorHandler: function(message,error) {
						$log.log(message);
						$state.go('projeto-list');
					}
				});
			} else if(modo=="editar") {
				$log.log("editar projeto");
				projetoServiceDwr.edit($scope.projeto,{
					callback: function(result) {
						$log.log(result);
						$state.go('projeto-list');
					},
					errorHandler: function(message,error) {
						$log.log(message);
						$state.go('projeto-list');
					}
				});
			}
		}
		
		$scope.irPaginaInserirAtividade = function() {
			$log.log("chamando pagina inserir atividade wow");
			$state.go('atividade-novo',{projeto : $scope.projeto});
			
		}
		
		$scope.irPaginaEditarAtividade = function(id) {
			$log.log("chamando pagina editar atividade wow");
			$state.go('atividade-editar',{projeto : $scope.projeto,id:id});
		}
		
		$scope.inserirAtividade = function(modo) {
			if(modo=="inserir") {
				$log.log("inseririndo atividade wow");
				$scope.projeto.atividade.push($scope.atividade);
				$log.log($scope.projeto);
				$scope.inserirProjeto(modo);
			} else if(modo="editar") {
				$log.log("editando atividade wow");
				$log.log(modo);
				$scope.inserirProjeto("editar");
			}
		}
		
		$scope.removerAtividade = function(id) {
			$log.log("remover");
			$log.log(id);
			$log.log($scope.indexAtividade);
			if($scope.indexAtividade!= null & $scope.indexAtividade > -1) {
				$scope.projeto.atividade.splice($scope.indexAtividade,1);
				$scope.inserirProjeto("editar");
			}
			$log.log($scope.projeto);
		}
		
		$scope.showConfirmAtividade = function(ev) {
		    // Appending dialog to document.body to cover sidenav in docs app
		    var confirm = $mdDialog.confirm()
		      //.parent(angular.element(document.body))
		      .title('Alerta')
		      .content('Tem certeza que deseja excluir esta atividade ?')
		      .ariaLabel('Excluir Atividade')
		      .ok('Aham')
		      .cancel('Nao to afim')
		      .targetEvent(ev);
		    $mdDialog.show(confirm).then(function() {
		      //$scope.removerProjeto();
		    	$log.log("remover atividade");
		    	$scope.removerAtividade($state.params.id);
		    }, function() {
		      //$scope.alert = 'You decided to keep your debt.';
		    });
		  };
		
	}
	
})(window.angular);