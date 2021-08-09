package com.udacity.shoestore

import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
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

        // set onClick listener for fab button
        binding.addShoeButton.setOnClickListener (

            //get an instance of the Navigation Controller, and set the onClickListener
            Navigation.createNavigateOnClickListener(R.id.action_shoeListFragment_to_shoeItemDetailsFragment)
        )

        //create first item (this is an example item)
        createShoeItem("Shoe Name", "Shoe Company", 6, "Shoe Description")


        //show options menu
        setHasOptionsMenu(true)
        return binding.root //contains root of the layout just inflated above
    }

    private fun setViews() {



    }

    private fun createShoeItem(name: String, company: String, size: Int, description: String) {

        //set image view (all shoes have same image)
        val resource = getShoeImageResource()
        binding.shoeImage.setImageDrawable(resource)

       //set text views
        binding.shoeName.text = name
        binding.shoeCompany.text = company
        binding.shoeSize.text = size.toString()
        binding.shoeDescription.text = description
    }

    private fun getShoeImageResource(): Drawable? {
        return context?.resources?.let { ResourcesCompat.getDrawable(it, R.drawable.adidas, null) }
    }

}