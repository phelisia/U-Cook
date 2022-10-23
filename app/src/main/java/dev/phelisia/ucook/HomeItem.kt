package dev.phelisia.ucook

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class HomeItem(
    var name: String,
    var image: String,
    val description:String
) : Parcelable

