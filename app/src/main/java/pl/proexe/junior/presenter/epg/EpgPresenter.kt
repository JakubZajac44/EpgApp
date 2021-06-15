package pl.proexe.junior.presenter.epg

import pl.proexe.junior.model.data.TvProgramme
import pl.proexe.junior.view.epg.EpgView

interface EpgPresenter {

    fun onViewCreated(view: EpgView)

    fun onEpgProgrammeClick(programme: TvProgramme)

}