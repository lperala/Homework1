package com.example.homework1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.os.PersistableBundle
import android.view.LayoutInflater
import com.example.homework1.databinding.ActivityMainBinding
import com.example.homework1.databinding.ActivityMapBinding
import com.example.homework1.databinding.ActivityMenuBinding
import com.google.android.gms.maps.CameraUpdateFactory

import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MapStyleOptions
import com.google.android.gms.maps.model.MarkerOptions
import java.util.*


class MapActivity : AppCompatActivity(), OnMapReadyCallback{

    private lateinit var map: GoogleMap
    private val TAG = MapActivity::class.java.simpleName
    private val REQUEST_LOCATION_PERMISSION = 1

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_map)
        val mapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        map = googleMap

        val oulu = LatLng(65.00, 25.44)
        val zoomLevel = 15f
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(oulu, zoomLevel))
        map.addMarker(MarkerOptions().position(oulu))

        setMapLongClick(map)
    }

    private fun setMapLongClick(map: GoogleMap) {
        map.setOnMapLongClickListener {

            val latitude = it.latitude
            val longitude = it.longitude

            println("LAT: " + latitude + " LNG: " + longitude)
            map.addMarker(MarkerOptions().position(LatLng(latitude,longitude)))
            /*
            map.addMarker(
                MarkerOptions()
                    .position(it)
                    .title(getString(R.drawable.ic_commute_24px))
                    .snippet(snippet)
            )
             */
        }
    }
}