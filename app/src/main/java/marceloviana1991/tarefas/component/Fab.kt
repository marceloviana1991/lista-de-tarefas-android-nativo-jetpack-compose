package marceloviana1991.tarefas.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
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

@Preview
@Composable
private fun PreviewFab() {
    Scaffold(
        floatingActionButton = { Fab(onClick = {}) }
    ) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {

        }
    }
}