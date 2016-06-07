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

<button style="float: right;vertical-align: middle; margin-top:16px; " type="button" class="btn btn-info btn-md" data-toggle="modal" data-target="#myModal">Add Song</button>
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
                
                  <!--<li class="active"><a  ng-click="fetchData('shiva');"  href="#">Menu Item 1</a></li>
                  <li><a href="#">Menu Item 2</a></li>
                  <li><a href="#">Reviews <span class="badge">1,118</span></a></li>  -->
                
                  <!-- ************************* Navbar Items  ********************************* -->
                  <li ng-repeat="god in gods" ng-click="fetchData(god[0].category);"><a href="#">{{god[0].category}}</a></li>

                
              </ul>
            </div><!--/.nav-collapse -->
          </div>
        </div>
      </div>
<!-- ******************* End Side Bar **************************** --> 

<!-- ******************* Main Content **************************** -->         
        <div class="col-sm-10">
            <div class="row">

                <!-- <div class="col-md-2 song"  ng-repeat="x in zipCodes">
                         Hello {{x.title}}!
                </div> -->


				<div class="col-sm-2 song-main" ng-repeat="x in zipCodes">
                
               <div style=" height:70%; width:100%" class="song-img">
                 <a href="#"><img class="image" src="http://icons.iconarchive.com/icons/cornmanthe3rd/plex/512/Media-play-music-icon.png" alt="Mountain View"></a>
                <div data-toggle="modal" data-target="#myModal" style="position: absolute; bottom:0;margin-bottom:58px;right:0;padding:8px;"><i class="fa fa-pencil fa-lg" aria-hidden="true"></i></div>
                </div>
            
                <div class="song-footer" style="height:30%;width:100%">Title : {{x.title}}</div>
                
                
            </div>


                   </div>


                </div>
<!-- ******************* End Main COntent **************************** -->         
        
<!-- ******************* Sign-Up Modal  **************************** -->        
        <!-- Modal -->
  <div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Upload Song</h4>
        </div>
        <div class="modal-body">
          
          
               <form class="form-horizontal form-background">
        
              <fieldset>

            <!-- Text input-->
            <div class="form-group">
              <label class="col-md-4 control-label" for="Category">Category</label>  
              <div class="col-md-6">
              <input id="Category" name="Category" type="text" placeholder="ex: Ganesh" class="form-control input-md" required="">

              </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
              <label class="col-md-4 control-label" for="Title">Title</label>  
              <div class="col-md-6">
              <input id="Title" name="Title" type="text" placeholder="Song Title" class="form-control input-md" required="">

              </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
              <label class="col-md-4 control-label" for="album">Album</label>  
              <div class="col-md-6">
              <input id="album" name="album" type="text" placeholder="Song Album" class="form-control input-md" required="">

              </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
              <label class="col-md-4 control-label" for="artist">Artist</label>  
              <div class="col-md-6">
              <input id="artist" name="artist" type="text" placeholder="Song Artist" class="form-control input-md" required="">

              </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
              <label class="col-md-4 control-label" for="composer">Composer</label>  
              <div class="col-md-6">
              <input id="composer" name="composer" type="text" placeholder="song composer" class="form-control input-md">

              </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
              <label class="col-md-4 control-label" for="duration">Duration</label>  
              <div class="col-md-6">
              <input id="duration" name="duration" type="text" placeholder="Time in Minutes" class="form-control input-md">

              </div>
            </div>

            <!-- Textarea -->
            <div class="form-group">
              <label class="col-md-4 control-label" for="url">URL</label>
              <div class="col-md-6">                     
                <textarea class="form-control" id="url" name="url">Song Url</textarea>
              </div>
            </div>

            <!-- File Button --> 
            <div class="form-group">
              <label class="col-md-4 control-label" for="filebutton">File Button</label>
              <div class="col-md-6">
                <input id="filebutton" name="filebutton" class="input-file" type="file">
              </div>
            </div>

            <!-- Button 
            <div class="form-group">
              <label class="col-md-4 control-label" for="Submit"></label>
              <div class="col-md-6">
                <button id="Submit" name="Submit" class="btn btn-primary">Submit</button>
              </div>
            </div>-->

            </fieldset>
        
          <!-- Button -->
            <div class="form-group modal-footer">
              <label class="col-md-4 control-label" for="Submit"></label>
                <button id="Submit" name="Submit" class="btn btn-primary" data-dismiss="modal">Submit</button>
            </div>
        
                   
</form>
            
            
        </div>
        
      </div>
      
    </div>
  </div>
<!-- End Modal -->            
        
<!-- ******************* End Sign-Up Modal  **************************** -->        
        
        </div>

    </div>

        </-- <script src="<c:url value="resources/js/angular.min.js" />"></script> -->
        
        
		<script src="https://use.fontawesome.com/c76c5cdd32.js"></script>
        <script src="<c:url value="resources/js/jquery.min.js" />"></script>
        <script src="<c:url value="resources/js/bootstrap.min.js" />"></script>
        <script src="<c:url value="resources/js/scripts.js" />"></script>

    </body>
</html>