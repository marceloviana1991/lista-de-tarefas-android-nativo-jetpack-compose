package marceloviana1991.tarefas.view.item

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import marceloviana1991.tarefas.R
import marceloviana1991.tarefas.model.Tarefa
import marceloviana1991.tarefas.ui.theme.RadioButtonAmarelo
import marceloviana1991.tarefas.ui.theme.RadioButtonVerde
import marceloviana1991.tarefas.ui.theme.RadioButtonVermelho
import marceloviana1991.tarefas.ui.theme.ShapeCardPrioridade

@Composable
fun ItemListaTarefa(
    position: Int,
    listaTarefas: MutableList<Tarefa>
) {

    val titulo = listaTarefas[position].tarefa
    val descricao = listaTarefas[position].descricao
    val prioridade = listaTarefas[position].prioridade

    val nivelDePrioridade: String = when (prioridade) {
        1 -> { "Prioridade baixa" }
        2 -> { "Prioridade média" }
        else -> { "Prioridade alta" }
    }

    val color = when (prioridade) {
        1 -> { RadioButtonVerde }
        2 -> { RadioButtonAmarelo }
        else -> { RadioButtonVermelho }
    }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
    ) {
        ConstraintLayout(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
        ) {
            val (txtTitulo, txtDescricao, cardPrioridade, txtPrioridade, btDeletar) = createRefs()
            Text(
                titulo.toString(),
                modifier = Modifier
                    .constrainAs(txtTitulo) {
                        top.linkTo(parent.top, margin = 10.dp)
                        start.linkTo(parent.start, margin = 10.dp)
                    }
            )
            Text(
                descricao.toString(),
                modifier = Modifier
                    .constrainAs(txtDescricao) {
                        top.linkTo(txtTitulo.bottom, margin = 10.dp)
                        start.linkTo(parent.start, margin = 10.dp)
                    }
            )
            Text(
                nivelDePrioridade,
                modifier = Modifier
                    .constrainAs(txtPrioridade) {
                        top.linkTo(txtDescricao.bottom, margin = 10.dp)
                        start.linkTo(parent.start, margin = 10.dp)
                        bottom.linkTo(parent.bottom, margin = 10.dp)
                    }
            )
            Card(
                colors = CardDefaults.cardColors(containerColor = color),
                modifier = Modifier
                    .size(30.dp)
                    .constrainAs(cardPrioridade) {
                        top.linkTo(txtDescricao.bottom, margin = 10.dp)
                        start.linkTo(txtPrioridade.end, margin = 10.dp)
                        bottom.linkTo(parent.bottom, margin = 10.dp)
                    },
                shape = ShapeCardPrioridade.large
            ) {

            }
            IconButton(
                onClick = {

                },
                modifier = Modifier
                    .constrainAs(btDeletar) {
                        top.linkTo(txtDescricao.bottom, margin = 10.dp)
                        end.linkTo(parent.end, margin = 10.dp)
                        bottom.linkTo(parent.bottom, margin = 10.dp)
                    }
            ) {
                Image(
                    imageVector = ImageVector.vectorResource(R.drawable.baseline_delete_24),
                    "botão excluir"
                )
            }
        }
    }
}
