package com.berkaykurtoglu.recipequest.data.source.local

import androidx.room.TypeConverter
import com.berkaykurtoglu.recipequest.data.source.local.entity.AllergenEntity
import com.berkaykurtoglu.recipequest.data.source.local.entity.AnalyzedInstructionEntity
import com.berkaykurtoglu.recipequest.data.source.local.entity.ExtendedIngredientEntity
import com.berkaykurtoglu.recipequest.data.source.local.entity.IngredientEntity
import com.berkaykurtoglu.recipequest.data.source.local.entity.RecipeDetailEntity
import com.berkaykurtoglu.recipequest.data.source.local.entity.StepEntity
import com.berkaykurtoglu.recipequest.domain.model.recipedetailmodel.AnalyzedInstructionModel
import com.berkaykurtoglu.recipequest.domain.model.recipedetailmodel.ExtendedIngredientModel
import com.berkaykurtoglu.recipequest.domain.model.recipedetailmodel.RecipeDetailModel
import com.berkaykurtoglu.recipequest.domain.model.recipedetailmodel.StepModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.util.Date

class Converters {
    private val gson = Gson()

    @TypeConverter
    fun fromExtendedIngredientEntityList(value: List<ExtendedIngredientEntity>): String {
        val type = object : TypeToken<List<ExtendedIngredientEntity>>() {}.type
        return gson.toJson(value, type)
    }

    @TypeConverter
    fun toExtendedIngredientEntityList(value: String): List<ExtendedIngredientEntity> {
        val type = object : TypeToken<List<ExtendedIngredientEntity>>() {}.type
        return gson.fromJson(value, type)
    }

    @TypeConverter
    fun fromAnalyzedInstructionEntityList(value : List<AnalyzedInstructionEntity>) : String {
        val type = object : TypeToken<List<AnalyzedInstructionEntity>>() {}.type
        return gson.toJson(value, type)
    }

    @TypeConverter
    fun toAnalyzedInstructionEntityList(value : String) : List<AnalyzedInstructionEntity> {
        val type = object : TypeToken<List<AnalyzedInstructionEntity>>() {}.type
        return gson.fromJson(value, type)
    }

    @TypeConverter
    fun fromStepEntityList(value : List<StepEntity>) : String {
        val type = object : TypeToken<List<StepEntity>>() {}.type
        return gson.toJson(value, type)
    }

    @TypeConverter
    fun toStepEntityList(value : String) : List<StepEntity> {
        val type = object : TypeToken<List<StepEntity>>() {}.type
        return gson.fromJson(value, type)
    }

    @TypeConverter
    fun fromIngredientEntityList(value: List<IngredientEntity>): String {
        val type = object : TypeToken<List<IngredientEntity>>() {}.type
        return gson.toJson(value, type)
    }

    @TypeConverter
    fun toIngredientEntityList(value: String): List<IngredientEntity> {
        val type = object : TypeToken<List<IngredientEntity>>() {}.type
        return gson.fromJson(value, type)
    }

    @TypeConverter
    fun fromAllergenEntityList(value : List<AllergenEntity>) : String {
        val type = object : TypeToken<List<AllergenEntity>>() {}.type
        return gson.toJson(value, type)
    }

    @TypeConverter
    fun toAllergenEntityList(value : String) : List<AllergenEntity> {
        val type = object : TypeToken<List<AllergenEntity>>() {}.type
        return gson.fromJson(value, type)
    }

    @TypeConverter
    fun fromStringListForDishTypes(value: List<String>): String {
        return value.joinToString(",")
    }

    @TypeConverter
    fun toStringListForDishTypes(value: String): List<String> {
        return value.split(",")
    }

    @TypeConverter
    fun fromTimeStamp(value: Long?): Date? {
        return value?.let { Date(it) }
    }
    @TypeConverter
    fun dateToTimeStamp(date: Date?): Long? {
        return date?.time
    }



}