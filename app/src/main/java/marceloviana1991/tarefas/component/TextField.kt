package marceloviana1991.tarefas.component

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import marceloviana1991.tarefas.ui.theme.CorNeutra
import marceloviana1991.tarefas.ui.theme.CorNeutraClara
import marceloviana1991.tarefas.ui.theme.CorSecundaria
import marceloviana1991.tarefas.ui.theme.ShapeEditText

@Composable
fun TextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier,
    label: String,
    singleLine: Boolean = false,
    keyboardType: KeyboardType
) {
    OutlinedTextField(
        value = value,
        onValueChange,
        modifier,
        label = { Text(text = label, fontWeight = FontWeight.Thin) },
        singleLine = singleLine,
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = CorSecundaria,
            unfocusedBorderColor = CorNeutra,
            focusedLabelColor = CorSecundaria,
            unfocusedLabelColor = CorNeutra,
            cursorColor = CorSecundaria,
            focusedContainerColor = CorNeutraClara
        ),
        shape = ShapeEditText.small,
        keyboardOptions = KeyboardOptions(
            capitalization = KeyboardCapitalization.Sentences,
            keyboardType = keyboardType
        )
    )
}

@Preview(showBackground = true)
@Composable
private fun PreviewTextField() {
    TextField(
        value = "",
        onValueChange = {},
        modifier = Modifier.padding(10.dp),
        label = "Campo de texto",
        keyboardType = KeyboardType.Text
    )
}

@Preview(showBackground = true)
@Composable
private fun PreviewTextFieldFilled() {
    TextField(
        value = "Texto digitado",
        onValueChange = {},
        modifier = Modifier.padding(10.dp),
        label = "Campo de texto",
        keyboardType = KeyboardType.Text
    )
}



