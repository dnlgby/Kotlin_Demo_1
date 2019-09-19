package com.example.kotlin_ex1.di

import dagger.Module


@Module
class AppModule {

/*    Don't need this. Application instance is already available through @BindsInstance in AppComponent */
//    @Singleton
//    @Provides
//    fun provideApplicationContext(app: Application): Context {
//        return app.applicationContext
//    }

}