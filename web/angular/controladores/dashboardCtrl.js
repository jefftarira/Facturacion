var app = angular.module('facturacionApp.dashboardCtrl', []);

/*Controlador del cliente*/


app.controller('dashboardCtrl', ['$scope', function($scope){

	$scope.activar('mDashboard','','Dashboard','Pagina principal');
}])