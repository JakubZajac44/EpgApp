package pl.proexe.junior.view.dailyViewPager

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import pl.proexe.junior.R
import pl.proexe.junior.app.EpgApplication
import pl.proexe.junior.model.data.DayTile
import pl.proexe.junior.model.data.TvProgramme
import pl.proexe.junior.presenter.dailyViewPager.DailyViewPagerPresenter
import pl.proexe.junior.view.adapter.FragmentListCollectionAdapter
import javax.inject.Inject

class DailyViewPagerFragment : Fragment(), DailyViewPagerView {

    private lateinit var demoCollectionAdapter: FragmentListCollectionAdapter
    private lateinit var viewPager: ViewPager2

    @Inject
    lateinit var presenter: DailyViewPagerPresenter

    lateinit var tabLayout: TabLayout
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.dialy_view_pager_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        (activity?.application as EpgApplication).component?.inject(this)
        tabLayout = view.findViewById(R.id.tab_layout)
        viewPager = view.findViewById(R.id.pager)
        presenter.onViewCreated(this)
    }


    override fun showDaysList(days: List<DayTile>, dayTile: DayTile) {
        demoCollectionAdapter = FragmentListCollectionAdapter(this, days.size)
        viewPager.adapter = demoCollectionAdapter

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = getString(days[position].dayLabel)
        }.attach()
        val selectedTab =
            tabLayout.getTabAt(days.indexOf(days.first { it.timestamp == dayTile.timestamp }))
        selectedTab?.select()
    }

    override fun selectDayTile(dayTile: DayTile) {

    }
}
