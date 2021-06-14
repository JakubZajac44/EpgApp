package pl.proexe.junior.app.di.module

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(private val contex: Application) {

    @Provides
    @Singleton
    fun provideContext():Context = contex
}