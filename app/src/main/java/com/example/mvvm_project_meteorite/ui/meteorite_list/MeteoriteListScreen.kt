package com.example.mvvm_project_meteorite.ui.meteorite_list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.mvvm_project_meteorite.data.Meteorite
import com.example.mvvm_project_meteorite.util.UiEvent
import androidx.compose.runtime.collectAsState

@Composable
fun MeteoriteListScreen(
    onNavigate: (UiEvent.Navigate) -> Unit,
    //meteoriteList: List<Meteorite>,
    viewModel: MeteoriteListViewModel = hiltViewModel()
) {

val meteoriteList = viewModel.meteoriteList.collectAsState(initial = emptyList())

//    LaunchedEffect(key1 = true) {
//        viewModel.updateMeteoriteList()
//    }

    Box(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.DarkGray)
    ) {
        Spacer(modifier = Modifier.height(10.dp))
        LazyColumn(
                modifier = Modifier.fillMaxSize()
        ) {
            items(meteoriteList.value) { meteorite ->
                MeteoriteItem(
                        meteorite = meteorite, modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                )
            }
        }
    }
}