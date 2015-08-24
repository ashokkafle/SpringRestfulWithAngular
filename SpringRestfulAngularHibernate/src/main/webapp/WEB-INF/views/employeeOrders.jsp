<div class="employeeOrders view">
    <div class="container">
        <header>
            <h3>Employee Orders</h3>
        </header>
        <div>
            <div class="row">
                <div class="span12">
                    <div class="indent">
                        <h4>Orders for {{ employee.firstName + ' ' + employee.lastName }}</h4>
                        {{employee.address}}
                        <br />
                        {{employee.city}}
                        <br /><br />
                    </div>
                </div>                
                <br /><br />
                <div class="span12">
                    <div data-ng-include="'/SpringRest/ordersTable'" />
                </div>
            </div>
        </div>
    </div>
</div>
