package com.berkaykurtoglu.recipequest.data.source.remote

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import coil.network.HttpException
import com.berkaykurtoglu.recipequest.domain.datasource.RemoteDataSource
import com.berkaykurtoglu.recipequest.domain.model.recipesmodel.RecipeModel
import okio.IOException

class RecipesPagingSource(
    private val mealType : String,
    private val remoteDataSource: RemoteDataSource
) : PagingSource<Int, RecipeModel>() {

    private val PAGE_SIZE = 10

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, RecipeModel> {

        return try{
            val currentPage = params.key ?: 0
            val currentOffset = currentPage*PAGE_SIZE
            val data = remoteDataSource.getRecipesRandomly(
                offset = currentOffset,
                number = PAGE_SIZE,
                mealType
            )
            Log.v("PagingSource", "Type: $mealType")
            LoadResult.Page(
                data = data.toRecipeModelList(),
                prevKey = null,
                nextKey = if (data.results.isEmpty()) null else currentPage + 1
            )

        }catch (e: IOException){
            LoadResult.Error(e)
        }catch (e: HttpException){
            LoadResult.Error(e)
        }catch (e: Exception){
            LoadResult.Error(e)
        }

    }

    override fun getRefreshKey(state: PagingState<Int, RecipeModel>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }

    }


}