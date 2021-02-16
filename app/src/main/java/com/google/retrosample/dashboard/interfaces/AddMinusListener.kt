package com.google.retrosample.dashboard.interfaces

import com.google.retrosample.dashboard.models.Fruit

interface AddMinusListener {
    fun addItem(fruit: Fruit)
    fun minusItem(fruit: Fruit)
}