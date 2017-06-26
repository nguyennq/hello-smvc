<%--
  Created by IntelliJ IDEA.
  User: quocnguyen
  Date: 31/12/2015
  Time: 2:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>User Management</title>
    <style>
        .id.ng-valid{
            background-color: lightgreen;
        }
        .id.ng-dirty.ng-invalid-required{
            background-color: red;
        }
        .id.ng-valid{
            background-color: lightgreen;
        }
        .name.ng-dirty.ng-invalid-required{
            background-color: red;
        }
        .name.ng-dirty.ng-invalid-minlength{
            background-color: yellow;
        }
        .age.ng-valid{
            background-color: lightgreen ;
        }
    </style>
    <link rel="stylesheet" href="/resources/css/bootstrap.min.css">
    <link href="<c:url value='/resources/css/app.css'/>" rel="stylesheet">
    <script src="/resources/js/angular.js"></script>
    <%--<script src="/resources/js/ui-bootstrap.js"></script>--%>
    <script src="/resources/js/ui-bootstrap-tpls.js"></script>
    <script src="<c:url value='/resources/js/app.js' />"></script>
    <script src="<c:url value='/resources/js/service/userService.js' />"></script>
    <script src="<c:url value='/resources/js/controller/userController.js' />"></script>
</head>
<body ng-app="myApp" class="ng-cloak">
<div class="generic-container" ng-controller="UserController as ctrl">
    <div class="panel panel-default">
        <div class="panel-heading"><span class="lead">User Registration Form </span></div>
        <div class="fomcontainer">
            <form ng-submit="ctrl.submit()" name="myForm" class="form-horizontal">
                <%--<div class="row">--%>
                    <%--<div class="form-group col-md-12">--%>
                        <%--<label class="col-md-2 control-lable" for="id">UserId</label>--%>
                        <%--<div class="col-md-7">--%>
                            <%--<input type="text" ng-model="ctrl.user.id" id="id" class="id form-control input-sm" placeholder="Enter id" required />--%>
                            <%--<div class="has-error" ng-show="myForm.$dirty">--%>
                                <%--<span ng-show="myForm.id.$error.required">This is a required field</span>--%>
                                <%--<span ng-show="myForm.id.$invalid">This field is invalid </span>--%>
                            <%--</div>--%>
                        <%--</div>--%>
                    <%--</div>--%>
                <%--</div>--%>

                <input type="hidden" ng-model="ctrl.user.userId" />
                <div class="row">
                    <div class="form-group col-md-12">
                        <label class="col-md-2 control-lable" for="name">Name</label>
                        <div class="col-md-7">
                            <input type="text" ng-model="ctrl.user.name" id="name" class="name form-control input-sm" placeholder="Enter your name" required ng-minlength="3"/>
                            <div class="has-error" ng-show="myForm.$dirty">
                                <span ng-show="myForm.name.$error.required">This is a required field</span>
                                <span ng-show="myForm.name.$error.minlength">Minimum length required is 3</span>
                                <span ng-show="myForm.name.$invalid">This field is invalid </span>
                            </div>
                        </div>
                    </div>
                </div>


                <div class="row">
                    <div class="form-group col-md-12">
                        <label class="col-md-2 control-lable" for="age">Age</label>
                        <div class="col-md-7">
                            <input type="text" ng-model="ctrl.user.age" id="age" class="form-control input-sm" placeholder="Enter your Age. [This field is validation free]"/>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="form-group col-md-12">
                        <label class="col-md-2 control-lable" for="salary">Salary</label>
                        <div class="col-md-7">
                            <input type="text" ng-model="ctrl.user.salary" id="salary" class="salary form-control input-sm" placeholder="Enter your Salary" required/>
                            <div class="has-error" ng-show="myForm.$dirty">
                                <span ng-show="myForm.salary.$error.required">This is a required field</span>
                                <span ng-show="myForm.salary.$invalid">This field is invalid </span>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="form-actions floatRight">
                        <input type="submit"  value="{{!ctrl.user.userId ? 'Add' : 'Update'}}" class="btn btn-primary btn-sm" ng-disabled="myForm.$invalid">
                        <button type="button" ng-click="ctrl.reset()" class="btn btn-warning btn-sm" ng-disabled="myForm.$pristine">Reset Form</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
    <div class="panel panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading"><span class="lead">List of Users </span></div>
        <div class="tablecontainer">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th>UserID</th>
                    <th>Name</th>
                    <th>Age</th>
                    <th>Salary</th>
                    <th width="20%"></th>
                </tr>
                </thead>
                <tbody>
                <tr ng-repeat="u in accountsPagination.content">
                    <td><span ng-bind="u.userid"></span></td>
                    <td><span ng-bind="u.name"></span></td>
                    <td><span ng-bind="u.age"></span></td>
                    <td><span ng-bind="u.salary"></span></td>
                    <td>
                        <button type="button" ng-click="ctrl.edit(u.userid)" class="btn btn-success custom-width">Edit</button>  <button type="button" ng-click="ctrl.remove(u.userid)" class="btn btn-danger custom-width">Remove</button>
                    </td>
                </tr>
                </tbody>
            </table>
            <nav class="panel-footer">
                <pagination boundary-links="true" total-items="accountsPagination.totalElements" ng-model="currentPage"
                            ng-change="loadingAccountTable(currentPage)" max-size="accountsPagination.size"
                            class="pagination-sm" previous-text="&lsaquo;" items-per-page="accountsPagination.size"
                            next-text="&rsaquo;" first-text="&laquo;" last-text="&raquo;"></pagination>
            </nav>
        </div>

    </div>
</div>



</body>
</html>
