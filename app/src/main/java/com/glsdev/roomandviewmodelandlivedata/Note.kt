package com.glsdev.roomandviewmodelandlivedata

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
data class Note(@PrimaryKey val id: UUID = UUID.randomUUID(), var title: String = "", var content: String = "",
var date: Date = Date())