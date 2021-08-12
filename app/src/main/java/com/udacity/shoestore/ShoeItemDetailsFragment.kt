package com.udacity.shoestore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import com.udacity.shoestore.databinding.FragmentShoeItemDetailsBinding
import com.udacity.shoestore.models.Shoe

class ShoeItemDetailsFragment: Fragment() {

    private val viewModel: SharedViewModel by activityViewModels()
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
            val name = binding.editTextShoeName.text?.toString() ?: "Name not provided"
            val company  = binding.editTextShoeCompany.text?.toString() ?: "Company not provided"
            val size = binding.editTextShoeSize.text?.toString() ?: "0"
            val description = binding.editTextShoeDescription.text?.toString() ?: "Description not provided"

            val shoeItem = Shoe(name, company, size, description)

            //update viewModel with new shoe item
            viewModel.addShoeItem(shoeItem)

            //navigate to shoe list fragment (and pass values to shoe list fragment via safe args)
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