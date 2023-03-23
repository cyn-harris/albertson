package com.example.codingchallenge.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.codingchallenge.databinding.FragmentAcronymBinding
import com.example.codingchallenge.viewmodel.AcronymViewModel
import dagger.hilt.android.AndroidEntryPoint

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
@AndroidEntryPoint
class AcronymFragment : Fragment() {

    private val acronymViewModel by viewModels<AcronymViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return FragmentAcronymBinding.inflate(inflater, container, false).apply {
            acronymViewModel = this@AcronymFragment.acronymViewModel
            adapter = LongformAdapter()
            lifecycleOwner = this@AcronymFragment.viewLifecycleOwner
        }.root
    }
}
