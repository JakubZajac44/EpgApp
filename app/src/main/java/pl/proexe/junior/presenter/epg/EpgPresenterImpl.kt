package pl.proexe.junior.presenter.epg

import pl.proexe.junior.model.data.TvProgramme
import pl.proexe.junior.model.repository.LocalEpgRepository
import pl.proexe.junior.model.repository.NavigationDrawerRepository
import pl.proexe.junior.model.repository.TimeRepository
import pl.proexe.junior.view.epg.EpgView
import javax.inject.Inject

class EpgPresenterImpl @Inject constructor(
    private val epgRepository: LocalEpgRepository,
    private val timeRepository: TimeRepository,
    private val navigationDrawerRepository: NavigationDrawerRepository
) : EpgPresenter {

    lateinit var view: EpgView


    override fun onViewCreated(view: EpgView) {
        this.view = view


        getNavDrawerItem()
    }


    private fun refreshCategory() {
//        view.showCategories()
    }

    private fun getNavDrawerItem() =
        view.showNavigationDrawer(navigationDrawerRepository.getNavigationDrawerItem())


    override fun onEpgProgrammeClick(programme: TvProgramme) {
        //No-op
    }

}