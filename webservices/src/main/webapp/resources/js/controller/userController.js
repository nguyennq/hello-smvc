/**
 * Created by quocnguyen on 31/12/2015.
 */
'use strict';
App.controller('UserController',['$scope','UserService',function($scope,UserService){
    var self = this;
    self.user = {userId:null, name: '', age:0, salary:0.0 };
    self.users =[];

    $scope.totalItems = 64;
    $scope.currentPage = 4;
    $scope.maxSize = 5;

    $scope.setPage = function (pageNo) {
        $scope.currentPage = pageNo;
    };

    $scope.bigTotalItems = 175;
    $scope.bigCurrentPage = 1;

    $scope.currentPage = 0;

    $scope.accountsPagination = {};

    $scope.accountRequest = {
        pageSize: 2,
        pageOffset: 0,
        orderBy: 'userid',
        isAscend: false
    };

    self.fetchAllUsers = function(){
        UserService.fetchAllUsers()
            .then(
                function(d){
                    console.log(d);
                    self.users = d.body;
                },
                function(errResponse){
                    console.error('Error while fetching Currencies');
                }
            );
    };
    self.createUser = function(user){
        UserService.createUser(user)
            .then(
                self.fetchAllUsers,
                function(errResponse){
                    console.error('Error while creating User.');
                }
            );
    };
    self.updateUser = function(user, id){
        UserService.updateUser(user, id)
            .then(
                self.fetchAllUsers,
                function(errResponse){
                    console.error('Error while updating User.');
                }
            )
    };
    self.fetchAllUsers();

    self.submit = function(){
        if(self.user.userId === null){
            console.log('Saving New User', self.user);
            self.createUser(self.user);
        }
        else {
            self.updateUser(self.user, self.user.id);
            console.log('User update with id ',self.user.id);
        }
        self.reset();
    }

    getAllAccount();

    $scope.loadingAccountTable = function (index) {
        console.log("loading data: " + index);
        $scope.accountRequest.pageOffset = index - 1;
        getAllAccount()
    }

    function getAllAccount(){
        UserService.fetchAllUsersPage($scope.accountRequest).then(
            function (data) {
                console.log(data);
                $scope.accountsPagination = data.body;
            },
            function (error) {

            }
        );
    }
}]);
