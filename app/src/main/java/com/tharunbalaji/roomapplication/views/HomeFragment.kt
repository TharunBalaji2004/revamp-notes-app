package com.tharunbalaji.roomapplication.views

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.tharunbalaji.roomapplication.R
import com.tharunbalaji.roomapplication.databinding.FragmentHomeBinding
import com.tharunbalaji.roomapplication.db.Note
import com.tharunbalaji.roomapplication.viewmodels.NoteViewModel


// NOTES App -> Two screens
// Home Screen (all notes)
// Edit Screen (create, update, delete)

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private val noteViewModel:NoteViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        noteViewModel.allNotes.observe(viewLifecycleOwner){ notes ->
            Log.d("HOME FRAGMENT","ALL NOTES: $notes")
        }

        binding.btnEdit.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_editFragment)
        }
    }
}