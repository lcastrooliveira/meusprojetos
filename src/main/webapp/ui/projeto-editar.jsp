<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<form name="myForm" novalidate>

<md-input-container flex>
<label>Nome do Projeto</label>
<input ng-model="projeto.nomeProjeto" placeholder="Insira o nome do projeto" required>
<span style="color:red" ng-show="myForm.projeto.nomeProjeto.$dirty && myForm.projeto.nomeProjeto.$invalid">
<span ng-show="myForm.projeto.nomeProjeto.$error.required">Insira nome do projeto</span>
</md-input-container>

<md-input-container flex>
<label>Responsavel</label>
<input ng-model="projeto.responsavel" placeholder="Insira o nome do responsavel" required>
<span style="color:red" ng-show="myForm.projeto.responsavel.$dirty && myForm.projeto.responsavel.$invalid">
<span ng-show="myForm.projeto.responsavel.$error.required">Insira o responsavel do projeto</span>
</md-input-container>

<h3>Atividades</h3>
<div flex layout="column">
	<md-content flex id="content">
		<md-list layout="column">
            <md-list-item class="md-3-line" ng-repeat="it in projeto.atividade" >
                  <h5><a ng-click="irPaginaEditarAtividade(it.id)" href="#">{{it.descricao}}</a></h5>
                  <md-divider ></md-divider>
            </md-list-item>
          </md-list>
	</md-content>
	<md-button ng-click="irPaginaInserirAtividade()">
		Nova Atividade
	</md-button>
</div>


<md-button class="md-raised md-primary" ng-disabled="myForm.$invalid" ng-click="inserirProjeto('editar')">
	Salvar
</md-button>
<md-button class="md-raised md-warn" ng-click="showConfirm($event)">
	Remover Projeto
</md-button>
<md-button ui-sref="projeto-list">
	Cancelar
</md-button>
</form>

