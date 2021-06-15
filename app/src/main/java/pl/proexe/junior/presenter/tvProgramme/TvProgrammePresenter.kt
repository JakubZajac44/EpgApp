package pl.proexe.junior.presenter.tvProgramme

import pl.proexe.junior.model.data.TvProgramme
import pl.proexe.junior.view.tvProgrammeList.TvProgrammeListView

interface TvProgrammePresenter {

    fun onViewCreated(view: TvProgrammeListView)

    fun onEpgProgrammeClick(programme: TvProgramme)


}