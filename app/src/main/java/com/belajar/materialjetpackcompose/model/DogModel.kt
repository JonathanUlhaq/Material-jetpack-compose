package com.belajar.materialjetpackcompose.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class DogModel (
    @DrawableRes val gambar:Int,
    @StringRes val tulisan:Int,
    val umur:Int,
    @StringRes val hobi:Int
        )