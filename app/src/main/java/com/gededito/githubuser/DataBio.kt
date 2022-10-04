package com.gededito.githubuser

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class DataBio(
    var username: String,
    var name: String,
    var location: String,
    var repository: String,
    var company: String,
    var followers: String,
    var following: String,
    var photo: Int
): Parcelable