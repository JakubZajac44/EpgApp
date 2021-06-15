package pl.proexe.junior.model.data

import java.util.*

data class TvProgramme(
    val title: String,
    val imageUrl: String,
    val type: String,
    val categoryEnum: TvProgrammeCategoryEnum,
    val isFavourite: Boolean,
    val startTime: Date,
    val endTime: Date,
    val progressPercent: Int
)