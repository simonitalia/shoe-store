package com.udacity.shoestore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.udacity.shoestore.databinding.FragmentShoeItemDetailsBinding

class ShoeItemDetailsFragment: Fragment() {

    private lateinit var binding: FragmentShoeItemDetailsBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        // Inflate the layout for this fragment
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_item_details, container, false)

        //cancel button click listener
        binding.cancelButton.setOnClickListener {view ->

            //passes null as as safe args values on cancel
            view.findNavController()
                .navigate(
                    ShoeItemDetailsFragmentDirections.actionShoeItemDetailsFragmentToShoeListFragment(
                        null,
                        null,
                        null,
                        null
                    ))
        }

        //save button click listener (pass safe args to shoe list fragment)
        binding.saveButton.setOnClickListener { view ->

            //get user input values from edit text fields
            val name: String? = binding.editTextShoeName.text?.toString()
            val company: String?  = binding.editTextShoeCompany.text?.toString()
            val size: String?  = binding.editTextShoeSize.text?.toString()
            val description: String? = binding.editTextShoeDescription.text?.toString()

            //pass values to shoe list fragment via safe args
            view.findNavController()
                .navigate(ShoeItemDetailsFragmentDirections.actionShoeItemDetailsFragmentToShoeListFragment(
                    name,
                    company,
                    size,
                    description
                ))
        }

        return binding.root
    }


}