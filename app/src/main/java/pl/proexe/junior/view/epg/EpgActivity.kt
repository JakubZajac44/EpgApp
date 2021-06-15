package pl.proexe.junior.view.epg

import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.add
import androidx.fragment.app.commit
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import pl.proexe.junior.R
import pl.proexe.junior.app.EpgApplication
import pl.proexe.junior.model.data.NavigationDrawerModel
import pl.proexe.junior.model.data.TvProgrammeCategory
import pl.proexe.junior.presenter.epg.EpgPresenter
import pl.proexe.junior.view.adapter.NavDrawerAdapter
import pl.proexe.junior.view.dailyViewPager.DailyViewPagerFragment
import javax.inject.Inject

class EpgActivity : AppCompatActivity(), EpgView {

    companion object {
        val TAG: String = EpgActivity::class.java.simpleName
    }

    @Inject
    lateinit var presenter: EpgPresenter

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var adapter: NavDrawerAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        (application as EpgApplication).component?.inject(this)
        drawerLayout = findViewById(R.id.drawer_layout)
        setSupportActionBar(activity_main_toolbar)
        navigation_rv.layoutManager = LinearLayoutManager(this)
        navigation_rv.setHasFixedSize(true)


        presenter.onViewCreated(this)


        val toggle = ActionBarDrawerToggle(
            this,
            drawerLayout,
            activity_main_toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )

        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()


        if (savedInstanceState == null) {
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                add<DailyViewPagerFragment>(R.id.fragment_container_view)
            }
        }
    }

    override fun showCategories(categories: List<TvProgrammeCategory>) {
       //To change body of created functions use File | Settings | File Templates.
    }

    override fun showNavigationDrawer(drawerModel: NavigationDrawerModel) {
        adapter = NavDrawerAdapter(drawerModel)
        navigation_rv.adapter = adapter
        adapter.notifyDataSetChanged()
        accountTitleTextView.text = drawerModel.accountInfo.userName
        accountIdTextView.text = drawerModel.accountInfo.userAccountValue.toString()
    }

}
