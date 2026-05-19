package ec.edu.puce.githubclient.models

import android.accessibilityservice.GestureDescription
import org.intellij.lang.annotations.Language

data class Repository(
    val id: String,
    val name: String,
    val owner : GitHubUser,
    val description: String?,
    val language: String?,
)
