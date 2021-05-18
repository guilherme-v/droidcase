package com.example.presentation.di.module

import android.content.Context
import com.example.presentation.DroidCaseApp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PresentationModule {

    @Singleton
    @Provides
    fun provideApplication(@ApplicationContext app: Context): DroidCaseApp {
        return app as DroidCaseApp
    }

    @Singleton
    @Provides
    fun provideRandomString(): String {
        return "HEYYYY! it WORKED! lol"
    }
}