package ec.edu.puce.githubclient.ui.theme.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import ec.edu.puce.githubclient.models.GitHubUser
import ec.edu.puce.githubclient.models.Repository

@Composable
fun RepoItem(
    repository: Repository
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(all = 8.dp),
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(all = 16.dp)
        ) {

//            AsyncImage(
//                model = repository.owner.avatarUrl,
//                contentDescription = "Imagen de ${repository.owner.login}",
//                modifier = Modifier.size(60.dp),
//                contentScale = ContentScale.Crop
//            )

            AsyncImage(
                model = repository.owner.avatarUrl,
                contentDescription = "Imagen de ${repository.owner.login}",
                contentScale = ContentScale.Crop, // Recorta la imagen para llenar el contenedor circular
                modifier = Modifier
                    .size(60.dp) // Define el tamaño del contenedor (diámetro)
                    .clip(CircleShape) // Recorta el contenedor en forma de círculo
            )

            Spacer(
                modifier = Modifier.width(16.dp)
            )

            Column {

                Text(
                    color = Blue,
                    text = repository.name,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )

                Spacer(
                    modifier = Modifier.height(16.dp)
                )

                repository.description?.let {
                    Text(
                        text = it,
                        style = MaterialTheme.typography.bodyMedium
                    )
                }

                Spacer(
                    modifier = Modifier.height(16.dp)
                )

                repository.language?.let {
                    Text(
                        color = Blue,
                        text = it,
                        style = MaterialTheme.typography.labelSmall
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RepoItemPreview() {

    val repository = Repository(
        id = "121323",
        name = "Holiws",
        description = "Holiwis",
        language = "Python",
        owner = GitHubUser(
            id = "jsjsjs",
            login = "sjajasjss",
            avatarUrl = "jsjsjss"
        )
    )

    RepoItem(repository = repository)
}