package com.example.mvvm_project_meteorite.ui.meteorite_list

import com.example.mvvm_project_meteorite.data.Meteorite

sealed class MeteoriteListEvent {
    data class OnMeteoriteClick(val meteorite: Meteorite): MeteoriteListEvent()
    data class OnAddFavoriteClick(val meteorite: Meteorite): MeteoriteListEvent()
}