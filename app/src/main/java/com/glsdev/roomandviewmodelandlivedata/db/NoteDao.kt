package com.glsdev.roomandviewmodelandlivedata.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.glsdev.roomandviewmodelandlivedata.Note
import java.util.*

@Dao
interface NoteDao {
    @Query("SELECT * FROM note")
    fun getNotes(): LiveData<List<Note>>

    @Query("SELECT * FROM note WHERE id=(:id)")
    fun getNote(id:UUID): LiveData<Note?>
}
