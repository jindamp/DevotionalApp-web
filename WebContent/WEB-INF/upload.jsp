<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>

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
</head>
<body ng-app="myApp">

	<!-- <form method="POST" action="uploadFile" enctype="multipart/form-data">
		File to upload: <input type="file" name="file"><br /> 
		Name: <input type="text" name="name"><br /> <br /> 
		<input type="submit" value="Upload"> Press here to upload the file!
	</form>
	 -->
	 
	 
	 <div ng-controller="myCtrl">
        <input type="file" file-model="myFile" />
        <button ng-click="uploadFile()">upload me</button>
    </div>
	 
	 
	
	
	     </-- <script src="<c:url value="resources/js/angular.min.js" />"></script> -->
    	<script src="https://use.fontawesome.com/c76c5cdd32.js"></script>
        <script src="<c:url value="resources/js/jquery.min.js" />"></script>
        <script src="<c:url value="resources/js/bootstrap.min.js" />"></script>
        <script src="<c:url value="resources/js/scripts.js" />"></script>
	 
</body>
</html>