var app = angular.module("myApp", []);


app.config(['$httpProvider', function($httpProvider) {
        $httpProvider.defaults.useXDomain = true;
        delete $httpProvider.defaults.headers.common['X-Requested-With'];
    }
]);



app.controller("getRequest",function($scope,$http){
	
	
	$scope.selectedCategory={};

	$scope.updateGods = function(){
		$http.get("categories")
		.success(function(data, status, headers, config) {
					$scope.gods = data;
					$scope.getCategories();
			    })
                .error(function(error, status, headers, config) {
                    console.log(status);
                    console.log(error);
                    console.log("Error occured");
                });
	}
	
	
    $http.get("categories")
    		.success(function(data, status, headers, config) {
    					$scope.gods = data;
    					$scope.getCategories();
    			    })
                    .error(function(error, status, headers, config) {
                        console.log(status);
                        console.log(error);
                        console.log("Error occured");
                    });
              
  
    $scope.cat = {};

    $scope.getCategories = function(){
     
    	$http.get("allCategories")
    	.success(function(data, status, headers, config) {
    				$scope.cat = data;
    				console.log(data);
                })
                .error(function(error, status, headers, config) {
                    console.log(status);
                    console.log(error);
                    console.log("Error occured");
                });
    }
    
    $scope.song = {};
    $scope.model = function(x, index) {
    	/*$scope.song['category'] = x.category;*/
    	$scope.song = x;
    }
    
    $scope.submitLyrics = function(song) {
    	console.log(JSON.stringify(song));
    	$http({
    		method:'POST',
    		url:'updateLyrics',
    		data:JSON.stringify(song)
    	}) .success(function(data, status, headers, config) {
    		console.log(data)
        })
        .error(function(error, status, headers, config) {
             console.log("Error occured");
        });
    }
    
    $scope.addSong = function(song) {
    	console.log("pavan"+JSON.stringify(song));
    	$http({
    		method:'POST',
    		url:'addSong',
    		data:JSON.stringify(song)
    	}) .success(function(data, status, headers, config) {
    		
        })
        .error(function(error, status, headers, config) {
             console.log("Error occured");
        });
    }
    
    $scope.updateSong = function(song) {
    	console.log(JSON.stringify(song));
    	$http({
    		method:'POST',
    		url:'updateSong',
    		data:JSON.stringify(song)
    	}) .success(function(data, status, headers, config) {
    		console.log(data)
        })
        .error(function(error, status, headers, config) {
             console.log("Error occured");
        });
    }
    
    
    
    
    
    $scope.AppendText = function() {
        var myEl = angular.element( document.querySelector( '#divID' ) );
        myEl.append($scope.song.lyrics_en);     
       }
    
    $scope.changeView = function(view){
        $location.path(view); // path not hash
    }
    
  
    $scope.fetchData = function(category)
                {
    				$scope.selectedCategory = category;
                    $http.get("songs/"+category)
                    .success(function(data, status, headers, config) {
                         $scope.zipCodes = data;
                    })
                    .error(function(error, status, headers, config) {
                         console.log(status);
                        console.log(error);
                         console.log("Error occured");
                    });
                };

    
     $scope.firstName = "John";
        $scope.lastName = "Doe";
    
    $scope.playSong = function(url) {
         
        $("#jquery_jplayer_1").jPlayer({
		ready: function (event) {
			$(this).jPlayer("setMedia", {
				title: "Bubble",
                 mp3: "http://dhasrimedia.com/dev/07RAMAYANAMU%20SRI%20RAMA.mp3"
			});
		},
		swfPath: "js/jplayer",
		supplied: "mp3",
		wmode: "window",
		useStateClassSkin: true,
		autoBlur: false,
		smoothPlayBar: true,
		keyEnabled: true,
		remainingDuration: true,
		toggleDuration: true
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







//============================ Uploader Code =====================================
app.directive('fileModel', ['$parse', function ($parse) {
    return {
        restrict: 'A',
        link: function(scope, element, attrs) {
            var model = $parse(attrs.fileModel);
            var modelSetter = model.assign;

            element.bind('change', function(){
                scope.$apply(function(){
                    modelSetter(scope, element[0].files[0]);
                });
            });
        }
    };
}]);

app.controller('myCtrl', ['$scope', '$http', function($scope, $http){

    $scope.uploadFile = function(){
        var file = $scope.myFile;
        var fd = new FormData();
        fd.append('file', file);
        //We can send anything in name parameter, 
        //it is hard coded to abc as it is irrelavant in this case.
        var uploadUrl = "/uploadFile";
        $http.post(uploadUrl, fd, {
            transformRequest: angular.identity,
            headers: {'Content-Type': undefined}
        })
        .success(function(){
        })
        .error(function(){
        });
    }

}]);