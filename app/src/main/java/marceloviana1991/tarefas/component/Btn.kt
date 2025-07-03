package marceloviana1991.tarefas.component

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import marceloviana1991.tarefas.ui.theme.CorSecundaria

@Composable
fun Btn(
    onClick: () -> Unit,
    modifier: Modifier,
    text: String
) {

    Button(
        onClick = onClick,
        modifier,
        colors = ButtonDefaults.buttonColors(
            containerColor = CorSecundaria,
            contentColor = Color.White
        )
    ) {
        Text(
            text = text,
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewBtn() {
    Btn(
        onClick = {},
        modifier = Modifier.padding(20.dp),
        "Texto do Botão"
    )
}