package com.codeBaron.orangemovies.data.internetconfiguration

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.codeBaron.orangemovies.data.internetconfiguration.model.InternetConfigurationDTO
import com.codeBaron.orangemovies.domain.statemanager.InternetStateHandler
import kotlinx.coroutines.launch

/**
 * @author Anyanwu Nicholas(codeBaron)
 * @since @since 10-09-2022
 * @see InternetConnectivityConfig
 * This function handles getting network state result and updating the UI
 */
class InternetConfigViewModel : ViewModel() {

    companion object {
        var internetConnectivityConfig: InternetConnectivityConfig? = null
        var internetConfigObject: MutableLiveData<InternetStateHandler<InternetConfigurationDTO>>? =
            null
    }

    fun networkState(context: Context): MutableLiveData<InternetStateHandler<InternetConfigurationDTO>>? {
        viewModelScope.launch {
            internetConnectivityConfig = InternetConnectivityConfig().networkInstance()
            internetConfigObject = internetConnectivityConfig?.internetConfig(context)
        }
        return internetConfigObject
    }
}