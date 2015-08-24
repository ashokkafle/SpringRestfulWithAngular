//This handles retrieving data and is used by controllers. 3 options (server, factory, provider) with 
//each doing the same thing just structuring the functions/data differently.
app.service('employeesService', function () {

    this.getEmployees = function ($http) {        
        return $http.get('/SpringRest/rest/emps');
    };

    this.insertEmployee = function ($http, msg_data) {
        return $http.post('/SpringRest/rest/emp/create', msg_data);
    };

    this.deleteEmployee = function ($http, id) {
        return $http.put('/SpringRest/rest/emp/delete/' + id);
    };

    this.getEmployee = function ($http, id) {
        return $http.get('/SpringRest/rest/emp/' + id);
    };
});