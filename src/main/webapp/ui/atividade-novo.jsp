<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<form name="myForm" novalidate>
<h3>Nova Atividade para: {{projeto.nomeProjeto}}</h3>

<md-input-container flex>
<label>Responsavel</label>
<input ng-model="atividade.responsavel" placeholder="Insira o nome do responsavel" required>
<span style="color:red" ng-show="myForm.atividade.responsavel.$dirty && myForm.atividade.responsavel.$invalid">
<span ng-show="myForm.atividade.responsavel.$error.required">Insira um responsavel para a atividade</span>
</md-input-container>

<md-input-container flex>
<label>Descricao</label>
<textarea ng-model="atividade.descricao" columns="1" md-maxlength="150" required/>
<span style="color:red" ng-show="myForm.atividade.descricao.$dirty && myForm.atividade.descricao.$invalid">
<span ng-show="myForm.atividade.descricao.$error.required">Insira uma descricao</span>
</md-input-container>

</form>


<md-button class="md-raised md-primary" ng-disabled="myForm.$invalid" ng-click="inserirAtividade(modo)">
	Salvar
</md-button>
<md-button class="md-raised md-warn" ng-hide="modo=='inserir'" ng-click="showConfirmAtividade($event)">
	Remover
</md-button>
<md-button ng-click="editarProjeto(projeto.id)">
	Cancelar
</md-button>


