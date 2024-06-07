package com.berkaykurtoglu.recipequest.data.source.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.berkaykurtoglu.recipequest.data.source.local.entity.LocalRecipeResponse
import kotlinx.coroutines.flow.Flow

@Dao
interface RecipeDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllRecipes(recipes: List<LocalRecipeResponse>)

    @Query("SELECT * FROM local_recipes")
    fun getAllRecipes() : Flow<List<LocalRecipeResponse>>

    @Query("DELETE FROM local_recipes")
    suspend fun deleteAllRecipes()

}