(function () {
    'use strict';

    angular
        .module('parkPlace')
        .controller('IndexController', ['$scope', 'NgMap', 'ParksService', IndexController]);

    function IndexController($scope, ngMap, parksService) {
        var _this = this;

        _this.ngMap = ngMap;
        _this.parksService = parksService;

        _this.parks = [];

        initMap();

        function fetchParks(lat, lng) {
            _this.parksService.fetchParksNearBy(lat, lng)
                .then(
                    function (d) {
                        _this.parks = d;

                        console.log(_this.parks);
                    },
                    function (errResponse) {
                        console.error('Error while fetching parks.');
                    }
                );
        }

        function initMap() {
            _this.ngMap.getMap()
                .then(function (map) {
                        var infoWindow = new google.maps.InfoWindow;

                        if (navigator.geolocation) {
                            tryAPIGeolocation(function (position) {
                                var pos = {
                                    lat: position.coords.latitude,
                                    lng: position.coords.longitude
                                };

                                infoWindow.setPosition(pos);
                                infoWindow.setContent('Location found.');
                                infoWindow.open(map);
                                map.setCenter(pos);

                                fetchParks(pos.lat, pos.lng);

                            }, function () {
                                handleLocationError(true, infoWindow, map.getCenter());
                            });
                        } else {
                            // Browser doesn't support Geolocation
                            handleLocationError(false, infoWindow, map.getCenter());
                        }
                    }
                );
        }

        function handleLocationError(browserHasGeolocation, infoWindow, pos) {
            _this.ngMap.getMap()
                .then(function (map) {
                    infoWindow.setPosition(pos);
                    infoWindow.setContent(browserHasGeolocation ?
                        'Error: The Geolocation service failed.' :
                        'Error: Your browser doesn\'t support geolocation.');
                    infoWindow.open(map);
                });
        }

        var tryAPIGeolocation = function (successCallback, failCallback) {
            jQuery.post("https://www.googleapis.com/geolocation/v1/geolocate?key=AIzaSyASwFKj6RSnZfHoBxYOsc6tHKtwGhN_xzg", function (success) {
                successCallback({coords: {latitude: success.location.lat, longitude: success.location.lng}});
            }).fail(function (err) {
                failCallback(err);
            });
        };
    }
})();
