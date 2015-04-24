<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<form name="myForm" novalidate>
<div flex layout="row">
	<md-content flex id="content">
		<h1>Projetos Cadastrados</h1>
		<md-list layout="column">
	           	<md-list-item class="md-3-line" ng-repeat="it in projetos" >
	                  <h3><a href="#" ng-click="editarProjeto(it.id)">{{it.nomeProjeto}}</h3></a>
	                  <p>Responsavel: {{it.responsavel}}</p>
	                  <md-divider ></md-divider>
	            </md-list-item>
         </md-list>
	</md-content>
</div>
<md-button class="md-raised md-primary" ui-sref="projeto-novo">
	Novo Projeto
</md-button>
</form>
	
