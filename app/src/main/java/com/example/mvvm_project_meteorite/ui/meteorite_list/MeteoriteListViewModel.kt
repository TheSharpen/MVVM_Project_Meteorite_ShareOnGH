package com.example.mvvm_project_meteorite.ui.meteorite_list

import android.media.metrics.Event
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvm_project_meteorite.MeteoriteApi
import com.example.mvvm_project_meteorite.data.Geolocation
import com.example.mvvm_project_meteorite.data.Meteorite
import com.example.mvvm_project_meteorite.util.Routes
import com.example.mvvm_project_meteorite.util.UiEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class MeteoriteListViewModel @Inject constructor(
    val api: MeteoriteApi,

) : ViewModel() {

   // var meteoriteList: List<Response<Meteorite>> by mutableStateOf(listOf())
    val meteoriteList = api.getMeteoriteList()

    private val _uiEvent = Channel<UiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

//    fun updateMeteoriteList() {
//        viewModelScope.launch {
//            meteoriteList = api.getMeteoriteList()
//        }
//    }

fun onEvent(event: MeteoriteListEvent) {
    when(event){
        is MeteoriteListEvent.OnMeteoriteClick -> {
            sendUiEvent(UiEvent.Navigate(Routes.METEORITE_DETAIL_SCREEN + "?meteoriteId=${event.meteorite.id}"))
        }
        is MeteoriteListEvent.OnAddFavoriteClick -> {
           //TODO
        }
    }
}


    fun sendUiEvent(event: UiEvent) {
        viewModelScope.launch {
            _uiEvent.send(event)
        }
    }

}