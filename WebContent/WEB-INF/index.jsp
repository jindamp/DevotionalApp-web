<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%-- <%@ page contentType="text/html; charset=UTF-8" %> --%>
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
        
        <script type="text/javascript" src="/resources/jplayer/jquery.jplayer.min.js"></script>
        
        <title>Insert title here</title>
    </head>
<!-- ******************* End Header **************************** -->        
    
    
    <body ng-app="myApp">
        
     <div class="container-fluid">

         <!-- ******************* Audio Player **************************** -->                 
        <div class="row">
            <div class="col-md-12 music-player" >
                <b class="play-song">Heading to play Song</b>

<button style="float: right;vertical-align: middle; margin-top:16px; " type="button" class="btn btn-info btn-md" data-toggle="modal" ng-click="getCategories()" data-target="#myModal">Add Song</button>
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
                 <a ng-click="playSong(x.path);" href="#"><img class="image" src="http://icons.iconarchive.com/icons/cornmanthe3rd/plex/512/Media-play-music-icon.png" alt="Mountain View"></a>
                <div data-toggle="modal" data-ng-click="model(x, $index)" data-target="#lyricsModal" style="position: absolute; bottom:0;margin-bottom:58px;right:0;padding:8px;"><i class="fa fa-wpforms fa-lg" aria-hidden="true"></i></div>
                <div data-toggle="modal" data-ng-click="model(x, $index)" data-target="#editModal" style="position: absolute; top:0;margin-bottom:58px;right:0;padding:8px;"><i class="fa fa-pencil fa-lg" aria-hidden="true"></i></div>   
                </div>
            
                <div class="song-footer" style="height:30%;width:100%">Title : {{x.title}}</div>
                
                
</div>


                   </div>


                </div>
<!-- ******************* End Main COntent **************************** -->         
        
<!-- ******************* Upload Modal  **************************** -->        
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
              <!-- <input id="Category" name="Category"  data-ng-model="insertSong.category" type="text" placeholder="ex: Ganesh" class="form-control input-md" required=""> -->
					<select ng-model="pavan.category" class="form-control input-md" ng-options="item for item in cat"></select>
				</div>
            </div>

            <!-- Text input-->
            <div class="form-group">
              <label class="col-md-4 control-label" for="Title">Title</label>  
              <div class="col-md-6">
              <input id="Title" name="Title" data-ng-model="pavan.title" type="text" placeholder="Song Title" class="form-control input-md" required="">

              </div>
            </div>
            
            
            <!-- Text input-->
            <div class="form-group">
              <label class="col-md-4 control-label" for="Title_Telugu">Title Telugu</label>  
              <div class="col-md-6">
              <input id="Title_Telugu" name="Title_Telugu" data-ng-model="pavan.title_telugu" type="text" placeholder="Song Title in telugu" class="form-control input-md" required="">

              </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
              <label class="col-md-4 control-label" for="album">Album</label>  
              <div class="col-md-6">
              <input id="album" name="album" data-ng-model="pavan.album" type="text" placeholder="Song Album" class="form-control input-md" required="">
			   	
              </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
              <label class="col-md-4 control-label" for="artist">Artist</label>  
              <div class="col-md-6">
              <input id="artist" name="artist" data-ng-model="pavan.artist" type="text" placeholder="Song Artist" class="form-control input-md" required="">

              </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
              <label class="col-md-4 control-label" for="composer">Composer</label>  
              <div class="col-md-6">
              <input id="composer" name="composer" data-ng-model="pavan.composer" type="text" placeholder="song composer" class="form-control input-md">

              </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
              <label class="col-md-4 control-label" for="duration">Duration</label>  
              <div class="col-md-6">
              <input id="duration" name="duration" data-ng-model="pavan.duration" type="text" placeholder="Time in Minutes" class="form-control input-md">

              </div>
            </div>

            <!-- Textarea -->
            <div class="form-group">
              <label class="col-md-4 control-label" for="url">URL</label>
              <div class="col-md-6">                     
                <textarea class="form-control" data-ng-model="pavan.path" id="url" name="url">Song Url</textarea>
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
                <button id="Submit" ng-click="addSong(pavan)" name="Submit" class="btn btn-primary" data-dismiss="modal">Submit</button>
            </div>
	</form>
            
            
        </div>
        
      </div>
      
    </div>
  </div>
<!-- End Modal -->            
        
<!-- ******************* End Upload Modal  **************************** -->        

<!-- ******************* Edit Modal  **************************** -->        
        <!-- Modal -->
  <div class="modal fade" id="editModal" role="dialog" >
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Update Lyrics</h4>
        </div>
        <div class="modal-body">
			<form class="form-horizontal form-background">
        
              <fieldset>


            <!-- Text input-->
            <div class="form-group">
              <label class="col-md-4 control-label" for="Category">Category</label>  
              <div class="col-md-6">
              <!-- <input id="Category" name="Category" data-ng-model="song.category" type="text" placeholder="ex: Ganesh" class="form-control input-md" required=""> -->

				<select data-ng-selected="{{song.category}}" data-ng-model="song.category" class="form-control input-md">
				<option data-ng-repeat="item in cat">{{item}}</option>
				</select>

              </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
              <label class="col-md-4 control-label" for="Title">Title</label>  
              <div class="col-md-6">
              <input id="Title" name="Title" data-ng-model="song.title" type="text" placeholder="Song Title" class="form-control input-md" required="">

              </div>
            </div>
            
            <!-- Text input-->
            <div class="form-group">
              <label class="col-md-4 control-label" for="Title">Title Telugu</label>  
              <div class="col-md-6">
              <input id="Title_Telugu" name="Title_Telugu" data-ng-model="song.title_telugu" type="text" placeholder="Song Title in telugu" class="form-control input-md" required="">
				</div>
            </div>

            <!-- Text input-->
            <div class="form-group">
              <label class="col-md-4 control-label" for="album">Album</label>  
              <div class="col-md-6">
              <input id="album" name="album" data-ng-model="song.album" type="text" placeholder="Song Album" class="form-control input-md" required="">

              </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
              <label class="col-md-4 control-label" for="artist">Artist</label>  
              <div class="col-md-6">
              <input id="artist" name="artist" data-ng-model="song.artist" type="text" placeholder="Song Artist" class="form-control input-md" required="">

              </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
              <label class="col-md-4 control-label" for="composer">Composer</label>  
              <div class="col-md-6">
              <input id="composer" name="composer" data-ng-model="song.composer" type="text" placeholder="song composer" class="form-control input-md">

              </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
              <label class="col-md-4 control-label" for="duration">Duration</label>  
              <div class="col-md-6">
              <input id="duration" name="duration" data-ng-model="song.duration" type="text" placeholder="Time in Minutes" class="form-control input-md">

              </div>
            </div>

            <!-- Textarea -->
            <div class="form-group">
              <label class="col-md-4 control-label" for="url">URL</label>
              <div class="col-md-6">                     
                <textarea class="form-control" id="url" name="url" data-ng-model="song.path">Song Url</textarea>
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
                <button id="Submit" ng-click="updateSong(song)" name="Submit" class="btn btn-primary" data-dismiss="modal">Submit</button>
            </div>
	</form>
            
            
        </div>
        
      </div>
      
    </div>
  </div>
<!-- End Modal -->            
        
<!-- ******************* End Edit Modal  **************************** -->              


<!-- ******************* Lyrics Modal  **************************** -->        
        <!-- Modal -->
  <div class="modal fade" id="lyricsModal" role="dialog" >
    <div class="modal-dialog">
    
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Upload Song</h4>
        </div>
        <div class="modal-body">
               <form class="form-horizontal form-background">
               <div class="row">
               <div class="col-md-1"></div>
                <div class="col-md-6">
               <div class="form-group">
                <textarea data-ng-model="song.lyrics_en" rows="10" name="english" cols="65"></textarea>
                </div>
            </div>
            </div>
            <div class="row">
            <div class="col-md-1"></div>
              <div class="col-md-6">
              <div class="form-group">
                <textarea data-ng-model="song.lyrics_telugu" rows="10" name="telugu" cols="65"></textarea>
                </div>
              </div>
            </div>
          <!-- Button -->
            <div class="form-group modal-footer">
              <label class="col-md-4 control-label" for="Submit"></label>
                <button id="Submit" data-ng-click="submitLyrics(song)" name="Submit" class="btn btn-primary" data-dismiss="modal">Submit</button>
            
            <!-- submitLyrics(song) -->
            </div>
	</form>
            
            
        </div>
        
      </div>
      
    </div>
  </div>
<!-- End Modal -->            
        
<!-- ******************* End Edit Modal  **************************** -->    
        
        <!-- ******************* Lyrics Display Modal  **************************** -->        
        <!-- Modal -->
  <div class="modal fade" id="displayLyrics" role="dialog" >
    <div class="modal-dialog">
    
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Song lyrics</h4>
        </div>
        <div class="modal-body">
        	<div class="container">
        		<div class="row">
        		<ul class="nav nav-tabs">
  <li class="active"><a href="#">Home</a></li>
  <li><a href="#">Menu 1</a></li>
  <li><a href="#">Menu 2</a></li>
  <li><a href="#">Menu 3</a></li>
</ul>
        			<div class="col-md-6">{{song.lyrics_en}}</div>   
            		<div class="col-md-6">{{song.lyrics_en}} </div>
        		</div>
        		
        	</div>
            
            
        </div>
        
      </div>
      
    </div>
  </div>
<!-- End Modal -->   
        
        </div>

    </div>

        </-- <script src="<c:url value="resources/js/angular.min.js" />"></script> -->
        
        
		<script src="https://use.fontawesome.com/c76c5cdd32.js"></script>
        <script src="<c:url value="resources/js/jquery.min.js" />"></script>
        <script src="<c:url value="resources/js/bootstrap.min.js" />"></script>
        <script src="<c:url value="resources/js/scripts.js" />"></script>

    </body>
</html>