package pl.proexe.junior.app

import android.app.Application
import android.content.Context
import pl.proexe.junior.app.di.component.AppComponent
import pl.proexe.junior.app.di.component.DaggerAppComponent
import pl.proexe.junior.app.di.module.AppModule
import pl.proexe.junior.app.di.module.RepositoryModule

class EpgApplication: Application() {


    private var context: Context? = null
     var component: AppComponent? = null

    private fun initDi(context: EpgApplication) = DaggerAppComponent.
    builder()
        .appModule(AppModule(context))
        .repositoryModule(RepositoryModule())
        .build()

    override fun onCreate() {
        super.onCreate()
        component= initDi(this)
    }
}