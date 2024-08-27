package com.tharunbalaji.roomapplication.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.tharunbalaji.roomapplication.R
import com.tharunbalaji.roomapplication.databinding.FragmentEditBinding
import com.tharunbalaji.roomapplication.db.Note
import com.tharunbalaji.roomapplication.viewmodels.NoteViewModel


class EditFragment : Fragment() {

    private lateinit var binding: FragmentEditBinding
    private val noteViewModel: NoteViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEditBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val id = arguments?.getInt("id")
        val title = arguments?.getString("title")
        val content = arguments?.getString("content")

        binding.etTitle.setText(title)
        binding.etContent.setText(content)
        binding.btnCreate.text = if (id != null) "UPDATE NOTE" else binding.btnCreate.text

        binding.btnCreate.setOnClickListener {
            val title = binding.etTitle.text.toString()
            val content = binding.etContent.text.toString()

            if (id != null) {
                val note = Note(id = id, title = title, content = content)
                noteViewModel.update(note)
            } else {
                val note = Note(title = title, content = content)
                noteViewModel.create(note)
            }

            findNavController().popBackStack()
        }
    }
}