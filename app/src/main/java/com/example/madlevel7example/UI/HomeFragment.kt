package com.example.madlevel7example.UI

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.madlevel7example.R
import com.example.madlevel7example.ViewModel.QuizViewModel
import kotlinx.android.synthetic.main.fragment_home.*

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class HomeFragment : Fragment() {

    private val viewModel: QuizViewModel by activityViewModels()


    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val navController = findNavController()

        viewModel.getQuiz()

        btCreateQuiz.setOnClickListener {
            navController.navigate(R.id.action_homeFragment_to_createQuizFragment)
        }

        viewModel.quiz.observe(viewLifecycleOwner, Observer {
            //make button visible and clickable
            if (!it.answer.isBlank() || !it.answer.isBlank()) {
                btStartQuiz.alpha = 1.0f
                btStartQuiz.isClickable = true

                btStartQuiz.setOnClickListener {
                    navController.navigate(R.id.action_homeFragment_to_quizFragment)
                }
            }
        })

    }
}