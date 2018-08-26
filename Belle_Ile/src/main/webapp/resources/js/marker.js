/**
 * Ajout de marker
 */
var markers = new OpenLayers.Layer.Markers( "Markers" );
map.addLayer(markers);

var size = new OpenLayers.Size(21,25);
var offset = new OpenLayers.Pixel(-(size.w/2), -size.h);
var icon = new OpenLayers.Icon('http://www.openlayers.org/dev/img/marker.png', size, offset);

markers.addMarker(new OpenLayers.Marker(new OpenLayers.LonLat(0,0),icon));
markers.addMarker(new OpenLayers.Marker(new OpenLayers.LonLat(0,0),icon.clone()));
