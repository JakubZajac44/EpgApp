package pl.proexe.junior.presenter.tvProgramme

import pl.proexe.junior.model.data.TvProgramme
import pl.proexe.junior.model.repository.LocalEpgRepository
import pl.proexe.junior.model.repository.TimeRepository
import pl.proexe.junior.view.tvProgrammeList.TvProgrammeListView
import javax.inject.Inject

class TvProgrammePresenterImpl @Inject constructor(private val  epgRepository: LocalEpgRepository, private val  timeRepository: TimeRepository): TvProgrammePresenter {

    lateinit var view: TvProgrammeListView



    override fun onViewCreated(view: TvProgrammeListView) {
        this.view = view
        refreshProgrammes()


    }



    private fun refreshProgrammes() =
        view.showEpgList(
            getProgrammes()
        )

    override fun onEpgProgrammeClick(programme: TvProgramme) {
        //No-op
    }



    private fun getProgrammes() =
        epgRepository.getProgrammesForDateTime(timeRepository.getCurrentTime())


}