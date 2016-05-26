var app = angular.module("myApp", []);


app.config(['$httpProvider', function($httpProvider) {
        $httpProvider.defaults.useXDomain = true;
        delete $httpProvider.defaults.headers.common['X-Requested-With'];
    }
]);




app.controller("getRequest",function($scope,$http){
               
    $http.get("http://localhost:8080/DevotionalApp/categories")
    		.success(function(data, status, headers, config) {
            
    					$scope.gods = data;
    					console.log(data);
                    })
                    .error(function(error, status, headers, config) {
                         console.log(status);
                        console.log(error);
                         console.log("Error occured");
                    });
              
    
    
    
    $scope.fetchData = function(category)
                {
                    $http.get("http://localhost:8080/DevotionalApp/songs/"+category)
                    .success(function(data, status, headers, config) {
                         $scope.zipCodes = data;
                    })
                    .error(function(error, status, headers, config) {
                         console.log(status);
                        console.log(error);
                         console.log("Error occured");
                    });
                };

    
    $scope.removeTask = function(item){
                    alert("Task Id is "+item);
        };

    
    });

    

    	  
      


      


/*app.controller("getRequest",function($scope,$http){
    
    var url = "http://192.168.30.107:8080/DevotionalApp/songs/ganesh";
        $http({
            method: 'JSONP',
            url: url
        }).
        success(function(status,data) {
            $scope.zipCodes = data;
            console.log("status");
        }).
        error(function(status) {
            //your code when fails
            console.log(status);
        });

});*/




app.controller("myCtrl", function($scope) {
  $scope.records = [
    "pavan",
    "akshay",
    "Centro comercial Moctezuma",
    "Ernst Handel",
  ]
});