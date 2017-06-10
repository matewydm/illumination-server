function initMap() {
    var mapProp= {
        center:new google.maps.LatLng(50.067396,19.918584),
        zoom:17,
    };
   var map = new google.maps.Map(document.getElementById('map'),mapProp);
   var geocoder = new google.maps.Geocoder();

    map.addListener('click', function(e) {
        var latlng = {lat: e.latLng.lat(), lng: e.latLng.lng()};

        geocoder.geocode({'location':latlng }, function(results, status) {
            $("#name").val( results[0].formatted_address);
            $("#latitude").val(results[0].geometry.location.lat());
            $("#longitude").val(results[0].geometry.location.lng());
            $("#country").val(results[0].address_components[6].short_name);
            $("#city").val(results[0].address_components[3].short_name);
            $("#street").val(results[0].address_components[1].short_name);

        console.log("asd")

    });

            console.log("asd")
    });


}