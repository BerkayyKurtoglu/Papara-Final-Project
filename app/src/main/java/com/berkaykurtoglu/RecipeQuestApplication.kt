package com.berkaykurtoglu

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.hilt.work.HiltWorkerFactory
import androidx.work.BackoffPolicy
import androidx.work.Configuration
import androidx.work.ListenableWorker
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.WorkerFactory
import androidx.work.WorkerParameters
import com.berkaykurtoglu.recipequest.data.source.local.favoritesdatabase.FavoritesDao
import com.berkaykurtoglu.recipequest.data.source.remote.SuggestRecipeWorker
import com.berkaykurtoglu.recipequest.domain.datasource.RemoteDataSource
import dagger.assisted.Assisted
import dagger.hilt.android.HiltAndroidApp
import java.util.concurrent.TimeUnit
import javax.inject.Inject

@HiltAndroidApp
class RecipeQuestApplication : Application(), Configuration.Provider{

    @Inject
    lateinit var workerFactory: CustomWorkerFactor
    @Inject
    lateinit var workManager: WorkManager

    private val oneTime = PeriodicWorkRequestBuilder<SuggestRecipeWorker>(
        repeatInterval = 1,TimeUnit.DAYS
    )
        .setInitialDelay(15, TimeUnit.SECONDS)
        .setBackoffCriteria(
            backoffPolicy = BackoffPolicy.LINEAR,
            backoffDelay = 10L,
            timeUnit = TimeUnit.SECONDS
        )
        .build()

    override val workManagerConfiguration: Configuration
        get() = Configuration.Builder()
            .setMinimumLoggingLevel(Log.DEBUG)
            .setWorkerFactory(workerFactory)
            .build()

    override fun onCreate() {
        super.onCreate()
        workManager.enqueue(oneTime)
    }

}


class CustomWorkerFactor @Inject constructor (
    private val favoriteDataSource : FavoritesDao,
    private val remoteDataSource: RemoteDataSource
) : WorkerFactory() {

    override fun createWorker(
        appContext: Context,
        workerClassName: String,
        workerParameters: WorkerParameters
    ): ListenableWorker? = SuggestRecipeWorker(
        appContext,
        workerParameters,
        favoriteDataSource,
        remoteDataSource
    )
}

