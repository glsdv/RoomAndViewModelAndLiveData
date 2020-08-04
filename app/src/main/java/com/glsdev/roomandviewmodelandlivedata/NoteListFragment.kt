package com.glsdev.roomandviewmodelandlivedata

import android.os.Bundle

import android.view.LayoutInflater
import android.view.View
import androidx.fragment.app.Fragment

import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class NoteListFragment : Fragment() {

    private lateinit var noteRecyclerView: RecyclerView
    private var adapter: NoteAdapter? = NoteAdapter(emptyList())

    private val notesViewModel: NotesViewModel by lazy {
        ViewModelProvider(this).get(NotesViewModel::class.java)
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_note_list, container, false)

        noteRecyclerView = view.findViewById(R.id.note_recycler_view) as RecyclerView
        noteRecyclerView.layoutManager = LinearLayoutManager(context)
        noteRecyclerView.adapter = adapter

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        notesViewModel.notes.observe(
            viewLifecycleOwner,
            Observer{ notes ->
                notes?.let{
                    updateUI(notes)
                }
            }
        )
    }

    private fun updateUI(notes: List<Note>){

        adapter = NoteAdapter(notes)
        noteRecyclerView.adapter = adapter
    }

    companion object{
        fun newInstance(): NoteListFragment{
            return NoteListFragment()
        }
    }

    private inner class NoteHolder(view: View): RecyclerView.ViewHolder(view), View.OnClickListener {

        private lateinit var note: Note

        private val titleText: TextView = itemView.findViewById(R.id.note_title)
        private val dateText: TextView = itemView.findViewById(R.id.note_date)

        init{
            itemView.setOnClickListener(this)
        }

        fun bind(note: Note){
            this.note = note
            titleText.text = this.note.title
            dateText.text = this.note.date.toString()
        }

        override fun onClick(v: View?) {
            Toast.makeText(context, "${note.title}", Toast.LENGTH_SHORT).show()
        }
    }

    private inner class NoteAdapter(var notes: List<Note>): RecyclerView.Adapter<NoteHolder>(){
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteHolder {
            val view = layoutInflater.inflate(R.layout.list_item_note, parent, false)
            return NoteHolder(view)
        }

        override fun getItemCount() = notes.size

        override fun onBindViewHolder(holder: NoteHolder, position: Int) {
            val note = notes[position]
            holder.bind(note)
        }
    }

}