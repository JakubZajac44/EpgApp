package pl.proexe.junior.model.repository

import pl.proexe.junior.model.data.TvProgrammeCategoryEnum
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CategoryRepository @Inject constructor() {

    fun getCategory() = mutableListOf(
        TvProgrammeCategoryEnum.ALL,
        TvProgrammeCategoryEnum.FAVOURITE,
        TvProgrammeCategoryEnum.KIDS,
        TvProgrammeCategoryEnum.EDUCATIONAL,
        TvProgrammeCategoryEnum.MOVIES_AND_SERIES,
        TvProgrammeCategoryEnum.INFO,
        TvProgrammeCategoryEnum.MUSIC,
        TvProgrammeCategoryEnum.GENERAL,
        TvProgrammeCategoryEnum.SPORT,
        TvProgrammeCategoryEnum.LIFESTYLE
    )
}