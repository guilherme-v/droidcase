package com.example.presentation.ui.pages.browser

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.Card
import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import br.curitiba.android.domain.model.Project
import com.example.presentation.R
import com.google.accompanist.coil.rememberCoilPainter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BrowserFragment : Fragment() {
    private val viewModel: BrowserViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                val projects = viewModel.projects.value
                BrowserView(projects)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BrowserViewDefault() {
    val projects = List(50) { Project(name = "DroidCase", ownerName = "Gui") }
    BrowserView(list = projects)
}

@Composable
fun BrowserView(list: List<Project>) {
    val scrollState = rememberLazyListState()
    LazyColumn(state = scrollState) {
        itemsIndexed(list) { _, project ->
            ProjectCard(project)
        }
    }
}

@Composable
fun ProjectCard(project: Project) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                horizontal = 12.dp,
                vertical = 4.dp,
            ),
        shape = MaterialTheme.shapes.small,
        elevation = 4.dp,
    ) {
        Row(
            modifier = Modifier.padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = rememberCoilPainter(
                    request = project.ownerAvatar,
                    previewPlaceholder = R.drawable.ic_launcher_background
                ),
                contentDescription = "Owner image",
                modifier = Modifier.size(62.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Column(
                modifier = Modifier.fillMaxWidth(0.9f)
            ) {
                Text(
                    text = "${project.ownerName}",
                    style = MaterialTheme.typography.h6,
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    style = MaterialTheme.typography.body1,
                    text = "${project.name}",
                )
            }
            Image(
                painter = painterResource(id = R.drawable.ic_star_unselected_24),
                contentDescription = "",
                modifier = Modifier.size(32.dp)
            )
        }
    }
}
