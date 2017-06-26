/**
 * Created by quocnguyen on 31/12/2015.
 */
'use strict';
App.factory('UserService',['$http','$q', function($http,$q){
    return{
        fetchAllUsers: function(){
            return $http.get('http://localhost:8080/user/')
                .then(
                    function(response){
                        return response.data;
                    },
                    function(errResponse){
                        console.error('Error while fetching users');
                        return $q.reject(errResponse);
                    }
                );
        },

        fetchAllUsersPage: function(pageRequest){
            return $http.post('http://localhost:8080/userpage/',pageRequest)
                .then(
                    function(response){
                        return response.data;
                    },
                    function(errResponse){
                        console.error('Error while fetching users');
                        return $q.reject(errResponse);
                    }
                );
        },

        createUser: function(user){
            return $http.post('http://localhost:8080/user/',user)
                .then(
                    function(response){
                        return response.data;
                    },
                    function(errResponse){
                        console.error('Error while creating user');
                        return $q.reject(errResponse);
                    }
                );
        },
        updateUser: function(user, id){
            return $http.put('http://localhost:8080/user/'+id,user)
                .then(
                    function(response){
                        return response.data;
                    },
                    function(errResponse){
                        console.error('Error while update user');
                        return $q.reject(errResponse);
                    }
                );

        }
    };
}]);

