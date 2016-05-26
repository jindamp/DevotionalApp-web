<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    
<!-- ******************* Header **************************** -->        
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="author" content="pavan Jindam!">

        <script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
        <script src="<c:url value="/resources/js/main.js" />"></script>
        <script src="http://code.jQuery.com/jQuery-latest.js" type="text/javascript"></script>
        
        <link href="<c:url value="/resources/css/bootstrap.min.css"/>" rel="stylesheet">
        <link href="<c:url value="/resources/css/style.css"/>" rel="stylesheet">
        <link href="<c:url value="/resources/css/search_btn.css"/>" rel="stylesheet">
        
        <title>Insert title here</title>
    </head>
<!-- ******************* End Header **************************** -->        
    
    
    <body ng-app="myApp">
        
     <div class="container-fluid">

         <!-- ******************* Audio Player **************************** -->                 
        <div class="row">
            <div class="col-md-12 music-player" >
                <b class="play-song">Heading to play Song</b>

    <!--
                <audio controls="controls">
                  <source src="track.ogg" type="audio/ogg" />
                  <source src="track.mp3" type="audio/mpeg" />
                            Your browser does not support the audio element.
                </audio>
    -->

            </div>
        </div>
         <!-- ******************* End Audio Player **************************** -->        

         <!-- ******************* Side Bar **************************** -->        
    <div class="row navigation" ng-controller="getRequest">
        <div class="col-sm-2 side-menu">
        <div class="sidebar-nav need-margin">
          <div class="navbar navbar-default" role="navigation">
            <div class="navbar-header">
              <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".sidebar-navbar-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
              </button>
              <span class="visible-xs navbar-brand">Sidebar menu</span>
            </div>
            <div class="navbar-collapse collapse sidebar-navbar-collapse">
              <ul class="nav navbar-nav" >

                <li style="margin-bottom:16px; margin:8px; "> <form>
                    <div class="box">
                        <div class="container-4">
                        <input type="search" id="search" placeholder="Search..." />
                        <button class="icon"><i class="fa fa-search"></i></button>
                    </div>
                    </div>
                </form>  </li>  
                <li class="active"><a  ng-click="fetchData('shiva');"  href="#">Menu Item 1</a></li>

                <li><a href="#">Menu Item 2</a></li>
                  
                <li ng-repeat="god in gods" ng-click="fetchData(god);"><a href="#">{{god}}</a></li>

                <li><a href="#">Reviews <span class="badge">1,118</span></a></li>
              </ul>
            </div><!--/.nav-collapse -->
          </div>
        </div>
      </div>
<!-- ******************* End Side Bar **************************** --> 

<!-- ******************* MAin Content **************************** -->         
        <div class="col-sm-10">
            <div class="row">

                <div class="col-md-2 song"  ng-repeat="x in zipCodes">
                         Hello {{x.title}}!
                </div>

                   </div>


                </div>
<!-- ******************* End Main COntent **************************** -->         
        </div>

    </div>

        </-- <script src="<c:url value="resources/js/angular.min.js" />"></script> -->
        <script src="<c:url value="resources/js/jquery.min.js" />"></script>
        <script src="<c:url value="resources/js/bootstrap.min.js" />"></script>
        <script src="<c:url value="resources/js/scripts.js" />"></script>

    </body>
</html>