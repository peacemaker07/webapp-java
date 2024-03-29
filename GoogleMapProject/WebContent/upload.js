    //<![CDATA[

	// Create a div to hold the control.
	var controlDiv = document.createElement('div');
	
	// Set CSS styles for the DIV containing the control
	// Setting padding to 5 px will offset the control
	// from the edge of the map.
	controlDiv.style.padding = '5px';
	
	// Set CSS for the control border.
	var controlUI = document.createElement('div');
	controlUI.style.backgroundColor = 'white';
	controlUI.style.borderStyle = 'solid';
	controlUI.style.borderWidth = '2px';
	controlUI.style.cursor = 'pointer';
	controlUI.style.textAlign = 'center';
	controlUI.title = 'Click to set the map to Home';
	controlDiv.appendChild(controlUI);
	
	// Set CSS for the control interior.
	var controlText = document.createElement('div');
	controlText.style.fontFamily = 'Arial,sans-serif';
	controlText.style.fontSize = '12px';
	controlText.style.paddingLeft = '4px';
	controlText.style.paddingRight = '4px';
	controlText.innerHTML = '<strong>Home</strong>';
	controlUI.appendChild(controlText);

	// Setup the click event listener: simply set the map to center on Chicago
	var chicago = new google.maps.LatLng(41.850033, -87.6500523);

	google.maps.event.addDomListener(outer, 'click', function() {
	  map.setCenter(chicago)
	});
	//]]>
