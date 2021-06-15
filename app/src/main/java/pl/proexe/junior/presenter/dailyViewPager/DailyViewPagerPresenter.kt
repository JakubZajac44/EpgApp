package pl.proexe.junior.presenter.dailyViewPager

import pl.proexe.junior.model.data.DayTile
import pl.proexe.junior.view.dailyViewPager.DailyViewPagerView

interface DailyViewPagerPresenter {

    fun onViewCreated(viewDaily: DailyViewPagerView)

    fun onDayTileClick(dayTile: DayTile)


}