package com.berkaykurtoglu.recipequest.data.source.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.berkaykurtoglu.recipequest.data.source.local.entity.RecipeDetailEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface RecipeDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRecipe(recipe : RecipeDetailEntity)

    @Query("SELECT * FROM recipe_cache")
    fun getAllRecipes() : Flow<List<RecipeDetailEntity>>

    @Query("DELETE FROM recipe_cache")
    suspend fun deleteAllRecipes() : Int // number of row deleted

    @Query("SELECT COUNT(id) FROM recipe_cache")
    suspend fun getCacheCount() : Int

    @Query("SELECT * FROM recipe_cache ORDER BY addedDate ASC LIMIT 1")
    suspend fun getOldestRecipe() : RecipeDetailEntity

    @Query("DELETE FROM recipe_cache WHERE id = :id")
    suspend fun deleteRecipeFromCache(id : Int) : Int

}