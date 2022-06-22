package id.co.mka.inposeryapp

import android.app.Application
import id.co.mka.inposeryapp.di.appModule
import id.co.mka.inposeryapp.di.viewModelModul
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class BaseApplication: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@BaseApplication)
            modules(
                listOf(
                    appModule,
                    viewModelModul,
                )
            )
        }
    }
}