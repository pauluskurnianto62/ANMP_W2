package com.paulus.a160421074_anmp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.paulus.a160421074_anmp.databinding.FragmentMainBinding
import com.paulus.a160421074_anmp.databinding.FragmentResultBinding

class ResultFragment : Fragment() {
    private lateinit var binding: FragmentResultBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentResultBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if(arguments != null) {
            val score =
                ResultFragmentArgs.fromBundle(requireArguments()).score
            binding.txtScore.text = "Your score is $score"
        }

        binding.btnBack.setOnClickListener {
            val action = ResultFragmentDirections.actionMainFragment()
            Navigation.findNavController(it).navigate(action)
        }
    }
}