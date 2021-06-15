package pl.proexe.junior.view.epg

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ImageSpan
import android.view.Menu
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
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

    var categoriesList: List<TvProgrammeCategory> = listOf()

    private var menu: Menu? = null


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

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.my_menu, menu)
        return true
    }

    override fun onPrepareOptionsMenu(menu: Menu?): Boolean {
        menu?.clear();
        for((i, category) in categoriesList.withIndex()){
            menu?.add(0, i, 1,
                ContextCompat.getDrawable(this, category.icon)?.let { menuIconWithText(it,category.categoryName) });
        }
        return super.onPrepareOptionsMenu(menu)
    }


    override fun showCategories(categoryEnums: List<TvProgrammeCategory>) {
        categoriesList = categoryEnums
        invalidateOptionsMenu()
    }

    override fun showNavigationDrawer(drawerModel: NavigationDrawerModel) {
        adapter = NavDrawerAdapter(drawerModel)
        navigation_rv.adapter = adapter
        adapter.notifyDataSetChanged()
        accountTitleTextView.text = drawerModel.accountInfo.userName
        accountIdTextView.text = drawerModel.accountInfo.userAccountValue.toString()
    }


    private fun menuIconWithText(r: Drawable, title: String): CharSequence {
        r.setBounds(0, 0, r.intrinsicWidth, r.intrinsicHeight)
        val sb = SpannableString("    $title")
        val imageSpan = ImageSpan(r, ImageSpan.ALIGN_BOTTOM)
        sb.setSpan(imageSpan, 0, 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        return sb
    }




}
