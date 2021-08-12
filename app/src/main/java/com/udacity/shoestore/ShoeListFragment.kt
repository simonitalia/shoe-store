package com.udacity.shoestore

import android.content.Context
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.*
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.core.content.res.ResourcesCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.models.Shoe


class ShoeListFragment: Fragment() {

    private val viewModel: SharedViewModel by activityViewModels()
    private lateinit var binding: FragmentShoeListBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        // Inflate the layout for this fragment
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_list, container, false)

        // set onClick listener for fab button
        binding.addShoeButton.setOnClickListener (

            //get an instance of the Navigation Controller, and set the onClickListener
            Navigation.createNavigateOnClickListener(R.id.action_shoeListFragment_to_shoeItemDetailsFragment)
        )

        //setup list view and adapter
        val adapter = ShoeListAdapter(this.context, viewModel.shoeList?.value ?: mutableListOf())
        binding.shoeListView.adapter = adapter

        //observer shoe list collection changes and update UI on change
        viewModel.shoeList.observe(viewLifecycleOwner, {

            //update list with new shoe list
            adapter.notifyDataSetChanged()
        })

        //show overflow menu (with login fragment as destination)
        setHasOptionsMenu(true)

        return binding.root //contains root of the layout just inflated above
    }

    //override method for overflow menu (with login fragment as destination)
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.overflow_menu, menu)
    }

    //override method that handles navigation to destination fragment
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, requireView().findNavController())
                || super.onOptionsItemSelected(item)
    }
}

class ShoeListAdapter(private val context: Context?,
                      private val dataSource: MutableList<Shoe>): BaseAdapter() {

    private val inflater: LayoutInflater
            = context?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getCount(): Int {
        return dataSource.size
    }

    override fun getItem(position: Int): Any {
        return dataSource[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        // Get view for row item
        val rowView = inflater.inflate(R.layout.fragment_shoe_list_item, parent, false)

        //set rowView text views
        val shoeNameTextView = rowView.findViewById(R.id.shoe_name) as TextView
        val shoeCompanyTextView = rowView.findViewById(R.id.shoe_company) as TextView
        val shoeSizeTextView = rowView.findViewById(R.id.shoe_size) as TextView
        val shoeDescriptionTextView = rowView.findViewById(R.id.shoe_description) as TextView

        //set data for text views
        val shoeItem = getItem(position) as Shoe

        shoeNameTextView.text = shoeItem.name
        shoeCompanyTextView.text = shoeItem.company
        shoeSizeTextView.text = shoeItem.size
        shoeDescriptionTextView.text = shoeItem.description

        //set default shoe image
        val resource = getShoeImageResource()
        val shoeImageView = rowView.findViewById(R.id.shoe_image) as ImageView
        shoeImageView.setImageDrawable(resource)

        return rowView
    }

    //handles retrieving default shoe image
    private fun getShoeImageResource(): Drawable? {
        return context?.resources?.let { ResourcesCompat.getDrawable(it, R.drawable.adidas, null) }
    }
}

