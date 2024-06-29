package com.codeBaron.orangemovies

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import com.codeBaron.orangemovies.data.internetconfiguration.InternetConfigViewModel
import com.codeBaron.orangemovies.data.navigations.ScreenNavigationManager
import com.codeBaron.orangemovies.domain.statemanager.InternetStateHandler
import com.codeBaron.orangemovies.ui.theme.OrangeMoviesTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            OrangeMoviesTheme {
                InternetState(mainActivity = this)
            }
        }
    }
}

@Composable
fun InternetState(mainActivity: MainActivity) {
    val isNetworkAvailable = remember { mutableStateOf(false) }
    val internetConfigViewModel = hiltViewModel<InternetConfigViewModel>()
    val internetState by internetConfigViewModel.networkState(mainActivity)!!.observeAsState()
    when(internetState) {
        is InternetStateHandler.IsInternetAvailable -> isNetworkAvailable.value = true

        is InternetStateHandler.IsInternetConnectionTypeChanged -> isNetworkAvailable.value = true

        is InternetStateHandler.IsInternetConnectionLost -> {
            isNetworkAvailable.value = false
            Toast.makeText(mainActivity, "Internet disconnected", Toast.LENGTH_SHORT).show()
        }
    }
    ScreenNavigationManager(mainActivity = mainActivity, internetState = isNetworkAvailable.value)
}