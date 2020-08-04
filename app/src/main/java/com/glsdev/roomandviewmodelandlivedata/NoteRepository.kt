package com.glsdev.roomandviewmodelandlivedata

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.room.Room
import com.glsdev.roomandviewmodelandlivedata.db.NoteDB
import java.lang.IllegalStateException
import java.util.*

private const val DB_NAME = "note-db"

class NoteRepository  private constructor(context: Context){
    private val database: NoteDB =
        Room.databaseBuilder(context.applicationContext,
        NoteDB::class.java, DB_NAME).build()

    private val noteDao = database.noteDao()
    fun getNotes(): LiveData<List<Note>> = noteDao.getNotes()
    fun getNote(id:UUID): LiveData<Note?> = noteDao.getNote(id)


    companion object{
        private var INSTANCE: NoteRepository? = null

        fun initialize(context: Context){
            if(INSTANCE == null){
                INSTANCE = NoteRepository(context)
            }
        }

        fun get(): NoteRepository{
            return INSTANCE ?: throw IllegalStateException("Exception")
        }
    }
}