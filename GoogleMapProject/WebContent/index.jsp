<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<style type="text/css">
      html { height: 100% }
      body { height: 100%; margin: 0px; padding: 0px }
      #map { height: 100% }
    </style>
    
    <script src="http://maps.google.com/maps/api/js?v=3&sensor=false&language=ja"
        type="text/javascript" charset="UTF-8"></script>

	<script type="text/javascript" src="map.js">
    </script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>GoogleMap × Exif</title>
</head>
<body onload="init()">
	<div id="map"></div>
</body>
</html>