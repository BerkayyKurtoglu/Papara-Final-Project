package com.berkaykurtoglu.recipequest.data.source.local.favoritesdatabase

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.berkaykurtoglu.recipequest.data.source.local.entity.RecipeDetailEntity

@Dao
interface FavoritesDao {


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRecipeToFavorites(recipe: RecipeDetailEntity) : Long

    @Query("DELETE FROM recipe_entity WHERE id = :id")
    suspend fun deleteRecipeFromFavorites(id: Int) : Int

    @Query("SELECT * FROM recipe_entity ORDER BY addedDate ASC")
    suspend fun getFavorites(): List<RecipeDetailEntity>

    @Query("SELECT * FROM recipe_entity WHERE id = :id")
    suspend fun getFavoriteById(id: Int): RecipeDetailEntity



}