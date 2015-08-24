//This controller retrieves data from the customersService and associates it with the $scope
//The $scope is ultimately bound to the customers view
app.controller('EmployeesController', function ($scope, $http, employeesService) {

    init();

    function init() {
        employeesService.getEmployees($http).success(function(data) {
            $scope.employees = data;
        });        
    }

    $scope.insertEmployee = function () {
        //retrieve the data from view and converting to JSON string
        var msgData = {
            firstName: $scope.newEmployee.firstName,
            lastName: $scope.newEmployee.lastName,
            email: $scope.newEmployee.email,
            telephone: $scope.newEmployee.telephone,
            address: $scope.newEmployee.address            
        };
        
        msgData= JSON.stringify(msgData); 
        
        employeesService.insertEmployee($http, msgData).success(function(){
            init();
        });        
        
        //resetting the form field values
        $scope.newEmployee = {
            firstName: '',
            lastName: '',
            email: '',
            telephone: '',
            address: ''
        };
    };

    $scope.deleteEmployee = function (id) {
        employeesService.deleteEmployee($http, id).success(function(){
            init();
        });
    };
});

//This controller retrieves data from the customersService and associates it with the $scope
//The $scope is bound to the order view
app.controller('EmployeeOrdersController', function ($scope, $routeParams, $http, employeesService) {    
    $scope.ordersTotal = 0.00;
    
    init();

    function init() {
        //Grab customerID off of the route        
        var employeeID = ($routeParams.employeeID) ? parseInt($routeParams.employeeID) : 0;
        if (employeeID > 0) {            
            employeesService.getEmployee($http, employeeID).success(function(data){
                $scope.employee = data;
            });
        }
    }

});

//This controller retrieves data from the customersService and associates it with the $scope
//The $scope is bound to the orders view
app.controller('OrdersController', function ($scope, $http, employeesService) {    
    init();

    function init() {        
        employeesService.getEmployees($http).success(function(data){
            $scope.employees = data;
        });
    }
});

app.controller('NavbarController', function ($scope, $location) {
    $scope.getClass = function (path) {
        if ($location.path().substr(0, path.length) == path) {
            return true
        } else {
            return false;
        }
    }
});

//This controller is a child controller that will inherit functionality from a parent
//It's used to track the orderby parameter and ordersTotal for a customer. Put it here rather than duplicating 
//setOrder and orderby across multiple controllers.
app.controller('OrderChildController', function ($scope) {
    $scope.orderby = 'product';
    $scope.reverse = false;
    $scope.ordersTotal = 0.00;

    init();

    function init() {
        //Calculate grand total
        //Handled at this level so we don't duplicate it across parent controllers
        if ($scope.employee && $scope.employee.orders) {
            var total = 0.00;
            for (var i = 0; i < $scope.employee.orders.length; i++) {
                var order = $scope.employee.orders[i];
                total += order.orderTotal;
            }
            $scope.ordersTotal = total;
        }
    }

    $scope.setOrder = function (orderby) {
        if (orderby === $scope.orderby)
        {
            $scope.reverse = !$scope.reverse;
        }
        $scope.orderby = orderby;
    };
});