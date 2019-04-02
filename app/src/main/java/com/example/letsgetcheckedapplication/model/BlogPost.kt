package com.example.letsgetcheckedapplication.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class BlogPost(
    val id: Int,
    val title: String,
    val author: String,
    val publish_date: String,
    val slug: String,
    val description: String,
    val content: String
) : Parcelable
