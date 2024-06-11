package com.berkaykurtoglu.recipequest.di

import android.content.Context
import android.net.ConnectivityManager
import com.berkaykurtoglu.recipequest.data.source.remote.RecipeApiService
import com.berkaykurtoglu.recipequest.data.source.remote.RemoteDataSourceImpl
import com.berkaykurtoglu.recipequest.domain.datasource.RemoteDataSource
import com.berkaykurtoglu.recipequest.util.Contants
import com.chuckerteam.chucker.api.ChuckerInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideConnectivityManager(
        @ApplicationContext context: Context
    ) = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

    @Singleton
    @Provides
    fun provideRecipeRetrofit(
        @ApplicationContext context: Context
    ) : Retrofit = Retrofit.Builder()
        .baseUrl(Contants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(OkHttpClient.Builder().addInterceptor(ChuckerInterceptor(context)).build())
        .build()

    @Singleton
    @Provides
    fun provideRecipeService(
        retrofit: Retrofit
    ): RecipeApiService = retrofit.create(RecipeApiService::class.java)

}