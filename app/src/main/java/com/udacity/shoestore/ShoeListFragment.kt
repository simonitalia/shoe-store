package com.udacity.shoestore

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.core.content.res.ResourcesCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.models.Shoe


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

        // set onClick listener for fab button
        binding.addShoeButton.setOnClickListener (

            //get an instance of the Navigation Controller, and set the onClickListener
            Navigation.createNavigateOnClickListener(R.id.action_shoeListFragment_to_shoeItemDetailsFragment)
        )

        //show overflow menu (with login fragment as destination)
        setHasOptionsMenu(true)

        //handle safe args passed in (from shoe item details fragment
        var args = ShoeListFragmentArgs.fromBundle(requireArguments())


        return binding.root //contains root of the layout just inflated above
    }

    //override method for overflow menu (with login fragment as destination)
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.overflow_menu, menu)
    }

    //override method that handles navigation to destination fragment
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, requireView().   findNavController())
                || super.onOptionsItemSelected(item)
    }

    private fun createShoeItem(name: String, company: String, size: String, description: String) {

        //create shoe object and append to shoeList
        val shoe = Shoe(name, company, size, description)
//        viewModel._shoeList.add(shoe)

        //set image view (all shoes have same image)
        val resource = getShoeImageResource()
        binding.shoeImage.setImageDrawable(resource)

       //set text views
        binding.shoeName.text = name
        binding.shoeCompany.text = company
        binding.shoeSize.text = size
        binding.shoeDescription.text = description
    }

    private fun getShoeImageResource(): Drawable? {
        return context?.resources?.let { ResourcesCompat.getDrawable(it, R.drawable.adidas, null) }
    }

}