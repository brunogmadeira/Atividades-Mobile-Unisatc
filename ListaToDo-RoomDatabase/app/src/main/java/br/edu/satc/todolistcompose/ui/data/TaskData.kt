package br.edu.satc.todolistcompose.ui.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tasks")
data class TaskData(
    @PrimaryKey val title: String,
    val description: String,
    val complete: Boolean
)
