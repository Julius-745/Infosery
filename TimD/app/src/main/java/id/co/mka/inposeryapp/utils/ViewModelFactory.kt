package id.co.mka.inposeryapp.utils

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import id.co.mka.inposeryapp.data.local.DataStoreRepository
import id.co.mka.inposeryapp.ui.possystem.DashboardTokoViewModel
import id.co.mka.inposeryapp.ui.splash.SplashViewModel

@Suppress("UNCHECKED_CAST")
class ViewModelFactory(private val dataStoreRepository: DataStoreRepository) :
    ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(DashboardTokoViewModel::class.java) -> {
                DashboardTokoViewModel(dataStoreRepository) as T
            }
            modelClass.isAssignableFrom(SplashViewModel::class.java) -> {
                SplashViewModel(dataStoreRepository) as T
            }
            else -> throw Throwable("Unknown ViewModel class: " + modelClass.name)
        }
    }
}