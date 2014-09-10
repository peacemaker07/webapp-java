    //<![CDATA[

	// mapオブジェクト
    var map;
    // styles
    var stylesArray = [{"featureType":"landscape.natural","elementType":"geometry.fill","stylers":[{"visibility":"on"},{"color":"#e0efef"}]},{"featureType":"poi","elementType":"geometry.fill","stylers":[{"visibility":"on"},{"hue":"#1900ff"},{"color":"#c0e8e8"}]},{"featureType":"landscape.man_made","elementType":"geometry.fill"},{"featureType":"road","elementType":"geometry","stylers":[{"lightness":100},{"visibility":"simplified"}]},{"featureType":"road","elementType":"labels","stylers":[{"visibility":"off"}]},{"featureType":"water","stylers":[{"color":"#7dcdcd"}]},{"featureType":"transit.line","elementType":"geometry","stylers":[{"visibility":"on"},{"lightness":700}]}]

    // 写真を選択するボタンを作成
    function HomeControl(controlDiv, map) {
        /* ボタン枠 */
        controlDiv.style.padding = '5px';
        controlDiv.style.backgroundColor = '#c0e8e8';
        controlDiv.style.border = '1px solid #000';
        controlDiv.style.cursor = 'pointer';
        controlDiv.style.textAlign = 'center';

        /* 写真選択ボタン */
        var controlUI = document.createElement('DIV');
        controlUI.style.backgroundColor = '#ffffff';
        controlUI.style.border = '1px solid #000';
        controlUI.style.float = 'left';
        controlUI.style.cursor = 'pointer';
        controlUI.style.textAlign = 'center';
        controlUI.style.marginRight = '5px';
        controlUI.title = '写真選択';
        controlDiv.appendChild(controlUI);

        var controlText = document.createElement('div');
        controlText.style.fontFamily = 'Arial,sans-serif';
        controlText.style.fontSize = '9px';
        controlText.style.padding = '2px 5px';
        controlText.innerHTML = '<b>--写真を選択してください--<b /><br>' +
        						'<form action=getPicture.action method=post enctype="multipart/form-data" align=LEFT>' +
        						'<input type=file name=uploadFile accept=image/* ><br />' +
        						'<input type=submit value=送信>' + 
        						'</form>';
        controlUI.appendChild(controlText);

        /* クリアボタン */
        var controlUI2 = document.createElement('DIV');
        controlUI2.style.float = 'left';
        controlUI2.style.backgroundColor = '#ffffff';
        controlUI2.style.border = '1px solid #000';
        controlUI2.style.cursor = 'pointer';
        controlUI2.style.textAlign = 'center';
        controlUI2.title = 'クリア';
        controlDiv.appendChild(controlUI2);

        var controlText2 = document.createElement('div');
        controlText2.style.fontFamily = 'Arial,sans-serif';
        controlText2.style.fontSize = '9px';
        controlText2.style.padding = '2px 5px';
        controlText2.innerHTML = '<b>クリア</b>';
        controlUI2.appendChild(controlText2);

        /* 写真選択ボタンをクリックした時 */
        google.maps.event.addDomListener(controlUI, 'click', function() {
        });
        /* クリアボタンをクリックした時->初期表示に戻す */
        google.maps.event.addDomListener(controlUI2, 'click', function() {
            init();
        });
    }
    
    // ピンと吹き出しを作成する
    function PicControl(map) {
    	var latlng = new google.maps.LatLng(35.69304, 139.7736108);
    	
    	// Markerの初期設定
        var markerOpts = {
//          position: new google.maps.LatLng(40.1, 139.1),
      	position: latlng,
          map: map,
          title: "marker test"
        };
        
        // 直前で作成したMarkerOptionsを利用してMarkerを作成
        var marker = new google.maps.Marker(markerOpts);
        var contentString=
      	  	"<dl id='infowin1'><dt>松本城</dt>" +
      	  	"<dd><a href=http://localhost:8080/GoogleMapProject/img/DSC_0940.jpg target=_blank><img src='img/DSC_0940.jpg' width=70% height=100% align='left' /></a>" +
      	  	"日時：・・・・<br />" +
      	  	"時間：・・・・<br />" +
      	  	"・・：・・・・<br />"+
        		"・・：・・・・<br />"+
        		"・・：・・・・<br />";
        var infowin = new google.maps.InfoWindow({content:contentString});

        // mouseoverイベントを取得するListenerを追加
        google.maps.event.addListener(marker, 'mouseover', function(){
            infowin.open(map, marker);
          });
    }
    
    // 初期化。bodyのonloadでinit()を指定することで呼び出してます
    function init() {

      // (1) Google Mapで利用する初期設定用の変数
      var latlng = new google.maps.LatLng(35.69304, 139.7736108);
      var opts = {
        zoom: 6,
        mapTypeId: google.maps.MapTypeId.ROADMAP,
        center: latlng,
        styles: stylesArray
      };

      // (2) Mapオブジェクトの生成
      // getElementById("map")の"map"は、body内の<div id="map">より
      map = new google.maps.Map(document.getElementById("map"), opts);
      
      /* 地図上にカスタムコントロール（写真の選択ボタン）を追加 */
      var homeControlDiv = document.createElement('DIV');
      var homeControl = new HomeControl(homeControlDiv, map);
      homeControlDiv.index = 1;
      /* カスタムコントロールを地図の右上に配置 */
      map.controls[google.maps.ControlPosition.TOP_RIGHT].push(homeControlDiv);
    }
    
    // 地図タイプを変更する
    function changeMapType(MapTypeId) {
    	map.setMapTypeId(MapTypeId);
    }
    
    // 地図を出力後、ピンをたてて写真の吹き出しをつくる
    function ReDraw(){
    	init();
    	PicControl(map);
    }
    //]]>
