package ec.edu.puce.githubclient.ui.theme.components
import android.R
import android.R.attr.text
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage


@Composable
fun RepoItem(
    name: String,
    description: String,
    avatarImg: String,
    languaje: String

){
    Card (
        modifier = Modifier
            .fillMaxWidth()
            .padding(all = 8.dp)
    ){
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(all = 16.dp)

        ){
            AsyncImage(
                model = avatarImg,
                contentDescription = "Imagen de $name ",
                modifier = Modifier.size(size = 60.dp),
                contentScale = ContentScale.Crop
            )
            Spacer(
                modifier = Modifier.width(width = 16.dp)
            )
            Column {
                Text(
                text = name,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
                )

            Spacer(modifier = Modifier.height(height = 16.dp))
                Text(
                    text = description,
                    style = MaterialTheme.typography.bodyMedium,
                    maxLines = 3
                )
                Spacer(modifier = Modifier.height(height = 16.dp))
                Text(
                    text = languaje,
                    style = MaterialTheme.typography.labelSmall,
                    maxLines = 3
                )
                Spacer(modifier = Modifier.height(height = 16.dp))
            }

        }

    }
}

@Preview(showBackground = true)
@Composable

fun RepoItemPreview (){
    RepoItem(
        name = "Squirtle",
        description = "Pokemon Tipo Agua",
        avatarImg = "https://www.pokemon.com/static-assets/content-assets/cms2/img/pokedex/full/007.png",
        languaje = "ScuerScuer"
    )
}