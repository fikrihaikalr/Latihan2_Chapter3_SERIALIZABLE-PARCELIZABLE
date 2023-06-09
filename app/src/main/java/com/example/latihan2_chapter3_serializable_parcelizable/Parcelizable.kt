package com.example.latihan2_chapter3_serializable_parcelizable

import android.os.Parcel
import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.net.Inet4Address


data class User2(
    val name: String,
    val email: String,
    val phone: String,
    val address: String,
    val age: String
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!
    ) {
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(email)
        parcel.writeString(phone)
        parcel.writeString(address)
        parcel.writeString(age)
    }

    companion object CREATOR : Parcelable.Creator<User2> {
        override fun createFromParcel(parcel: Parcel): User2 {
            return User2(parcel)
        }

        override fun newArray(size: Int): Array<User2?> {
            return arrayOfNulls(size)
        }
    }
}