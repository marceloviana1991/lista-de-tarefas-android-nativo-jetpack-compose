package marceloviana1991.tarefas.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import marceloviana1991.tarefas.model.Tarefa


@Dao
interface TarefaDao {

    @Query("SELECT * FROM tarefas ORDER BY prioridade DESC")
    suspend fun listarTarefas(): List<Tarefa>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun inserirTarefa(tarefa: Tarefa)

    @Delete
    suspend fun deletarTarefa(tarefa: Tarefa)

    @Query("DELETE FROM tarefas")
    suspend fun deletarTodas()
}