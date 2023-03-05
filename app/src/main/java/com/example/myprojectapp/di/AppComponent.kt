package com.example.myprojectapp.di

import android.content.Context
import com.example.myprojectapp.App
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Component(modules = [AuthModule::class])
interface AppComponent {

    @Component.Factory
    interface Factory {

        fun create(
            @BindsInstance
            context: Context
        ): AppComponent
    }

    fun inject(application: App)

//    fun getMainActivityComponent(): MainActivitySubcomponent.Factory
}