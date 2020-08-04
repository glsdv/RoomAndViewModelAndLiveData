package com.glsdev.roomandviewmodelandlivedata

import androidx.lifecycle.ViewModel

class NotesViewModel: ViewModel() {
    private val noteRepository = NoteRepository.get()
    val notes = noteRepository.getNotes()


}