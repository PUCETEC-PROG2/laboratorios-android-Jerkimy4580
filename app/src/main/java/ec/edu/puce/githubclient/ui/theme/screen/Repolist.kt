package ec.edu.puce.githubclient.ui.theme.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ec.edu.puce.githubclient.ui.theme.components.RepoItem

@Composable

fun RepoList (){
    Column (
        modifier = Modifier
            .padding(horizontal = 4.dp, vertical = 48.dp)
    ){

        RepoItem(
            name = "Charmander",
            description = "Pokemon Tipo Fuego",
            avatarImg = "https://i.pinimg.com/564x/60/99/83/609983ed72d4220da851afed92db0418.jpg",
            languaje = "Char Char!!"
        )

        RepoItem(
            name = "Eve",
            description = "Pokemon Tipo Normal",
            avatarImg = "https://www.pokemon.com/static-assets/content-assets/cms2/img/pokedex/full/133.png",
            languaje = "UWUWWUWU!!!"
        )

        RepoItem(
            name = "Squirtle",
            description = "Pokemon Tipo Agua",
            avatarImg = "https://www.pokemon.com/static-assets/content-assets/cms2/img/pokedex/full/007.png",
            languaje = "ScuerScuer"
        )


    }
}

@Preview(showBackground = true)
@Composable

fun RepoListPreview (){
    RepoList(

    )
}