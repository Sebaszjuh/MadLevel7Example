package com.example.madlevel7example.UI

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.madlevel7example.R
import com.example.madlevel7example.ViewModel.QuizViewModel
import kotlinx.android.synthetic.main.fragment_create_quiz.*
import kotlinx.android.synthetic.main.fragment_quiz.*

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class CreateQuizFragment : Fragment() {

    private val viewModel: QuizViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_create_quiz, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btn_create_quiz_confirm.setOnClickListener {
            viewModel.createQuiz(inputQuestion.text.toString(), inputAnswer.text.toString())
        }

        observeQuizCreation()
    }

    private fun observeQuizCreation() {
        viewModel.createSuccess.observe(viewLifecycleOwner, Observer {
            Toast.makeText(activity, R.string.succes, Toast.LENGTH_LONG).show()
            findNavController().popBackStack()
        })

        viewModel.errorText.observe(viewLifecycleOwner, Observer {
            Toast.makeText(activity, it, Toast.LENGTH_SHORT).show()
        })
    }
}
