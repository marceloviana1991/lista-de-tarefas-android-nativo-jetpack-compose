package marceloviana1991.tarefas.viewmodel

import android.app.Application
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import marceloviana1991.tarefas.data.AppDatabase
import marceloviana1991.tarefas.model.Tarefa

class TarefaViewModel(application: Application) : AndroidViewModel(application) {

    private val dao = AppDatabase.getDatabase(application).tarefaDao()

    var listaTarefas = mutableStateListOf<Tarefa>()
        private set

    init {
        carregarTarefas()
    }

    fun carregarTarefas() {
        viewModelScope.launch {
            val tarefas = dao.listarTarefas()
            listaTarefas.clear()
            listaTarefas.addAll(tarefas)
        }
    }

    fun adicionarTarefa(tarefa: Tarefa) {
        viewModelScope.launch {
            dao.inserirTarefa(tarefa)
            carregarTarefas()
        }
    }

    fun removerTarefa(tarefa: Tarefa) {
        viewModelScope.launch {
            dao.deletarTarefa(tarefa)
            carregarTarefas()
        }
    }

    fun limparTudo() {
        viewModelScope.launch {
            dao.deletarTodas()
            carregarTarefas()
        }
    }
}