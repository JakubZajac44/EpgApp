package pl.proexe.junior.app.di.module

import dagger.Module
import dagger.Provides
import pl.proexe.junior.model.repository.CategoryRepository
import pl.proexe.junior.model.repository.LocalEpgRepository
import pl.proexe.junior.model.repository.NavigationDrawerRepository
import pl.proexe.junior.model.repository.TimeRepository
import pl.proexe.junior.presenter.dailyViewPager.DailyViewPagerPresenter
import pl.proexe.junior.presenter.dailyViewPager.DailyViewPagerPresenterImpl
import pl.proexe.junior.presenter.epg.EpgPresenter
import pl.proexe.junior.presenter.epg.EpgPresenterImpl
import pl.proexe.junior.presenter.tvProgramme.TvProgrammePresenter
import pl.proexe.junior.presenter.tvProgramme.TvProgrammePresenterImpl
import javax.inject.Singleton

@Module
class PresenterModule {

    @Provides
    @Singleton
    fun provideEpgPresenter( navigationDrawerRepository: NavigationDrawerRepository, categoryRepository: CategoryRepository): EpgPresenter = EpgPresenterImpl( navigationDrawerRepository,categoryRepository)

    @Provides
    @Singleton
    fun provideDailyViewPagerPresenter(timeRepository: TimeRepository): DailyViewPagerPresenter = DailyViewPagerPresenterImpl(timeRepository)

    @Provides
    @Singleton
    fun provideTvProgrammePresenter(epgRepository: LocalEpgRepository,timeRepository: TimeRepository): TvProgrammePresenter = TvProgrammePresenterImpl(epgRepository,timeRepository)
}