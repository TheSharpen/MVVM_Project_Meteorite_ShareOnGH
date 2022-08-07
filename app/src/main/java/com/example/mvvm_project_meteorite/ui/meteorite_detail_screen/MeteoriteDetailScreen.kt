package com.example.mvvm_project_meteorite.ui.meteorite_detail_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.mvvm_project_meteorite.util.UiEvent
import kotlinx.coroutines.flow.collect

@Composable
fun MeteoriteDetailScreen(
    onPopBackStack: () -> Unit,
    viewModel: MeteoriteDetailViewModel = hiltViewModel()
) {

    LaunchedEffect(key1 = true) {
        viewModel.uiEvent.collect { event ->
            when (event) {
                is UiEvent.PopBackStack  -> onPopBackStack()
                else -> Unit
            }
        }
    }
    Column(modifier =Modifier.fillMaxSize().background(color = Color.Black)) {
        Card(modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)) {
            Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = viewModel.name)
            }

        }
        Spacer(modifier = Modifier.height(20.dp))
    }



}