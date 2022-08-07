package com.example.mvvm_project_meteorite.ui.meteorite_detail_screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvm_project_meteorite.MeteoriteApi
import com.example.mvvm_project_meteorite.data.Meteorite
import com.example.mvvm_project_meteorite.util.UiEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MeteoriteDetailViewModel @Inject constructor(
    private val api: MeteoriteApi,
    savedStateHandle: SavedStateHandle

    ): ViewModel() {

    private val _uiEvent = Channel<UiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    var meteorite by mutableStateOf<Meteorite?>(null)
        private set

    var name by mutableStateOf("")
        private set

    var nametype by mutableStateOf("")
        private set

    var fall by mutableStateOf("")
        private set

    var year by mutableStateOf("")
        private set

//    var geolocation by mutableStateOf("")
//        private set

    var id by mutableStateOf("")
        private set

    var mass by mutableStateOf("")
        private set

    var recclass by mutableStateOf("")
        private set

    var reclat by mutableStateOf("")
        private set

    var reclong by mutableStateOf("")
        private set


    init {
        val meteoriteId = savedStateHandle.get<Int>("meteoriteId")!!
        if (meteoriteId != -1) {
            viewModelScope.launch {
                api.getMeteoriteById(meteoriteId.toString())?.let {
                    meteorite ->
                    name = meteorite.name
                    nametype = meteorite.nametype
                    fall = meteorite.fall
                    year = meteorite.year
                    id = meteorite.id
                    mass = meteorite.mass
                    recclass = meteorite.recclass
                    reclat = meteorite.reclat
                    reclong = meteorite.reclong
                    this@MeteoriteDetailViewModel.meteorite = meteorite
                }
            }
        }
    }

    fun sendUiEvent(event: UiEvent) {
        viewModelScope.launch {
            _uiEvent.send(event)
        }
    }
}