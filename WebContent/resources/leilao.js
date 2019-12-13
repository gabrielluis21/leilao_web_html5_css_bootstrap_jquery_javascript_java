var app = angular.module("leilao", []);

app.factory("logged", function() {
	return {
		user: ""
	};
});

app.controller("controlar", function($scope, $http){
	var usuario = "";
	
	$scope.entrar = function(){
		$http({
	     	url : 'http://localhost:8080/siteLeilao/LoginController',
	        method : "GET",
	        data : {
	        	'email': $scope.txtEmail,
	        	'pwd': $scope.TxtPwd
	        }
	        }).then(function(response) {
	        	$scope.usuario = response.data;
	        	$scope.txtEmail = "";
	        	$scope.TxtPwd = "";
	        }, function(response) {
	            //FAIL CASE
	        });
		logged.user = usuario;
	}
	
	$scope.cadastrar = function(){
		$http({
	     	url : 'http://localhost:8080/siteLeilao/CadastroController',
	        method : "POST",
	        data : {
	        	'nome' : $scope.txtName,
	        	'idade': $scope.txtAge,
	        	'cpf': $scope.txtCpf,
	        	'rg': $scope.txtRg,
	        	'dtNasc': $scope.txtDtNasc,
	        	'email': $scope.txtEmail,
	        	'ender': $scope.txtEnder,
	        	'pwd': $scope.TxtPwd
	        }
	        }).then(function(response) {
	        	$scope.usuario = response.data;
	        	$scope.txtName= "";
	        	$scope.txtAge= "";
	        	$scope.txtCpf= "";
	        	$scope.txtRg = "";
	        	$scope.txtDtNasc = "";
	        	$scope.txtEmail = "";
	        	$scope.txtEnder = "";
	        	$scope.TxtPwd = "";
	        }, function(response) {
	            //FAIL CASE
	        });
			logged.user = usuario;
	} 
});

app.controller("lance", function ($scope, logged) {
	$scope.auctionLogged = logged;
	$scope.bids = [];

	$scope.startingBid = 0.0;
	$scope.highestBid = 0.0;

	$scope.currentBid = 0.0;
	
	$scope.setSartingBid = function (value) {
		$scope.startingBid = value;
		if ($scope.bids.length === 0) {
			$scope.highestBid = $scope.startingBid;
		}
	}

	$scope.bid = function () {
		$scope.bids.push({user: $scope.auctionLogged.user, value: $scope.currentBid});
	}

});