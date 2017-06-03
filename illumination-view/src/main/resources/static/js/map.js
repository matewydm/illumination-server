var map;
function initMap() {
    map = new google.maps.Map(document.getElementById('map'), {
        center: {lat: 50.067396, lng: 19.918584},
        zoom: 17
    });
    for (var index in lampList) {
        var lamp = lampList[index];
        console.log(lamp);
        var latitude = lamp.addressData.latitude;
        var longitude = lamp.addressData.longitude;
        var lampCircle = new google.maps.Circle({
            strokeColor: color(),
            strokeOpacity: 0.8,
            strokeWeight: 2,
            fillColor: color(),
            fillOpacity: 0.35,
            map: map,
            center: {lat: latitude, lng: longitude},
            radius: 3
        });
        var infoWindow= new google.maps.InfoWindow({
            content: lamp.description
        });
        google.maps.event.addListener(lampCircle, 'click', function(ev){
            infoWindow.setPosition(lampCircle.getCenter());
            infoWindow.open(map);
        });
        function color() {
            switch(lamp.status) {
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
        }
    }
}