import androidx.room.*
import br.edu.satc.todolistcompose.ui.data.TaskData

@Dao
interface TaskDao {
    @Query("SELECT * FROM tasks")
    fun getAllTasksFlow(): kotlinx.coroutines.flow.Flow<List<TaskData>>

    @Insert
    fun insertTask(task: TaskData)

    @Query("DELETE FROM tasks")
    fun deleteAllTasks()
}
