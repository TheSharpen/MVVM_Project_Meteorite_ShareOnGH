package com.example.mvvm_project_meteorite

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.mvvm_project_meteorite.ui.meteorite_detail_screen.MeteoriteDetailScreen
import com.example.mvvm_project_meteorite.ui.meteorite_list.MeteoriteListScreen
import com.example.mvvm_project_meteorite.ui.meteorite_list.MeteoriteListViewModel
import com.example.mvvm_project_meteorite.ui.theme.MVVM_Project_MeteoriteTheme
import com.example.mvvm_project_meteorite.util.Routes
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        val viewModel by viewModels<MeteoriteListViewModel>()

        super.onCreate(savedInstanceState)
        setContent {
            MVVM_Project_MeteoriteTheme {
                // A surface container using the 'background' color from the theme
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = Routes.METEORITE_LIST) {
                    composable(Routes.METEORITE_LIST) {
                        MeteoriteListScreen(
                                onNavigate = {
                                    navController.navigate(it.route)
                                })
                    }
                    composable(route = Routes.METEORITE_DETAIL_SCREEN + "?meteoriteId={meteoriteId}",
                    arguments = listOf(
                            navArgument(
                                    name ="meteoriteId"
                            ){
                                type = NavType.IntType
                                defaultValue = -1
                            }
                    ))
                    {
                        MeteoriteDetailScreen(onPopBackStack = {
                            navController.popBackStack()
                        })
                    }
                }



                   // MeteoriteListScreen(meteoriteList = viewModel.meteoriteList)



            }
        }
    }
}

