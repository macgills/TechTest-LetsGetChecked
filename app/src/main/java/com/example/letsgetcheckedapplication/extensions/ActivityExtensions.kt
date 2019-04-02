package com.example.letsgetcheckedapplication.extensions

import android.app.Activity
import android.content.Intent
import android.os.Parcelable

internal inline fun <reified T> Activity.startActivity(vararg parcelables: Parcelable) {
    startActivity(
        Intent(this, T::class.java).apply {
            parcelables.forEach {
                putExtra(it.javaClass.canonicalName, it)
            }
        }
    )
}