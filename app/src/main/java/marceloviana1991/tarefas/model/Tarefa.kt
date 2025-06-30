package marceloviana1991.tarefas.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tarefas")
data class Tarefa(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    val tarefa: String? = null,
    val descricao: String? = null,
    val prioridade: Int? = null,
)
