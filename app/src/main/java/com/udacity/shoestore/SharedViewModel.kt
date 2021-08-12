package com.udacity.shoestore

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe


class SharedViewModel: ViewModel() {

    // shoe list live data collection
    private val _shoeList = MutableLiveData<MutableList<Shoe>>()
    val shoeList: LiveData<MutableList<Shoe>>
        get() = _shoeList //externally accessible getter

    //initialize live data value and sample shoe item
    init {
        _shoeList.value = mutableListOf()
        val shoeItem = Shoe("Name", "Company", "5", "Example Shoe")
        addShoeItem(shoeItem)
    }

    //called when the view model instance is destroyed
    override fun onCleared() {
        super.onCleared()
        Log.i("SharedViewModel","SharedViewModel destroyed")
    }

    //adds a shoe item to the shoeList collection
    fun addShoeItem(shoeItem: Shoe) {
        _shoeList.value?.let { shoeList ->
            shoeList.add(shoeItem)
        }
    }

}