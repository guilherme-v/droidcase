package com.example.presentation.ui.pages.browser

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.curitiba.android.domain.model.Project
import br.curitiba.android.domain.usecases.GetProjects
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BrowserViewModel @Inject constructor(
    private val getProjects: GetProjects
) : ViewModel() {

    init {
        loadProjects()
    }

    val projects: MutableState<List<Project>> = mutableStateOf(ArrayList())

    fun loadProjects() {
        viewModelScope.launch {
            val result = getProjects.execute()
            projects.value = result
            Log.d("AHHHH", "loadProjects: $result")
        }
    }
}