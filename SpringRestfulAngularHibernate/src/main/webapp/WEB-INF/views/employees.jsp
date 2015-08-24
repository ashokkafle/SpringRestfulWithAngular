<div class="employees view">
    <div class="container">
        <header>
            <h3>Employee</h3>
        </header>
        <div class="row">
            <div class="span3">
                
                <spring:message code="fname" />
                <br />
                <input data-ng-model="newEmployee.firstName" type="text" placeholder="First Name">
            </div>
        </div>
        <div class="row">
            <div class="span3">
                Last Name:
                <br />
                <input data-ng-model="newEmployee.lastName" type="text" placeholder="Last Name">
            </div>
        </div>
        <div class="row">
            <div class="span3">
                Email ID:
                <br />
                <input data-ng-model="newEmployee.email" type="text" placeholder="Email">
            </div>
        </div>
        <div class="row">
            <div class="span3">
                Telephone:
                <br />
                <input data-ng-model="newEmployee.telephone" type="text" placeholder="XXX-XXX-XXXX">
            </div>
        </div>
        <div class="row">
            <div class="span3">
                Address:
                <br />
                <input data-ng-model="newEmployee.address" type="text" placeholder="Address">
            </div>
        </div>
        <div class="row">
            <div class="span3">
                <button id="submitCustomer" class="btn btn-primary" type="button" 
                    data-ng-disabled="!newEmployee.firstName || !newEmployee.lastName || !newEmployee.address" 
                    data-ng-click="insertEmployee()">Add Employee</button>
            </div>
        </div>
        <br /><br />
        <div>
            <div class="row cardContainer">
                <div class="span3 card" data-ng-repeat="employee in employees | orderBy:'lastName'">
                    <button class="btn close cardClose" data-ng-click="deleteEmployee(employee.id)">&times;</button>
                    <div class="cardHeader">{{employee.firstName + ' ' + employee.lastName}}</div>
                    <div class="cardBody">{{employee.address}}</div>
                    <a href="#/employeeorders/{{employee.id}}" class="cardBody btn-link">View {{ employee.orders.length }} Orders</a>
                </div>
            </div>
        </div>
    </div>
</div>