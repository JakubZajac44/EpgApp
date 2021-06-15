package pl.proexe.junior.view.epg

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.add
import androidx.fragment.app.commit
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import pl.proexe.junior.R
import pl.proexe.junior.app.EpgApplication
import pl.proexe.junior.model.data.DayTile
import pl.proexe.junior.model.data.NavigationDrawerModel
import pl.proexe.junior.model.data.TvProgramme
import pl.proexe.junior.model.data.TvProgrammeCategory
import pl.proexe.junior.presenter.epg.EpgPresenter
import pl.proexe.junior.view.dailyViewPager.DailyViewPagerFragment
import javax.inject.Inject

class EpgActivity : AppCompatActivity(), EpgView {

    companion object{
        val TAG: String = EpgActivity::class.java.simpleName
    }

    @Inject
   lateinit var presenter: EpgPresenter


    private lateinit var recyclerView: RecyclerView
    private lateinit var layoutManager: LinearLayoutManager

    var programmeList =  mutableListOf<TvProgramme>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        (application as EpgApplication).component?.inject(this)

//        recyclerView = findViewById(R.id.tvProgrammeRecyclerView)
        layoutManager = LinearLayoutManager(this)
//        recyclerView.layoutManager = layoutManager
        presenter.onViewCreated(this)
        if (savedInstanceState == null) {
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                add<DailyViewPagerFragment>(R.id.fragment_container_view)
            }
        }




//        recyclerView.adapter = EpgRecyclerAdapter(programmeList)
    }


    override fun showEpgList(programmes: List<TvProgramme>) {

    }

    override fun showDaysList(days: List<DayTile>) {
      // lista u góry
    }

    override fun showCategories(categories: List<TvProgrammeCategory>) {
       //To change body of created functions use File | Settings | File Templates.
    }

    override fun showNavigationDrawer(drawerModel: NavigationDrawerModel) {
       //To change body of created functions use File | Settings | File Templates.
    }

    override fun selectDayTile(dayTile: DayTile) {
       //To change body of created functions use File | Settings | File Templates.
    }
}
