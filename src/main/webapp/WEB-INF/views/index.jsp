<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!doctype html>
<html lang="en" ng-app="parkPlace">
<head>
    <meta charset="utf-8">
    <meta name="viewport"
          content="width=device-width,initial-scale=1,maximum-scale=1,shrink-to-fit=no,user-scalable=no"/>

    <title>ParkPlace</title>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css"/>

    <script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js"></script>

    <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyASwFKj6RSnZfHoBxYOsc6tHKtwGhN_xzg"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>
    <script src="https://rawgit.com/allenhwkim/angularjs-google-maps/master/build/scripts/ng-map.js"></script>

    <link href="<c:url value='/assets/css/site.css' />" rel="stylesheet"/>

    <script src="<c:url value="/assets/js/parkplace.js" />"></script>
    <script src="<c:url value="/assets/js/app.js" />"></script>
    <script src="<c:url value="/assets/js/service/parksservice.js" />"></script>
    <script src="<c:url value="/assets/js/controller/indexcontroller.js" />"></script>

    <!-- CSRF security token to get past filter -->
    <meta name="_csrf" content="${_csrf.token}"/>
    <meta name="_csrf_header" content="${_csrf.headerName}"/>

    <script>
        (function () {
            var token = $("meta[name='_csrf']").attr("content");
            var header = $("meta[name='_csrf_header']").attr("content");

            //
            // Include the CSRF security token in AJAX requests to the server.
            //
            $(document).ajaxSend(function (e, xhr, options) {
                xhr.setRequestHeader(header, token);
            });
        })();
    </script>
</head>

<body class="ng-cloak" ng-controller="IndexController as ctrl">

<nav class="navbar navbar-expand-md navbar-dark bg-dark">
    <a class="navbar-brand" href="#">ParkPlace</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbar"
            aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbar">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item active">
                <a class="nav-link" href="#">About</a>
            </li>
        </ul>

        <form class="form-inline my-2 my-lg-0">
            <input class="form-control mr-sm-2" type="text" placeholder="Search" aria-label="Search">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
        </form>
    </div>
</nav>

<div class="container-fluid" style="padding: 0px; margin: 0px; height: 100%;">

    <ng-map style="height: 50%;" center="[37.06929, -76.48775]"></ng-map>

    <div class="list-group" style="margin: 10px; padding-bottom: 10px; height: 50%; overflow-y: auto;">
        <a href="#"
           class="list-group-item list-group-item-action flex-column align-items-start"
           ng-repeat="p in ctrl.parks">

            <div class="d-flex w-100 justify-content-between">
                <h5 class="mb-1" ng-bind="p.name"></h5>
                <small>{{ p.distance }} mi.</small>
            </div>

            <p class="mb-1">Donec id elit non mi porta gravida at eget metus. Maecenas sed diam eget risus varius
                blandit.</p>
            <small>{{ p.rating }}/5</small>
        </a>
    </div>

</div>

</body>
</html>