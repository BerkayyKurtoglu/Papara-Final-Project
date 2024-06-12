package com.berkaykurtoglu.recipequest.data.source.local.cachedatabase

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.berkaykurtoglu.recipequest.data.source.local.entity.RecipeDetailEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface CacheDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRecipe(recipe : RecipeDetailEntity)

    @Query("SELECT * FROM recipe_entity ORDER BY addedDate ASC")
    fun cacheGetAllRecipes() : PagingSource<Int, RecipeDetailEntity>

    @Query("DELETE FROM recipe_entity")
    suspend fun cacheDeleteAllRecipes() : Int // number of row deleted

    @Query("SELECT COUNT(id) FROM recipe_entity")
    suspend fun cacheGetCount() : Int

    @Query("SELECT * FROM recipe_entity ORDER BY addedDate ASC LIMIT 1")
    suspend fun cacheGetOldestRecipe() : RecipeDetailEntity

    @Query("DELETE FROM recipe_entity WHERE id = :id")
    suspend fun cacheDeleteRecipeFromCache(id : Int) : Int

    @Query("SELECT * FROM recipe_entity WHERE id = :id")
    suspend fun cacheGetRecipeById(id : Int) : RecipeDetailEntity?

    @Query("SELECT * FROM recipe_entity WHERE title LIKE '%' || :query || '%'")
    suspend fun cacheSearchRecipes(query : String) : List<RecipeDetailEntity>


}