function initMap() {
    map = new google.maps.Map(document.getElementById('map'), {
        center: {lat: 50.067396, lng: 19.918584},
        zoom: 17
    });
    setCircle(map, lampList);

    // for (var index in lampList) {
    //     var lamp = lampList[index];
    //     console.log(lamp);
    //     var latitude = lamp.addressData.latitude;
    //     var longitude = lamp.addressData.longitude;
    //     var lampCircle = new google.maps.Circle({
    //         strokeColor: color(),
    //         strokeOpacity: 0.8,
    //         strokeWeight: 2,
    //         fillColor: color(),
    //         fillOpacity: 0.35,
    //         map: map,
    //         center: {lat: latitude, lng: longitude},
    //         radius: 3
    //     });
    //     var infoWindow= new google.maps.InfoWindow({
    //         content: lamp.description
    //     });
    //     google.maps.event.addListener(lampCircle, 'click', function(ev){
    //         infoWindow.setPosition(lampCircle.getCenter());
    //         infoWindow.open(map);
    //     });

    // }
}


function setCircle(map, lamps) {
    var infoWindow = new google.maps.InfoWindow();
    for (i = 0; i < lamps.length; i++) {
        var lat = lamps[i].addressData.latitude;
        var long = lamps[i].addressData.longitude;
        var content = lamps[i].description;
        var latlngset = new google.maps.LatLng(lat, long);

        var lampCircle = new google.maps.Circle({
            path: google.maps.SymbolPath.CIRCLE,
            strokeColor: color(lamps[i]),
            strokeOpacity: 0.8,
            strokeWeight: 2,
            fillColor: color(lamps[i]),
            fillOpacity: 0.35,
            map: map,
            position: latlngset,
            center: {lat: lat, lng: long},
            scale: 100,
            radius: 3
        });
        google.maps.event.addListener(lampCircle, 'click', (function (lampCircle, i) {
            return function () {
                infoWindow.setContent('<a href="/light/create/' +lamps[i].id +'">Click here</a>');
                infoWindow.setPosition(lampCircle.getCenter());
                infoWindow.open(map);
            }
        })(lampCircle, i));
    }

    function color(l) {
        switch (l.status) {
            case WORKING:
                return '#FFE600';
                break;
            case BROKEN:
                return '#FF0000';
                break;
            case NOT_WORKING:
                return '#000000';
                break;
            default:
                return '#09FF00';
        }
    };


}