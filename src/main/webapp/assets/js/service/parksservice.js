(function () {
    'use strict';

    angular
        .module('parkPlace')
        .factory('ParksService', ['$http', '$q', ParksService]);

    function ParksService($http, $q) {
        var _this = this;

        _this.REST_SERVICE_URI = 'api/parks?{0}';

        var factory = {
            fetchParksNearBy: fetchParksNearBy
        };

        return factory;

        function fetchParksNearBy(lat, lng) {
            var deferred = $q.defer();

            var querystring = '?lat={0}&lng={1}'.format(lat, lng);

            $http.get(_this.REST_SERVICE_URI.format(querystring))
                .then(
                    function (response) {
                        deferred.resolve(response.data)
                    },
                    function (errResponse) {
                        console.error('Error while fetching nearby parks.');
                        deferred.reject(errResponse);
                    }
                );
            return deferred.promise;
        }
    }
})();
