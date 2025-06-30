package marceloviana1991.tarefas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import marceloviana1991.tarefas.ui.theme.ListaDeTarefasComposeTheme
import marceloviana1991.tarefas.view.ListaTarefas
import marceloviana1991.tarefas.view.SalvarTarefa
import marceloviana1991.tarefas.viewmodel.TarefaViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ListaDeTarefasComposeTheme(darkTheme = false) {
                val navController = rememberNavController()
                val tarefaViewModel: TarefaViewModel = viewModel()

                NavHost(
                    navController = navController,
                    startDestination = "listaTarefas"
                ) {
                    composable("listaTarefas") { ListaTarefas(navController, tarefaViewModel) }
                    composable("salvarTarefa") { SalvarTarefa(navController, tarefaViewModel) }
                }
            }
        }
    }
}
