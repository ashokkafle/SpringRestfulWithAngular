<div class="orders view">
    <div class="container">
        <header>
            <h3>All Employee Orders</h3>
        </header>
        <div>
            <div class="row">
                <div class="span12" data-ng-repeat="employee in employees | orderBy:'lastName'">
                    <div class="indent">
                        <h4><a href="#/customerorders/{{employee.id}}">{{ employee.firstName + ' ' + employee.lastName }}</a></h4>
                    </div>
                    <div data-ng-include="'/SpringRest/ordersTable'" />
                </div>
            </div>
        </div>
    </div>
</div>