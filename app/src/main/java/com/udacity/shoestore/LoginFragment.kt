package com.udacity.shoestore

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.udacity.shoestore.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        // Inflate the layout for this fragment
        val binding: FragmentLoginBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)

        // set onClick listener for Button
        binding.signIn.setOnClickListener (

            //get an instance of the Navigation Controller, and set the onClickListener
            Navigation.createNavigateOnClickListener(R.id.action_loginFragment_to_welcomeFragment)
        )

        binding.register.setOnClickListener (

            //get an instance of the Navigation Controller, and set the onClickListener
            Navigation.createNavigateOnClickListener(R.id.action_loginFragment_to_welcomeFragment)
        )

        return binding.root //contains root of the layout just inflated above
    }
}