package com.example.myprojectapp

import android.app.Activity
import android.app.Application
import com.example.myprojectapp.di.AppComponent
import com.example.myprojectapp.di.DaggerAppComponent

class App: Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.factory().create(applicationContext)

    }
}

fun Activity.getComponent(): AppComponent = (application as App).appComponent