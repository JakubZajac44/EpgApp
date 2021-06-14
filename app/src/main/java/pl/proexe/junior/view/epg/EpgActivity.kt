package pl.proexe.junior.view.epg

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import pl.proexe.junior.R
import pl.proexe.junior.app.EpgApplication
import pl.proexe.junior.model.data.DayTile
import pl.proexe.junior.model.data.NavigationDrawerModel
import pl.proexe.junior.model.data.TvProgramme
import pl.proexe.junior.model.data.TvProgrammeCategory
import pl.proexe.junior.model.repository.LocalEpgRepository
import pl.proexe.junior.model.repository.TimeRepository
import pl.proexe.junior.presenter.epg.EpgPresenter
import pl.proexe.junior.presenter.epg.LocalEpgPresenter
import pl.proexe.junior.view.adapter.EpgRecyclerAdapter
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

        recyclerView = findViewById(R.id.tvProgrammeRecyclerView)
        layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager




        presenter.onViewCreated(this)

        recyclerView.adapter = EpgRecyclerAdapter(programmeList)
    }


    override fun showEpgList(programmes: List<TvProgramme>) {
        programmeList.clear()
        programmeList.addAll(programmes)
        recyclerView.adapter?.notifyDataSetChanged()
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
