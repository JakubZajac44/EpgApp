package pl.proexe.junior.app.di.component

import dagger.Component
import pl.proexe.junior.app.di.module.AppModule
import pl.proexe.junior.app.di.module.PresenterModule
import pl.proexe.junior.app.di.module.RepositoryModule
import pl.proexe.junior.view.epg.EpgActivity
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, RepositoryModule::class, PresenterModule::class])
interface AppComponent {

    fun inject(target: EpgActivity)
}