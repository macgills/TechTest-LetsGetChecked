package com.example.letsgetcheckedapplication.extensions

import android.view.LayoutInflater
import android.view.ViewGroup

internal fun ViewGroup.inflate(layoutId: Int, attachToRoot: Boolean = false) =
    LayoutInflater.from(context).inflate(layoutId, this, attachToRoot)