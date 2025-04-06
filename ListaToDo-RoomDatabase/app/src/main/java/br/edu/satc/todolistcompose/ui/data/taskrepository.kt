package br.edu.satc.todolistcompose.ui.data

import TaskDao

class TaskRepository(private val taskDao: TaskDao) {
    val allTasks = taskDao.getAllTasksFlow()

    suspend fun insert(task: TaskData) {
        taskDao.insertTask(task)
    }
}
