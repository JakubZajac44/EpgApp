package pl.proexe.junior.view.dailyViewPager

import pl.proexe.junior.model.data.DayTile
import pl.proexe.junior.model.data.TvProgramme

interface DailyViewPagerView {

    fun showDaysList(days: List<DayTile>, todayDayTile: DayTile)

    fun selectDayTile(dayTile: DayTile)
}