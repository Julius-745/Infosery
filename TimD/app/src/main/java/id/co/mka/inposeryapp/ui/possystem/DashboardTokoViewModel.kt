package id.co.mka.inposeryapp.ui.possystem

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import id.co.mka.inposeryapp.data.local.DataStoreRepository

class DashboardTokoViewModel(dataStoreRepository: DataStoreRepository) : ViewModel() {
    val tokenUserFromDataStore = dataStoreRepository.readTokenFromDataStore.asLiveData()
}