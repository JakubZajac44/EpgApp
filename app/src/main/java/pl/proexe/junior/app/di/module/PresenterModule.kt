package pl.proexe.junior.app.di.module

import dagger.Module
import dagger.Provides
import pl.proexe.junior.model.repository.LocalEpgRepository
import pl.proexe.junior.model.repository.TimeRepository
import pl.proexe.junior.presenter.epg.EpgPresenter
import pl.proexe.junior.presenter.epg.LocalEpgPresenter
import javax.inject.Singleton

@Module
class PresenterModule {

    @Provides
    @Singleton
    fun provideEpgPresenter(epgRepository: LocalEpgRepository,timeRepository: TimeRepository): EpgPresenter = LocalEpgPresenter(epgRepository,timeRepository)
}