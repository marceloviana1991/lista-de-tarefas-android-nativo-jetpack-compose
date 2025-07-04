package marceloviana1991.tarefas.view

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import marceloviana1991.tarefas.component.Btn

import marceloviana1991.tarefas.component.TopBar
import marceloviana1991.tarefas.component.TextField
import marceloviana1991.tarefas.model.Tarefa
import marceloviana1991.tarefas.ui.theme.RadioButtonAmarelo
import marceloviana1991.tarefas.ui.theme.RadioButtonVerde
import marceloviana1991.tarefas.ui.theme.RadioButtonVermelho
import marceloviana1991.tarefas.viewmodel.TarefaViewModel

@Composable
fun SalvarTarefa(
    navController: NavController,
    tarefaViewModel: TarefaViewModel
) {
    var tituloTarefa by remember { mutableStateOf("") }
    var descricaoTarefa by remember { mutableStateOf("") }
    var baixaPrioridadeTarefa by remember { mutableStateOf(false) }
    var mediaPrioridadeTarefa by remember { mutableStateOf(false) }
    var altaPrioridadeTarefa by remember { mutableStateOf(false) }

    val contexto = androidx.compose.ui.platform.LocalContext.current

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = { TopBar("Salvar Tarefa") }
    ) { innerPadding ->
        Column(
            modifier = Modifier.fillMaxSize().verticalScroll(rememberScrollState())
                .padding(innerPadding)
        ) {
            TextField(
                value = tituloTarefa,
                onValueChange = {
                    tituloTarefa = it
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp, 20.dp, 20.dp, 0.dp),
                label = "Título Tarefa",
                singleLine = true,
                keyboardType = KeyboardType.Text
            )

            TextField(
                value = descricaoTarefa,
                onValueChange = {
                    descricaoTarefa = it
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp)
                    .padding(20.dp, 10.dp, 20.dp, 0.dp),
                label = "Descrição",
                keyboardType = KeyboardType.Text
            )
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Nível de prioridade")
                RadioButton(
                    selected = baixaPrioridadeTarefa,
                    onClick = {
                        baixaPrioridadeTarefa = true
                        mediaPrioridadeTarefa = false
                        altaPrioridadeTarefa = false
                    },
                    colors = RadioButtonDefaults.colors(
                        selectedColor = RadioButtonVerde,
                        unselectedColor = RadioButtonVerde
                    )
                )
                RadioButton(
                    selected = mediaPrioridadeTarefa,
                    onClick = {
                        baixaPrioridadeTarefa = false
                        mediaPrioridadeTarefa = true
                        altaPrioridadeTarefa = false
                    },
                    colors = RadioButtonDefaults.colors(
                        selectedColor = RadioButtonAmarelo,
                        unselectedColor = RadioButtonAmarelo
                    )
                )
                RadioButton(
                    selected = altaPrioridadeTarefa,
                    onClick = {
                        baixaPrioridadeTarefa = false
                        mediaPrioridadeTarefa = false
                        altaPrioridadeTarefa = true
                    },
                    colors = RadioButtonDefaults.colors(
                        selectedColor = RadioButtonVermelho,
                        unselectedColor = RadioButtonVermelho
                    )
                )
            }
            Btn(
                onClick = {
                    val prioridade = when {
                        baixaPrioridadeTarefa -> 1
                        mediaPrioridadeTarefa -> 2
                        altaPrioridadeTarefa -> 3
                        else -> 1 // prioridade padrão
                    }
                    if (tituloTarefa.isNotBlank() && descricaoTarefa.isNotBlank()) {
                        val tarefa = Tarefa(
                            tarefa = tituloTarefa,
                            descricao = descricaoTarefa,
                            prioridade = prioridade
                        )
                        tarefaViewModel.adicionarTarefa(tarefa)
                        Toast.makeText(contexto, "Tarefa salva!", Toast.LENGTH_SHORT).show()
                        navController.popBackStack() // Voltar para a tela anterior
                    } else {
                        Toast.makeText(contexto, "Preencha todos os campos", Toast.LENGTH_SHORT).show()
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp)
                    .height(60.dp),
                text = "Salvar"
            )
        }
    }
}
