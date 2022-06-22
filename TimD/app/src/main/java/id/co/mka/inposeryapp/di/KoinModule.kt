package id.co.mka.inposeryapp.di

import androidx.datastore.core.DataStoreFactory
import androidx.datastore.dataStoreFile
import id.co.mka.inposeryapp.data.network.api.Api
import id.co.mka.inposeryapp.data.network.retrofit.Retrofit
import id.co.mka.inposeryapp.ui.login.LoginViewModel
import id.co.mka.inposeryapp.ui.register.RegisterViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.GlobalContext.get
import org.koin.dsl.module

val appModule = module {
    single<Api> { Retrofit.getRetrofit(androidContext()) }
}

val viewModelModul = module {
    viewModel { LoginViewModel(get()) }
    viewModel { RegisterViewModel(get()) }
}