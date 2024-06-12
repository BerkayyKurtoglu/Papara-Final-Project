package com.berkaykurtoglu.recipequest.data.source.remote

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.hilt.work.HiltWorker
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.berkaykurtoglu.recipequest.R
import com.berkaykurtoglu.recipequest.data.source.local.favoritesdatabase.FavoritesDao
import com.berkaykurtoglu.recipequest.domain.datasource.RemoteDataSource
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.withContext

@HiltWorker
class SuggestRecipeWorker @AssistedInject constructor (
    @Assisted private val context: Context,
    @Assisted params: WorkerParameters,
    @Assisted private val favoriteDataSource : FavoritesDao,
    @Assisted private val remoteDataSource: RemoteDataSource
) : CoroutineWorker(context, params) {
    private val CHANNEL_ID = "channel_id"

    override suspend fun doWork(): Result {
        return withContext(Dispatchers.IO){
            getNotificationManager()
            try {
                val response = async { favoriteDataSource.getFavorites() }.await()
                if (response.isNotEmpty()){
                    val randomFavorite = response.random()
                    val resultList = async{remoteDataSource.suggestSimilarRecipe(randomFavorite.id)}.await()
                    resultList.forEach {
                        println(it.title)
                    }
                    if (resultList.isNotEmpty()){
                        withContext(Dispatchers.Main){
                            getNotificationManager().notify(1,getNotificationCompatBuilder(
                                content = resultList.first().title
                            ).build())
                        }
                    }else println("empty")
                }
                Result.success()
            } catch (e : Exception){
                println(e.localizedMessage)
                Result.retry()
            }
        }
    }

    private fun getNotificationCompatBuilder(
        title : String = "We are suggesting this 😉",
        content : String
    ) =
        NotificationCompat.Builder(context, CHANNEL_ID)
            .setContentTitle(title)
            .setContentText(content)
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setPriority(NotificationCompat.PRIORITY_HIGH) //for older versions

    private fun getNotificationManager(

    ) : NotificationManager {

        val manager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                CHANNEL_ID,
                "Main Channel",
                NotificationManager.IMPORTANCE_HIGH
            )
            manager.createNotificationChannel(channel)
        }
        return manager
    }



}