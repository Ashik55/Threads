package com.threads.app.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Post(
    val id: Int,
    val imageUrl: String?,
    val type: String?,
    val title: String?,
    val videoUrl: String?,
    val description: String?
) : Parcelable