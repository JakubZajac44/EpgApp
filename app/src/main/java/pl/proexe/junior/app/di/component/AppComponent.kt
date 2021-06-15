package pl.proexe.junior.app.di.component

import dagger.Component
import pl.proexe.junior.app.di.module.AppModule
import pl.proexe.junior.app.di.module.PresenterModule
import pl.proexe.junior.app.di.module.RepositoryModule
import pl.proexe.junior.view.epg.EpgActivity
import pl.proexe.junior.view.tvProgrammeList.TvProgrammeListFragment
import pl.proexe.junior.view.dailyViewPager.DailyViewPagerFragment
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, RepositoryModule::class, PresenterModule::class])
interface AppComponent {

    fun inject(target: EpgActivity)

    fun inject(target: TvProgrammeListFragment)

    fun inject(target: DailyViewPagerFragment)
}