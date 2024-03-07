package com.paulus.a160421074_anmp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.paulus.a160421074_anmp.databinding.FragmentGameBinding
import com.paulus.a160421074_anmp.databinding.FragmentMainBinding
import kotlin.random.Random


class GameFragment : Fragment() {
    private lateinit var binding: FragmentGameBinding
    var wrongAnswer:Int = 0
    var score:Int = 0
    var numOne:Int = Random.nextInt(99)
    var numTwo:Int = Random.nextInt(99)
    var totalNum:Int = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentGameBinding.inflate(inflater, container, false)
        return binding.root
    }

    fun NextQuestion() {
        binding.txtAnswer.text.clear()

        numOne = Random.nextInt(99)
        numTwo = Random.nextInt(99)

        binding.txtNumOne.text = numOne.toString()
        binding.txtNumTwo.text = numTwo.toString()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.txtNumOne.text = numOne.toString()
        binding.txtNumTwo.text = numTwo.toString()

        totalNum = numOne + numTwo

        val myAnswer = binding.txtAnswer.text

        if(arguments != null) {
            val playerName =
                GameFragmentArgs.fromBundle(requireArguments()).name
            binding.txtTurn.text = "$playerName's Turn"
        }

        binding.btnSubmit.setOnClickListener {
            if (myAnswer.toString() == totalNum.toString()) {
                score++
                NextQuestion()
            }
            else {
                wrongAnswer++
                if (wrongAnswer == 1){
                    val action = GameFragmentDirections.actionResultFragment(score)
                    Navigation.findNavController(it).navigate(action)
                }
            }
        }
    }
}