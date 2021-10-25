package com.example.nasaproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.WindowManager
import com.example.nasaproject.model.Photo
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_pop_up.*

class PopUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pop_up)
        supportActionBar?.title = "Photo Info"

        val dm = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(dm)

        val width = dm.widthPixels *(0.8)
        val height = dm.heightPixels *(0.8)

        //We make sure the popUp doesn't cover the whole screen, but just a fraction of it
        window.setLayout(width.toInt(),height.toInt())

        //We get our photo object and assign its values to views
        val photo = intent.getParcelableExtra<Photo>("photo")
        if(photo!=null){
            Picasso.get().load(photo.img_src).into(popupImage)
            dateOfPhoto.text = "Date: ${photo.earth_date}"
            roverName.text = "Rover Name: ${photo.rover.name}"
            cameraName.text = "Camera Name: ${photo.camera.full_name}"
            missionStatus.text = "Status: ${photo.rover.status}"
            launchDate.text = "Launch Date: ${photo.rover.launch_date}"
            landingDate.text = "Landing Date: ${photo.rover.landing_date}"

        }
    }
}