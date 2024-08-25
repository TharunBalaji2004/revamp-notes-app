package com.tharunbalaji.roomapplication.views

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.tharunbalaji.roomapplication.R
import com.tharunbalaji.roomapplication.db.Note

class NoteViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    fun bind(note: Note) {
        val tvTitle: TextView = itemView.findViewById(R.id.tv_title)
        val tvContent: TextView = itemView.findViewById(R.id.tv_content)

        tvTitle.text = note.title
        tvContent.text = note.content
    }
}

class NoteAdapter: RecyclerView.Adapter<NoteViewHolder>() {

    private var notes: List<Note> = emptyList()

    fun updateList(notes: List<Note>) {
        this.notes = notes
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.note_card, parent, false)
        return NoteViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return notes.size
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        holder.bind(notes.get(position))
    }
}