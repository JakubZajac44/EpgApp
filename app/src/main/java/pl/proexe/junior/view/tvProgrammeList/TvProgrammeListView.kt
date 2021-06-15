package pl.proexe.junior.view.tvProgrammeList

import pl.proexe.junior.model.data.TvProgramme

interface TvProgrammeListView {

    fun showEpgList(programmes: List<TvProgramme>)
}