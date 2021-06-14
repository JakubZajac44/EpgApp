package pl.proexe.junior.app.di.module

import dagger.Module
import dagger.Provides
import pl.proexe.junior.model.repository.LocalEpgRepository
import pl.proexe.junior.model.repository.TimeRepository
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun provideLocalEpgRepository(): LocalEpgRepository = LocalEpgRepository()

    @Provides
    @Singleton
    fun provideTimeRepository(): TimeRepository = TimeRepository()
}