package com.udacity.shoestore.screens

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeViewModel: ViewModel() {

    // Create a list of all shoes
    private val shoeList = listOf(
        Shoe(
            "Casual High Top", 6.0, "Converse", "Black high top", listOf("converse")
        ),

        Shoe(
            "Sport Sneaker", 5.0, "Adidas", "White sport sneaker", listOf("adidas")
        ),

        Shoe(
            "Casual Sneaker ", 5.0, "Lacoste", "White casual sneaker", listOf("lacoste")
        ),

        Shoe(
            "Canvas High Top", 5.0, "Penguin", "Navy canvas high top", listOf("penguin")
        ),

        Shoe(
            "Casual shoe", 5.0, "Oca", "Yellow casual shoe", listOf("oca")
        )
    )

    private val _selectedShoe = MutableLiveData<Shoe>()
    val selectedShoe: LiveData<Shoe>
        get() = _selectedShoe


}