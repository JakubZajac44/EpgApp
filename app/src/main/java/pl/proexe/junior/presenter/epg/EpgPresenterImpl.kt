package pl.proexe.junior.presenter.epg

import pl.proexe.junior.R
import pl.proexe.junior.model.data.TvProgramme
import pl.proexe.junior.model.data.TvProgrammeCategory
import pl.proexe.junior.model.data.TvProgrammeCategoryEnum
import pl.proexe.junior.model.repository.CategoryRepository
import pl.proexe.junior.model.repository.NavigationDrawerRepository
import pl.proexe.junior.view.epg.EpgView
import javax.inject.Inject

class EpgPresenterImpl @Inject constructor(
    private val navigationDrawerRepository: NavigationDrawerRepository,
    private val categoryRepository: CategoryRepository
) : EpgPresenter {

    lateinit var view: EpgView


    override fun onViewCreated(view: EpgView) {
        this.view = view


        getNavDrawerItem()
        refreshCategory()
    }


    private fun refreshCategory() =
        view.showCategories(convertCategory(categoryRepository.getCategory()))


    private fun getNavDrawerItem() =
        view.showNavigationDrawer(navigationDrawerRepository.getNavigationDrawerItem())


    override fun onEpgProgrammeClick(programme: TvProgramme) {
        //No-op
    }

    private fun convertCategory(categoryListEnum: List<TvProgrammeCategoryEnum>): List<TvProgrammeCategory> {
        val categoryList = mutableListOf<TvProgrammeCategory>()

        for (category in categoryListEnum) {
            when (category) {
                TvProgrammeCategoryEnum.ALL -> {
                    categoryList.add(TvProgrammeCategory("Wszystkie", R.drawable.ic_all))
                }
                TvProgrammeCategoryEnum.KIDS -> {
                    categoryList.add(TvProgrammeCategory("Dzieci", R.drawable.ic_kids))
                }
                TvProgrammeCategoryEnum.FAVOURITE -> {
                    categoryList.add(TvProgrammeCategory("Ulubione", R.drawable.ic_fav))
                }
                TvProgrammeCategoryEnum.EDUCATIONAL -> {
                    categoryList.add(TvProgrammeCategory("Edukacja", R.drawable.ic_edu))
                }
                TvProgrammeCategoryEnum.MOVIES_AND_SERIES -> {
                    categoryList.add(TvProgrammeCategory("Filmy i seriale", R.drawable.ic_movie))
                }
                TvProgrammeCategoryEnum.INFO -> {
                    categoryList.add(TvProgrammeCategory("Informacja", R.drawable.ic_info))
                }
                TvProgrammeCategoryEnum.MUSIC -> {
                    categoryList.add(TvProgrammeCategory("Muzyka", R.drawable.ic_music))
                }
                TvProgrammeCategoryEnum.GENERAL -> {
                    categoryList.add(TvProgrammeCategory("Ogólne", R.drawable.ic_general))
                }
                TvProgrammeCategoryEnum.SPORT -> {
                    categoryList.add(TvProgrammeCategory("Sport", R.drawable.ic_sport))
                }
                TvProgrammeCategoryEnum.LIFESTYLE -> {
                    categoryList.add(TvProgrammeCategory("Styl życia", R.drawable.ic_styl))
                }


            }
        }
        return categoryList
    }

}