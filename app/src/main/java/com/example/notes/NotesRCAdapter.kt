package com.example.notes

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NotesRVAdapter(private val context: Context, private val listner : INotesRVAdapter)
    : RecyclerView.Adapter<NotesRVAdapter.NoteViewHolder>() {

    private val allNotes = arrayListOf<Note>()
     class NoteViewHolder (itemview : View) : RecyclerView.ViewHolder(itemview){
        val textView: TextView = itemView.findViewById(R.id.tvNote)
        val deleteButton: ImageView = itemview.findViewById(R.id.ivDelete)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val viewHolder = NoteViewHolder( LayoutInflater.from(context)
            .inflate(R.layout.item_note, parent, false))
        viewHolder.deleteButton.setOnClickListener{
            listner.onItemClicked(allNotes[viewHolder.adapterPosition])
        }
        return viewHolder
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val currentNote = allNotes[position]
        holder.textView.text = currentNote.text
    }

    override fun getItemCount(): Int {
        return allNotes.size
    }
    fun updateList(newList : List<Note>){
        allNotes.clear()
        allNotes.addAll(newList)

        notifyDataSetChanged()
    }
}

interface INotesRVAdapter{
    fun onItemClicked(note: Note)
}