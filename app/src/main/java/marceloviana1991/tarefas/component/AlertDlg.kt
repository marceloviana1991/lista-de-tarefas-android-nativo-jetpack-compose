package marceloviana1991.tarefas.component

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun AlertDlg (
    showDialog: Boolean,
    onDismiss: () -> Unit,
    onConfirm: () -> Unit
) {
    if (showDialog) {
        AlertDialog(
            onDismissRequest = onDismiss,
            title = {
                Text(text = "Excluir tarefa")
            },
            text = {
                Text("Tem certeza que deseja excluir essa tarefa?")
            },
            confirmButton = {
                Btn(
                    onClick = onConfirm,
                    modifier = Modifier,
                    text = "Confirmar"
                )
            },
            dismissButton = {
                Btn(
                    onClick = onDismiss,
                    modifier = Modifier,
                    text = "Cancelar"
                )
            }
        )
    }
}
