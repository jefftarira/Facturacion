var app = angular.module('facturacionApp.configuracion',[]);

app.factory('Configuracion', ['$http', '$q', function($http, $q){

	var self = {

		config : {},
		cargar: function(){

			var q = $q.defer();

			$http.get('configuracion.json')
				.success(function(data){
					self.config=data;

					q.resolve();

				})
				.error(function(){
					q.reject();
					console.error("Error al cargar configuracion");
				})

			return q.promise;
		}

	};

	return self;

}])