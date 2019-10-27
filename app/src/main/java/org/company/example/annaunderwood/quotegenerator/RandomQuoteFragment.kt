package org.company.example.annaunderwood.quotegenerator

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.company.example.annaunderwood.quotegenerator.databinding.RandomQuoteFragmentBinding


class RandomQuoteFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        val binding = RandomQuoteFragmentBinding.inflate(inflater)

        val viewModel = ViewModelProviders.of(this).get(RandomQuoteViewModel::class.java)

        binding.viewmodel = viewModel
        binding.setLifecycleOwner(this)


        binding.button.setOnClickListener {
            viewModel.parceRandomQuote()
        }

        return binding.root
    }



}
