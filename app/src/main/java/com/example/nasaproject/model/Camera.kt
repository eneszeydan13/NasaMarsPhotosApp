package com.example.nasaproject.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Camera(
    val full_name: String,
    val id: Int,
    val name: String,
    val rover_id: Int
):Parcelable