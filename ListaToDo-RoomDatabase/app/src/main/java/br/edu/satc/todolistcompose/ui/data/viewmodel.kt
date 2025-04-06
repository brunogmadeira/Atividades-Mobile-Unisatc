package br.edu.satc.todolistcompose.ui.data

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class TaskViewModel(application: Application) : AndroidViewModel(application) {
    private val db = AppDatabase.getDatabase(application)
    private val repository = TaskRepository(db.taskDao())

    val tasks: StateFlow<List<TaskData>> = repository.allTasks
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    fun addTask(title: String, description: String) {
        val task = TaskData(title = title, description = description, complete = false)
        viewModelScope.launch {
            repository.insert(task)
        }
    }
}
