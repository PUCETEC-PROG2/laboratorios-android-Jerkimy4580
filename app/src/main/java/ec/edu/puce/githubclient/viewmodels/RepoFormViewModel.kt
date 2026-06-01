package ec.edu.puce.githubclient.viewmodels

import android.accessibilityservice.GestureDescription
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import ec.edu.puce.githubclient.models.Repository
import ec.edu.puce.githubclient.models.RepositoryPayLoad
import ec.edu.puce.githubclient.services.RetrofitClient
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class RepoFormViewModel: ViewModel() {
    private val _isLoading = MutableStateFlow(value = false)
    val isLoading = _isLoading.asStateFlow()

    private val _errorMsg = MutableStateFlow<String?>(value = null)
    val errorMsg = _errorMsg.asStateFlow()
    private val _isSuccess = MutableStateFlow(value = false)
    val isSuccess = _isSuccess.asStateFlow()

    fun createRepository (name: String, description: String){
        viewModelScope.launch{
            _isLoading.value = true
            _errorMsg.value = null
            try {
                val repositoryBody = RepositoryPayLoad(name,description)
                RetrofitClient.apiService.createRepository(repositoryBody)
                _isSuccess.value = true
            } catch (e: Exception) {
                _errorMsg.value = "Error al crear Repositorio: ${e.localizedMessage}"
            } finally {
                _isLoading.value = false

            }
        }
    }
    fun resetSuccess(){
        _isSuccess.value = false
    }
    fun resetError(){
        _errorMsg.value = null
    }
}