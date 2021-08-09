package com.udacity.shoestore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.udacity.shoestore.databinding.FragmentShoeItemDetailsBinding

class ShoeItemDetailsFragment: Fragment() {

    private lateinit var binding: FragmentShoeItemDetailsBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        // Inflate the layout for this fragment
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_item_details, container, false)

//        binding.cancelButton.setOnClickListener (
//            activity?.onBackPressed()
//
//        )

        return binding.root
    }


}