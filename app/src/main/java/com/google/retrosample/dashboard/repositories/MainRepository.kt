package com.google.retrosample.dashboard.repositories

import androidx.lifecycle.MutableLiveData
import com.google.retrosample.dashboard.models.Fruit


class MainRepository {
    val fruits = mutableListOf<Fruit>()
    val selectedfruits = mutableMapOf<String, Fruit>()
    val mutablefruitList = MutableLiveData<Map<String, Fruit>>()
    val selectedMutablefruitList = MutableLiveData<Map<String, Fruit>>()

    init {
        selectedfruits.put("Apple", Fruit("Apple", 0))
        selectedfruits.put("Orange", Fruit("Orange", 0))
        selectedfruits.put("Mango", Fruit("Mango", 0))

        mutablefruitList.postValue(selectedfruits)
    }

    fun addFruits(fruit: Fruit) {
        selectedfruits.put(fruit.name, fruit)
        mutablefruitList.postValue(selectedfruits)
    }

    fun minusFruits(fruit: Fruit) {
        selectedfruits.put(fruit.name, fruit)
        mutablefruitList.postValue(selectedfruits)
    }
}