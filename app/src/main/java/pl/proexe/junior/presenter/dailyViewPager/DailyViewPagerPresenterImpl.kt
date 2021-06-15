package pl.proexe.junior.presenter.dailyViewPager

import pl.proexe.junior.model.data.DayTile
import pl.proexe.junior.model.repository.TimeRepository
import pl.proexe.junior.util.convertMillisecondToDateFormat
import pl.proexe.junior.view.dailyViewPager.DailyViewPagerView
import javax.inject.Inject

class DailyViewPagerPresenterImpl @Inject constructor(
    private val timeRepository: TimeRepository
) : DailyViewPagerPresenter {

    lateinit var viewDaily: DailyViewPagerView


    override fun onViewCreated(viewDaily: DailyViewPagerView) {
        this.viewDaily = viewDaily
        refreshDays()
    }

    private fun refreshDays() =
        viewDaily.showDaysList(
            timeRepository.getDayTiles(),
            getTodayDayTile(timeRepository.getDayTiles())
        )

    private fun getTodayDayTile(dailyTileList: List<DayTile>): DayTile {
        return dailyTileList.first {
            convertMillisecondToDateFormat(it.timestamp) == convertMillisecondToDateFormat(
                timeRepository.getCurrentTime().time
            )
        }
    }

    override fun onDayTileClick(dayTile: DayTile) =
        viewDaily.selectDayTile(dayTile)

}