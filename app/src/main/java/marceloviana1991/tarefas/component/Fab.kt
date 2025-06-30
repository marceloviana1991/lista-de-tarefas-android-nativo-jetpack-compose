package marceloviana1991.tarefas.component

import androidx.compose.foundation.Image
import androidx.compose.material3.FloatingActionButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import marceloviana1991.tarefas.R
import marceloviana1991.tarefas.ui.theme.CorDestaque

@Composable
fun Fab(onClick: () -> Unit) {
    FloatingActionButton(
        onClick = { onClick() },
        containerColor = CorDestaque
    ) {
        Image(
            imageVector = ImageVector.vectorResource(R.drawable.ic_add),
            contentDescription = "botão adicionar"
        )
    }
}