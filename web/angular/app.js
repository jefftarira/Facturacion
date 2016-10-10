var app= angular.module('facturacionApp', [
	'ngRoute', 'jcs-autoValidate',
	'facturacionApp.configuracion',
	'facturacionApp.mensajes',
	'facturacionApp.notificaciones',
	'facturacionApp.clientes',
	'facturacionApp.clientesCtrl',
	'facturacionApp.dashboardCtrl'
	]);

angular.module('jcs-autoValidate')
.run([
    'defaultErrorMessageResolver',
    function (defaultErrorMessageResolver) {
        // To change the root resource file path
        defaultErrorMessageResolver.setI18nFileRootPath('angular/lib');
        defaultErrorMessageResolver.setCulture('es-co');
    }
]);

app.controller('mainCtrl', ['$scope','Configuracion','Mensajes','Notificaciones', function($scope,Configuracion,Mensajes,Notificaciones){

	$scope.config   = {};
	$scope.mensajes = Mensajes.mensajes;
	$scope.notificaciones = Notificaciones.notificaciones;
	$scope.titulo    = "";
	$scope.subtitulo ="";

	$scope.usuario = {
		nombre : "Jefferson Tarira"
	};	

	Configuracion.cargar().then(function(){
		$scope.config = Configuracion.config;
	})

	/*Funciones globales*/

	$scope.activar = function(menu , submenu, titulo , subtitulo){
		$scope.titulo    = titulo;
		$scope.subtitulo = subtitulo;

		$scope.mDashboard ="";
		$scope.mClientes  ="";

		$scope[menu] ='active';

	};

}]);


app.config(['$routeProvider',function($routeProvider){
	$routeProvider
	.when('/',{
		templateUrl: 'dashboard/dashboard.html',
		controller : 'dashboardCtrl'

	})
	.when('/clientes',{
		templateUrl: 'clientes/clientes.html',
		controller : 'clientesCtrl'
	})
	.otherwise({
		redirectTo: '/'
	})
}]);


/*Filtros*/

app.filter('quitarletra',function(){
	return function(palabra){
		if(palabra){			
			if (palabra.length > 1)
				return palabra.substr(1);		
			else
				return palabra;
		}
	}
})

.filter('mensajecorto',function(){
	return function(mensaje){
		if(mensaje){			
			if (mensaje.length > 20)
				return mensaje.substr(0,37)+"...";		
			else
				return mensaje;
		}
	}
})