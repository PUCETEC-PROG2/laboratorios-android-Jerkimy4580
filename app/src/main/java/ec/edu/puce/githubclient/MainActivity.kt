package ec.edu.puce.githubclient

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewmodel.compose.viewModel
import ec.edu.puce.githubclient.ui.theme.GithubClientTheme
import ec.edu.puce.githubclient.ui.theme.screen.RepoList
import ec.edu.puce.githubclient.ui.theme.theme.RepoForm
import ec.edu.puce.githubclient.viewmodels.RepoListViewModel


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            var currentScreen by remember { mutableStateOf("repoList") }
            val listViewModel: RepoListViewModel = viewModel()
            GithubClientTheme {
                when (currentScreen) {
                    "repoList" -> RepoList(
                        onNavigateToForm = {
                            currentScreen = "repoForm"
                        }
                    )

                    "repoForm" -> RepoForm(
                        onBackClick = {currentScreen = "repoList"},
                        onSaveSuccess = {
                            listViewModel.fetchRepos()
                            currentScreen = "repoList"
                        }
                    )
                }
            }
        }
    }
}