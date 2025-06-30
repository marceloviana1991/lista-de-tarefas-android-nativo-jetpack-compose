package marceloviana1991.tarefas.view

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

import androidx.navigation.NavController
import marceloviana1991.tarefas.component.Fab
import marceloviana1991.tarefas.component.TopBar
import marceloviana1991.tarefas.model.Tarefa
import marceloviana1991.tarefas.view.item.ItemListaTarefa


@Composable
fun ListaTarefas(
    navController: NavController
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = { TopBar("Lista de Tarefas") },
        floatingActionButton = { Fab(onClick = { navController.navigate("salvarTarefa") }) }

    ) { innerPadding ->
        val listaDeTarefas: MutableList<Tarefa> = mutableListOf(
            Tarefa("Tarefa", "É uma tarefa", 1),
            Tarefa("Tarefa", "É uma tarefa", 2),
            Tarefa("Tarefa", "É uma tarefa", 3)
        )
        LazyColumn(
            modifier = Modifier
            .padding(innerPadding)
        ) {
            itemsIndexed(listaDeTarefas) { position, _ ->

                ItemListaTarefa(position, listaDeTarefas)
            }

        }
    }
}