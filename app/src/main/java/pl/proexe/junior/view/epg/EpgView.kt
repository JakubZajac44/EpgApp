package pl.proexe.junior.view.epg

import pl.proexe.junior.model.data.NavigationDrawerModel
import pl.proexe.junior.model.data.TvProgrammeCategory

interface EpgView {

    fun showCategories(categoryEnums: List<TvProgrammeCategory>)

    fun showNavigationDrawer(drawerModel: NavigationDrawerModel)


}