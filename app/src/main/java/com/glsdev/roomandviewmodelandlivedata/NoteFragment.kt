package com.glsdev.roomandviewmodelandlivedata

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView


class NoteFragment : Fragment() {

    private lateinit var note: Note
    private lateinit var titleF: EditText
    private lateinit var dateF: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        note = Note()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_note, container, false)

        titleF = view.findViewById(R.id.note_title) as EditText
        dateF = view.findViewById(R.id.note_date) as TextView



        return view
    }


    override fun onStart() {
        super.onStart()

        val titleWatcher = object : TextWatcher{
            override fun afterTextChanged(s: Editable?) {

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                note.title = s.toString()
            }
        }
        titleF.addTextChangedListener(titleWatcher)
    }

}