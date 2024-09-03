package com.example.viewmodelwork

import androidx.annotation.DrawableRes

data class WorkUIState(
    @DrawableRes
    val diceOne: Int? = null,
    @DrawableRes
    val diceTwo: Int = R.drawable.dice_one,
    val numberOfRolls: Int = 0,
    val dicesAreEqual: Boolean? = null
)
