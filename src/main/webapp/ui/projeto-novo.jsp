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

<md-button class="md-raised md-primary" ng-disabled="myForm.$invalid" ng-click="inserirProjeto('inserir')">
	Adicionar
</md-button>
<md-button ui-sref="projeto-list">
	Cancelar
</md-button>
</form>

