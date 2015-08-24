var app = angular.module('springTest', ['ngRoute']);

//This configures the routes and associates each route with a view and a controller
app.config(function ($routeProvider) {
    $routeProvider
        .when('/employees',
            {
                controller: 'EmployeesController',
                templateUrl: '/SpringRest/employees'
            })
        //Define a route that has a route parameter in it (:employeeID)
        .when('/employeeorders/:employeeID',
            {
                controller: 'EmployeeOrdersController',
                templateUrl: '/SpringRest/employeeOrders'
            })
        .when('/orders',
            {
                controller: 'OrdersController',
                templateUrl: '/SpringRest/orders'
            })
        .otherwise({ redirectTo: '/employees' });
});