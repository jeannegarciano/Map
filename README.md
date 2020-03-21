# Map
It is a simple android mobile application that shows Ontario College of Teachers location in the map. The mobile application looks like this: 


![map](https://user-images.githubusercontent.com/13115198/77228467-b43dd500-6bc2-11ea-8413-e6d4e0759ef6.png)

This is the code for setting the langitude and longitude:

    LatLng ontario = new LatLng(43.6691, -79.3913);
 
This is the code to play around the camera which includes moving, zoom in and zoom out:

    @Override
        public void onMapReady(GoogleMap googleMap) {
            mMap = googleMap;

            LatLng ontario = new LatLng(43.6691, -79.3913);
            mMap.moveCamera(CameraUpdateFactory.newLatLng(ontario));
            mMap.getMaxZoomLevel();

            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(ontario, 15));
            // Zoom in, animating the camera.
            mMap.animateCamera(CameraUpdateFactory.zoomIn());

            // Zoom out to zoom level 10, animating with a duration of 2 seconds.
            mMap.animateCamera(CameraUpdateFactory.zoomTo(10), 2000, null);
            CameraPosition cameraPosition = new CameraPosition.Builder()
                    .target(ontario)      // Sets the center of the map to Mountain View
                    .zoom(17)                   // Sets the zoom
                    .bearing(90)                // Sets the orientation of the camera to east
                    .tilt(30)                   // Sets the tilt of the camera to 30 degrees
                    .build();                   // Creates a CameraPosition from the builder
            mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
        }
       
  This is how you add marker to target location:
  
     mMap.addMarker(new MarkerOptions().position(ontario).title("Ontario College of Teachers"));
     
  Lastly, I added lines of code to handle onBackPressed button so that when the user clicks the hardware back button, it will not show the splashscreen: 
  
    @Override
    public void onBackPressed() {
        startActivity(new Intent(this, MapsActivity.class));
        moveTaskToBack(true);
    }
