package com.udacity.shoestore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.udacity.shoestore.databinding.FragmentShoeListBinding

class ShoeListFragment: Fragment() {

    //ViewModel instance
    private lateinit var viewModel: ShoeViewModel

    private lateinit var binding: FragmentShoeListBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        // Inflate the layout for this fragment
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_list, container, false)

        //create ViewModel Instance
        viewModel = ViewModelProvider(this).get(ShoeViewModel::class.java)

        //connect data variable from layout / fragment file to viewModel (ViewModel data binding)
        binding.shoeViewModel = viewModel

        //make the data binding lifecycle aware
        binding.setLifecycleOwner(this)

        //show options menu
        setHasOptionsMenu(true)
        return binding.root //contains root of the layout just inflated above
    }

    fun setViews() {



    }

}