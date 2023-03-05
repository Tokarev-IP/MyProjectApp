package com.example.myprojectapp.di

import dagger.Module
import dagger.Provides

@Module
class AuthModule{

    @Provides
    fun provideString(): String { return "Hello"}
}

//@Module
//interface AuthModule {
//
//    @Binds
//    fun bindAuthInterface(impl: AuthRepository): AuthInterface
//}