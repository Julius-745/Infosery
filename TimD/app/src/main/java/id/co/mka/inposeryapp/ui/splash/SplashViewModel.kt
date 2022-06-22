package id.co.mka.inposeryapp.ui.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import id.co.mka.inposeryapp.data.local.DataStoreRepository

class SplashViewModel(dataStoreRepository: DataStoreRepository) : ViewModel() {
    val tokenUserFromDataStore = dataStoreRepository.readTokenFromDataStore.asLiveData()
}