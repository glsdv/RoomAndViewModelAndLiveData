package com.glsdev.roomandviewmodelandlivedata.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.glsdev.roomandviewmodelandlivedata.Note


@Database(entities = [Note::class], version = 1)
@TypeConverters(NoteTypeConverter::class)
abstract class NoteDB: RoomDatabase() {
    abstract fun noteDao(): NoteDao
}