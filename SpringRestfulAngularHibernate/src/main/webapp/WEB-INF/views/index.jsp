<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html data-ng-app="springTest">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Spring RestFul</title>
        <link rel="shortcut icon" href="data:image/x-icon;," type="image/x-icon">
        <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
        <link href="<c:url value="/resources/css/bootstrap-responsive.min.css" />" rel="stylesheet">
        <link href="<c:url value="/resources/css/myStyle.css" />" rel="stylesheet">       
    </head>

    <body>
        <div class="navbar navbar-fixed-top">
            <div class="navbar-inner">
                <div class="container">
                    <a class="brand " href="#/">
                        <img src="<c:url value="/resources/images/people.png" />" alt="logo"> Employee Manager
                    </a>
                    <ul class="nav nav-pills" data-ng-controller="NavbarController">
                        <li data-ng-class="{'active':getClass('/employees')}"><a href="#/employees">Employees</a></li>
                        <li data-ng-class="{'active':getClass('/orders')}"><a href="#/orders">Orders</a></li>
                    </ul>
                </div>
            </div>
        </div>
        
        <!-- Note that AngularJS 1.2+ now has a built-in ng-animation direction. Left in animated-view to show a 
         custom directive -->
        <div animated-view></div>


        <div id="footer">
            <div class="navbar navbar-fixed-bottom">
                <div class="navbar-inner">
                    <div class="container">
                        <footer>
                            <div class="row">
                                <div class="span4">
                                    Created by: Ashok Kafle
                                </div>
                                <div class="span4">
                                    Twitter: <a href="https://twitter.com/Ashok_Kafle">@Ashok_Kafle</a>
                                </div>
                                <div class="span4">
                                    Facebook: <a href="http://facebook.com/ashokkafle">Ashok Kafle</a>
                                </div>
                            </div>
                        </footer>
                    </div>
                </div>
            </div>
        </div>
    </body>
    
    <!-- Vendor Libs: jQuery only used for Bootstrap functionality -->
    <script src="<c:url value="/resources/js/angular.js" />"></script>
    <script src="<c:url value="/resources/js/angular-route.js" />"></script>        
    <script src="<c:url value="/resources/js/jquery.min.js" />"></script>

    <!-- UI Libs -->
    <script src="<c:url value="/resources/js/bootstrap.js" />"></script>
    
    <!-- App libs -->
    <script src="<c:url value="/resources/js/app/app.js" />"></script>
    <script src="<c:url value="/resources/js/app/controllers.js" />"></script>
    <script src="<c:url value="/resources/js/app/employeesService.js" />"></script>
    <script src="<c:url value="/resources/js/app/animatedView.js" />"></script>    
</html>
