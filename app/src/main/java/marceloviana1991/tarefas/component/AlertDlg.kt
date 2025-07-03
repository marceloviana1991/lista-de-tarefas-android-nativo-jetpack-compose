package marceloviana1991.tarefas.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun AlertDlg (
    title: String,
    text: String,
    showDialog: Boolean,
    onDismiss: () -> Unit,
    onConfirm: () -> Unit
) {
    if (showDialog) {
        AlertDialog(
            onDismissRequest = onDismiss,
            title = {
                Text(text = title)
            },
            text = {
                Text(text)
            },
            confirmButton = {
                Row(
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Btn(
                        onClick = onDismiss,
                        modifier = Modifier.padding(end = 8.dp),
                        text = "Cancelar"
                    )
                    Btn(
                        onClick = onConfirm,
                        modifier = Modifier.padding(start = 8.dp),
                        text = "Confirmar"
                    )
                }
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewAlertDlg() {
    AlertDlg(
        title = "Título AlertDialog",
        text = "Texto AlertDialog aaaaaaaaaaaaaaaaaaaaaaaaaa",
        showDialog = true,
        onConfirm = {},
        onDismiss = {}
    )
}
