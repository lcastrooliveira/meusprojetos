<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<form name="myForm" novalidate>

<md-input-container flex>
<label>Username</label>
<input ng-model="usuario.username" placeholder="Insira o nome de usuario" required/>
<span style="color:red" ng-show="myForm.usuario.username.$dirty && myForm.usuario.username.$invalid"/>
<span ng-show="myForm.usuario.username.$error.required">Insira nome de usuario</span>
</md-input-container>

<md-input-container flex>
<label>Email</label>
<input type="email" ng-model="usuario.email" placeholder="Insira seu email" required/>
<span style="color:red" ng-show="myForm.usuario.email.$dirty && myForm.usuario.email.$invalid"/>
<span ng-show="myForm.usuario.email.$error.required">Insira um email valido</span>
</md-input-container>

<md-input-container flex>
<label>Senha</label>
<input type="password" id="userPwd" ng-model="usuario.password" placeholder="Insira a senha" required/>
<span style="color:red" ng-show="myForm.usuario.password.$dirty && myForm.usuario.password.$invalid">
<span ng-show="myForm.usuario.password.$error.required">Insira uma senha</span>
</md-input-container>

<md-input-container flex>
<label>Confirme Senha</label>
<input type="password" id="userPwdConfirm" pw-check="userPwd" ng-model="myForm.confirmpassword" placeholder="Confirme a senha" required>
<span style="color:red" ng-show="myForm.confirmpassword.$dirty && myForm.confirmpassword.$error">
</md-input-container>



<p>Privilegio:</p>
<md-radio-group ng-model="usuario.role">
      <md-radio-button value='admin' class="md-primary">Administrador</md-radio-button>
      <md-radio-button value='user' selected="true" > Usuario </md-radio-button>
    </md-radio-group>
<md-button class="md-raised md-primary" ng-disabled="myForm.$invalid" ng-click="adicionarUsuario('inserir')">
	Adicionar
</md-button>
<md-button ui-sref="user-list">
	Cancelar
</md-button>
</form>

